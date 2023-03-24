package by.bntu.fitr.poisit.matnik.university.model.entity;
import by.bntu.fitr.poisit.matnik.university.model.logic.Manager;
import java.util.Arrays;

public class Hero {

    String name;
    String race;
    Artifact[] artifacts;
    int level;

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


    public Hero(String name, int level, String race, Artifact[] artifacts){

        this.artifacts = artifacts;
        this.level = level;
        this.name = name;
        this.race = race;
    }


    public Hero(){
        this("Sasha", 0, "Human", null);
    }


    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", race='" + race + '\'' +
                "\nartifacts: "+ Arrays.toString(artifacts) +
                ", level=" + level +
                " total stats" +
                "}\n";
    }
}
