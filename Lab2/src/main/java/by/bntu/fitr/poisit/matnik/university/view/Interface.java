package main.java.by.bntu.fitr.poisit.matnik.university.view;


import main.java.by.bntu.fitr.poisit.matnik.university.model.FileHandler;
import entity.Hero;
import main.java.by.bntu.fitr.poisit.matnik.university.logic.Manager;
import main.java.by.bntu.fitr.poisit.matnik.university.logic.Sorter;
import main.java.by.bntu.fitr.poisit.matnik.university.util.HardcodeHeroInitializer;
import main.java.by.bntu.fitr.poisit.matnik.university.util.HeroCreator;
import main.java.by.bntu.fitr.poisit.matnik.university.util.RandomHeroInitializer;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Interface {

    private JTextArea outputArea;
    private Manager manager;
    private JTextField textField;
    static List<Hero> heroes;
    public Interface() {

        manager = new Manager();
        // Создаем главное окно
        JFrame frame = new JFrame("Управление героями");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 480);

        // Создаем текстовую область для вывода информации
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        frame.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Создаем панель с кнопками
        JPanel buttonPanel = new JPanel(new GridLayout(0, 4, 10, 10)); // 0 строк, 2 столбца, отступы 10 пикселей

        JButton randomButton = new JButton("Random hero creation");
        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createRandomHero();
            }
        });

        JButton hardcoreButton = new JButton("Hardcode hero creation");
        hardcoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createHardcoreHero();
            }
        });

        JButton sortByNameAndLevelButton = new JButton("Sort by name and level");
        sortByNameAndLevelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortHeroesByNameAndLevel();
            }
        });

        JButton sortByLevelButton = new JButton("Sort by name");
        sortByLevelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortHeroesByName();
            }
        });

        JButton sortByBuildCostButton = new JButton("Sort by build cost");
        sortByBuildCostButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortHeroesByBuildCost();
            }
        });

        JButton findByNameButton = new JButton("Find by name");
        findByNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findHeroByName();
            }
        });

        JButton findByLevelButton = new JButton("Find by level");
        findByLevelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findHeroByLevel();
            }
        });

        JButton openFromFileButton = new JButton("Open from File");
        openFromFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFromFile();
            }
        });
        JButton serializeButton = new JButton("Serialize");
        serializeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serializeHeroes();
            }
        });

        JButton saveToTextFileButton = new JButton("Save to Text File");
        saveToTextFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToTextFile();
            }
        });
        JButton customSerializeButton = new JButton("CustomSerialize");
        customSerializeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customSerializeHeroes();
            }
        });

        JButton customDeserializeButton = new JButton("CustomDeserialize");
        customDeserializeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customDeserializeHeroes();
            }
        });

        // Добавляем поле для ввода имени героя
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(150, 30)); // Устанавливаем размер поля для ввода
        buttonPanel.add(textField); // Добавляем поле для ввода

        buttonPanel.add(randomButton);
        buttonPanel.add(hardcoreButton);
        buttonPanel.add(sortByNameAndLevelButton);
        buttonPanel.add(sortByLevelButton);
        buttonPanel.add(sortByBuildCostButton);
        buttonPanel.add(findByNameButton);
        buttonPanel.add(findByLevelButton);
        buttonPanel.add(openFromFileButton);
        buttonPanel.add(serializeButton);
        buttonPanel.add(saveToTextFileButton);
        buttonPanel.add(customSerializeButton);
        buttonPanel.add(customDeserializeButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void serializeHeroes() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                FileHandler.saveHeroesToFile(heroes, filePath);
            } catch (Exception ex) {
                updateOutput("Error while serializing to file.");
            }
        }
    }



    private void customSerializeHeroes() {
        outputArea.setText("");
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                FileHandler.customSerialize(heroes, filePath); // Используйте вашу реализацию метода customSerialize
                updateOutput("Successfully custom serialized to file.");
            } catch (Exception ex) {
                updateOutput("Error during custom serialization.");
            }
        }
    }

    private void customDeserializeHeroes() {
        outputArea.setText("");
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                heroes = FileHandler.customDeserialize(filePath); // Используйте вашу реализацию метода customDeserialize
                for (Hero hero : heroes) {
                    updateOutput(hero.toString());
                    List<Integer> stats = manager.getStats(hero);
                    updateOutput(manager.statsToString(stats));
                }
            } catch (Exception ex) {
                updateOutput("Error during custom deserialization.");
            }
        }
    }

    private void saveToTextFile() {
        outputArea.setText("");
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                FileHandler.saveHeroesToTextFile(heroes, filePath);
                updateOutput("Successfully saved to .txt file.");
            } catch (Exception ex) {
                updateOutput("Error during creation txt file");
            }
        }
    }


    private void sortHeroesByNameAndLevel() {
        outputArea.setText("");
        try {
            heroes = Sorter.sortByName(heroes);
            for (Hero hero : heroes) {
                updateOutput(hero.toString());
                List<Integer> stats = manager.getStats(hero);
                updateOutput(manager.statsToString(stats));
            }
        } catch (Exception ex) {
            updateOutput("List is empty!");
        }
    }


    private void openFromFile() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                heroes = FileHandler.loadHeroesFromFile(filePath);
                for (Hero hero : heroes) {
                    updateOutput(hero.toString());
                    List<Integer> stats = manager.getStats(hero);
                    updateOutput(manager.statsToString(stats));
                }
            } catch (Exception ex) {
                updateOutput("Error while opening from file.");
            }
        }
    }


    private void sortHeroesByName() {
        outputArea.setText("");
        try {
            heroes = Sorter.sortByName(heroes);
            for (Hero hero : heroes) {
                updateOutput(hero.toString());
                List<Integer> stats = manager.getStats(hero);
                updateOutput(manager.statsToString(stats));
            }
        } catch (Exception ex) {
            updateOutput("List is empty!");
        }
    }

    private void sortHeroesByBuildCost() {
        outputArea.setText("");
        try {
            heroes = Sorter.sortByBuildCost(heroes);
            for (Hero hero : heroes) {
                updateOutput(hero.toString());
                List<Integer> stats = manager.getStats(hero);
                updateOutput(manager.statsToString(stats));
            }
        } catch (Exception ex) {
            updateOutput("List is empty!");
        }
    }

    private void findHeroByName() {
        try {
            outputArea.setText("");
            String name = textField.getText();
            outputArea.append(manager.findHeroesByName(heroes, name).toString());
        } catch (Exception ex) {
            updateOutput("Error!");
        }
    }

    private void findHeroByLevel() {
        try {
            outputArea.setText("");
            int lvl = Integer.parseInt(textField.getText());
            outputArea.append(manager.findHeroesByLevel(heroes, lvl).toString());
        } catch (Exception ex) {
            updateOutput("Error!");
        }
    }

    private void updateOutput(String message) {
        outputArea.append(message + "\n");
    }

    private void createRandomHero() {
        try {
            outputArea.setText("");
            int count = Integer.parseInt(textField.getText());
            heroes = HeroCreator.create(count);
            heroes = RandomHeroInitializer.initialize(heroes, count);

            for (Hero hero : heroes) {
                updateOutput(hero.toString());
                List<Integer> stats = manager.getStats(hero);
                updateOutput(manager.statsToString(stats));
            }
        } catch (Exception ex) {
            updateOutput("Error!");
        }
    }




    private void createHardcoreHero() {
        outputArea.setText("");
        heroes = HeroCreator.create(3);
        heroes = HardcodeHeroInitializer.initialize(heroes);
        for (Hero hero : heroes) {
            updateOutput(hero.toString());
            List<Integer> stats = manager.getStats(hero);
            updateOutput(manager.statsToString(stats));

        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interface();
            }
        });
    }
}
