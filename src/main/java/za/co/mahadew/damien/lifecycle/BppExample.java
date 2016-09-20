package za.co.mahadew.damien.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by damien.mahadew on 2016-09-19.
 */
@Component
public class BppExample implements BeanPostProcessor {

    /**
     * You can modify the instantiated bean before and after initialization
     * Not common to write your own, however spring provides many implementations
     */
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        return null;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return null;
    }
}
