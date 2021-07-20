package sustain.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sustain.project.interfaces.OverAllTotalRepo;
import sustain.project.models.OverAllTotal;


import java.util.List;

@Service
@Transactional
public class OverAllTotalService{
    @Autowired
    private OverAllTotalRepo repo;

    public List<OverAllTotal> listAll() {
        return repo.findAll();
    }

    public void save(OverAllTotal overAllTotalObject) {
        repo.save(overAllTotalObject);
    }

    public OverAllTotal get(String username) {
        return repo.findById(username).get();
    }

    public void delete(String username) {
        repo.deleteById(username);
    }

}