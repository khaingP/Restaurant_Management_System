package mas.masfinalproject.Service;

import lombok.RequiredArgsConstructor;
import mas.masfinalproject.model.Eatery;
import mas.masfinalproject.model.EateryType;
import mas.masfinalproject.repository.EateryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EateryService {
    private final EateryRepository eateryRepository;

    public List<Eatery> eateryOrderedList(){
        return eateryRepository.findOrderedByName();
    }

//    changing methods for dynamic inheritance
    public void changeToCafe(Eatery eatery) {
        removePreviousType(eatery);
        eatery.getTypes().add(EateryType.CAFE);
        eateryRepository.save(eatery);
    }

    public void changeToRestaurant(Eatery eatery) {
        removePreviousType(eatery);
        eatery.getTypes().add(EateryType.RESTAURANT);
        eateryRepository.save(eatery);
    }

    public void changeToBar(Eatery eatery) {
        removePreviousType(eatery);
        eatery.getTypes().add(EateryType.BAR);
        eateryRepository.save(eatery);
    }

    private void removePreviousType(Eatery eatery) {
        eatery.getTypes().clear();
    }




}
