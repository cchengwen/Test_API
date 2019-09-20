package com.api.software_install;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 操作yml配置文件
 * Created by wen on 2019/09/10
 */
public class OperateYml {
    private static Logger logger = LoggerFactory.getLogger(OperateYml.class);
    private final static DumperOptions options = new DumperOptions();
    private final static String property = "\\src\\main\\resources\\application-test.yml";

    static {
        //将默认读取的方式设置为块状读取
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
    }

    /**
     * 写入配置文件
     *
     * @param sourceData
     * @throws IOException
     */
    public static void addToYml(SourceData sourceData) throws IOException {
        System.out.println(sourceData.getPassword().matches("^[0-9]+$"));


        String propertyPath = System.getProperty("user.dir");
        propertyPath = propertyPath + property;
        Yaml yaml = new Yaml(options);
        //  yml最外层
        LinkedHashMap<String, Object> dataMap = yaml.load(new FileReader(propertyPath));
        if (dataMap == null) {
            dataMap = new LinkedHashMap<>();
        }

        // 在更新配置文件之前先判断是否有修改数据库用户名与密码
        if (!sourceData.getUsername().isEmpty() || !sourceData.getPassword().isEmpty()) {
            boolean b = Dbdriver.updateUsernameAndPassword(sourceData.getUsername(), sourceData.getPassword(), sourceData.getDbIP());
            if (!b) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                throw new RuntimeException("执行修改数据库用户名与密码失败！");
            }
        }

        //  端口配置
        LinkedHashMap<String, Object> port = new LinkedHashMap<>();
        port.put("port", sourceData.getPort());
        dataMap.put("server", port);

        //  数据库配置
        LinkedHashMap<String, LinkedHashMap<String, Object>> datasource = new LinkedHashMap<>();
        LinkedHashMap<String, Object> sources = new LinkedHashMap<>();
        sources.put("url", "jdbc:mysql://" + sourceData.getDbIP() + ":3306/" + sourceData.getDbName() + "?serverTimezone=GMT%2b8&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true");
        sources.put("driver-class-name", "com.mysql.cj.jdbc.Driver");
        sources.put("username", sourceData.getUsername());
        Object password = sourceData.getPassword();
        //  判断是否输入的密码是否为纯数字
        if (sourceData.getPassword().matches("^\\d+$")) {
            //  为纯数字则转类型
            password = Long.parseLong(sourceData.getPassword());
        }
        sources.put("password", password);
        datasource.put("datasource", sources);
        dataMap.put("spring", datasource);
        //  写入到配置文件中
        yaml.dump(dataMap, new FileWriter(propertyPath));
        //  创建数据库
        UpdateDatabase.updatedatabase(sourceData.getDbName(), sourceData.getDbIP());
    }


    public static void main(String[] args) throws IOException {
        SourceData data = new SourceData();
        data.setPort(8089);
        data.setDbIP("localhost");
        data.setDbType("mysql");
        data.setDbName("zjbb");
        data.setUsername("root");
        data.setPassword("root");
        addToYml(data);
    }
}
