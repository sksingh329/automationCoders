package utils.assertions;

import org.testng.Assert;
import reports.extent.ReporterUtils;

public class TestValidations {
    public TestValidations(){}
    //TODO - Implement generic for parameters
    //TODO - Add method for contains, regular expression
    public void checkEquals(String validationDetails, String actual, String expected){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        if(actual.equals(expected))
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,validationDetails+"</br>Validation- "+"Expected:"+expected+"== Actual:"+actual);
        else
            ReporterUtils.log(ReporterUtils.Status.FAIL,methodName,validationDetails+"</br>(Validation) "+"Expected:"+expected+"!= Actual:"+actual);
    }
    public void checkNotNull(String validationDetails,String text){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        if(text != null)
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,validationDetails+"</br>(Validation) "+text+" is not null.");
        else
            ReporterUtils.log(ReporterUtils.Status.FAIL,methodName,validationDetails+"</br>(Validation) "+text+" is null.");
    }
    public void checkTrue(String validationDetails,boolean expression){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        if(expression)
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName, validationDetails+"</br>(Validation) Is expression true? "+ true +".");
        else
            ReporterUtils.log(ReporterUtils.Status.FAIL,methodName, validationDetails+"</br>(Validation) Is expression true? "+ false +".");
    }
}
