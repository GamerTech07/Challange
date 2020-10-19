package io.moritzfelixbecker.challange;
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

import io.moritzfelixbecker.challange.commands.TimerCMD;
import io.moritzfelixbecker.challange.lister.PlayerJoinListener;
import io.moritzfelixbecker.challange.utils.TimerUtil;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Challange extends JavaPlugin {

    private static Challange instance;

    public static String PREFIX = "§8› §9Challange §8» §7";

    @Override
    public void onEnable() {
        instance = this;

        getCommand("timer").setExecutor(new TimerCMD());

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoinListener(), this);


    }

    @Override
    public void onDisable() {

    }

    public static Challange getInstance() {
        return instance;
    }
}
