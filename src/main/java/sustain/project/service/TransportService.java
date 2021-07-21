package sustain.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sustain.project.interfaces.TransportRepo;
import sustain.project.models.Transport;
import java.util.List;

@Service
@Transactional
public class TransportService {
    @Autowired
    private TransportRepo repo;

    public List<Transport> listAll() {
        return repo.findAll();
    }

    public void save(Transport transportObj) {
        repo.save(transportObj);
    }

    public Transport get(String type) {
        return repo.findById(type).get();
    }

    public void delete(String type) {
        repo.deleteById(type);
    }

    public void deleteAll(Iterable<Transport> transportObj){
        repo.deleteAllInBatch(transportObj);
    }


}