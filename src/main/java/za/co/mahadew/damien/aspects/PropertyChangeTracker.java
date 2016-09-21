package za.co.mahadew.damien.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import za.co.mahadew.damien.models.Laptop;

import javax.xml.ws.BindingType;
import java.util.logging.Logger;

/**
 * Created by damien.mahadew on 2016-09-20.
 */
@Aspect
@Component
public class PropertyChangeTracker {

    private void log(String string) {
        System.out.println("PropertyChangeTrackerLOG :: " +string);
    }

    @Before("execution(String get*(*))")
    public void trackChange() {
        log("property about to change");
    }

    /**
     * using aspects + context
     *
     * NOTE::: IF ADVICE THROWS EXCEPTION THEN TARGET WILL NOT BE CALLED
     *
     * If you are checking target type ie class that is called, try and cast + instance of first to check type
     *
     * Dont assume that there are any arguments passed through!!!
     *
     * To avoid the above look at the method called testingContextSelectionInAspects
     *
     */
    @Before("execution(void set*(*))")
    public void trackChangeWithContext(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        Object newValue = joinPoint.getArgs()[0];
        String kind = joinPoint.getKind();
        log(name + " = method name -- about to change to = " + newValue + " -- on" + joinPoint.getTarget() + " and the kind is :" + kind);
    }

    @Before("execution(void set*(*)) && target(laptop) && args(string)")
    public void testingContextSelectionInAspects(Laptop laptop, String string) {
        log("testingContextSelectionInAspects");
    }

    @AfterReturning(value = "execution(String get*(*))", returning = "string")
    public void aspectTestingAfterReturning(JoinPoint joinPoint, String string) {
        log(joinPoint.getSignature() + " - method is returning = " + string);
    }

    @AfterThrowing(value = "execution(String get*(*))", throwing = "e")
    public void aspectTestingAfterThrowing(JoinPoint joinPoint, Exception e) {
        log(joinPoint.getSignature() + " - method is throwing an exception = " + e.getMessage());
        // YOU CAN RETHROW A DIFFERENT EXCEPTION
    }


    @After(value = "execution(String get*(*))")
    public void aspectTestingAfter(JoinPoint joinPoint) throws Exception{
        log(joinPoint.getSignature() + " - after aspect testing -- value = " + joinPoint.getArgs()[0]);
//        throw new Exception("waat"); -- you can throw an exception here tooo
    }

    @Around("execution(String get*(*))")
    public Object aspectTestingAround(ProceedingJoinPoint joinPoint) throws  Throwable {

        Object value = joinPoint.proceed();
        return value + " : Value has changed using around advice";

    }


}
