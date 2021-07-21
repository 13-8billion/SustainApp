package sustain.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sustain.project.interfaces.AddTransportRepo;
import sustain.project.interfaces.TransportTotalRepo;
import sustain.project.models.AddTransport;
import sustain.project.models.TransportTotal;

import java.util.List;

@Service
@Transactional
public class TransportTotalService {
    @Autowired
    private TransportTotalRepo repo;

    public List<TransportTotal> listAll() {
        return repo.findAll();
    }

    public void save(TransportTotal transportObj) {
        repo.save(transportObj);
    }

    public TransportTotal get(String type) {
        return repo.findById(type).get();
    }

    public void delete(String type) {
        repo.deleteById(type);
    }

    public void deleteAll(Iterable<TransportTotal> transportObj){
        repo.deleteAllInBatch(transportObj);
    }


}