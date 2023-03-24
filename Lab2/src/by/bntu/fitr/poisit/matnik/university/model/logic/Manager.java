package by.bntu.fitr.poisit.matnik.university.model.logic;

import by.bntu.fitr.poisit.matnik.university.model.entity.Hero;
import by.bntu.fitr.poisit.matnik.university.model.entity.Artifact;
import java.util.Random;

public class Manager {


    public static int[] getStats(Hero hero) {
        int[] stats = new int[]{0, 0, 0, 0, 0, 0, 0};
        for (Artifact artifact : hero.getArtifacts()){
            for (int i = 0; i < 7; i++) stats[i] += artifact.getStats()[i];
        }
        return stats;
    }

}
