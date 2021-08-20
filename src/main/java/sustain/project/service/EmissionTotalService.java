package sustain.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sustain.project.interfaces.EmissionTotalRepo;
import sustain.project.models.EmissionTotal;


import java.util.List;

@Service
@Transactional
public class EmissionTotalService {
    @Autowired
    private EmissionTotalRepo repo;

    public List<EmissionTotal> listAll() {
        return repo.findAll();
    }

    public void save(EmissionTotal emissionTotalObject) {
        repo.save(emissionTotalObject);
    }

    public EmissionTotal get(String username) {
        return repo.findById(username).get();
    }

    public void delete(String username) {
        repo.deleteById(username);
    }

}

