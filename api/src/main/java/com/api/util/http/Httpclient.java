package com.api.util.http;

import com.api.util.code.Transcode;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Httpclient {

    /**
     * post请求，key - value  格式参数
     *
     * @param url
     * @param params
     * @return
     */
    public static String doPost(String url, Map params) {
        BufferedReader reader = null;
        try {
            HttpClient client = new DefaultHttpClient();
            //  实例化请求方法
            HttpPost post = new HttpPost();
            post.setURI(new URI(url));

            //  设置参数
            List<NameValuePair> nvps = new ArrayList<>();
            for (Iterator iter = params.keySet().iterator(); iter.hasNext();) {
                String name = (String) iter.next();
                String value = String.valueOf(params.get(name));
                nvps.add(new BasicNameValuePair(name, value));
            }
            post.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));

            //  response响应
            HttpResponse response = client.execute(post);
            int code = response.getStatusLine().getStatusCode();
            if (code == 200){
                reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
                StringBuilder builder = new StringBuilder();
                String line;
                String NL = System.getProperty("line.separator");
                while ((line = reader.readLine()) != null){
                    builder.append(line+NL);
                }
                reader.close();
                return builder.toString();
            }else {
                return response.getStatusLine().toString();
            }

        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     *    get 请求
     * @param url
     * @return
     */
    public static String doGetJson(String url){
        String resp = null;
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null){
                resp = EntityUtils.toString(entity, "UTF-8");
            }
            httpGet.releaseConnection();
            return Transcode.unicodeToString(resp);
        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;
    }

    /**
     *   解决get请求特殊字符问题
     * @param url
     * @return
     */
    public static String urlEncode(String url){
        if (url == null || url == ""){
            return null;
        }
        final String reserved_char = ";/?:@=&";
        String ret = "";
        for (int i = 0; i < url.length(); i++) {
            String s = String.valueOf(url.charAt(i));
            if (reserved_char.contains(s)){
                ret += s;
            }else {
                try {
                    ret += URLEncoder.encode(s, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return ret.replace("+", "%20");
    }
}
