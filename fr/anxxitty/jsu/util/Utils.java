package fr.anxxitty.jsu.util;

import java.io.File;
import java.util.Locale;

public class Utils {

    public static String getHomeFolder() {
        return System.getProperty("user.home");
    }

    public static String findMinecraftDir() {
        String os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
        String path;
        if (os.contains("win")) {
            path = System.getenv("APPDATA") + "/.minecraft";
        } else {
            path = System.getProperty("user.home");
            if (os.contains("mac")) {
                path = path + "Library" + File.separator + "Application Support";
            }
            else {
                path += "/.minecraft";
            }
        }
        return path;
    }

}
