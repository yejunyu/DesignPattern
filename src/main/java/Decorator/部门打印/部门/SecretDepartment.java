package Decorator.部门打印.部门;

import Decorator.部门打印.PrintComponent;
import Decorator.部门打印.PrintDecorator;
import Decorator.部门打印.PrintServer;
import Decorator.部门打印.TextComponent;
import Decorator.部门打印.printDecorator.FooterDecorator;
import Decorator.部门打印.printDecorator.HeaderDecorator;
import Decorator.部门打印.printDecorator.ImgWatermarkDecorator;
import Decorator.部门打印.printDecorator.TextWatermarkDecorator;

/**
 * @Author: yejunyu
 * @Date: 2018/9/19
 * @Email: yyyejunyu@gmail.com
 */
public class SecretDepartment {
    public static void main(String[] args) {
        SecretDepartment s = new SecretDepartment();
        s.print("s");
    }

    public void print(String text) {
        /**
         * 使用装饰模式之后,打印任务不再是一个单独的SecretPrint类
         * 而是将多个打印项目聚合成一个打印任务,printTask
         */
        PrintComponent textComponent = new TextComponent(text);
        // header 聚合textCom
        PrintDecorator header = new HeaderDecorator(textComponent, "绝密header");
        // footer 聚合header
        PrintDecorator footer = new FooterDecorator(header, "文本绝密footer");
        // watermark聚合footer
        PrintDecorator watermark = new TextWatermarkDecorator(footer, "绝密水印");
        //
        PrintServer.executePrintTask(watermark);
    }

    public void print2(String text) {
        /**
         * 新增打印任务,无需文档管理系统增加新类,只要A部门自己修改代码即可
         */
        PrintComponent printComponent = new TextComponent(text);
        PrintDecorator watermark = new ImgWatermarkDecorator(printComponent);
        PrintServer.executePrintTask(watermark);
    }
}
