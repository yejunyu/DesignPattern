package Decorator.部门打印;

/**
 * 文档打印小组负责维护
 *
 * @Author: yejunyu
 * @Date: 2018/9/19
 * @Email: yyyejunyu@gmail.com
 */
public class TextComponent extends PrintComponent {
    private String text;

    public TextComponent(String text) {
        this.text = text;
    }

    @Override
    public void print() {
        Printer.printText(this.text);
    }
}
