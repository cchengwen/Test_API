package com.api.software_install;

public class SourceData {
    private Integer port;  //  服务器端口号
    private String engine;  //  数据库引擎
    private String dataSourceIP;  //  数据库地址
    private String username;  //  数据库用户名
    private String password;   //   数据库密码
    private String dataSourceName;  //  数据库名称
    private String dataSourceMethod;  //  数据库操作方法

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getDataSourceIP() {
        return dataSourceIP;
    }

    public void setDataSourceIP(String dataSourceIP) {
        this.dataSourceIP = dataSourceIP;
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

    public String getDataSourceName() {
        return dataSourceName;
    }

    public void setDataSourceName(String dataSourceName) {
        this.dataSourceName = dataSourceName;
    }

    public String getDataSourceMethod() {
        return dataSourceMethod;
    }

    public void setDataSourceMethod(String dataSourceMethod) {
        this.dataSourceMethod = dataSourceMethod;
    }

    @Override
    public String toString() {
        return "SourceData{" +
                "port=" + port +
                ", engine='" + engine + '\'' +
                ", dataSourceIP='" + dataSourceIP + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dataSourceName='" + dataSourceName + '\'' +
                ", dataSourceMethod='" + dataSourceMethod + '\'' +
                '}';
    }
}
