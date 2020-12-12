package utils.assertions;

import exceptions.CustomExceptions;
import reports.extent.ReporterUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestValidations {
    public TestValidations(){}
    //TODO - Implement generic for parameters - float, double
    public void checkEquals(String validationDetails, String actual, String expected){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        if(actual.equals(expected))
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,validationDetails+"</br>Validation- "+"Expected:"+expected+"</br>Actual:"+actual);
        else
            throw new CustomExceptions(methodName,validationDetails+"</br>(Validation) "+"Expected:"+expected+"</br>Actual:"+actual);
    }
    public void checkEquals(String validationDetails, int actual, int expected){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        if(actual == expected)
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,validationDetails+"</br>Validation- "+"Expected:"+expected+"</br>Actual:"+actual);
        else
            throw new CustomExceptions(methodName,validationDetails+"</br>(Validation) "+"Expected:"+expected+"</br>Actual:"+actual);
    }
    public void checkNotNull(String validationDetails,String text){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        if(text != null)
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,validationDetails+"</br>(Validation) "+text+" is not null.");
        else
            throw new CustomExceptions(methodName,validationDetails+"</br>(Validation) "+text+" is null.");
    }
    public void checkTrue(String validationDetails,boolean expression){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        if(expression)
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName, validationDetails+"</br>(Validation) Is expression true? "+ true +".");
        else
            throw new CustomExceptions(methodName,validationDetails+"</br>(Validation) Is expression true? "+ false +".");
    }
    public void checkFalse(String validationDetails,boolean expression){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        if(!expression)
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName, validationDetails+"</br>(Validation) Is expression false? "+ false +".");
        else
            throw new CustomExceptions(methodName,validationDetails+"</br>(Validation) Is expression false? "+ true +".");
    }
    // Implement regular expression for partial validation 
    public void checkContains(String validationDetails, String actual, String partialText){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        if(actual.contains(partialText))
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,validationDetails+"</br>Validation- "+"Expected Partial Text:"+partialText+"</br>Actual:"+actual);
        else
            throw new CustomExceptions(methodName,validationDetails+"</br>(Validation) "+"Expected Partial Text:"+partialText+"</br>Actual:"+actual);
    }
    public void checkContains(String validationDetails, String actual, String expectedPattern,boolean usingRegEx){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        Pattern pattern = Pattern.compile(expectedPattern);
        Matcher matcher = pattern.matcher(actual);
        if(matcher.matches())
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,validationDetails+"</br>Validation- "+"Expected Pattern:"+expectedPattern+"</br>Actual:"+actual);
        else
            throw new CustomExceptions(methodName,validationDetails+"</br>(Validation) "+"Expected Pattern:"+expectedPattern+"</br>Actual:"+actual);
    }
}
