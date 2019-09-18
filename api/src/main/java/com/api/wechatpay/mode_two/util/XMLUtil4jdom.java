package com.api.wechatpay.mode_two.util;

import org.apache.commons.lang3.StringUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class XMLUtil4jdom {
    private static Logger logger = LoggerFactory.getLogger(XMLUtil4jdom.class);

    /**
     *   解析xml，返回第一级元素分健值对，如果第一级元素有子节点，则此节点的值是子节点的xml数据
     * @param strXml
     * @return
     * @throws JDOMException
     * @throws IOException
     */
    public static Map doXMLParse(String strXml) throws JDOMException, IOException {
        logger.info("xml字符串：[{}]", strXml);
        strXml = strXml.replaceFirst("encoding=\".*\"", "encoding=\"UTF-8\"");
        if (strXml.isEmpty() || StringUtils.isBlank(strXml)) return null;
        Map<String, String> map = new HashMap<>();
        InputStream in = new ByteArrayInputStream(strXml.getBytes());
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(in);
        Element root = doc.getRootElement();
        List list = root.getChildren();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Element ele = (Element) iterator.next();
            String k = ele.getName();
            String v = "";
            List children = ele.getChildren();
            if (children.isEmpty()){
                v = ele.getTextNormalize();
            }else {
                v = getChildrenText(children);
            }
            map.put(k, v);
        }
        in.close();
        return map;
    }

    /**
     *  获取子结点的xml
     * @param children
     * @return
     */
    public static String getChildrenText(List children){
        StringBuffer sb = new StringBuffer();
        if (!children.isEmpty()){
            Iterator iterator = children.iterator();
            if (iterator.hasNext()){
                Element ele = (Element) iterator.next();
                String name = ele.getName();
                String value = ele.getTextNormalize();
                List children1 = ele.getChildren();
                sb.append("<"+name+">");
                if (!children1.isEmpty()){
                    sb.append(getChildrenText(children1));
                }
                sb.append(value);
                sb.append("</"+name+">");
            }
        }
        return sb.toString();
    }
}
