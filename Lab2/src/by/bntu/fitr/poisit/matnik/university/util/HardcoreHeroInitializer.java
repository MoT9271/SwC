package by.bntu.fitr.poisit.matnik.university.util;



import entity.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HardcoreHeroInitializer {
    public static List<Hero> initialize(List<Hero> heroes) {
        List<Artifact> artifacts = new ArrayList<>();
        artifacts.add(new Artifact("Wraith Band", Arrays.asList(2, 5, 2, 0, 2, 5, 700)));
        artifacts.add(new Artifact("Bracer", Arrays.asList(5, 2, 2, 0, 2, 5, 260)));


        String[] names = new String[]{"Richard", "Richard", "Henry"};


        String assassinName = names[0];
        List<Artifact> assassinBuild = new ArrayList<>(artifacts);
        heroes.add(new Assassin(assassinName, 50, "Human", assassinBuild));

        artifacts.add(new Artifact("Boots of Speed", Arrays.asList(0, 0, 0, 45, 0, 0, 300)));
        String supportName = names[1];
        List<Artifact> supportBuild = new ArrayList<>(artifacts);
        heroes.add(new Support(supportName, 51, "Elf", supportBuild));

        artifacts.add(new Artifact("Null Talisman", Arrays.asList(2, 2, 5, 0, 2, 5, 120)));
        String tankName = names[2];
        List<Artifact> tankBuild = new ArrayList<>(artifacts);
        heroes.add(new Tank(tankName, 52, "Orc", tankBuild));

        return heroes;
    }
}
