package com.github.sapokr

import com.discord.sapokr.litewaffle.LiteWaffle.Companion.LWUtility
import com.discord.sapokr.litewaffle.LiteWaffle.Companion.LWInitialize
import org.bukkit.plugin.java.JavaPlugin;

class LiteWaffle_Admin : JavaPlugin() {
    companion object {
        var LiteUtility: LWUtility = LWInitialize("LiteWaffle_Admin")
    }

    override fun onEnable() {
        logger.info("LiteWaffle Admin Loaded.")

        LiteUtility.setDisplayname("LiteWaffle Admin")

        LiteUtility.addListenerHandler(LWAHandler())
    }

    override fun onDisable() {
        logger.info("LiteWaffle Admin Unloaded.")
    }
}