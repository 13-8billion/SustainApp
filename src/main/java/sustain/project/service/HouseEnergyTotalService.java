package sustain.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sustain.project.interfaces.HouseEnergyTotalRepo;
import sustain.project.models.HouseEnergyTotal;

import java.util.List;

@Service
@Transactional
public class HouseEnergyTotalService {
    @Autowired
    private HouseEnergyTotalRepo repo;

    public List<HouseEnergyTotal> listAll() {
        return repo.findAll();
    }

    public void save(HouseEnergyTotal houseObj) {
        repo.save(houseObj);
    }

    public HouseEnergyTotal get(String type) {
        return repo.findById(type).get();
    }

    public void delete(String type) {
        repo.deleteById(type);
    }

    public void deleteAll(Iterable<HouseEnergyTotal> houseObj){
        repo.deleteAllInBatch(houseObj);
    }
}