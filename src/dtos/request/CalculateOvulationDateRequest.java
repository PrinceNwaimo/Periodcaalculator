package dtos.request;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class CalculateOvulationDateRequest {
    private String dateOfBirth;
    private String lastPeriodDate;
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

    public  String calculateOvulationDate(String lastPeriodDate, int cycleLength) {

        LocalDate lastPeriod = LocalDate.parse(lastPeriodDate);
        LocalDate ovulationDate = lastPeriod.plusDays(cycleLength / 2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE,d MMMM,yyyy");
        String formattedOvulationDate = ovulationDate.format(formatter);

        return formattedOvulationDate;
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
            Next Ovulation date: %s
            """,ageConverter(dateOfBirth),lastPeriodDate,cycleLength,calculateOvulationDate(lastPeriodDate,cycleLength));
    }

}
