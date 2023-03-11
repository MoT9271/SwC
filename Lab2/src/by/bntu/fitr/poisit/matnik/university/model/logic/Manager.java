package by.bntu.fitr.poisit.matnik.university.model.logic;

import by.bntu.fitr.poisit.matnik.university.model.entity.Hero;

import java.util.Random;

public class Manager {
    public static Hero[] creatHeroes(int count) {
        String[] artifacts = new String[]{"Wraith Band", "Bracer", "Null Talisman", "Boots of Speed"};
        String[] names = new String[]{"Richard", "William", "Henry", "Norman", "Edward", "Atelard"};
        String[] races = new String[]{"Human", "Orc", "Dwarf", "Elf", "Worgen", "Undead", "Tauren", "Troll"};
        String[] archetypes = new String[]{"Tank", "Assassin", "Warrior", "Support", "Rdd"};
        Hero[] heroes = new Hero[count];
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            String name = names[(int)Math.floor(Math.random() * names.length)];
            String race = races[(int)Math.floor(Math.random() * races.length)];
            String archetype = archetypes[(int)Math.floor(Math.random() * archetypes.length)];
            String[] build = new String[3];
            for (int j = 0; j < 3; j++) {
                build[j] = artifacts[(int)Math.floor(Math.random() * artifacts.length)];
            }
            heroes[i] = new Hero(name, 0, race, archetype, build);
        }
        return heroes;
    }

    public static int[] getStats(Hero hero) {
        // Artifact:[strength, agility, intelligence, movement speed, armor, attack speed, coast]
        int[] wR = new int[]{2, 5, 2, 0, 2, 5, 700}; //Wraith Band
        int[] bR = new int[]{5, 2, 2, 0, 2, 5, 260};//Bracer
        int[] nT = new int[]{2, 2, 5, 0, 2, 5, 120};//Null Talisman
        int[] bS = new int[]{0, 0, 0, 45, 0, 0, 300};//Boots of Speed
        int[] temp;
        int[] stats = new int[]{0, 0, 0, 0, 0, 0, 0};
        for (int j = 0; j < 3; j++) {
            if (hero.artifacts[j] == "Wraith Band") {
                temp = wR;
            }
            else if (hero.artifacts[j] == "Bracer"){
                temp = bR;
            }
            else if (hero.artifacts[j] == "Null Talisman"){
                temp = nT;
            }
            else {
                temp = bS;
            }
            for (int k = 0; k < 7; k++){
                stats[k] += temp[k];
            }

        }
        return stats;
    }

}
