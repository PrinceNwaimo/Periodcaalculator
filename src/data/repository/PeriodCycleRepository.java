package data.repository;

import data.models.PeriodCycleChecker;

public interface PeriodCycleRepository {
    PeriodCycleChecker save(PeriodCycleChecker cycle);

    PeriodCycleChecker findById(int id);

    long count();

    int findAll();

    void delete(PeriodCycleChecker cycle);

    void delete(int id);

    void deleteAll();
}

