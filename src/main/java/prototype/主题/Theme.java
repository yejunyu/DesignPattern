package prototype.主题;

/**
 * @Author: yejunyu
 * @Date: 2018/9/19
 * @Email: yyyejunyu@gmail.com
 */
public class Theme {

    private String ringtone;
    private String paper;
    private String saver;

    public Theme(String ringtone, String paper, String saver) {
        this.ringtone = ringtone;
        this.paper = paper;
        this.saver = saver;
    }

    /**
     * 通过反射获取Ringtone
     *
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public Ringtone getRingtone() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> cl = Class.forName(ringtone);
        Ringtone inst = (Ringtone) cl.newInstance();
        return inst;
    }

    public void setRingtone(String ringtone) {
        this.ringtone = ringtone;
    }

    public WallPaper getWallPaper() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> cl = Class.forName(paper);
        WallPaper inst = (WallPaper) cl.newInstance();
        return inst;
    }

    public ScreenSaver getScreenSaver() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> cl = Class.forName(saver);
        ScreenSaver inst = (ScreenSaver) cl.newInstance();
        return inst;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public void setSaver(String saver) {
        this.saver = saver;
    }

    interface Ringtone {
    }

    interface WallPaper {
    }

    interface ScreenSaver {
    }
}
