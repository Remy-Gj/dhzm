package com.dhzm.Utils;

/**
 * @author Remy~
 * @date 来自:2022年02月21日 13:26
 */

public class CommandProcessing {
    //private String hander; //包头
    private String instructions; //命令字
    private String pklength; //包长
    private String centralized ; //集中器地址
    private String uid; //单灯控制器id
    private String command; //命令动作
    private String groups; //组号
    private String lamps ; //灯号
    private String bright; //光亮等级
    private String checkcode; //校验码
   // private String pktail; //包尾

    private String CommandsSum; //命令段

    /**
     * 计算包长
     * @author Remy~
     * @date 2022/2/23 10:44
     * @param  centralized 集中器地址
     * @param  CommandsSum 命令段(单灯控制器id+命令动作+组号+灯号+光亮等级 字符串总和)
     * @return  java.lang.String
     */
    public String packageLength(String centralized,String CommandsSum){
        if (centralized != null && CommandsSum != null){
            int allNum = (CommandsSum.length()/2)+(centralized.length()/2);
            pklength = ObjTransForm.intToHex(allNum,null);
           return pklength;
        }else{
            System.err.println("数据为空");
        }
        return "";
    }


    /**
     *计算校验码
     * @author Remy~
     * @date 2022/2/23 10:46
     * @param  instructions 命令字
     * @param  pklength 包长
     * @param  centralizedString 集中器地址
     * @param  CommandsSum 命令段(单灯控制器id+命令动作+组号+灯号+光亮等级 字符串总和)
     * @return  java.lang.String
     */
    public String packageVerification(String instructions,String pklength,String centralizedString,String CommandsSum){
        if(instructions!=null&& pklength!=null&&CommandsSum!=null) {
            String sum = centralizedString + instructions + pklength + CommandsSum;
//            sum=sum.replaceAll("\"","");//去掉拼接字符串中的“”
            String s = ObjTransForm.checkCode(sum);
            return s;
        }else{
            System.err.println("没有数据");
            return null;
        }
    }


}
