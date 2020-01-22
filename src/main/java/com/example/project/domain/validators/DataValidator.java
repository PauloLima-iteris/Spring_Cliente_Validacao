
package com.example.project.domain.validators;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DataValidator implements ConstraintValidator<Dataa, Date> {

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        Calendar c = Calendar.getInstance();
        Date d = new Date();
        if (value.after(after(d, c))) {
            return false;
        }
        if (value.before(before(d, c))) {
            return false;
        }
        return true;
    }
 
    private Date after(Date d, Calendar c) {
        Date after;
        c.setTime(d);
        c.add(Calendar.DATE, 7);
        after = c.getTime();
        System.out.println("Dia after" + after);
        return after;
    }
 
    private Date before(Date d, Calendar c) {
        Date before;
        c.setTime(d);
        c.add(Calendar.DATE, -7);
        before = c.getTime();
        System.out.println(before);
        System.out.println("Dia after" + before);
        return before;
    }
 
}
