package pl.pp.spring.trainingrecorderapp.services.db;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.pp.spring.trainingrecorderapp.repositories.TrainingRepository;
import pl.pp.spring.trainingrecorderapp.services.TrainingService;

@Service
@Primary
public class TrainingDbService implements TrainingService {

    private final TrainingRepository trainingRepository;

    public TrainingDbService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

}
