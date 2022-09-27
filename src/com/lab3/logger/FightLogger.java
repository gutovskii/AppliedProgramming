package com.lab3.logger;

import com.lab3.datakeeper.DataKeeper;
import com.lab3.droids.Droid;

import java.util.ArrayList;

public class FightLogger {
    private final ArrayList<Droid> team1;
    private final ArrayList<Droid> team2;
    private final boolean isTeamFight;

    public FightLogger(ArrayList<Droid> team1, ArrayList<Droid> team2) {
        this.team1 = team1;
        this.team2 = team2;

        this.isTeamFight = (team1.size() > 1 || team2.size() > 1);
    }

    public void logRoundInfo(int roundNumber) {
        log("\n\uD83D\uDEA9 " + "РАУНД " + roundNumber + " \uD83D\uDEA9\n");
        logFightersInfo();
    }

    public void logFightersInfo() {
        if (isTeamFight) {
            log("\t=====Команда №1=====\n");
            if (team1.isEmpty()) {
                log("\t☠ " + ConsoleColors.WHITE_UNDERLINED + "Усіх винищено" + ConsoleColors.RESET + " ☠\n");
            } else {
                for (Droid droid : team1) {
                    log(ConsoleColors.BLUE + droid + ConsoleColors.RESET + "\n");
                }
            }
            log("\n");
            log("\t=====Команда №2=====\n");
            if (team2.isEmpty()) {
                log("\t☠ " + ConsoleColors.WHITE_UNDERLINED + "Усіх винищено" + ConsoleColors.RESET + " ☠\n");
            } else {
                for (Droid droid : team2) {
                    log(ConsoleColors.YELLOW + droid + ConsoleColors.RESET + "\n");
                }
                log("\n");
            }
        }
        else {
            log("\t=====Бійці====\n");
            log(ConsoleColors.BLUE + team1.get(0) + ConsoleColors.RESET + "\n");
            log(ConsoleColors.YELLOW + team2.get(0) + ConsoleColors.RESET + "\n");
            log("\n");
        }
    }

    public void logWinner(boolean winner) {
        if (isTeamFight) {
            if (winner) {
                log("\n\uD83C\uDF89 Перемогла перша команда \uD83C\uDF89\n");
            }
            else {
                log("\n\uD83C\uDF89 Перемогла друга команда \uD83C\uDF89\n");
            }
        }
        else {
            if (winner) {
                log("\n\uD83C\uDF89 Переміг перший дроїд \uD83C\uDF89\n");
            }
            else {
                log("\n\uD83C\uDF89 Переміг другий дроїд \uD83C\uDF89\n");
            }
        }
        log("\n");
    }

    public void logAttack(Droid attacker, Droid defender, double resultDamage) {
        log(
            attacker.getName() +
            ConsoleColors.RED + " атакує " + ConsoleColors.RESET +
            defender.getName() +
            ", наносячи " + resultDamage + " шкоди\n"
        );
    }

    public void logTakeHit(Droid defender) {
        log(
            "У " + defender.getName() +
            ConsoleColors.BLUE + " залишилось " + ConsoleColors.RESET +
            defender.getHealth() + "❤\n"
        );
    }

    public void logDestroy(Droid defender) {
        log(
            defender.getName() + " " +
            ConsoleColors.RED_UNDERLINED + "знищено" + ConsoleColors.RESET + " \uD83D\uDC80\n"
        );
    }

    public void logCriticalHit() {
        log("\uD83D\uDD25 " + ConsoleColors.RED_BOLD + "Критичний удар" + ConsoleColors.RESET + " \uD83D\uDD25\n");
    }

    public void logBlock() {
        log("\uD83D\uDD37 " + ConsoleColors.BLUE_BOLD + "Блокування атаки" + ConsoleColors.RESET + " \uD83D\uDD37\n");
    }

    public void logHeal(double resultHeal) {
        log("\uD83D\uDC9A " + ConsoleColors.GREEN_BOLD + "Зцілення команди на " + resultHeal + ConsoleColors.RESET + " \uD83D\uDC9A\n");
    }

    public void logSplashAttack() {
        log("\uD83D\uDCA5 " + ConsoleColors.RED_BOLD + "Масова атака" + ConsoleColors.RESET + " \uD83D\uDCA5\n");
    }

    public void logReturnAttack() {
        log("\uD83D\uDDE1 " + ConsoleColors.PURPLE_BOLD + "Повернення удару" + ConsoleColors.RESET + " \uD83D\uDDE1\n");
    }

    private void log(String info) {
        DataKeeper.fightInfo.append(info);
        System.out.print(info);
    }
}
