package by.bntu.fitr.poisit.matnik.university.model.logic;

import by.bntu.fitr.poisit.matnik.university.model.entity.Hero;
import by.bntu.fitr.poisit.matnik.university.model.entity.Artifact;

import java.util.List;
import java.util.ArrayList;

public class Manager {

    public static List<Integer> getStats(Hero hero) {
        List<Integer> stats = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            stats.add(0);
        }
        if (hero == null) return null;
        if (hero.getArtifacts() == null) return null;
        for (Artifact artifact : hero.getArtifacts()){
            for (int i = 0; i < 7; i++) {
                stats.set(i, stats.get(i) + artifact.getStats().get(i));
            }
        }
        return stats;
    }

    public static List<Hero> findHeroesByName(List<Hero> heroes, String name) {
        List<Hero> foundHeroes = new ArrayList<>();
        for (Hero hero : heroes) {
            if (hero.getName().equals(name)) {
                foundHeroes.add(hero);
            }
        }
        return foundHeroes;
    }
    public static List<Hero> findHeroesByLevel(List<Hero> heroes, int level) {
        List<Hero> foundHeroes = new ArrayList<>();
        for (Hero hero : heroes) {
            if (hero.getLevel() == level) {
                foundHeroes.add(hero);
            }
        }
        return foundHeroes;
    }
}
