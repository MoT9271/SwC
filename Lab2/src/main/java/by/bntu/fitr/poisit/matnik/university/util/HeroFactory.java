package main.java.by.bntu.fitr.poisit.matnik.university.util;

import entity.Artifact;
import entity.Hero;
import org.apache.logging.log4j.core.Logger;
import main.java.by.bntu.fitr.poisit.matnik.university.util.HeroType;

import java.util.List;

public interface HeroFactory {
    static final Logger logger = (Logger) CustomLogger.getLogger();

    Hero createHero(String name, int level, String race, List<Artifact> artifacts);

    static HeroFactory getFactory(HeroType type) {
        switch (type) {
            case ASSASSIN:
                logger.info("Creating AssassinFactory");
                return new AssassinFactory();
            case SUPPORT:
                logger.info("Creating SupportFactory");
                return new SupportFactory();
            case TANK:
                logger.info("Creating TankFactory");
                return new TankFactory();
            default:
                logger.error("Unknown Hero Type");
                throw new IllegalArgumentException("Unknown Hero Type");
        }
    }
}
