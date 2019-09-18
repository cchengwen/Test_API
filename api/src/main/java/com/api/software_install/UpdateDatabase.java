package com.api.software_install;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by wen on 2019/09/11
 * 读取sql脚本 & 更新数据库名
 */
public class UpdateDatabase {
    //  默认数据库url
    private static String DEFAULT_DATABASE_URL = "jdbc:mysql://localhost:3306/sakila?serverTimezone=GMT%2b8";

    public static boolean updatedatabase(String name) {
        Connection conn = null;
        Statement statement = null;
        boolean success = false;

        try {
            List<String> sqlList = new ArrayList<>();
            //  读取sql脚本
            InputStream sqlFile = new FileInputStream("E:\\space\\Test\\api\\src\\main\\resources\\sql\\shiro.sql");

            StringBuilder sqlSb = new StringBuilder();
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = sqlFile.read(b)) != -1) {
                sqlSb.append(new String(b, 0, len, "UTF-8"));
            }
            String[] split = sqlSb.toString().split("(;\\s*\\r\\n)|(;\\s*\\n)");

            // 将数组转成LIST并且过滤LOCKTABLE 和注释
            for (int i = 0; i < split.length; i++) {
                String trim = split[i];
                if (!trim.equals("") && trim.indexOf("LOCK TABLES") != 0 && trim.indexOf("UNLOCK TABLES") != 0 && trim.indexOf("/*") != 0) {
                    sqlList.add(split[i]);
                }
            }
            // 创建数据库链接并执行SQL脚本
            conn = getConn();
            conn.setAutoCommit(false);  //  关闭自动提交
            System.out.println(sqlList);
            statement = conn.createStatement();
            for (String sql : sqlList) {
                statement.addBatch(sql);
            }
            statement.executeBatch();  //  批量执行
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
            // 如果报错，则删除D

        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return success;
    }


    /**
     *   操作数据库
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     * @throws SQLException
     */
    private static Connection getConn() throws ClassNotFoundException, IOException {
        Connection conn = null;
        Properties properties = new Properties();
        //  读取配置文件
        InputStream in = new FileInputStream("E:\\space\\Test\\api\\src\\main\\resources\\application-test.yml");
        properties.load(in);
        Class.forName(properties.getProperty("driver-class-name"));
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        try {
            //  创建连接
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            // 如果异常则执行, 数据库为本身已经存在的
            Statement st = null;
            try {
                //  创建连接
                conn = DriverManager.getConnection(DEFAULT_DATABASE_URL, username, password);
//                System.out.println(url.split("\\?")[0].split("/")[3]);
                st = conn.createStatement();
                //  执行创建数据库语句
                st.execute("CREATE DATABASE "+url.split("\\?")[0].split("/")[3]);
                //  把新建的数据库连接返回
                conn = DriverManager.getConnection(url, username, password);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }finally {
                if (st != null){
                    try {
                        st.close();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
        return conn;
    }
}
