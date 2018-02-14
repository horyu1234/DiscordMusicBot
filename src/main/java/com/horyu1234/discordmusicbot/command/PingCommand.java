package com.horyu1234.discordmusicbot.command;

import com.horyu1234.discordmusicbot.Colors;
import de.btobastian.sdcf4j.Command;
import de.btobastian.sdcf4j.CommandExecutor;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Message;

/**
 * Created by horyu on 2018-02-14
 */
public class PingCommand implements CommandExecutor {
    @Command(aliases = {"h!ping", "h!핑"})
    public void onPingCommand(Message message, JDA jda) {
        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setDescription("퐁!")
                .setColor(Colors.BLUE);

        message.getChannel().sendMessage(embedBuilder.build()).complete();
    }
}
