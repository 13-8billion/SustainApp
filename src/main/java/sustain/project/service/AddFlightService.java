package sustain.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sustain.project.interfaces.AddFlightRepo;
import sustain.project.models.AddFlight;

import java.util.List;

@Service
@Transactional
public class  AddFlightService {
    @Autowired
    private AddFlightRepo repo;

    public List<AddFlight> listAll() {
        return repo.findAll();
    }

    public void save(AddFlight flightObj) {
        repo.save(flightObj);
    }

    public AddFlight get(String type) {
        return repo.findById(type).get();
    }

    public void delete(String type) {
        repo.deleteById(type);
    }

    public void deleteAll(Iterable<AddFlight> flightObj) {
        repo.deleteAllInBatch(flightObj);
    }
}