package ua.training.controller.util;

import ua.training.constants.PropertyFileNames;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleUtil {

    public static String getPropertyFromLangBundle(String property, Locale lang) {
        ResourceBundle langBundle = ResourceBundle.getBundle(PropertyFileNames.LOCALE, lang);
        return langBundle.getString(property);
    }
}
