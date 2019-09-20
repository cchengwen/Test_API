package com.api.software_install;

public class SourceData {
    private Integer port;  //  服务器端口号
    private String dbIP;  //  数据库地址
    private String engine;  //  数据库引擎
    private String username;  //  数据库用户名
    private String password;   //   数据库密码
    private String dbName;  //  数据库名称
    private String dbType;  //  数据库类型

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getDbIP() {
        return dbIP;
    }

    public void setDbIP(String dbIP) {
        this.dbIP = dbIP;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    @Override
    public String toString() {
        return "SourceData{" +
                "port=" + port +
                ", dbIP='" + dbIP + '\'' +
                ", engine='" + engine + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dbName='" + dbName + '\'' +
                ", dbType='" + dbType + '\'' +
                '}';
    }
}
