package com.horyu1234.discordmusicbot;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.color.ANSIConstants;
import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase;

import static ch.qos.logback.classic.Level.WARN;

/**
 * Created by horyu on 2018-01-25
 */
public class CompositeConverter extends ForegroundCompositeConverterBase<ILoggingEvent> {
    @Override
    protected String getForegroundColorCode(ILoggingEvent event) {
        Level level = event.getLevel();
        if (level == WARN) {
            return ANSIConstants.YELLOW_FG;
        } else if (level == Level.ERROR) {
            return ANSIConstants.RED_FG;
        } else if (level == Level.DEBUG) {
            return ANSIConstants.CYAN_FG;
        } else if (level == Level.TRACE) {
            return ANSIConstants.GREEN_FG;
        }
        return ANSIConstants.WHITE_FG;
    }
}
