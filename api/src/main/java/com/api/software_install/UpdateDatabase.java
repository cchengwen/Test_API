package com.api.software_install;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.File;
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

    private static Logger logger = LoggerFactory.getLogger(UpdateDatabase.class);

    /**
     *    读取sql脚本，更新数据库操作
     * @param name  数据库表名
     * @param dbIP  数据库地址
     * @return
     */
    public static boolean updatedatabase(String name, String dbIP) {
        Connection conn = null;
        Statement statement = null;
        boolean success = false;

        try {
            List<String> sqlList = new ArrayList<>();
            //  读取sql脚本
            InputStream sqlFile = new FileInputStream(new File("").getCanonicalPath()+"\\src\\main\\resources\\sql\\shiro.sql");

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
            conn = Dbdriver.getConnection(dbIP);
            conn.setAutoCommit(false);  //  关闭自动提交
            statement = conn.createStatement();
            for (String sql : sqlList) {
                statement.addBatch(sql);
            }
            statement.executeBatch();  //  批量执行
            success = true;
        } catch (Exception e) {
            logger.error("读取sql脚本，更新数据库异常：e = [{}]", e.getMessage());
            //  设置手动回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
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

}
