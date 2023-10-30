package main.java.by.bntu.fitr.poisit.matnik.university.model;


import entity.*;
import main.java.by.bntu.fitr.poisit.matnik.university.util.CustomLogger;
import org.apache.logging.log4j.core.Logger;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final Logger logger = (Logger) CustomLogger.getLogger();

    // Save a list of heroes to a binary file
    public static void saveHeroesToFile(List<Hero> heroes, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(heroes);
            logger.info("Saved heroes to file: " + fileName);
        } catch (IOException e) {
            logger.error("Error while saving heroes to file:" + fileName + e);
        }
    }

    // Load a list of heroes from a binary file
    public static List<Hero> loadHeroesFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            logger.info("Loaded heroes from file:" + fileName);
            return (List<Hero>) in.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            logger.error("Error while loading heroes from file:" + fileName + e);
            throw e;
        }
    }

    // Save a list of heroes to a text file
    public static void saveHeroesToTextFile(List<Hero> heroes, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Hero hero : heroes) {
                writer.write(hero.toString() + "\n");
            }
            logger.info("Saved heroes to text file:" + fileName);
        }
        catch (IOException e) {
            logger.error("Error while saving heroes to text file:" + fileName + e);
        }
    }


    public static void customSerialize(List<Hero> heroes, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Hero hero : heroes) {
                writer.write("HeroType: " + hero.getClass().getSimpleName() + "\n");
                writer.write("Name: " + hero.getName() + "\n");
                writer.write("Race: " + hero.getRace() + "\n");
                writer.write("Level: " + hero.getLevel() + "\n");

                // Сериализация артефактов
                for (Artifact artifact : hero.getArtifacts()) {
                    writer.write("Artifact: " + artifact.getType() + "\n");
                    List<Integer> stats = artifact.getStats();
                    writer.write("Stats: ");
                    for (int i = 0; i < stats.size(); i++) {
                        writer.write(stats.get(i).toString());
                        if (i < stats.size() - 1) {
                            writer.write(", ");
                        }
                    }
                    writer.write("\n");
                }

                // Сериализация способностей (для героев, у которых они есть)
                if (hero.getAbilities() != null) {
                    writer.write("Abilities: ");
                    for (Abilities ability : hero.getAbilities()) {
                        writer.write(ability.name());
                        if (ability != hero.getAbilities().get(hero.getAbilities().size() - 1)) {
                            writer.write(", ");
                        }
                    }
                    writer.write("\n");
                }

                // Разделитель между героями
                writer.write("\n");
                logger.info("Custom serialization to file:" + filename);
            }
        } catch (IOException e) {
            logger.error("Error during custom serialization:" + filename + e);
        }
    }

    public static List<Hero> customDeserialize(String filename) {
        List<Hero> heroes = new ArrayList<>();
        Hero hero = null; // Используем, чтобы хранить текущего обрабатываемого героя
        List<Artifact> artifacts = new ArrayList<>();
        List<Abilities> abilities = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ");
                if (parts.length == 2) {
                    String field = parts[0];
                    String value = parts[1];
                    switch (field) {
                        case "HeroType":
                            // Создаем нового героя при обнаружении нового типа
                            if (hero != null) {
                                hero.setArtifacts(artifacts);
                                hero.setAbilities(abilities);
                                heroes.add(hero);
                            }

                            hero = createHero(value, "", 0, "", new ArrayList<>());
                            artifacts.clear();
                            abilities.clear();
                            break;
                        case "Name":
                            if (hero != null) {
                                hero.setName(value);
                            }
                            break;
                        case "Race":
                            if (hero != null) {
                                hero.setRace(value);
                            }
                            break;
                        case "Level":
                            if (hero != null) {
                                hero.setLevel(Integer.parseInt(value));
                            }
                            break;
                        case "Artifact":
                            if (hero != null) {
                                String artifactType = value;
                                line = reader.readLine(); // Следующая строка должна содержать статы артефакта
                                parts = line.split(": ");
                                if (parts.length == 2 && parts[0].equals("Stats")) {
                                    String[] statsStr = parts[1].split(", ");
                                    List<Integer> stats = new ArrayList<>();
                                    for (String statStr : statsStr) {
                                        stats.add(Integer.parseInt(statStr));
                                    }
                                    artifacts.add(new Artifact(artifactType, stats));
                                }
                            }
                            break;
                        case "Abilities":
                            if (hero != null) {
                                String[] abilitiesStr = value.split(", ");
                                for (String abilityStr : abilitiesStr) {
                                    abilities.add(Abilities.valueOf(abilityStr));
                                }
                            }
                            break;
                    }
                }
            }

            // Добавляем последнего героя, так как после цикла обработки не будет разделителя
            if (hero != null) {
                hero.setArtifacts(artifacts);
                hero.setAbilities(abilities);
                heroes.add(hero);
            }
            logger.info("Custom deserialization from file:" + filename);
        } catch (IOException e) {
            logger.error("Error during custom deserialization:" + filename + e);
        }

        return heroes;
    }


    private static Hero createHero(String heroType, String name, int level, String race, List<Artifact> artifacts) {
        switch (heroType) {
            case "Support":
                return new Support(name, level, race, artifacts);
            case "Tank":
                return new Tank(name, level, race, artifacts);
            case "Assassin":
                return new Assassin(name, level, race, artifacts);
            default:
                return null; // Обработка других типов героев
        }
    }


}
