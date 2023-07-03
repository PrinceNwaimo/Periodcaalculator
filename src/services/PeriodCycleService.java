package services;

import data.models.PeriodCycleChecker;
import dtos.request.CalculateNextPeriodDateRequest;
import dtos.request.CalculateOvulationDateRequest;

public interface PeriodCycleService {

    PeriodCycleChecker nextPeriodDate(CalculateNextPeriodDateRequest periodRequest);

    PeriodCycleChecker ovulationDate(CalculateOvulationDateRequest dateRequest);
}
