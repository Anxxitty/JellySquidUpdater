package fr.anxxitty.jsu.install;

import java.io.File;

public class Updater {

    public static void updateClient(File installLocation, String version) {
        if (!installLocation.exists()) {
            System.err.println("Error: " + installLocation.getAbsolutePath() + " folder does not exist, please enter a correct install location");
            return;
        }
        System.out.println("Updating client with options : Install Location = " + installLocation + ", Version = " + version);
    }

    public static void updateServer(File installLocation, String version) {
        if (!installLocation.exists()) {
            System.err.println("Error: " + installLocation.getAbsolutePath() + " folder does not exist, please enter a correct install location");
            return;
        }
        System.out.println("Updating server with options : Install Location = " + installLocation + ", Version = " + version);
    }


}
