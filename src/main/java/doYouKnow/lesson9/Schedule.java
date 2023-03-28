package doYouKnow.lesson9;

import java.time.LocalTime;
import java.util.Iterator;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @Author yjy
 * @Date 2023/3/28
 **/
public class Schedule<E extends Event> {

    private volatile boolean active;
    private volatile Optional<E> currentEvent = Optional.empty();
    private final SortedSet<TimeEvent> events = new TreeSet<>();

    private class TimeEvent implements Comparable<TimeEvent> {

        E event;
        LocalTime startTime, stopTime;

        public TimeEvent(E event, LocalTime startTime, LocalTime stopTime) {
            this.event = event;
            this.startTime = startTime;
            this.stopTime = stopTime;
        }

        @Override
        public int compareTo(TimeEvent o) {
            if (stopTime.isBefore(o.startTime)) return -1;
            if (o.stopTime.isBefore(startTime)) return 1;
            return 0;
        }
    }


    /**
     * 新增一份任务,指定开始时间和结束时间
     *
     * @param event
     * @param startTime
     * @param stopTime
     */
    public void addEvent(E event, LocalTime startTime, LocalTime stopTime) {
        if (active) {
            throw new IllegalStateException("计划器已经被启动");
        }
        if (startTime.isAfter(stopTime)) {
            throw new IllegalArgumentException("时间设置错误");
        }
        TimeEvent timeEvent = new TimeEvent(event, startTime, stopTime);
        if (!events.add(timeEvent)) {
            throw new IllegalArgumentException("重叠的任务");
        }
    }

    /**
     * 调用方法起, 计划期就负责正确的时间调用事件的start, stop,启动之后,不能再向计划期添加事件
     */
    public void launch() {
        if (active) {
            return;
        }
        if (events.size() == 0) {
            throw new RuntimeException("event 没有元素");
        }
        active = true;
        Iterator<TimeEvent> iterator = events.iterator();
        while (iterator.hasNext()) {
            try {
                TimeEvent next = iterator.next();

                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 返回当前的活动事件
     *
     * @return
     */
    public Optional<E> currentEvent() {
        return currentEvent;
    }


}
