package designPattern.部门打印;

import javax.swing.*;

/**
 * 文档打印小组负责维护
 *
 * @Author: yejunyu
 * @Date: 2018/9/19
 * @Email: yyyejunyu@gmail.com
 */
public class Printer {
    static void printText(String str) {
        System.out.println("这是内容");
        System.out.println(str);
    }

    public static void printHeader(String str) {
        System.out.println("这是header");
        System.out.println(str);
    }

    public static void printFooter(String str) {
        System.out.println("这是footer");
        System.out.println(str);
    }

    public static void printTextmark(String str) {
        System.out.println("这是水印");
        System.out.println(str);
    }

    public static void printImgmark(ImageIcon img) {
        System.out.println("这是logo水印");
        System.out.println(img);
    }
}
