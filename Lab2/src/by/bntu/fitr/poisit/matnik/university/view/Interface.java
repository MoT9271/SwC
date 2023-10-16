package by.bntu.fitr.poisit.matnik.university.view;


import by.bntu.fitr.poisit.matnik.university.util.*;
import entity.Hero;
import logic.Manager;
import logic.Sorter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
        JPanel buttonPanel = new JPanel(new GridLayout(0, 2, 10, 10)); // 0 строк, 2 столбца, отступы 10 пикселей

        JButton randomButton = new JButton("Random hero creation");
        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createRandomHero();
            }
        });

        JButton hardcoreButton = new JButton("Hardcore hero creation");
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

        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
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

    // Остальные методы без изменений

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interface();
            }
        });
    }
}
