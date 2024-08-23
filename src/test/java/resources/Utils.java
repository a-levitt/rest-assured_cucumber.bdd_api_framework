package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {

    RequestSpecification req;

    public RequestSpecification requestSpecification() throws IOException {

        PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));

        req = new RequestSpecBuilder()
            .setBaseUri(getGlobalValue("baseUrl"))
            .addQueryParam("key", "qaclick123")
            .setContentType(ContentType.JSON)
            .addFilter(RequestLoggingFilter.logRequestTo(log))
            .addFilter(ResponseLoggingFilter.logResponseTo(log))
            .build()
        ;

        return req;
    }

    public static String getGlobalValue(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("src/test/java/resources/global.properties");
        properties.load(fis);
        return properties.getProperty(key);
    }
}
