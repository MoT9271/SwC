package by.bntu.fitr.poisit.vikvik.university.model.logic;

import by.bntu.fitr.poisit.vikvik.university.model.entity.Knight;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Manager {
    public static Knight[] creatHeroes(int count) {
        String[] artifacts = new String[]{"Wraith Band", "Bracer", "Null Talisman", "Boots of Speed"};
        String[] names = new String[]{"Richard", "William", "Henry", "Norman", "Edward", "Atelard"};
        String[] races = new String[]{"Human", "Orc", "Dwarf", "Elf", "Worgen", "Undead", "Tauren", "Troll"};
        String[] archetypes = new String[]{"Tank", "Assassin", "Warrior", "Support", "Rdd"};
        Knight[] knights = new Knight[count];
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            String name = names[(int) Math.floor(Math.random() * names.length)];
            String race = races[(int) Math.floor(Math.random() * races.length)];
            String archetype = archetypes[(int) Math.floor(Math.random() * archetypes.length)];
            String[] build = new String[3];
            for (int j = 0; j < 3; j++) {
                build[j] = artifacts[(int) Math.floor(Math.random() * artifacts.length)];
            }
            knights[i] = new Knight(name, 0, race, archetype, build);
        }
        return knights;
    }

    public static String getStats(Knight[] knights) {
        // Artifact:[strength, agility, intelligence, movement speed, armor, attack speed, coast]
        int[] wR = new int[]{2, 5, 2, 0, 2, 5, 700};
        int[] bR = new int[]{5, 2, 2, 0, 2, 5, 260};
        int[] nT = new int[]{2, 2, 5, 0, 2, 5, 120};
        int[] bS = new int[]{0, 0, 0, 45, 0, 0, 300};
        int[] temp;
        int[] stats;
        for (int i = 0; i < knights.length; i++) {
            stats = new int[]{0, 0, 0, 0, 0, 0, 0};
            for (int j = 0; j < 3; j++) {

                if (knights[i].artifacts[j] == "Wraith Band") {
                    temp = wR;
                }
                else if (knights[i].artifacts[j] == "Bracer"){
                    temp = bR;
                }
                else if (knights[i].artifacts[j] == "Null Talisman"){
                    temp = nT;
                }
                else {
                    temp = bS;
                }
                for (int k = 0; k < 7; k++){
                    stats[k] += temp[k];
                }

            }
        }

        return "strength" + stats[0] + "agility" + stats[1] + "intelligence" stats[2] + f\"movement speed {stats_of_hero[3]}, armor {stats_of_hero[4]}, attack speed {stats_of_hero[5]},\"\n" +
                "                f\" coast {stats_of_hero[6]}\")";
    }

}
