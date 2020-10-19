package io.moritzfelixbecker.challange.lister;
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
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent playerJoinEvent) {
        Player player = playerJoinEvent.getPlayer();

        playerJoinEvent.setJoinMessage(
                Challange.PREFIX + "Der Spieler §8» §c" + player.getDisplayName() + " §7hat die Welt betreten."
        );


    }

}
