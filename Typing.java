package Practicetypingsystem;

import java.util.Scanner; // 导入 扫描器包

public class Typing {     //打字系统   1.0版本
    public static void main(String[] args) {
        //原文
        String word = "父亲说事已如此不必难过好在天无绝人之路回家变卖典质父亲还了亏空又借钱办了丧事这些日子家中光景很是惨澹一半为了丧事一半为了父亲赋闲丧事完毕父亲要到南京谋事我也要回北京念书我们便同行到南京时有朋友约去游逛勾留了一日第二日上午便须渡江到浦口";
        Scanner sc = new Scanner(System.in); // 创建 扫描器对象
        System.out.println("欢迎使用我的打字系统(每天100字轻松学会打字)");
        System.out.println("今日共" + word.length() + "字");
        for (int i = 0; i < word.length(); i++) { //用原文的 字符串个数 创建一 for循环
            System.out.println("正确字:" + word.charAt(i));
            String okword = sc.next();  //输入的字

            if (okword.equals(String.valueOf(word.charAt(i)))) {  // 用charAt方法取下标i的字 返回一个字符
                                              // 再用String类中的ValueOf方法 把字符转化成字符串 然后比较内容
                System.out.println("正确,真棒!" + "(还剩" + (word.length() - (i + 1)) + "字)");
                System.out.println("---------------");
            } else {
                System.out.println("错误!");
                i--; //输入错误 i - 1 , 不 -1 会忽略错误的字  取到下一个字
            }
        }
        System.out.println("恭喜你今日完成"+ word.length()+"字!");
        System.out.println("可喜可贺!");
    }
}
