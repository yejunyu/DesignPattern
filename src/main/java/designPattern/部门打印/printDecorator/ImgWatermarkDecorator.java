package designPattern.部门打印.printDecorator;

import designPattern.部门打印.PrintComponent;
import designPattern.部门打印.PrintDecorator;
import designPattern.部门打印.Printer;

import javax.swing.*;

/**
 * 文档打印小组负责维护
 *
 * @Author: yejunyu
 * @Date: 2018/9/19
 * @Email: yyyejunyu@gmail.com
 */
public class ImgWatermarkDecorator extends PrintDecorator {
    private static ImageIcon logo;
    private PrintComponent component;

    public ImgWatermarkDecorator(PrintComponent component) {
        this.component = component;
    }

    @Override
    public void print() {
        Printer.printImgmark(ImgWatermarkDecorator.logo);
        component.print();
    }
}
