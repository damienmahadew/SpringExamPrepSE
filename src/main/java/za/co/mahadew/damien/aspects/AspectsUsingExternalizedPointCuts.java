package za.co.mahadew.damien.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import za.co.mahadew.damien.models.Laptop;

/**
 * Created by DAMIEN6 on 21/09/2016.
 */
@Aspect
@Component
public class AspectsUsingExternalizedPointCuts {

    private void log(String string) {
        System.out.println("AspectsUsingExternalizedPointCutsLOG :: " + string);
    }

    @Before("za.co.mahadew.damien.aspects.ExternalizingPointCutExpressions.getterMethods()")
    public void testingBeforeAspectWithExternalizedPointCuts(JoinPoint joinPoint) {
        log("testingBeforeAspectWithExternalizedPointCuts");
    }

    @After("za.co.mahadew.damien.aspects.ExternalizingPointCutExpressions.setterMethods()")
    public void testingAfterAspectWithExternalizedPointCuts(JoinPoint joinPoint) {
        log("testingAfterAspectWithExternalizedPointCuts");
    }

    @After("za.co.mahadew.damien.aspects.ExternalizingPointCutExpressions.setterMethodsWithTargetAndArgsValidation(laptop, string)")
    public void testingAfterAspectWithExternalizedPointCutsAndTargetAndArgsValidation(Laptop laptop, String string) {
        log("testingAfterAspectWithExternalizedPointCutsAndTargetAndArgsValidation");
    }


}
