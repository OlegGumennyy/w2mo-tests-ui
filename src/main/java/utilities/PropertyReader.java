package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*******************************************************************************
 * (C) Copyright
 * Logivations GmbH, Munich 2010-2016
 ******************************************************************************/

public class PropertyReader {

    private static final String PROP_FILE = "application.properties";
    private static final String CRM_TEST_DATA_FILE = "D:\\Personal files\\w2mo-tests-ui\\src\\test\\resources\\testdata\\warehouse\\test-data.xml";

    public static String loadProperty(String property) throws FileNotFoundException {
        return getPropertyString(property, PROP_FILE);
    }

    public static String loadTestData(String property) throws FileNotFoundException {
        return getPropertyString(property, CRM_TEST_DATA_FILE);
    }

    private static String getPropertyString(String name, String filePath) throws FileNotFoundException {
        Properties property = new Properties();
        InputStream input = new FileInputStream(filePath);

        try {
            property.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String value = "";

        if (name != null) {
            value = property.getProperty(name);
        }
        return value;
    }

}
