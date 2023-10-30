package main.java.by.bntu.fitr.poisit.matnik.university.util;

import entity.Artifact;
import entity.Hero;

import org.apache.logging.log4j.core.Logger;
import main.java.by.bntu.fitr.poisit.matnik.university.util.HeroType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomHeroInitializer {
    private static final Logger logger = (Logger) CustomLogger.getLogger();

    public static List<Hero> initialize(List<Hero> heroes, int count) {
        List<Artifact> artifacts = new ArrayList<>();
        artifacts.add(new Artifact("Wraith Band", Arrays.asList(2, 5, 2, 0, 2, 5, 700)));
        artifacts.add(new Artifact("Bracer", Arrays.asList(5, 2, 2, 0, 2, 5, 260)));
        artifacts.add(new Artifact("Null Talisman", Arrays.asList(2, 2, 5, 0, 2, 5, 120)));
        artifacts.add(new Artifact("Boots of Speed", Arrays.asList(0, 0, 0, 45, 0, 0, 300)));
        String[] names = new String[]{"Richard", "William", "Henry", "Norman", "Edward", "Atelard"};
        String[] races = new String[]{"Human", "Orc", "Dwarf", "Elf", "Worgen", "Undead", "Tauren", "Troll"};

        for (int i = 0; i < count; i++) {
            String name = names[(int) Math.floor(Math.random() * names.length)];
            String race = races[(int) Math.floor(Math.random() * races.length)];
            List<Artifact> build = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                build.add(artifacts.get((int) Math.floor(Math.random() * artifacts.size())));
            }
            int randomNumber = (int) (Math.floor(Math.random() * (3 - 1)) + 1);
            int level = (int) (Math.floor(Math.random() * (80 - 1)) + 1);

            HeroFactory heroFactory;
            if (randomNumber == 1) {
                heroFactory = HeroFactory.getFactory(HeroType.ASSASSIN);
                logger.info("Creating AssassinFactory");
            } else if (randomNumber == 2) {
                heroFactory = HeroFactory.getFactory(HeroType.SUPPORT);
                logger.info("Creating SupportFactory");
            } else {
                heroFactory = HeroFactory.getFactory(HeroType.TANK);
                logger.info("Creating TankFactory");
            }

            Hero hero = heroFactory.createHero(name, level, race, build);
            heroes.add(hero);
        }
        return heroes;
    }
}
