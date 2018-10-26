package cn.java.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD, ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)  
@Constraint(validatedBy=ANValidator.class)  
public @interface AccountNumberValidator {
	String message() default "账号必须已字母开头";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default {};
}
