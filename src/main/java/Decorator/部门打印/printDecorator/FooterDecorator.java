package Decorator.部门打印.printDecorator;

import Decorator.部门打印.PrintComponent;
import Decorator.部门打印.PrintDecorator;
import Decorator.部门打印.Printer;

/**
 * 文档打印小组负责维护
 *
 * @Author: yejunyu
 * @Date: 2018/9/19
 * @Email: yyyejunyu@gmail.com
 */
public class FooterDecorator extends PrintDecorator {
    private PrintComponent component;
    private String text;

    public FooterDecorator(PrintComponent component, String text) {
        this.component = component;
        this.text = text;
    }

    @Override
    public void print() {
        Printer.printFooter(text);
        component.print();
    }
}
