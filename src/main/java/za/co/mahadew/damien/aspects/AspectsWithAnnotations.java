package za.co.mahadew.damien.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by DAMIEN6 on 21/09/2016.
 */
@Aspect
@Component
public class AspectsWithAnnotations {
    //e.g.
    // If you want to specify annotations look at the example below- uses named point cut with annotation
    @Around("transactionMethod(txn)")
    public Object testingAspectWithAnnotations(ProceedingJoinPoint joinPoint, Transactional txn) throws Throwable {
        Object value = joinPoint.proceed();
        return value;
    }

    @Pointcut("execution(* *(..)) && @annotation(txn)")
    public void transactionMethod(Transactional txn) {}

}
