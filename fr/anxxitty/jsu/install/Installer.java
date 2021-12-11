package fr.anxxitty.jsu.install;

import java.io.File;

public class Installer {

    public static void installClient(File installLocation, String version, Boolean createProfile) {
        if (!installLocation.exists()) {
            System.err.println("Error: " + installLocation.getAbsolutePath() + " folder does not exist, please enter a correct install location");
            return;
        }
        System.out.println("Installing client with options : Install Location = " + installLocation + ", Version = " + version + ", Create Profile = " + createProfile);
    }

    public static void installServer(File installLocation, String version, Boolean generateScripts) {
        if (!installLocation.exists()) {
            System.err.println("Error: " + installLocation.getAbsolutePath() + " folder does not exist, please enter a correct install location");
            return;
        }
        System.out.println("Installing server with options : Install Location = " + installLocation + ", Version = " + version + ", Generate Start Scripts = " + generateScripts);
    }

}
