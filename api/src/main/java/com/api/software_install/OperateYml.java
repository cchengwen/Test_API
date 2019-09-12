package com.api.software_install;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.LinkedHashMap;

/**
 * 操作yml配置文件
 * Created by wen on 2019/09/10
 */
public class OperateYml {

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
        String propertyPath = System.getProperty("user.dir");
        propertyPath = propertyPath + property;
        Yaml yaml = new Yaml(options);
        //  yml最外层
        LinkedHashMap<String, Object> dataMap = yaml.load(new FileReader(propertyPath));
        if (dataMap == null) {
            dataMap = new LinkedHashMap<>();
        }
        //  端口配置
        LinkedHashMap<String, Object> port = new LinkedHashMap<>();
        port.put("port", sourceData.getPort());
        dataMap.put("server", port);

        //  数据库配置
        LinkedHashMap<String, LinkedHashMap<String, Object>> datasource = new LinkedHashMap<>();
        LinkedHashMap<String, Object> sources = new LinkedHashMap<>();
        sources.put("url","jdbc:mysql://" + sourceData.getDataSourceIP() + ":3306/" + sourceData.getDataSourceName() + "?serverTimezone=GMT%2b8&useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true");
        sources.put("driver-class-name", "com.mysql.cj.jdbc.Driver");
        sources.put("username", sourceData.getUsername());
        sources.put("password", sourceData.getPassword());
        datasource.put("datasource", sources);
        dataMap.put("spring", datasource);
        yaml.dump(dataMap, new FileWriter(propertyPath));

        UpdateDatabase.updatedatabase(sourceData.getDataSourceName());
    }


    public static void main(String[] args) throws IOException {
//        File file = new File("E:\\space\\Test\\api\\src\\main\\resources\\application-test.yml");
//        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
//        map.put("url", "jdbc:mysql://192.168.0.121:3306/usertest?");
//        map.put("driver-class-name", "com.mysql.cj.jdbc.Driver");
//        map.put("username", "root");
//        map.put("password", "root");
//        addToYml(file);    18825394668
//        String property = System.getProperty("resources");
//        System.out.println(property);
//
//        File file1 = new File("");
//        String path = file1.getCanonicalPath();
//        System.out.println(path);

        SourceData data = new SourceData();
        data.setPort(8089);
        data.setDataSourceIP("localhost");
        data.setDataSourceMethod("mysql");
        data.setDataSourceName("GGSS");
        data.setUsername("root");
        data.setPassword("root");
        addToYml(data);
    }
}
