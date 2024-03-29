package main.java.by.bntu.fitr.poisit.matnik.university.logic;

import entity.Hero;
import entity.Artifact;
import main.java.by.bntu.fitr.poisit.matnik.university.util.CustomLogger;
import org.apache.logging.log4j.core.Logger;

import java.util.List;
import java.util.ArrayList;

public class Manager {
    private static final Logger logger = (Logger) CustomLogger.getLogger();
    public static List<Integer> getStats(Hero hero) {
        List<Integer> stats = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            stats.add(0);
        }
        if (hero == null) {
            logger.error("getStats method called with a null hero.");
            return null;
        }
        if (hero.getArtifacts() == null) {
            logger.error("getStats method called with a hero having null artifacts.");
            return null;
        }
        for (Artifact artifact : hero.getArtifacts()) {
            for (int i = 0; i < 7; i++) {
                stats.set(i, stats.get(i) + artifact.getStats().get(i));
            }
        }
        logger.info("Computed stats for hero: " + hero.getName());
        return stats;
    }

    public String statsToString(List<Integer> stats) {
        logger.info("Converting stats to a string.");
        return ("Stats:\r\nstrength " + stats.get(0) + " agility " + stats.get(1) + " intelligence " + stats.get(2) + " movement speed " + stats.get(3) + " armor " + stats.get(4) + " attack speed " + stats.get(5) + " cost " + stats.get(6) + "\n" + "\n");
    }

    public List<Hero> findHeroesByName(List<Hero> heroes, String name) {
        logger.info("Searching heroes by name: " + name);
        List<Hero> foundHeroes = new ArrayList<>();
        for (Hero hero : heroes) {
            if (hero.getName().equals(name)) {
                foundHeroes.add(hero);
            }
        }
        return foundHeroes;
    }

    public List<Hero> findHeroesByLevel(List<Hero> heroes, int level) {
        logger.info("Searching heroes by level: " + level);
        List<Hero> foundHeroes = new ArrayList<>();
        for (Hero hero : heroes) {
            if (hero.getLevel() == level) {
                foundHeroes.add(hero);
            }
        }
        return foundHeroes;
    }
}
