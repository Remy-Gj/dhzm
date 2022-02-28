package com.dhzm.Utils;

import java.util.ArrayList;

/**
 * @author Remy~
 * @date 来自:2022年02月17日 15:16
 */
public class ObjTransForm {
    /**
     * Byte数组转字符串
     * @author Remy~
     * @date 2022/2/17 15:54
     * @param  TFByte 需要转为字符串的byte数组
     * @return  java.lang.String
     */
    public static String byteTF_String(byte[] TFByte) {
        if (TFByte.length != 0) {
            StringBuilder stringBuilder = new StringBuilder("");
            for (int i = 0; i < TFByte.length; i++) {
                int v = TFByte[i] & 0xFF;
                String hv = Integer.toHexString(v);
                if (hv.length() < 2) {
                    stringBuilder.append(0);
                }
                stringBuilder.append(hv);
            }
            String s = String.valueOf(stringBuilder);
            return s;
        } else {
            return "接收的数组可能为空";
        }
    }
    /**
     *String转byte
     * @author Remy~
     * @date 2022/2/17 15:56
     * @param  TFStr 需要转为byte数组的字符串
     * @return  byte[]
     */
    public static byte[] stringTF_Byte(String TFStr) {
        if (TFStr != null) {
            if (TFStr.length() % 2 != 0) {//长度为单数
                TFStr = "0" + TFStr;//前面补0
            }
            char[] chars = TFStr.toCharArray();
            int len = chars.length / 2;
            byte[] bytes = new byte[len];
            for (int i = 0; i < len; i++) {
                int x = i * 2;
                bytes[i] = (byte) Integer.parseInt(String.valueOf(new char[]{chars[x], chars[x + 1]}), 16);
            }
            System.out.println(bytes);
            return bytes;
        } else {
            System.err.println("没有收到任何命令....");
            return null;
        }
    }

   /**
    * 10进制转换16进制
    * @author Remy~
    * @date 2022/2/21 15:34
    * @param  n int类型的10进制数据
    * @param  a String动作类型
    * @return  java.lang.String
    */
    public static String intToHex(int n,String a) {
        StringBuilder sb = new StringBuilder(8);
        String s;
        char []b = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(n != 0){
            sb = sb.append(b[n%16]);
            n = n/16;
        }
        s=sb.reverse().toString();
        if ("33".equals(a)==true){
            s = switch (s.length()) {
                case 1 -> "0" + s;
                default -> s;
            };
        }else {
            s = switch (s.length()) {
                case 1 -> "000" + s;
                case 2 -> "00" + s;
                case 3 -> "0" + s;
                default -> s;
            };
        }
        return s;
    }
  /**
   * 计算校验码
   * @author Remy~
   * @date 2022/2/23 10:41
   * @param  command 命令字+包长+集中器地址+数据(控制段)的字符串和
   * @return  java.lang.String
   */
    public static String checkCode(String command) {
        if (command != null) {
            byte[] bytes = ObjTransForm.stringTF_Byte(command);
            Integer i1 = 0;
            ArrayList<Integer> integers = new ArrayList<>();
            for (int i = 0; i < bytes.length; i++) {
                integers.add(bytes[i] & 0xFF);
                i1 = switch (i) {
                    case 0 -> i = i;
                    case 1 -> integers.get(0) + integers.get(i);
                    default -> i1 + integers.get(i);
                };
            }
            String hexString = Long.toHexString(i1);
            hexString = switch ( hexString.length()) {
                case 1 -> "000" +  hexString;
                case 2 -> "00" +  hexString;
                case 3 -> "0" +  hexString;
                default ->  hexString;
            };
            return hexString;
        }else {
            System.err.println("没有收到数据");
        }
        return "";
    }
}
