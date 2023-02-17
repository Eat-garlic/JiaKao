package com.eglc.jk.common.cfg;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Configuration;
import javax.validation.Validation;
import javax.validation.Validator;
@Configuration
public class ValidatorCfg {
    public Validator  validator(){
        //快速失败
        return Validation.byProvider(HibernateValidator.class)
                .configure()
                .failFast(true)
                .buildValidatorFactory()
                .getValidator();
    }
}
