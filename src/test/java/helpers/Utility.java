package helpers;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;

public class Utility {
    public static File getJSONSchemaFile(String JSONFile) {
        return new File("src/test/java/helpers/JSONSchemas/" +JSONFile);
    }
    public static String generateRandomEmail() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz"+"1234567890"+"_-~";
        String email = "";
        String temp = RandomStringUtils.randomAlphanumeric(10); //email length 10 chars
        email = temp + "@testdata.com";
        return email;
    }
    public static String generateRandomUsername() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz"+"1234567890"+"_-~";
        String username = "";
        username = RandomStringUtils.randomAlphanumeric(5);
        return username;
    }
}
