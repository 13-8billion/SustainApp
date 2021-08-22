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

    public EmissionTotal get(int id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

}

