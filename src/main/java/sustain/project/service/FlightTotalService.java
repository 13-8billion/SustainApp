package sustain.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sustain.project.interfaces.FlightTotalRepo;
import sustain.project.models.FlightTotal;

import java.util.List;


@Service
@Transactional
public class FlightTotalService {

    @Autowired
    private FlightTotalRepo repo;

    public List<FlightTotal> listAll() {
        return repo.findAll();
    }

    public void save(FlightTotal flightObj) {
        repo.save(flightObj);
    }

    public FlightTotal get(int id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }

    public void deleteAll(Iterable<FlightTotal> flightObj){
        repo.deleteAllInBatch(flightObj);
    }


}