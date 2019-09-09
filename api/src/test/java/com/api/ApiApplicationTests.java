package com.api;

import com.api.newtest.realizeapi.workorder.service.CreateWorkService;
import com.api.test.kkl.service.KklServiceImpl;
import com.api.test.shenzhou.res.ShenZhouReturnData;
import com.api.test.shenzhou.service.ShzhouService;
import com.api.wechat.aes.AesException;
import com.api.wechat.aes.WXBizMsgCrypt;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiApplicationTests {

    @Autowired private CreateWorkService createWork;
    @Autowired
    private ShzhouService shzhouService;
    @Autowired
    private KklServiceImpl kklService;


//    @Autowired private Cesi cesi;

    @Test
    public void CacTest(){
        try {
            createWork.canncelWork();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void xTest(){
        try {
            createWork.cancelWork();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void creeTest(){
        try {
            createWork.pushOrder();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    @Test
//    public void test5() throws Exception {
//        cesi.jiami();
////        cesi.jiemi();
//    }

    @Test
    public void test4() {
        JSONObject kkl = kklService.getKkl("11");
        System.out.println(kkl);
    }

    //   神州get请求
    @Test
    public void testShZhouGet() throws Exception {
        shzhouService.getHttp();
    }

    //   神州post请求
    @Test
    public void test() throws Exception {
        ShenZhouReturnData shenzhou = shzhouService.shenzhou();
        System.out.println(shenzhou.getData());
    }

    // 微信数据加密
    @Test
    public void test2() throws AesException {
        String token = "pamtest";
        String key = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFG";
        String appId = "wxb11529c136998cb6";
        WXBizMsgCrypt wx = new WXBizMsgCrypt(token, key, appId);
        String msg = "你好！";
        String timeStamp = "1409304348";
        String noce = "";
        String s = wx.encryptMsg(msg, timeStamp, noce);
        System.out.println(s);
    }

    //  解密的 xml 格式
    String xmlFormat = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";

    //   微信数据解密
    @Test
    public void test3() throws AesException, ParserConfigurationException, IOException, SAXException {
        String token = "pamtest";
        String key = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFG";
        String appId = "wxb11529c136998cb6";
        WXBizMsgCrypt wx = new WXBizMsgCrypt(token, key, appId);

        String text = "<xml>\n" +
                "<Encrypt><![CDATA[1CBvrl+Q8LCh7IJsAoOY0g+kR0uvQ1OkhF5UyfQAHYo0pRc62ITKporm1p+4As0Tz8+0yybYlg6ZBR38Hng2Qg==]]></Encrypt>\n" +
                "<MsgSignature><![CDATA[1bc56f72026d3b7d2804c1f57cad58385a40f058]]></MsgSignature>\n" +
                "<TimeStamp>1409304348</TimeStamp>\n" +
                "<Nonce><![CDATA[]]></Nonce>\n" +
                "</xml>";

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        StringReader sr = new StringReader(text);
        InputSource is = new InputSource(sr);
        Document document = db.parse(is);

        Element root = document.getDocumentElement();
        NodeList nodelist1 = root.getElementsByTagName("Encrypt");
        NodeList nodelist2 = root.getElementsByTagName("MsgSignature");

        String encrypt = nodelist1.item(0).getTextContent();
        String msgSignature = nodelist2.item(0).getTextContent();
        String fromXML = String.format(xmlFormat, encrypt);

        String timeStamp = "1409304348";
        String noce = "";
        String s = wx.decryptMsg(msgSignature, timeStamp, noce, fromXML);
        System.out.println(s);
    }

    @Autowired private RestTemplate restTemplate;

    @Test
    public void contextLoads() {

    }

}
