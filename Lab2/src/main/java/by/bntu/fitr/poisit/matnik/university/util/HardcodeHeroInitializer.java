package main.java.by.bntu.fitr.poisit.matnik.university.util;

import entity.Artifact;
import entity.Hero;
import org.apache.logging.log4j.core.Logger;

import main.java.by.bntu.fitr.poisit.matnik.university.logic.Manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HardcodeHeroInitializer {
    private static final Logger logger = (Logger) CustomLogger.getLogger();

    public static List<Hero> initialize(List<Hero> heroes) {
        // Создайте фабрики
        HeroFactory assassinFactory = new AssassinFactory();
        HeroFactory supportFactory = new SupportFactory();
        HeroFactory tankFactory = new TankFactory();

        List<Artifact> artifacts = new ArrayList<>();
        artifacts.add(new Artifact("Wraith Band", Arrays.asList(2, 5, 2, 0, 2, 5, 700)));
        artifacts.add(new Artifact("Bracer", Arrays.asList(5, 2, 2, 0, 2, 5, 260)));
        artifacts.add(new Artifact("Boots of Speed", Arrays.asList(0, 0, 0, 45, 0, 0, 300)));
        artifacts.add(new Artifact("Null Talisman", Arrays.asList(2, 2, 5, 0, 2, 5, 120)));

        String[] names = new String[]{"Richard", "Richard", "Henry"};

        String assassinName = names[0];
        List<Artifact> assassinBuild = new ArrayList<>(artifacts);
        // Используйте фабрику для создания Assassin
        heroes.add(assassinFactory.createHero(assassinName, 50, "Human", assassinBuild));
        logger.info("Initialized Assassin: " + assassinName);

        String supportName = names[1];
        List<Artifact> supportBuild = new ArrayList<>(artifacts);
        // Используйте фабрику для создания Support
        heroes.add(supportFactory.createHero(supportName, 51, "Elf", supportBuild));
        logger.info("Initialized Support: " + supportName);

        String tankName = names[2];
        List<Artifact> tankBuild = new ArrayList<>(artifacts);
        // Используйте фабрику для создания Tank
        heroes.add(tankFactory.createHero(tankName, 52, "Orc", tankBuild));
        logger.info("Initialized Tank: " + tankName);

        return heroes;
    }
}
