package com.example.project.domain.validators;

import static org.junit.Assert.assertTrue;
import java.util.Calendar;
import java.util.Date;
import static org.junit.Assert.assertFalse;
import javax.validation.ConstraintValidatorContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class DataValidatorTest {

    @Mock
    ConstraintValidatorContext constraintValidatorContext;

    DataValidator dataValidator;

    @Before
    public void setUp() {

        dataValidator = new DataValidator();
    }

    @Test
    public void should_NotBeValid_WhenNotNumber() {
        assertTrue(dataValidator.isValid(new Date(), constraintValidatorContext));
    }

    @Test
    public void should_NotBeValid_WhenDataAfter7days(){
        Calendar c = Calendar.getInstance();
        Date dataa = new Date();
        c.setTime(dataa);
        c.add(Calendar.DATE, 7);
        assertTrue(dataValidator.isValid(c.getTime(), constraintValidatorContext));
    }

    @Test
    public void should_NotBeValid_WhenDataBefore7days(){
        Calendar d = Calendar.getInstance();
        Date datae = new Date();
        d.setTime(datae);
        d.add(Calendar.DATE,-7);
        assertTrue(dataValidator.isValid(d.getTime(), constraintValidatorContext));
    }

    @Test
    public void should_NotBeValid_Whennotnull(){
        assertFalse(dataValidator.isValid(null, constraintValidatorContext));
    }

    @Test
    public void should_NotBeValid_WhenDataAfter10(){
        Calendar d = Calendar.getInstance();
        Date datae = new Date();
        d.setTime(datae);
        d.add(Calendar.DATE,-10);
        assertFalse(dataValidator.isValid(d.getTime(), constraintValidatorContext));
    }

    @Test
    public void should_NotBeValid_WhenDataBefore10(){
        Calendar d = Calendar.getInstance();
        Date datae = new Date();
        d.setTime(datae);
        d.add(Calendar.DATE, 10);
        assertFalse(dataValidator.isValid(d.getTime(), constraintValidatorContext));
    }

} 