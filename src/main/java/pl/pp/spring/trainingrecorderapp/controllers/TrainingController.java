package pl.pp.spring.trainingrecorderapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.pp.spring.trainingrecorderapp.model.Training;
import pl.pp.spring.trainingrecorderapp.repositories.TrainingRepository;


@Controller
public class TrainingController {

    private final TrainingRepository trainingRepository;

    public TrainingController(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    @GetMapping("/saveTraining")
    public String showAddForm(Model model) {
        model.addAttribute("training", new Training());
        return "saveTraining";
    }

    @GetMapping("/trainings/{trainingId}/edit")
    public String showEditCategoryForm(@PathVariable Long trainingId, Model model) {
        Training training = trainingRepository.findById(trainingId).orElse(null);
        model.addAttribute("training", training);

        return "saveTraining";
    }

    @PostMapping("/saveTraining")
    public String saveTraining(@ModelAttribute Training training) {
        trainingRepository.save(training);
        return "redirect:/trainingsList";
    }

    @GetMapping("/trainings/{trainingId}/delete")
    public String deleteTraining(@PathVariable Long trainingId) {
        trainingRepository.deleteById(trainingId);
        return "redirect:/trainingsList";
    }

    @RequestMapping("/trainingsList")
    public String showList(Model model) {
        model.addAttribute("trainings", trainingRepository.findAll());
        return "trainingsList";
    }

}
