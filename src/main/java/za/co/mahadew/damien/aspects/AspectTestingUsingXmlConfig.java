package za.co.mahadew.damien.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by DAMIEN6 on 21/09/2016.
 */
public class AspectTestingUsingXmlConfig {

    private void log(String string) {
        System.out.println("AspectTestingUsingXmlConfigLOG :: " + string);
    }

    public void testingXmlConfigBeforeAdvice(JoinPoint joinPoint) {
        log("Before Advice - Method Name = " + joinPoint.getSignature());
    }

    public void testingXmlConfigAfterAdvice(JoinPoint joinPoint) {
        log("After Advice - Method Name = " + joinPoint.getSignature());
    }

    public void testingXmlConfigAfterReturningAdvice(JoinPoint joinPoint, String string) {
        log("After Advice - Method Name = " + joinPoint.getSignature() + " - returning string = " + string);
    }

    public void testingXmlConfigAfterThrowingAdvice(JoinPoint joinPoint, Exception e) {
        log("After Advice - Method Name = " + joinPoint.getSignature() + " after throwing = " + e.getMessage());
    }

    public Object testingXmlConfigAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
        log("Around Advice - Method Name = " + joinPoint.getSignature() + " - adding AROUNDADVICE to string");
        Object value = joinPoint.proceed();
        return value + "AROUNDADVICE";
    }


}
