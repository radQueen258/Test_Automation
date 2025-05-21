package instruction_33;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

public class Settings {
    private static String file = "src/test/resources/Settings.xml";
    private static Document document;
    private static String baseUrl;
    private static String login;
    private static String password;

    static {
        try {
            File f = new File(file);
            if (!f.exists()) {
                throw new RuntimeException("Settings file not found: " + file);
            }
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            document = dBuilder.parse(f);
            document.getDocumentElement().normalize();
        } catch (Exception e) {
            throw new RuntimeException("Error reading settings: " + e.getMessage());
        }
    }

    public static String getBaseUrl() {
        if (baseUrl == null) {
            baseUrl = getTagValue("BaseUrl");
        }
        return baseUrl;
    }

    public static String getLogin() {
        if (login == null) {
            login = getTagValue("Login");
        }
        return login;
    }

    public static String getPassword() {
        if (password == null) {
            password = getTagValue("Password");
        }
        return password;
    }

    private static String getTagValue(String tag) {
        NodeList list = document.getElementsByTagName(tag);
        if (list.getLength() > 0) {
            return list.item(0).getTextContent();
        }
        throw new RuntimeException("Tag not found in settings: " + tag);
    }
}
