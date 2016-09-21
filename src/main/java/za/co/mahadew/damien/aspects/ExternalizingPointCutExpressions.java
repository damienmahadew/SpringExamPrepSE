package za.co.mahadew.damien.aspects;

import org.aspectj.lang.annotation.Pointcut;
import za.co.mahadew.damien.models.Laptop;

/**
 * Created by DAMIEN6 on 21/09/2016.
 */
public class ExternalizingPointCutExpressions {

    /**
     * This is the best practice i.e. declare point cuts in separate file
     */

    @Pointcut("execution(String get*())")
    public void getterMethods(){}

    @Pointcut("execution(void set*(*))")
    public void setterMethods(){}

    @Pointcut("execution(void set*(*)) && target(laptop) && args(string)")
    public void setterMethodsWithTargetAndArgsValidation(Laptop laptop, String string){}



}
