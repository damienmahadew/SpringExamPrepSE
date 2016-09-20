package za.co.mahadew.damien.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * Created by damien.mahadew on 2016-09-19.
 */
@Component
public class BeanFactoryPPExample implements BeanFactoryPostProcessor {

    /**
     * This method will allow us to modify a bean before its even instantiated!!
     *
     * Quite powerful as we can change bean definitions
     * @param configurableListableBeanFactory
     * @throws BeansException
     */
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        //Do something here with a bean
        //Rare to find a custom post processor, the usual ones are properties configurer or registering a custom scope
    }
}
