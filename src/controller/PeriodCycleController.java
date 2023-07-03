package controller;

import dtos.request.CalculateNextPeriodDateRequest;
import dtos.request.CalculateOvulationDateRequest;
import services.PeriodCycleService;
import services.PeriodCycleServiceImplementation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PeriodCycleController {
PeriodCycleService cycleService = new PeriodCycleServiceImplementation();

    public Object periodDate(CalculateNextPeriodDateRequest request){
        return cycleService.nextPeriodDate(request);
    }


    public Object ovulationDate(CalculateOvulationDateRequest request){
        return cycleService.ovulationDate(request);
    }
}
