package by.bntu.fitr.poisit.matnik.university.model.entity;

import java.util.Arrays;
import java.util.List;

public class Artifact
{
    String type;
    List<Integer> stats;
    public Artifact(String type, List<Integer> stats){
        this.type = type;
        this.stats = stats;
    }

    public Artifact(){
        this("Wraith Band", Arrays.asList(2, 5, 2, 0, 2, 5, 700));
    }


    public String getType() {
        return type;
    }

    public List<Integer> getStats() {
        return stats;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStats(List<Integer> stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return "Artifact" +
                "type='" + type + '\'' +
                ", stats: " + "strength " + stats.get(0) + ", agility " + stats.get(1) + ", intelligence " + stats.get(2)
                + ", movement speed " + stats.get(3) + ", armor" + stats.get(4) + ", attack speed " + stats.get(5) + ", cost " + stats.get(6) + '\n';
    }
}