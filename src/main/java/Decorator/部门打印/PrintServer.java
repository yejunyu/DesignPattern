package Decorator.部门打印;

/**
 * 执行打印任务
 *
 * @Author: yejunyu
 * @Date: 2018/9/19
 * @Email: yyyejunyu@gmail.com
 */
public class PrintServer {

    public static void executePrintTask(PrintComponent component) {
        log();
        component.print();
        audit();
    }

    private static void log() {
        // todo 打印日志
    }

    private static void audit() {
        // todo 记录审计相关内容
    }
}
