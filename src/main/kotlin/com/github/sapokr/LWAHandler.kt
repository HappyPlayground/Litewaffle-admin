package com.github.sapokr

import com.discord.sapokr.litewaffle.LiteWaffle.Companion.Ops
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.bukkit.Bukkit

class LWAHandler: ListenerAdapter() {
    override fun onMessageReceived(event: MessageReceivedEvent) {
        val content = event.message.contentRaw.substring(1)

        if (content.startsWith("/")) {
            if (!Ops.contains(event.author.id)) {
                event.message.reply("권한이 없습니다.").queue()
                return
            }

            val plugin = Bukkit.getPluginManager().getPlugin("LiteWaffle-Admin") ?: return

            Bukkit.getScheduler().runTask(plugin, Runnable {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), content.substring(1))
            })

            event.message.reply("완료").queue()
            return
        }
    }
}