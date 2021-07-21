package sustain.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sustain.project.interfaces.AddHouseRepo;
import sustain.project.models.AddHouse;
import java.util.List;

@Service
@Transactional
public class  AddHouseService {
    @Autowired
    private AddHouseRepo repo;

    public List<AddHouse> listAll() {
        return repo.findAll();
    }

    public void save(AddHouse houseObj) {
        repo.save(houseObj);
    }

    public AddHouse get(String type) {
        return repo.findById(type).get();
    }

    public void delete(String type) {
        repo.deleteById(type);
    }

    public void deleteAll(Iterable<AddHouse> houseObj){
        repo.deleteAllInBatch(houseObj);
    }


}