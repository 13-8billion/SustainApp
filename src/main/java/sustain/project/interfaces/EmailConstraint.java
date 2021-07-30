package sustain.project.interfaces;

import sustain.project.models.EmailValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailConstraint {
    String message() default "*Email already exists!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
