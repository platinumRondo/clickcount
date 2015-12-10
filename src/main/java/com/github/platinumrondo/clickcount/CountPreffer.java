package com.github.platinumrondo.clickcount;

import java.util.prefs.Preferences;

/**
 * Utility class that retrieve and store the value reached. 
 * @author rondo
 */
public final class CountPreffer {
    private static final String KEY = "count";
    private static final Preferences PREF = Preferences
            .userNodeForPackage(Main.class);

    private CountPreffer() {
    }

    public static long get() {
        return PREF.getLong(KEY, 0);
    }

    public static void put(long i) {
        PREF.putLong(KEY, i);
    }

}
