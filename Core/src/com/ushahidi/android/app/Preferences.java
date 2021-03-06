
package com.ushahidi.android.app;

import java.io.File;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {
    public static boolean httpRunning = false;

    public static boolean AutoFetch = false;

    public static boolean vibrate = false;

    public static boolean ringtone = false;

    public static boolean flashLed = false;

    public static int countries = 0;

    public static int AutoUpdateDelay = 0;

    public static final int NOTIFICATION_ID = 1;

    public static final String PREFS_NAME = "UshahidiService";

    public static String incidentsResponse = "";

    public static String categoriesResponse = "";

    public static String savePath = "";

    public static String domain = "";

    public static String firstname = "";

    public static String lastname = "";

    public static String email = "";

    public static String totalReports = "";

    public static String fileName = "";

    public static int isCheckinEnabled = 0;

    public static int appRunsFirstTime = 0;

    public static int activeDeployment = 0;

    public static int photoWidth = 200;

    public static String deploymentLatitude = "0.0";

    public static String deploymentLongitude = "0.0";

    private static SharedPreferences settings;

    private static SharedPreferences.Editor editor;

    public static String totalReportsFetched = "";

    public static void loadSettings(Context context) {
        final SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);

        final String path = context.getDir("",
                Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE).toString();

        savePath = settings.getString("savePath", path);

        domain = settings.getString("Domain", Preferences.domain);
        firstname = settings.getString("Firstname", "");
        lastname = settings.getString("Lastname", "");
        email = settings.getString("Email", "");
        countries = settings.getInt("Countries", 0);
        AutoUpdateDelay = settings.getInt("AutoUpdateDelay", 5);
        AutoFetch = settings.getBoolean("AutoFetch", false);
        totalReports = settings.getString("TotalReports", "20");
        isCheckinEnabled = settings.getInt("CheckinEnabled", isCheckinEnabled);
        activeDeployment = settings.getInt("ActiveDeployment", 0);
        deploymentLatitude = settings.getString("DeploymentLatitude", "0.0");
        deploymentLongitude = settings.getString("DeploymentLongitude", "0.0");
        photoWidth = settings.getInt("PhotoWidth", 200);
        appRunsFirstTime = settings.getInt("AppRunsFirstTime", appRunsFirstTime);
        // make sure folder exists
        final File dir = new File(Preferences.savePath);
        dir.mkdirs();

    }

    public static void saveSettings(Context context) {
        settings = context.getSharedPreferences(PREFS_NAME, 0);
        editor = settings.edit();
        editor.putString("Domain", domain);
        editor.putInt("CheckinEnabled", isCheckinEnabled);
        editor.putInt("ActiveDeployment", activeDeployment);
        editor.putString("DeploymentLatitude", deploymentLatitude);
        editor.putString("DeploymentLongitude", deploymentLongitude);
        editor.putInt("AppRunsFirstTime", appRunsFirstTime);
        editor.commit();
    }
}
