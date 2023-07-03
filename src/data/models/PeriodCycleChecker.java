package data.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PeriodCycleChecker {
    private int id;
    private String lastPeriod;


    private int periodDays;

    private int cycleLength;

    public String getLastPeriod() {
        return lastPeriod;
    }

    public void setLastPeriod(String lastPeriod) {
        this.lastPeriod = lastPeriod;
    }

    public int getPeriodDays() {
        return periodDays;
    }

    public void setPeriodDays(int periodDays) {
        this.periodDays = periodDays;
    }

    public int getCycleLength() {
        return cycleLength;
    }

    public void setCycleLength(int cycleLength) {
        this.cycleLength = cycleLength;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "PeriodCycleChecker{" +
                "lastPeriod='" + lastPeriod + '\'' +
                ", periodDays=" + periodDays +
                ", cycleLength=" + cycleLength +
                '}';
    }
}
