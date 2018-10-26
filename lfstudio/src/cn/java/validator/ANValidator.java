package cn.java.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ANValidator implements ConstraintValidator<AccountNumberValidator, String>{

	//private String moneyReg = "^\\d+(\\.\\d{1,2})?$";//表示金额的正则表达式  
	private String ANnumver = "^[a-zA-Z]+[a-zA-Z0-9]*";
    private Pattern moneyPattern = Pattern.compile(ANnumver);
	
	@Override
	public void initialize(AccountNumberValidator constraintAnnotation) {
		// TODO Auto-generated method stub
	}
	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		if (arg0 == null)  
	           return true;
		return moneyPattern.matcher(arg0.toString()).matches();
	}
	
}
