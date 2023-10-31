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
import java.util.Locale;
import java.util.ResourceBundle;

public class Interface {

    private JTextArea outputArea;
    private Manager manager;
    private JTextField textField;
    static List<Hero> heroes;
    private ResourceBundle messages;
    private Locale currentLocale;
    private JButton randomButton;
    private JButton hardcodeButton;
    private JButton sortByNameAndLevelButton;
    private JButton sortByLevelButton;
    private JButton sortByBuildCostButton;
    private JButton findByNameButton;
    private JButton findByLevelButton;
    private JButton openFromFileButton;
    private JButton serializeButton;
    private JButton saveToTextFileButton;
    private JButton customSerializeButton;
    private JButton customDeserializeButton;
    private JComboBox<String> localeComboBox;
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
        messages = ResourceBundle.getBundle("localization", Locale.getDefault());
        JPanel buttonPanel = new JPanel(new GridLayout(0, 4, 10, 10)); // 0 строк, 2 столбца, отступы 10 пикселей
        randomButton = new JButton(messages.getString("random_button"));
        hardcodeButton = new JButton(messages.getString("hardcore_button"));
        sortByNameAndLevelButton = new JButton(messages.getString("sort_by_name_and_level_button"));
        sortByLevelButton = new JButton(messages.getString("sort_by_name_button"));
        sortByBuildCostButton = new JButton(messages.getString("sort_by_build_cost_button"));
        findByNameButton = new JButton(messages.getString("find_by_name_button"));
        findByLevelButton = new JButton(messages.getString("find_by_level_button"));
        openFromFileButton = new JButton(messages.getString("open_from_file_button"));
        serializeButton = new JButton(messages.getString("serialize_button"));
        saveToTextFileButton = new JButton(messages.getString("save_to_text_file_button"));
        customSerializeButton = new JButton(messages.getString("custom_serialize_button"));
        customDeserializeButton = new JButton(messages.getString("custom_deserialize_button"));
        localeComboBox = new JComboBox<>(new String[] {"English", "Русский"});
        String defaultRegion = Locale.getDefault().getCountry();
        if (defaultRegion.equals("US")) {
            localeComboBox.setSelectedIndex(0); // Выбор "English"
        } else if (defaultRegion.equals("RU")) {
            localeComboBox.setSelectedIndex(1); // Выбор "Русский"
        }
        localeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = localeComboBox.getSelectedIndex();
                switch (selectedIndex) {
                    case 0:
                        currentLocale = new Locale("en", "US");
                        break;
                    case 1:
                        currentLocale = new Locale("ru", "RU");
                        break;
                    // Добавьте другие варианты локализации по необходимости
                }

                // Обновите ResourceBundle для выбранной локализации
                messages = ResourceBundle.getBundle("localization", currentLocale);

                // Обновите тексты всех компонентов согласно выбранной локализации
                updateLocalizedTexts();
            }
        });

        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createRandomHero();
            }
        });


        hardcodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createHardcoreHero();
            }
        });

        sortByNameAndLevelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortHeroesByNameAndLevel();
            }
        });

        sortByLevelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortHeroesByName();
            }
        });


        sortByBuildCostButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortHeroesByBuildCost();
            }
        });


        findByNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findHeroByName();
            }
        });


        findByLevelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findHeroByLevel();
            }
        });


        openFromFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFromFile();
            }
        });

        serializeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serializeHeroes();
            }
        });


        saveToTextFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToTextFile();
            }
        });

        customSerializeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customSerializeHeroes();
            }
        });


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
        buttonPanel.add(hardcodeButton);
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
        buttonPanel.add(localeComboBox);
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

    private void updateLocalizedTexts() {
        // Обновляем тексты всех компонентов согласно выбранной локализации
        randomButton.setText(messages.getString("random_button"));
        hardcodeButton.setText(messages.getString("hardcore_button"));
        sortByNameAndLevelButton.setText(messages.getString("sort_by_name_and_level_button"));
        sortByLevelButton.setText(messages.getString("sort_by_name_button"));
        sortByBuildCostButton.setText(messages.getString("sort_by_build_cost_button"));
        findByNameButton.setText(messages.getString("find_by_name_button"));
        findByLevelButton.setText(messages.getString("find_by_level_button"));
        openFromFileButton.setText(messages.getString("open_from_file_button"));
        serializeButton.setText(messages.getString("serialize_button"));
        saveToTextFileButton.setText(messages.getString("save_to_text_file_button"));
        customSerializeButton.setText(messages.getString("custom_serialize_button"));
        customDeserializeButton.setText(messages.getString("custom_deserialize_button"));

        // И так далее для всех компонентов, которые требуют локализации
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
