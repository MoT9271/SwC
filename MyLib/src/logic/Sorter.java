package logic;


import entity.Hero;

import java.util.Comparator;
import java.util.List;

public class Sorter {
    public static List<Hero> sortByLevelName(List<Hero> heroes) {
        heroes.sort(Comparator.comparingInt(Hero::getLevel).thenComparing(Hero::getName));
        return heroes;
    }

    public static List<Hero> sortByName(List<Hero> heroes) {
        heroes.sort(Comparator.comparing(Hero::getName));
        return heroes;
    }

    public static List<Hero> sortByBuildCost(List<Hero> heroes) {
        heroes.sort(Comparator.comparingDouble(hero -> Manager.getStats(hero).get(6)));
        return heroes;
    }


}
