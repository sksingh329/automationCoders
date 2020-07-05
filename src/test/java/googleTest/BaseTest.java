package googleTest;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import utils.HandlePropertiesFile;

import java.util.Properties;


public class BaseTest {
    public Properties env;
    public Logger log;
    @BeforeClass
    public void setUpSuite(){
        env = HandlePropertiesFile.loadProperties("src/test/java/env/", "env.properties");
    }
}
