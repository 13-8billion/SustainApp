package sustain.project.models;

import org.springframework.beans.factory.annotation.Autowired;
import sustain.project.interfaces.EmailConstraint;
import sustain.project.service.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class EmailValidator implements ConstraintValidator<EmailConstraint, String> {

    @Autowired
    private UserService service;

    @Override
    public void initialize(EmailConstraint email) {
    }

    @Override
    public boolean isValid(String email,
                           ConstraintValidatorContext cxt) {

        ArrayList<String> emails = new ArrayList<>();
        List<User> users = service.listAll();

        for (int i = 0; i < users.size(); i++) {
            emails.add(users.get(i).getEmail());

        }
        return !emails.contains(email);
    }

}