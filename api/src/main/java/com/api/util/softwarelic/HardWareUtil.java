package com.api.util.softwarelic;

import java.io.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * 获取电脑硬件信息
 */
public class HardWareUtil {

    /**
     * 获取电脑主板序列号
     *
     * @return
     */
    public static String getMainBoardSN() {
        String vbs = "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
                + "Set colItems = objWMIService.ExecQuery _ \n"
                + "   (\"Select * from Win32_BaseBoard\") \n"
                + "For Each objItem in colItems \n"
                + "    Wscript.Echo objItem.SerialNumber \n"
                + "    exit for  ' do the first cpu only! \n"
                + "Next \n";
        return getSoftInfo(vbs);
    }

    /**
     * 　获取硬盘序列号
     *
     * @param drive
     * @return
     */
    public static String getHardNumber(String drive) {
        String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n"
                + "Set colDrives = objFSO.Drives\n"
                + "Set objDrive = colDrives.item(\"" + drive + "\")\n"
                + "Wscript.Echo objDrive.SerialNumber";  // see note
        return getSoftInfo(vbs);
    }


    /**
     *   获取硬盘序列号
     * @return
     */
    public static String getHardNum(){
        String hardNum = "";  //定义变量 硬盘序列号
        try {
            Process exec = Runtime.getRuntime().exec("cmd /c  dir C:"); //  获取命令行参数
            BufferedReader reader = new BufferedReader(new InputStreamReader(exec.getInputStream(), "GBK"));
            String line;
            while ((line = reader.readLine()) != null){
                //读取参数并获取硬盘序列号
                if (line.indexOf("卷的序列号是 ") != -1) {
                    hardNum = line.substring(line.indexOf("卷的序列号是 ") + "卷的序列是 ".length(), line.length());
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hardNum.trim();
    }


    private static String getSoftInfo(String vbs) {
        String result = "";
        try {
            File file = File.createTempFile("realhowto", ".vbs");
            file.deleteOnExit();
            FileWriter writer = new FileWriter(file);
            writer.write(vbs);
            writer.close();
            Process exec = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
            BufferedReader reader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            writer.close();
            return result.trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 获取mac网卡
     *
     * @return
     */
    public static String getMac() {
        StringBuffer sb = new StringBuffer();
        try {
            byte[] address = NetworkInterface.getByInetAddress(InetAddress.getLocalHost()).getHardwareAddress();
            for (int i = 0; i < address.length; i++) {
                if (i != 0) {
                    sb.append("-");
                }
                String s = Integer.toHexString(address[i] & 0xFF);
                sb.append(s.length() == 1 ? 0 + s : s);
            }
            return sb.toString().toUpperCase();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     *  获取CPU序列号
     * @return
     */
    public static String getCPUNumber() {
        String result = "";
        try {
            File file = File.createTempFile("tmp", ".vbs");
            file.deleteOnExit();
            FileWriter writer = new FileWriter(file);
            String vbs = "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
                    + "Set colItems = objWMIService.ExecQuery _ \n"
                    + "   (\"Select * from Win32_Processor\") \n"
                    + "For Each objItem in colItems \n"
                    + "    Wscript.Echo objItem.ProcessorId \n"
                    + "    exit for  ' do the first cpu only! \n" + "Next \n";
           writer.write(vbs);
           writer.close();
            String path = file.getPath().replace("%20", " ");
            Process exec = Runtime.getRuntime().exec("cscript //NoLogo " + path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null){
                result += line;
            }
           reader.close();
            file.delete();

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (result.trim().length() < 1 || result == null){
            result = "无CPU_ID被读取";
        }
        return result.trim();
    }


    public static void main(String[] args) {
        System.out.println("主板序列号：" + getMainBoardSN());
        System.out.println("硬盘序列号1：" + getHardNumber("C"));
        System.out.println("硬盘序列号2：" + getHardNum());
        System.out.println("mac网卡：" + getMac());
        System.out.println("CPU序列号：" + getCPUNumber());
    }
}
