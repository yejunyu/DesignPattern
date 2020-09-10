package designPattern.部门打印.printDecorator;

import designPattern.部门打印.PrintComponent;
import designPattern.部门打印.PrintDecorator;
import designPattern.部门打印.Printer;

/**
 * 文档打印小组负责维护
 *
 * @Author: yejunyu
 * @Date: 2018/9/19
 * @Email: yyyejunyu@gmail.com
 */
public class TextWatermarkDecorator extends PrintDecorator {
    private PrintComponent component;
    private String text;

    public TextWatermarkDecorator(PrintComponent component, String text) {
        this.component = component;
        this.text = text;
    }

    @Override
    public void print() {
        Printer.printTextmark(text);
        component.print();
    }
}
