package me.alivesteve.ffatourney.Utilities;

import org.bukkit.Bukkit;

public class Utilities {

    public static boolean event;
    public static int timer;
    public static int taskID;

    public static void init() {
        Utilities.event = false;
        Utilities.timer = 0;
    }



    public static void setTimer() {
        Utilities.timer = 30;
    }

    public static void stopTimer(){
        Bukkit.getScheduler().cancelTask(taskID);
    }
}
