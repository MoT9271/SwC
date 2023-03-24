package by.bntu.fitr.poisit.matnik.university.util;

import by.bntu.fitr.poisit.matnik.university.model.entity.Artifact;
import by.bntu.fitr.poisit.matnik.university.model.entity.Hero;

import java.util.Random;

public class HeroInitializer {
    public static Hero[] initialize(Hero [] heroes) {
        //String[] artifacts = new String[]{"Wraith Band", "Bracer", "Null Talisman", "Boots of Speed"};
        Artifact[]  artifacts = new Artifact[4];
        artifacts[0] = new Artifact("Wraith Band", new int[]{2, 5, 2, 0, 2, 5, 700});
        artifacts[1] = new Artifact("Bracer", new int[]{5, 2, 2, 0, 2, 5, 260});
        artifacts[2] = new Artifact("Null Talisman", new int[]{2, 2, 5, 0, 2, 5, 120});
        artifacts[3] = new Artifact("Boots of Speed", new int[]{0, 0, 0, 45, 0, 0, 300});
        String[] names = new String[]{"Richard", "William", "Henry", "Norman", "Edward", "Atelard"};
        String[] races = new String[]{"Human", "Orc", "Dwarf", "Elf", "Worgen", "Undead", "Tauren", "Troll"};
        String[] archetypes = new String[]{"Tank", "Assassin", "Warrior", "Support", "Rdd"};
        Random random = new Random();
        for (int i = 0; i < heroes.length; i++) {
            String name = names[(int)Math.floor(Math.random() * names.length)];
            String race = races[(int)Math.floor(Math.random() * races.length)];
            String archetype = archetypes[(int)Math.floor(Math.random() * archetypes.length)];
            Artifact[] build = new Artifact[3];
            for (int j = 0; j < 3; j++) {
                build[j] = artifacts[(int)Math.floor(Math.random() * artifacts.length)];
            }
            heroes[i] = new Hero(name, 0, race, archetype, build);
        }
        return heroes;
    }
}
