package sustain.project.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import sustain.project.classes.AddActivity;

public interface ActivityRepo extends JpaRepository<AddActivity, Integer> {
}