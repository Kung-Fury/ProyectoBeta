package com.trifulcas.mavensecurity.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidarPrecioReglasValidacion implements ConstraintValidator<ValidarPrecio, String> {
	@Override
	public void initialize(ValidarPrecio precio) {
	}
	@Override
	public boolean isValid(String precio, ConstraintValidatorContext cxt) {
		String regex = "^([0-9]{0,2}((.)[0-9]{0,2}))$";	
		
		//String regex = "[0-9]+([,.][0-9]{1,2})?";	
	return precio.matches(regex);
	}
}