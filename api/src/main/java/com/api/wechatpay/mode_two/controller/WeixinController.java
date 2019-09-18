package com.api.wechatpay.mode_two.controller;


import com.api.wechatpay.mode_two.service.WeixinPayService;
import com.api.wechatpay.mode_two.util.PayConfigUtil;
import com.api.wechatpay.mode_two.util.PayToolUtil;
import com.api.wechatpay.mode_two.util.QRUtil;
import com.api.wechatpay.mode_two.util.XMLUtil4jdom;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import org.jdom.JDOMException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@RestController
@RequestMapping("/wxpay")
public class WeixinController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WeixinPayService weixinPayService;

    @GetMapping("/getcode")
    public void getQrCode(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        String productId = request.getParameter("productId");
        String userId = request.getParameter("userId");
        logger.info("请求参数 --> productid = [{}], userId = [{}]", productId, userId);

        try {
            String pay = weixinPayService.weixinPay(userId, productId);
            //  根据url生成二唯码
            int width = 300, height = 300;
            //  二唯码图片格式
            String imgFormat = "gif";
            Hashtable hashtable = new Hashtable();
            //  内容所使用编码
            hashtable.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix;
            try {
                bitMatrix = new MultiFormatWriter().encode(pay, BarcodeFormat.QR_CODE, width, height, hashtable);
                QRUtil.writeToStream(bitMatrix, imgFormat, response.getOutputStream());
            } catch (WriterException e) {
                e.printStackTrace();
            }
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/notify")
    public void weixinNotify(HttpServletRequest request, HttpServletResponse response) {
        //  读取参数
        InputStream inputStream;
        StringBuffer sb = new StringBuffer();
        try {
            inputStream = request.getInputStream();
            String line;
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            in.close();
            inputStream.close();

            //  解析xml成map
            Map<String, String> map = new Hashtable<>();
            map = XMLUtil4jdom.doXMLParse(sb.toString());

            //  过虑空，设置treeMap
            SortedMap<Object, Object> sortedMap = new TreeMap<>();
            Iterator iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                String parameter = (String) iterator.next();
                String parameterValue = map.get(parameter);
                String v = "";
                if (null != parameterValue) {
                    v = parameterValue.trim();
                }
                sortedMap.put(parameter, v);
            }

            //  账号信息
            String key = PayConfigUtil.API_KEY;

            // 判断签名是否正确
            if (PayToolUtil.chekcSign("UTF-8", sortedMap, key)) {
                //  处理业务
                //////////执行自己的业务逻辑////////////////
                String resXml = "";
                String result_code = (String) sortedMap.get("result_code");
                if ("SUCCESS".equals(result_code)) {
                    // 支付
                    String mch_id = (String) sortedMap.get("mch_id");
                    String openid = (String) sortedMap.get("openid");
                    String is_subscribe = (String) sortedMap.get("is_subscribe");
                    String out_trade_no = (String) sortedMap.get("out_trade_no");
                    String total_fee = (String) sortedMap.get("total_fee");
                    //////////执行自己的业务逻辑////////////////
                    //暂时使用最简单的业务逻辑来处理：只是将业务处理结果保存到session中
                    //（根据自己的实际业务逻辑来调整，很多时候，我们会操作业务表，将返回成功的状态保留下来）
                    request.getSession().setAttribute("_PAY_RESULT", "OK");
                    System.out.println("支付成功");

                    //通知微信.异步确认成功.必写.不然会一直通知后台.八次之后就认为交易失败了.
                    resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>" + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml>";
                } else {
                    resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>" + "<return_msg><![CDATA[报文为空，支付失败]]></return_msg>" + "</xml>";
                }
                //------------------------------
                //处理业务完毕
                //------------------------------
                BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
                out.write(resXml.getBytes());
                out.flush();
                out.close();
            }else {
                System.out.println("验签失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        }

    }

}
