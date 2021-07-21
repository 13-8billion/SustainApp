package sustain.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sustain.project.interfaces.HouseEnergyRepo;
import sustain.project.models.HouseEnergy;

import java.util.List;

@Service
@Transactional
public class HouseEnergyService {
    @Autowired
    private HouseEnergyRepo repo;

    public List<HouseEnergy> listAll() {
        return repo.findAll();
    }

    public void save(HouseEnergy houseObj) {
        repo.save(houseObj);
    }

    public HouseEnergy get(String type) {
        return repo.findById(type).get();
    }

    public void delete(String type) {
        repo.deleteById(type);
    }

    public void deleteAll(Iterable<HouseEnergy> houseObj){
        repo.deleteAllInBatch(houseObj);
    }


}