package sustain.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sustain.project.interfaces.AddTransportRepo;
import sustain.project.models.AddTransport;

import java.util.List;

@Service
@Transactional
public class AddTransportService {
    @Autowired
    private AddTransportRepo repo;

    public List<AddTransport> listAll() {
        return repo.findAll();
    }

    public void save(AddTransport transportObj) {
        repo.save(transportObj);
    }

    public AddTransport get(String type) {
        return repo.findById(type).get();
    }

    public void delete(String type) {
        repo.deleteById(type);
    }

    public void deleteAll(Iterable<AddTransport> transportObj){
        repo.deleteAllInBatch(transportObj);
    }


}