package com.api.software_install;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 修改数据库用户名& 密码 (测试用，非调用类)
 */
public class Notify {

    //  修改数据库用户名
    public void setData() throws IOException, ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement statement = null;
        conn = Dbdriver.getConnection("localhost");
        statement = conn.createStatement();
        //  修改数据主库用户名的sql
        String upUsernameSql = "update mysql.user set user='root' where user='ppp'";
        String flushSql = "flush privileges";
        statement.addBatch(upUsernameSql);
        statement.addBatch(flushSql);
        statement.executeBatch();
        System.out.println("执行完成！");
    }

    public void upPwd() throws IOException, ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;
        connection = Dbdriver.getConnection("localhost");
        statement = connection.createStatement();
        //  修改数据库密码的sql
        String upPwdSql = "update mysql.user set authentication_string=password('root') where user='root' ";
        String flushSql = "flush privileges";
        statement.addBatch(upPwdSql);
        statement.addBatch(flushSql);
        statement.executeBatch();
        System.out.println("修改成功");
    }

//    public void selectSql() throws IOException, ClassNotFoundException, SQLException {
//        Connection connection = null;
//        Statement statement = null;
//        connection = Dbdriver.getConnection();
//        statement = connection.createStatement();
//        String selectSql = "select user, host from mysql.user";
//        ResultSet resultSet = statement.executeQuery(selectSql);
//        List<String> list = new ArrayList<>();
//        while (resultSet.next()) {
//            String name = resultSet.getString("user");
//            list.add(name);
//        }
//        for (String s : list) {
//            if (!"mysql.session".equals(s) && !"mysql.sys".equals(s)){
//                System.out.println(s);
//            }
//        }
//
//    }

    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
//        new Notify().setData();
//        new Notify().upPwd();
//        new Notify().selectSql();
        Dbdriver.updateUsernameAndPassword("root", "root", "localhost");
    }
}
