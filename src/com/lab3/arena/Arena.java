package com.lab3.arena;

import com.lab3.droids.Droid;
import com.lab3.logger.FightLogger;

import java.util.ArrayList;

public class Arena {
    private final ArrayList<Droid> team1;
    private final ArrayList<Droid> team2;
    private final FightLogger logger;

    public Arena(ArrayList<Droid> team1, ArrayList<Droid> team2) {
        this.team1 = team1;
        this.team2 = team2;
        this.logger = new FightLogger(team1, team2);
    }

    public void fight() {
        int attackerIdx = 0;
        int defenderIdx = 0;

        Droid attacker;
        Droid defender;

        ArrayList<Droid> attackers = team1;
        ArrayList<Droid> defenders = team2;

        int roundNumber = 1;
        while (!attackers.isEmpty() && !defenders.isEmpty()) {
            logger.logRoundInfo(roundNumber);

            if (attackerIdx == attackers.size() && defenderIdx == defenders.size()) {
                attackerIdx = 0;
                defenderIdx = 0;
            }

            while (attackerIdx >= attackers.size()) attackerIdx--;
            attacker = attackers.get(attackerIdx);

            while (defenderIdx >= defenders.size()) defenderIdx--;
            if (defenderIdx == -1) break;
            defender = defenders.get(defenderIdx);
            attacker.attack(defender);

            while (defenderIdx >= defenders.size()) defenderIdx--;
            if (defenderIdx == -1) break;
            attacker = defenders.get(defenderIdx);

            while (attackerIdx >= attackers.size()) attackerIdx--;
            if (attackerIdx == -1) break;
            defender = attackers.get(attackerIdx);
            attacker.attack(defender);

            attackerIdx++;
            defenderIdx++;

            var tempDroids = defenders;
            defenders = attackers;
            attackers = tempDroids;

            var tempIdx = attackerIdx;
            attackerIdx = defenderIdx;
            defenderIdx = tempIdx;

            roundNumber++;
        }
        var winner = !team1.isEmpty();
        logger.logWinner(winner);
    }
}
