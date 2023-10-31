package main.java.by.bntu.fitr.poisit.matnik.university.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class Localisation {

    private static Locale currentLocale = new Locale("en", "US");
    private static ResourceBundle messages = ResourceBundle.getBundle("localization", currentLocale);

    public static String getMessage(String key) {
        return messages.getString(key);
    }

    public static void setLocale(String language, String country) {
        currentLocale = new Locale(language, country);
        messages = ResourceBundle.getBundle("localization", currentLocale);
    }
}