package sustain.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sustain.project.interfaces.AddEmissionRepo;
import sustain.project.models.AddEmission;
import java.util.List;

@Service
@Transactional
public class  AddEmissionService {
    @Autowired
    private AddEmissionRepo repo;

    public List<AddEmission> listAll() {
        return repo.findAll();
    }

    public void save(AddEmission emissionObj) {
        repo.save(emissionObj);
    }

    public AddEmission get(String username) {
        return repo.findById(username).get();
    }

    public void delete(String username) {
        repo.deleteById(username);
    }

    public void deleteAll(Iterable<AddEmission> emissionObj){
        repo.deleteAllInBatch(emissionObj);
    }


}