package CommmonUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ProjectProperties {

   // private static ProjectProperties configProperties = null;
    Properties prop;

    private ProjectProperties() {
        try {
            FileReader reader = new FileReader("src/test/resources/Configuration/Config.properties");
            prop = new Properties();
            prop.load(reader);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}