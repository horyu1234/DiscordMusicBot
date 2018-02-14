package com.horyu1234.discordmusicbot;

import com.horyu1234.discordmusicbot.command.PingCommand;
import de.btobastian.sdcf4j.CommandHandler;
import de.btobastian.sdcf4j.handler.JDA3Handler;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by horyu on 2018-02-14
 */
public class DiscordMusicBot {
    private static final Logger LOGGER = LoggerFactory.getLogger(DiscordMusicBot.class);

    public static void main(String[] args) {
        if (args.length != 1) {
            LOGGER.error("봇의 토큰을 입력해주세요.");
            return;
        }

        LOGGER.info("디스코드 봇을 시작하는 중입니다...");
        String botToken = args[0];
        JDABuilder jdaBuilder = new JDABuilder(AccountType.BOT);

        JDA jda;
        try {
            jda = jdaBuilder
                    .setToken(botToken)
                    .buildAsync();
        } catch (Exception e) {
            LOGGER.error("JDA 를 초기화하는 중 오류가 발생하였습니다.", e);
            return;
        }

        jda.getPresence().setGame(Game.playing("h!help"));

        LOGGER.info("명령어 핸들러를 초기화하는 중입니다...");
        CommandHandler commandHandler = new JDA3Handler(jda);

        commandHandler.registerCommand(new PingCommand());

        LOGGER.info("디스코드 봇이 성공적으로 시작되었습니다.");
    }
}
