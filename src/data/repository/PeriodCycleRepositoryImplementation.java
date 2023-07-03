package data.repository;

import data.models.PeriodCycleChecker;

import java.util.ArrayList;
import java.util.List;

public class PeriodCycleRepositoryImplementation implements  PeriodCycleRepository{
    private List<PeriodCycleChecker> cycles =new ArrayList<>();

    private int count;

    @Override
    public PeriodCycleChecker save(PeriodCycleChecker cycle) {
        boolean accountHasNotBeenSaved = cycle.getId() == 0;
        if (accountHasNotBeenSaved) saveNew(cycle);
        cycle.setId(generateCycleId());
        cycles.add(cycle);
        count++;

        return cycle;
    }
    private void saveNew(PeriodCycleChecker cycle){
        cycle.setId(generateCycleId());
        cycles.add(cycle);
    }

    private int generateCycleId() {return count +1;
    }


    @Override
    public PeriodCycleChecker findById(int id) {
        return null;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public int findAll() {
        return count;
    }

    @Override
    public void delete(PeriodCycleChecker cycle) {
        for (PeriodCycleChecker cycle1 : cycles) {
            cycles.remove(cycle);
            count --;
            break;

        }

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void deleteAll() {

    }
}
