package com.api.software_install;

import org.apache.commons.lang3.StringUtils;
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

public class Dbdriver {

    private static Logger logger = LoggerFactory.getLogger(Dbdriver.class);

    private final static String PROP_PATH = "\\src\\main\\resources\\application-test.yml";

    /**
     * 数据连接，操作数据
     *
     * @param dbIP 数据库地址
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Connection getConnection(String dbIP) throws IOException, ClassNotFoundException {
        Connection connection = null;
        //  创建一个properties对象
        Properties properties = new Properties();
        // 获取配置文件所在路径
        String path = new File("").getCanonicalPath() + PROP_PATH;
        logger.info("获取配置文件路径：[{}]", path);
        //  流读取配置文件
        InputStream is = new FileInputStream(path);
        //   加载配置文件
        properties.load(is);
        //  获取配置参数
        Class.forName(properties.getProperty("driver-class-name"));
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        logger.info("数据库连接：url=[{}], username= [{}], password = [{}]", url, username, password);
        try {
            //  无异常则没有新建数据库，直接返回连接
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            // 如果异常则执行, 数据库为本身已经存在的
            Statement st = null;
            try {
                //  默认数据库url
                String default_database_url = "jdbc:mysql://" + dbIP + ":3306/sakila?serverTimezone=GMT%2b8";
                logger.info("新建数据库： default_database_url = [{}]", default_database_url);
                //  创建连接
                connection = DriverManager.getConnection(default_database_url, username, password);
                st = connection.createStatement();
                //  执行创建数据库语句
                st.execute("CREATE DATABASE " + url.split("\\?")[0].split("/")[3]);
                //  把新建的数据库连接返回
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e1) {
                logger.error("新建数据库异常：e1 = [{}]",e.getMessage());
                //  设置手动回滚事务
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
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
        return connection;
    }

    /**
     * 修改数据库用户名与密码
     *
     * @param username 用户名
     * @param password 密码
     * @param dbIP     数据库ip
     * @return
     */
    public static boolean updateUsernameAndPassword(String username, String password, String dbIP) {
        logger.info("username = [{}],  password = [{}]", username, password);
        Connection connection = null;
        Statement statement = null;
        try {
            // 获取相关连接
            connection = getConnection(dbIP);
            statement = connection.createStatement();
            //  先查询数据库，获取要修改的目标
            String selectSql = "SELECT user, host FROM mysql.user";
            //  执行sql，返回结果
            ResultSet resultSet = statement.executeQuery(selectSql);
            //  此用来接收遍历出来的参数结果集
            List<String> users = new ArrayList<>();
            //  遍历sql返回的结果集，获取相关的参数
            while (resultSet.next()) {
                String user1 = resultSet.getString("user");
                users.add(user1);
            }
            //  遍历参数结果集
            for (String s : users) {
                if (!"mysql.session".equals(s) && !"mysql.sys".equals(s)) {
                    logger.info("数据库用户名：[{}]", s);
                    //  判断密码是否为空，不为空则修改
                    if (!password.isEmpty() || StringUtils.isBlank(password)) {
                        String upPasswrodSql = "update mysql.user set authentication_string=password('" + password + "') where user='" + s + "'";
                        String flushSql2 = "flush privileges";
                        statement.addBatch(upPasswrodSql);
                        statement.addBatch(flushSql2);
                        statement.executeBatch();
                    }
                    //判断用户名是否为空， 不为空则修改
                    if (!username.isEmpty() || StringUtils.isBlank(username)) {
                        String upUsernameSql = "update mysql.user set user='" + username + "' where user='" + s + "'";
                        String flushSql1 = "flush privileges";
                        statement.addBatch(upUsernameSql);
                        statement.addBatch(flushSql1);
                        statement.executeBatch();
                    }
                    logger.info("执行修改数据库用户名与密码成功！");
                    break;
                }
            }
            return true;
        } catch (Exception e) {
            logger.error("执行修改数据库用户名与密码失败");
            //  修改失败手动回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }
}
