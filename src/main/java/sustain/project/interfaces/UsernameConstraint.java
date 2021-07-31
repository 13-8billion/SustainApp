package sustain.project.interfaces;

import sustain.project.models.UsernameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UsernameValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UsernameConstraint {
    String message() default "*Username already exists!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}