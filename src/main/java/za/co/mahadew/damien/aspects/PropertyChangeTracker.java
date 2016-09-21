package za.co.mahadew.damien.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.xml.ws.BindingType;
import java.util.logging.Logger;

/**
 * Created by damien.mahadew on 2016-09-20.
 */
@Aspect
@Component
public class PropertyChangeTracker {

    private void log(String string) {
        System.out.println(string);
    }

    @Before("execution(String get*(*))")
    public void trackChange() {
        log("property about to change");
    }

    /**
     * using aspects + context
     */
    @Before("execution(void set*(*))")
    public void trackChangeWithContext(JoinPoint joinPoint) {

    }
}
