package mas.masfinalproject.Service;

import mas.masfinalproject.model.Cook;
import mas.masfinalproject.repository.CookRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CookService {
    private final CookRepository cookRepository;

    @Autowired
    public CookService(CookRepository cookRepository) {
        this.cookRepository = cookRepository;
    }

    public Cook saveCook(Cook cook) {
        // Check XOR constraint between experiences and training
        if (cook.getExperiences() != null && cook.getTraining() != null) {
            throw new IllegalArgumentException("Experiences and Training are mutually exclusive. Only one should be set.");
        }

        return cookRepository.save(cook);
    }


}
