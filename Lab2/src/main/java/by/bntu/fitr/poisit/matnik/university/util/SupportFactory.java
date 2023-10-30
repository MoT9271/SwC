package main.java.by.bntu.fitr.poisit.matnik.university.util;

import entity.Artifact;
import entity.Hero;
import entity.Support;

import java.util.List;

public class SupportFactory implements HeroFactory {
    @Override
    public Hero createHero(String name, int level, String race, List<Artifact> artifacts) {
        return new Support(name, level, race, artifacts);
    }
}