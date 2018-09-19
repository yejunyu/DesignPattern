package prototype.主题;

/**
 * @Author: yejunyu
 * @Date: 2018/9/19
 * @Email: yyyejunyu@gmail.com
 */
public class Client {

    private static void useTheme(Theme theme) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        // 通过Theme获取具体内容
        Theme.Ringtone ringtone = theme.getRingtone();
        Theme.WallPaper wallPaper = theme.getWallPaper();
        Theme.ScreenSaver screenSaver = theme.getScreenSaver();
        // todo 使用内容
    }

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        String ringtone = "经典铃声";
        String WallPaper = "时尚壁纸";
        String ScreenSaver = "夜色待机";

        Theme theme = new Theme(ringtone, WallPaper, ScreenSaver);
        useTheme(theme);
    }
}
