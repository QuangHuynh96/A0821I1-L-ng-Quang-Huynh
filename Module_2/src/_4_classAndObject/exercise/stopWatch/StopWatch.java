package _4_classAndObject.exercise.stopWatch;

import java.util.Date;

public class StopWatch {
    private Date startTime;
    private Date stopTime;

    public Date getStartTime() {
        return startTime;
    }

    public void startTime() {
        startTime= new Date();
    }
    public void start() {
        startTime= new Date();
    }
    public void stop() {
        stopTime= new Date();
    }

    public long getElapsedTime() {
        return stopTime.getTime() - startTime.getTime();
    }
}
