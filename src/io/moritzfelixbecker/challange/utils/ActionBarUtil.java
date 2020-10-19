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

import net.minecraft.server.v1_16_R2.MathHelper;
import org.bukkit.Bukkit;

public class ActionBarUtil {

    private static long startTime;
    private static long stopTime;
    private static long currentTime;
    private static boolean started;


    public static void startTimer() {
        startTime = System.currentTimeMillis();
        started = true;
    }

    public static void stopTimer() {
        stopTime = System.currentTimeMillis();
        currentTime = currentTime + (stopTime - startTime);
        started = false;
    }

    public static void resetTimer() {

    }

    public static void resumeTimer() {
        if(!started) {
            startTime = System.currentTimeMillis();
            started = true;
        }
    }

    public static int[] getTime() {
        if(!started) {
            int[] out = new int[]{0, 0, 0, 0};
            out[0] = (int)(currentTime/3600000  );
            out[1] = (int)(currentTime/60000  ) % 60;
            out[2] = (int)(currentTime/1000  ) % 60;
            out[3] = (int)(currentTime)     % 1000;
            return out;
        }


        int[] out = new int[]{0, 0, 0, 0};
        out[0] = (int)(currentTime/3600000  );
        out[1] = (int)(currentTime/60000  ) % 60;
        out[2] = (int)(currentTime/1000  ) % 60;
        out[3] = (int)(currentTime)     % 1000;
        return out;
    }

}
