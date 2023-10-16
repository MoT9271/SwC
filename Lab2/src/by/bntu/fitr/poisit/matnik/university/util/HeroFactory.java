package by.bntu.fitr.poisit.matnik.university.util;

import entity.Artifact;
import entity.Hero;

import java.util.List;

public interface HeroFactory {

    Hero createHero(String name, int level, String race, List<Artifact> artifacts);

    static HeroFactory getFactory(HeroType type) {
        switch (type) {
            case ASSASSIN:
                return new AssassinFactory();
            case SUPPORT:
                return new SupportFactory();
            case TANK:
                return new TankFactory();
            default:
                throw new IllegalArgumentException("Unknown Hero Type");
        }
    }
}