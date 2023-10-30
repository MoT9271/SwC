package main.java.by.bntu.fitr.poisit.matnik.university.logic;

import entity.Hero;
import org.apache.logging.log4j.core.Logger;
import main.java.by.bntu.fitr.poisit.matnik.university.util.CustomLogger;

import java.util.Comparator;
import java.util.List;

public class Sorter {
    private static final Logger logger = (Logger) CustomLogger.getLogger();

    public static List<Hero> sortByLevelName(List<Hero> heroes) {
        logger.info("Sorting heroes by level and name.");
        heroes.sort(Comparator.comparingInt(Hero::getLevel).thenComparing(Hero::getName));
        return heroes;
    }

    public static List<Hero> sortByName(List<Hero> heroes) {
        logger.info("Sorting heroes by name.");
        heroes.sort(Comparator.comparing(Hero::getName));
        return heroes;
    }

    public static List<Hero> sortByBuildCost(List<Hero> heroes) {
        logger.info("Sorting heroes by build cost.");
        heroes.sort(Comparator.comparingDouble(hero -> Manager.getStats(hero).get(6)));
        return heroes;
    }
}
