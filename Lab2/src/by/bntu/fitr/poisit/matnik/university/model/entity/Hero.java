package by.bntu.fitr.poisit.matnik.university.model.entity;

import java.util.Arrays;

public abstract class Hero {

    String name;
    String race;
    Artifact[] artifacts;
    int level;
    public abstract void setAbilities(Abilities[] abilities);
    public abstract Abilities[] getAbilities();
    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public Artifact[] getArtifacts() {
        return artifacts;
    }

    public int getLevel() {
        return level;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setArtifacts(Artifact[] artifacts) {
        this.artifacts = artifacts;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    public Hero(String name, int level, String race, Artifact[] artifacts) {

        this.artifacts = artifacts;
        this.level = level;
        this.name = name;
        this.race = race;
    }

    public Hero(Hero hero) {
        this.artifacts = hero.getArtifacts();
        this.level = hero.getLevel();
        this.name = hero.getName();
        this.race = hero.getName();
    }


    public Hero() {
        this("Sasha", 0, "Gavs", null);
    }


    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", race='" + race + '\'' +
                "\nartifacts: " + Arrays.toString(artifacts) +
                ", level=" + level +
                " total stats" +
                "}\n";
    }
}
