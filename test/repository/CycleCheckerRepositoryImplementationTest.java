package repository;

import data.models.PeriodCycleChecker;
import data.repository.PeriodCycleRepository;
import data.repository.PeriodCycleRepositoryImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CycleCheckerRepositoryImplementationTest {

    private PeriodCycleRepository cycleRepository;

    private PeriodCycleChecker cycle;

    @BeforeEach
    public void setup() {
        cycleRepository = new PeriodCycleRepositoryImplementation();
        cycle = new PeriodCycleChecker();
        cycle.setId(1);
        cycle.setPeriodDays(4);
        cycle.setLastPeriod("Fire");
        cycle.setCycleLength(35);

    }

    @Test
    public void saveEmailTest(){
        PeriodCycleChecker cycle = new PeriodCycleChecker();
        cycleRepository.save(cycle);
        assertEquals(1,cycleRepository.count());

    }
    @Test
    public void deleteEmailTest(){
        PeriodCycleChecker savedEmail = cycleRepository.save( cycle);
        assertEquals(1,cycleRepository.count());
        cycleRepository.delete(cycle);
        assertEquals(0,cycleRepository.count());
    }
}
