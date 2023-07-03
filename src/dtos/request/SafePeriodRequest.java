package dtos.request;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class SafePeriodRequest {
    private String dateOfBirth;
    private String lastPeriodDate;
    private int cycleLength;

    private String date;
    private  String ovulationDate;


    public String getLastPeriodDate() {
        return lastPeriodDate;
    }

    public void setLastPeriodDate(String lastPeriodDate) {
        this.lastPeriodDate = lastPeriodDate;
    }

    public int getCycleLength() {
        return cycleLength;
    }

    public void setCycleLength(int cycleLength) {
        this.cycleLength = cycleLength;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public int ageConverter(String dateOfBirth){
        LocalDate year = LocalDate.now();
        return Period.between(LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd/MM/yyyy")),year).getYears();
    }

    public  String calculateSafePeriod() {
        LocalDate lastPeriod = LocalDate.parse(lastPeriodDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate ovulationDate = lastPeriod.plusDays(cycleLength / 2);
        LocalDate startDate = ovulationDate.minusDays(7);
        LocalDate endDate = ovulationDate.plusDays(19);

        LocalDate[] safePeriod = {startDate, endDate};
        return Arrays.toString(safePeriod);

    }

    @Override
    public String toString() {
        return String.format("""
            =======================
            Age: %s
            =======================
            Last Period date: %s
            =======================
            Length of Cycle:%s
            ======================
            Safe period: %s
            """,ageConverter(dateOfBirth),lastPeriodDate,cycleLength, calculateSafePeriod());
    }


}
