package by.bntu.fitr.poisit.matnik.university.model.entity;
import by.bntu.fitr.poisit.matnik.university.model.logic.Manager;
import java.util.Arrays;

public class Hero {

    String name;
    String race;
    String archetype;


    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public String getArchetype() {
        return archetype;
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

    public void setArchetype(String archetype) {
        this.archetype = archetype;
    }

    public void setArtifacts(Artifact[] artifacts) {
        this.artifacts = artifacts;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    Artifact[] artifacts;
    int level;
    public Hero(String name, int level, String race, String archetype, Artifact[] artifacts){
        this.archetype = archetype;
        this.artifacts = artifacts;
        this.level = level;
        this.name = name;
        this.race = race;
    }


    public Hero(){
        this("Sasha", 0, "Human", "Tank", null);
    }


    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", archetype='" + archetype + '\'' +
                "artifacts: "+ Arrays.toString(artifacts) +
                ", level=" + level +
                " total stats" + Arrays.toString(Manager.getStats(this)) +
                "}\n";
    }
}
