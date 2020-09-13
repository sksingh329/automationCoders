package utils.assertions;

import org.testng.Assert;
import reports.extent.ReporterUtils;

public class TestValidations {
    public TestValidations(){}
    public void checkEquals(String actual, String expected){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        if(actual.equals(expected))
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,"(Validation) "+"Expected:"+expected+"== Actual:"+actual);
        else
            ReporterUtils.log(ReporterUtils.Status.FAIL,methodName,"(Validation) "+"Expected:"+expected+"!= Actual:"+actual);
    }
    public void checkNotNull(String text){
        String methodName = Thread.currentThread().getStackTrace()[1].getClassName() +"." + Thread.currentThread().getStackTrace()[1].getMethodName();
        if(text != null)
            ReporterUtils.log(ReporterUtils.Status.PASS,methodName,"(Validation) "+text+" is not null.");
        else
            ReporterUtils.log(ReporterUtils.Status.FAIL,methodName,"(Validation) "+text+" is null.");
    }
}
