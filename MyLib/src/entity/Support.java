package entity;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Support extends Hero implements Serializable {

    public Support(){}

    List<Abilities> abilities;

    public Support(String name, int level, String race, List<Artifact> artifacts) {
        super(name, level, race, artifacts);
        abilities = new ArrayList<>();
        abilities.add(Abilities.HEAL);
        abilities.add(Abilities.STUN);
    }

    public void setAbilities(List<Abilities> abilities) {
        this.abilities = abilities;
    }

    public List<Abilities> getAbilities() {
        return abilities;
    }

    @Override
    public String toString() {
        return "Support{" +
                "abilities=" + abilities +
                ", name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", \nartifacts=" + artifacts +
                ", level=" + level +
                "}\n";
    }
}
