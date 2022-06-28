package pl.pp.spring.trainingrecorderapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.pp.spring.trainingrecorderapp.model.Training;

public interface TrainingRepository extends CrudRepository<Training, Long> {
}
