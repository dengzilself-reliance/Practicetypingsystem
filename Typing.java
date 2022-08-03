package Practicetypingsystem;

import java.util.Scanner; // 导入 扫描器包

public class Typing {     //打字系统   3.0版本
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 创建 扫描器对象
        //文章
        String word = "时我看见他的背影我的泪很快地流下来了我赶紧拭干了泪怕他看见也怕别人看见我看时放扑扑衣";
        //错字
        String misprint = "嘴座受能在聪说走往铁缩努流也别回错";
        //词组
        String phrase = "你好,时间,世界,测试";

        System.out.println("欢迎使用我的打字系统(每天100字轻松学会打字)");
        OUT:
        // 标签
        while (true) {
            System.out.println("请输入练习模式(单字,错字,自由,词组,退出):");
            String input = sc.next();
            switch (input) {
                case "单字":
                    separateWord(word, sc); // 调用separateWord 单字练习方法
                    break;
                case "错字":
                    separateWord(misprint, sc); // 调用separateWord 单字练习方法
                    break;
                case "自由":
                    freePractice(word, sc);
                    break;
                case "词组":
                    phrasePractice(phrase, sc);  // 调用 phrasePractice 词组练习方法
                    break;
                case "退出":
                    System.out.println("退出打字系统成功!");
                    break OUT; // 结束 while死循环
                default:
                    System.out.println("输入命令有误!");
            }

        }


    }

    /**
     * 传入文章 一个字一个字 练习打字
     *
     * @param word 文章
     * @param sc   扫描器对象
     */
    public static void separateWord(String word, Scanner sc) {
        System.out.println("今日共" + word.length() + "个字");
        for (int i = 0; i < word.length(); i++) { //用原文的 字符串个数 创建一 for循环
            System.out.println("正确字:" + word.charAt(i));
            String okword = sc.next();  //输入的字
            if (okword.equals(String.valueOf(word.charAt(i)))) {  // 用charAt方法取下标i的字 返回一个字符
                // 再用String类中的ValueOf方法 把字符转化成字符串 然后比较内容
                System.out.println("正确,真棒!" + "(还剩" + (word.length() - (i + 1)) + "个字)");
                System.out.println("---------------");
            } else {
                System.out.println("错误!");
                i--; //输入错误 i - 1 , 不 -1 会忽略错误的字  取到下一个字
            }
        }
        System.out.println("恭喜你今日完成" + word.length() + "字!");
        System.out.println("可喜可贺!");
    }

    /**
     * 自由练习
     * @param word 文章
     * @param sc   扫描器
     */
    public static void freePractice(String word, Scanner sc) {
        System.out.println("今日共" + word.length() + "个字");

        for (int i = 0; i < word.length();) { //根据文章的长度创造for循环
            if ((word.length() - i) < 10) {
                //文章最后 几个字
                System.out.println("最后几个字:" + word.substring(i, ((word.length() - i) + i)));  //最后几个字
                String enter1 = sc.next(); //输入的字
                int enterlength1 = enter1.length();  //输入的字符串长度
                if (enter1.equals(word.substring(i, (enterlength1 + i)))) {
                    //输入的字 比对
                    i += enterlength1;  // 循环 + 输入的字符串长度
                    //i -- ; //循环-1 不然i++ 取字错误
                    if(word.length() == (i + enterlength1 - 1)){
                        //也没搞懂  就这样吧
                        System.out.println("恭喜你今日完成" + word.length() + "字!");
                        System.out.println("可喜可贺!");
                    }

                } else {
                    System.out.println("错误!");
                    //i--;
                }
            } else {
                System.out.println("前十个字:" + word.substring(i, (10 + i)));  //截取 10个字
                String enter = sc.next(); //输入的字
                int enterlength = enter.length();  //输入的字符串长度
                if (enter.equals(word.substring(i, (enterlength + i)))) {
                    //输入的字 比对 文章
                    i += enterlength;  // 取字往后  循环 + 输入的字符串长度
                    //i -- ; // 循环 -1  不然i++ 多取一位
                    System.out.println("正确,真棒!" + "(还剩" + (word.length() - i) + "个字)");
                    System.out.println("---------------");
                } else {
                    System.out.println("错误!");
                    //i--;  //循环-1 不然取字错误
                }
            }
        }
    }

    /**
     * 传入 词组, 根据组词内容,用","分割成字符串数组
     *
     * @param phrase 词组
     * @param sc     扫描器
     */
    public static void phrasePractice(String phrase, Scanner sc) {
        String[] arrayphrase = phrase.split(","); //正则表达式 根据“,”分割 字符串内容 成 字符串数组
        System.out.println("今日共" + arrayphrase.length + "个词组" + phrase.length() + "个字");
        for (int i = 0; i < arrayphrase.length; i++) {  //根据字符串数组 长度 创建 for循环
            System.out.println("正确词组:" + arrayphrase[i]);
            String okphrase = sc.next(); // 输入
            if (okphrase.equals(arrayphrase[i])) {  //比对输入的内容 是否 正确   用字符串对象equals方法 比对内容
                System.out.println("正确,真棒!" + "(还剩" + (arrayphrase.length - (i + 1)) + "个词组)");
                System.out.println("---------------");
            } else {
                System.out.println("错误!");
                i--;  // 输错 for循环 -1  不然会忽略错误的词组 取错误词组的下一个词组
            }
        }
        System.out.println("恭喜你今日完成" + arrayphrase.length + "个词组!" + phrase.length() + "个字");
        System.out.println("可喜可贺!");
    }

}