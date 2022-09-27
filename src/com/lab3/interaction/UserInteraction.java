package com.lab3.interaction;

import com.lab3.arena.Arena;
import com.lab3.datakeeper.DataKeeper;
import com.lab3.droids.*;
import com.lab3.logger.ConsoleColors;
import com.lab3.logger.FightLogger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInteraction {
    private final Scanner scanner = new Scanner(System.in);

    private final ArrayList<Droid> team1 = new ArrayList<>();
    private final ArrayList<Droid> team2 = new ArrayList<>();

    public void chooseTasks() {
        while (true) {
            System.out.println("\uD83E\uDD16 =====Меню===== \uD83E\uDD16");
            System.out.println("1: Створити команди");
            System.out.println("2: Почати бій");
            System.out.println("3: Записати бій у файл");
            System.out.println("4: Вивести бій із файлу");
            System.out.println("0: Вихід");
            int taskNumber = Integer.parseInt(scanner.nextLine());

            switch (taskNumber) {
                case 1:
                    createTeams();
                    break;
                case 2:
                    startFight();
                    break;
                case 3:
                    System.out.println("Шлях до файлу: ");
                    String writePath = scanner.nextLine();
                    saveFightInFile(writePath);
                    break;
                case 4:
                    System.out.println("Шлях до файлу: ");
                    String outputPath = scanner.nextLine();
                    reproduceFightFromFile(outputPath);
                    break;
                case 0:
                    return;
                default:
                    return;
            }
        }
    }

    private void createTeams() {
        team1.clear();
        team2.clear();

        System.out.println("Кількість бійців у " + ConsoleColors.BLUE + "першій " + ConsoleColors.RESET + "команді: ");
        int droidsCountInTeam1 = Integer.parseInt(scanner.nextLine());

        System.out.println("Кількість бійців у " + ConsoleColors.YELLOW + "другій " + ConsoleColors.RESET + "команді: ");
        int droidsCountInTeam2 = Integer.parseInt(scanner.nextLine());

        System.out.println(ConsoleColors.BLUE + "Перша " + ConsoleColors.RESET + "команда");
        System.out.println("Обирай дроїдів: ");
        createDroids(team1, team2, droidsCountInTeam1);

        System.out.println(ConsoleColors.YELLOW + "Друга " + ConsoleColors.RESET + "команда");
        System.out.println("Обирай дроїдів: ");
        createDroids(team2, team1, droidsCountInTeam2);

        FightLogger logger = new FightLogger(team1, team2);
        logger.logFightersInfo();
    }

    private void startFight() {
        if (team1.isEmpty() || team2.isEmpty()) {
            System.out.println(ConsoleColors.WHITE_UNDERLINED + "Пусті команди участі не беруть" + ConsoleColors.RESET);
            return;
        }
        DataKeeper.reset();
        Arena arena = new Arena(team1, team2);
        arena.fight();
    }

    private void saveFightInFile(String path) {
        if (DataKeeper.fightInfo.isEmpty()) {
            System.out.println(ConsoleColors.WHITE_UNDERLINED + "Запис файлу пустый" + ConsoleColors.RESET);
        }
        try {
            Path file = Paths.get(path);
            Files.writeString(file, DataKeeper.fightInfo, StandardCharsets.UTF_8, StandardOpenOption.WRITE);
            System.out.println(ConsoleColors.GREEN_UNDERLINED + "Дані записані успішно!" + ConsoleColors.RESET);
        } catch (IOException e) {
            System.out.println(ConsoleColors.RED_UNDERLINED + "Такого файлу не існує!" + ConsoleColors.RESET);
        } catch (Exception e) {
            System.out.println(ConsoleColors.RED_UNDERLINED + "Щось пішло не так..." + ConsoleColors.RESET);
        }
    }

    private void reproduceFightFromFile(String path) {
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
                System.out.println(scanner.nextLine());
        } catch (IOException e) {
            System.out.println(ConsoleColors.RED_UNDERLINED + "Такого файлу не існує!" + ConsoleColors.RESET);
        } catch (Exception e) {
            System.out.println(ConsoleColors.RED_UNDERLINED + "Щось пішло не так..." + ConsoleColors.RESET);
        }
    }

    private void createDroids(ArrayList<Droid> allies, ArrayList<Droid> enemies, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("1: Basic");
            System.out.println("2: Attacker");
            System.out.println("3: Defender");
            System.out.println("4: Spiky");
            System.out.println("5: Healer");
            int chosenDroid = Integer.parseInt(scanner.nextLine());
            switch (chosenDroid) {
                case 1 -> allies.add(new BasicDroid(allies, enemies));
                case 2 -> allies.add(new AttackerDroid(allies, enemies));
                case 3 -> allies.add(new DefenderDroid(allies, enemies));
                case 4 -> allies.add(new SpikyDroid(allies, enemies));
                case 5 -> allies.add(new HealerDroid(allies, enemies));
                default -> allies.add(new BasicDroid(allies, enemies));
            }
        }
    }
}