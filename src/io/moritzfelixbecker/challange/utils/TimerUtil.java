package io.moritzfelixbecker.challange.utils;
/*
 * Project: [Minecraft] Challange 1.16.3 1
 * Author: Moritz Felix Becker
 * Date: 18.10.2020
 * Copyright © 2020 Moritz Felix Becker
 * All rights reserved. No part of this publication may be reproduced,
 * distributed, or transmitted in any form or by any means, including photocopying, recording,
 * or other methods, without the prior written permission of the publisher,
 * except in the case of brief quotations embodied in critical reviews and certain other noncommercial
 * uses permitted by copyright law. For permission requests, write to the publisher, addressed
 * “Moritz-Felix.Becker@web.de” at the address below.
 */

import io.moritzfelixbecker.challange.Challange;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class TimerUtil {

    private static long startTime;
    private static long stopTime;
    private static long millis;
    private static int seconds;
    private static int minutes;
    private static long hours;
    private static int days;
    private static long before;


    private static boolean started;


    public static void startTimer() {
        started = true;
        startTime = System.currentTimeMillis();

        Bukkit.getScheduler().scheduleSyncRepeatingTask(Challange.getInstance(), ()-> {
            if(started) {
                stopTime = System.currentTimeMillis();
                millis = before + (stopTime - startTime);
                seconds = (int) TimeUnit.MILLISECONDS.toSeconds(millis);
                minutes = (int) TimeUnit.SECONDS.toMinutes(seconds);
                hours = TimeUnit.MINUTES.toHours(minutes);
            }

            Bukkit.getOnlinePlayers().forEach((player)->{
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(TimerUtil.getTime()));
            });

        }, 10, 10);

    }

    public static void stopTimer() {
        if(started) {
           started = false;
           stopTime = System.currentTimeMillis();
        }
    }

    public static void resetTimer() {
        started = false;
        millis = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;
        days = 0;
    }

    public static void resumeTimer() {
        before = before + millis;
        stopTime = 0;
        startTime = System.currentTimeMillis() - before;
        started = true;
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Challange.getInstance(), ()-> {
            if(started) {
                stopTime = System.currentTimeMillis();
                millis = stopTime - startTime;
                seconds = (int) TimeUnit.MILLISECONDS.toSeconds(millis);
                minutes = (int) TimeUnit.SECONDS.toMinutes(seconds);
                hours = TimeUnit.MINUTES.toHours(minutes);
            }

            Bukkit.getOnlinePlayers().forEach((player)->{
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(TimerUtil.getTime()));
            });

        }, 10, 10);
    }

    public static String getTime() {
        return "§8» §a" + days + ":" + hours + ":" + minutes + ":" + seconds;
    }


}
