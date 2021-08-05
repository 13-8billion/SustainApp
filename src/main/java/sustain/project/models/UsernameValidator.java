package sustain.project.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import sustain.project.interfaces.UsernameConstraint;
import sustain.project.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;


@Configurable
public class UsernameValidator implements ConstraintValidator<UsernameConstraint, String> {

    @Autowired
    private UserService service;

    @Override
    public void initialize(UsernameConstraint username) {
    }

    @Override
    public boolean isValid(String username,
                           ConstraintValidatorContext cxt) {

        ArrayList<String> names = new ArrayList<>();

        for (int i = 0; i < service.listAll().size(); i++) {
            names.add(service.listAll().get(i).getUsername());
        }
        return !names.contains(username);
    }

}