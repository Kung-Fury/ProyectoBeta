package com.trifulcas.mavensecurity.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ValidarPrecioReglasValidacion.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidarPrecio {
	String message() default "Formato de precio icorrecto.";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}