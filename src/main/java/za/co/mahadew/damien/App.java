package za.co.mahadew.damien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import za.co.mahadew.damien.config.AppConfig;
import za.co.mahadew.damien.models.Laptop;
import za.co.mahadew.damien.services.LaptopService;
import za.co.mahadew.damien.services.NotificationService;

import javax.persistence.EntityManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);


//      Loading spring xml configuration
        ApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("classpath:/spring-config.xml");

        String getHelloWorld = (String) applicationContext.getBean("getHelloWorld");
        String getBusinessConfigBean = (String) applicationContext.getBean("getBusinessConfigBean");
        String getInfrastructureConfigBean= (String) applicationContext.getBean("getInfrastructureConfigBean");
        String nameFromEnvProp= (String) applicationContext.getBean("testingProp");
        String testingPropFromPropertiesPlaceholder= (String) applicationContext.getBean("testingPropFromPropertiesPlaceholder");
        String personsAgeSpELTesting= (String) applicationContext.getBean("personsAgeSpELTesting");
        LaptopService laptopServiceImpl = (LaptopService) applicationContext.getBean("laptopServiceImpl");

        /**
         * VERY IMPORTANT -- ASpects will only work on beans! as it needs to create proxies for them
         */
        Laptop laptop = (Laptop) applicationContext.getBean("laptopPrototypeBean");
        laptop.setModel(" aspect testing");
        //Testing XML config for aspect String get*()
        laptop.getModel();

        System.out.println(getHelloWorld);
        System.out.println(getBusinessConfigBean);
        System.out.println(getInfrastructureConfigBean);
        System.out.println(nameFromEnvProp);
        System.out.println(testingPropFromPropertiesPlaceholder);
        System.out.println(personsAgeSpELTesting);
        System.out.println(laptopServiceImpl.getLaptopDetails(laptop));
        try {
            laptopServiceImpl.getTestExceptionThrowing(laptop);
        } catch (Exception e) {

        }

        EntityManager entityManager = (EntityManager) applicationContext.getBean("entityManager");



    }


}
