package sustain.project.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sustain.project.interfaces.ActivityRepo;

@Service
public class AddActivityService {

    @Autowired
    private ActivityRepo repo;

    public void save(AddActivity a) {
        repo.save(a);
    }

//    public AddActivity get(String activityType) {
//        return repo.findById(activityType).get();
//    }
//
//    public void delete(String activityType) {
//        repo.deleteById(activityType);
//    }
}

