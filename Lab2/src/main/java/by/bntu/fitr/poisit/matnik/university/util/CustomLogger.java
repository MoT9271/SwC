package main.java.by.bntu.fitr.poisit.matnik.university.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.config.AppenderRef;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.layout.PatternLayout;

public class CustomLogger {

    public static Logger getLogger() {
        // Создание и настройка аппендера для консоли
        ConsoleAppender consoleAppender = ConsoleAppender.newBuilder()
                .withName("ConsoleAppender")
                .setLayout(PatternLayout.newBuilder().withPattern("%m%n").build())
                .build();

        // Создание и настройка аппендера для файла
        FileAppender fileAppender = FileAppender.newBuilder()
                .withName("FileAppender")
                .withFileName("logs/info.log")
                .setLayout(PatternLayout.newBuilder().withPattern("%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n").build())
                .build();

        // Получение конфигурации Log4j2
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        Configuration config = context.getConfiguration();

        // Создание и настройка логгера
        LoggerConfig loggerConfig = LoggerConfig.createLogger(
                false, org.apache.logging.log4j.Level.TRACE,
                "HeroLogger", "true", new AppenderRef[] { AppenderRef.createAppenderRef("ConsoleAppender", null, null) },
                null, config, null
        );
        loggerConfig.addAppender(consoleAppender, org.apache.logging.log4j.Level.TRACE, null);
        loggerConfig.addAppender(fileAppender, org.apache.logging.log4j.Level.TRACE, null);

        config.addLogger("HeroLogger", loggerConfig);

        // Получение логгера
        return LogManager.getLogger("HeroLogger");
    }
}
