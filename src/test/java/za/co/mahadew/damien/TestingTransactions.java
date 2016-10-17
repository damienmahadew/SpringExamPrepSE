package za.co.mahadew.damien;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import za.co.mahadew.damien.config.AppConfig;

/**
 * Created by damien.mahadew on 2016-10-17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"config/AppConfig.java"})
@Transactional
public class TestingTransactions {

    @Test
    public void exampleTransactionalTesting() {
        //Since the class is declared as @Transactional, the methods have the same property
    }

    @Test
    @Commit
    public void exapleTestCommit() {
        //Whatever happens here will be committed
    }
}
