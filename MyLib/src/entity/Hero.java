package entity;

import java.io.Serializable;
import java.util.List;

public abstract class Hero implements Serializable {

    String name;
    String race;
    List<Artifact> artifacts;
    int level;

    public abstract void setAbilities(List<Abilities> abilities);
    public abstract List<Abilities> getAbilities();

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public List<Artifact> getArtifacts() {
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

    public void setArtifacts(List<Artifact> artifacts) {
        this.artifacts = artifacts;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Hero(String name, int level, String race, List<Artifact> artifacts) {
        this.artifacts = artifacts;
        this.level = level;
        this.name = name;
        this.race = race;
    }

    public Hero(Hero hero) {
        this.artifacts = hero.getArtifacts();
        this.level = hero.getLevel();
        this.name = hero.getName();
        this.race = hero.getRace();
    }

    public Hero() {
        this("Sasha", 0, "Gavs", null);
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", race='" + race + '\'' +
                "\nartifacts: " + artifacts +
                ", level=" + level +
                " total stats" +
                "}\n";
    }
}
