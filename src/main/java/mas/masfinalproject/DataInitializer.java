package mas.masfinalproject;

import lombok.RequiredArgsConstructor;
import mas.masfinalproject.model.*;
import mas.masfinalproject.repository.*;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final EateryRepository eateryRepository;
    private final OrderDishRepository orderDishRepository;
    private final OrderRepository orderRepository;
    private final CookRepository cookRepository;
    private final TrainingRepository trainingRepository;
    private final ExperienceRepository experienceRepository;

    @EventListener
    public void atStart(ContextRefreshedEvent ev) {
        System.out.println("Context  refreshed");
//        Training training = Training.builder().description("Training Name").duration("3")
//                .build();
//        trainingRepository.save(training);
//        Experience experience= Experience.builder().duration(3).position("cook_1").build();
//        experienceRepository.save(experience);
//        Set<Experience> experiences = new HashSet<>();
//        experiences.add(experience);
//        try {
//            Cook cook = Cook.builder().
//                    id(112L).name("Jan").PESEL("12345678911").surname("jhon").speciality("Aaaa").phone_number("123456789").experiences(experiences).training(training).
//                    build();
//            cookRepository.save(cook);
//        }catch (IllegalArgumentException e) {
//            System.out.println("XOR constraint violated: " + e.getMessage());
//        }
//
//    }
    }
}
