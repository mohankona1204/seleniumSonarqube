package Library;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    Properties properties;

    InputStream inputStream = null;

    String propFilePath=System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";

    public PropertyReader() {
        properties = new Properties();
        loadProperties();
    }

    private void loadProperties() {
        try {
            inputStream = new FileInputStream(propFilePath);
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.print("Unable to load config.properties");
            e.printStackTrace();
        }
    }

    public String readProperty(String key) {
        return properties.getProperty(key);
    }

    public void setProperty(String key, String value) throws ConfigurationException {
        PropertiesConfiguration config = new PropertiesConfiguration(propFilePath);
        config.setProperty(key, value);
        config.save();
    }
}
