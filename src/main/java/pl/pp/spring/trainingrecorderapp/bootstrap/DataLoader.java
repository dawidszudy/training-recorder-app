package pl.pp.spring.trainingrecorderapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.pp.spring.trainingrecorderapp.model.Training;
import pl.pp.spring.trainingrecorderapp.repositories.TrainingRepository;

import java.time.LocalDate;
import java.time.Month;

@Component
public class DataLoader implements CommandLineRunner {

    private final TrainingRepository trainingRepository;

    public DataLoader(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Training training1 = getExampleTraining1();
        Training training2 = getExampleTraining2();

        trainingRepository.save(training1);
        trainingRepository.save(training2);

    }

    private Training getExampleTraining1() {
        Training training1 = new Training();
        training1.setHours(1);
        training1.setMinutes(25);
        training1.setSeconds(56);

        training1.setAmountCalories(896L);
        training1.setAmountKilometers(5.5);
        training1.setDate(LocalDate.of(2022, Month.JUNE, 19));

        training1.setDescription("bieg na przełaj");

        return training1;
    }

    private Training getExampleTraining2() {
        Training training2 = new Training();
        training2.setHours(0);
        training2.setMinutes(45);
        training2.setSeconds(12);

        training2.setAmountCalories(521L);
        training2.setAmountKilometers(2.8);
        training2.setDate(LocalDate.of(2022, Month.JUNE, 20));

        training2.setDescription("bieg po bieżni");

        return training2;
    }
}
