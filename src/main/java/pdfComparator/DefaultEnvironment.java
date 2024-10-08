package pdfComparator;

import com.typesafe.config.ConfigFactory;



public class DefaultEnvironment {

    public static Environment create() {
        ConfigFactory.invalidateCaches();
        return new ConfigFileEnvironment(ConfigFactory.load());
    }
}
