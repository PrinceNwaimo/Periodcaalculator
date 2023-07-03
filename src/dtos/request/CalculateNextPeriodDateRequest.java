package dtos.request;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class CalculateNextPeriodDateRequest {
    private String dateOfBirth;
    private String lastPeriodDate = String.valueOf(DateTimeFormatter.ofPattern("EEEE, d MMMM, yyyy"));
    private int cycleLength;
    private String date;

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
        return Period.between(LocalDate.parse(dateOfBirth,DateTimeFormatter.ofPattern("dd/MM/yyyy")),year).getYears();
    }
    public String calculateNextPeriodDate(String lastPeriodDate, int cycleLength) {
        LocalDate lastPeriod = LocalDate.parse(lastPeriodDate);

        LocalDate nextPeriodDate = lastPeriod.plusDays(cycleLength);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM, yyyy");
        String formattedNextPeriodDate = nextPeriodDate.format(formatter);

        return formattedNextPeriodDate;
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
            Next Period date: %s
            """,ageConverter(dateOfBirth),lastPeriodDate,cycleLength,calculateNextPeriodDate(lastPeriodDate,cycleLength));
    }


}