package com.api.util.softwarelic;

import java.io.*;

public class LocalFile {

    /**
     * 写入文件
     *
     * @param file
     * @param data
     */
    public static void writerFile(File file, String data) {
        BufferedOutputStream bos = null;
        try {
            //1、建立连接
            //2、选择输出流,以追加形式(在原有内容上追加) 写出文件 必须为true 否则为覆盖
            bos = new BufferedOutputStream(new FileOutputStream(file, true));

            //将字符串转换为字节数组,方便下面写入
            byte[] bytes = data.getBytes();

            //3、写入文件
            bos.write(bytes, 0, data.length());
            bos.flush(); //将存储在管道中的数据强制刷新出去

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     *   读取文件
     * @param file
     * @return
     */
    public static String readFile(File file) {
        StringBuilder sb = new StringBuilder();
        try {
            // 读取字符文件
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
            } finally {
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
