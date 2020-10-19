package io.moritzfelixbecker.challange.commands;
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
import io.moritzfelixbecker.challange.utils.TimerUtil;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TimerCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if(player.hasPermission("server.timer")) {
                if(args.length == 0) {

                }


                if(args[0].equalsIgnoreCase("start")) {
                    TimerUtil.startTimer();
                    player.sendMessage(Challange.PREFIX + "Der Timer wurde gestartet");
                    player.playSound(player.getLocation(), Sound.BLOCK_END_PORTAL_FRAME_FILL, 1, 10);
                } else if(args[0].equalsIgnoreCase("stop")) {
                    TimerUtil.stopTimer();
                    player.sendMessage(Challange.PREFIX + "Der Timer wurde pausiert");
                    player.playSound(player.getLocation(), Sound.BLOCK_END_PORTAL_FRAME_FILL, 1, 10);
                } else if(args[0].equalsIgnoreCase("resume")) {
                    TimerUtil.resumeTimer();
                    player.sendMessage(Challange.PREFIX + "Der Timer wurde fortgesetzt");
                    player.playSound(player.getLocation(), Sound.BLOCK_END_PORTAL_FRAME_FILL, 1, 10);
                }

            }

        }


        return true;
    }
}
