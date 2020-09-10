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
public class HeaderDecorator extends PrintDecorator {
    private PrintComponent component;
    private String text;

    /**
     * 初始化的时候必须包含其他打印组件,这是实现装饰模式的前提
     * 同事也需要指定当前所需的参数,不能在print函数的参数中指定
     * 因为每个Decorator所需参数是不一样的
     *
     * @param component
     * @param text
     */
    public HeaderDecorator(PrintComponent component, String text) {
        this.component = component;
        this.text = text;
    }

    @Override
    public void print() {
        Printer.printHeader(text);
        // 如果component本身是Decorator,就会嵌套打印下去
        // 如果不是Decorator,则打印到此结束
        component.print();
    }
}
