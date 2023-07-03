package services;

import data.models.PeriodCycleChecker;
import data.repository.PeriodCycleRepository;
import data.repository.PeriodCycleRepositoryImplementation;
import dtos.request.CalculateNextPeriodDateRequest;
import dtos.request.CalculateOvulationDateRequest;


public class PeriodCycleServiceImplementation implements PeriodCycleService{

    PeriodCycleRepository cycleRepository = new PeriodCycleRepositoryImplementation();
    @Override
    public PeriodCycleChecker nextPeriodDate(CalculateNextPeriodDateRequest periodRequest) {
        PeriodCycleChecker periodCycle = new PeriodCycleChecker();
        return cycleRepository.save(periodCycle);
    }


    @Override
    public PeriodCycleChecker ovulationDate(CalculateOvulationDateRequest dateRequest) {
        PeriodCycleChecker cycle = new PeriodCycleChecker();
        return cycleRepository.save(cycle);
    }
}
