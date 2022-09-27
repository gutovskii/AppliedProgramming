package com.lab3.droids;

import java.util.ArrayList;
import java.util.Random;

public class HealerDroid extends Droid {
    private final double maxHealPower = 12;
    private final double maxHealReducer = 0.5;

    public HealerDroid(ArrayList<Droid> allies, ArrayList<Droid> enemies) {
        super(
            "Healer",
            80,
            7.5,
            0.20,
            "Зцілення команди",
            allies,
            enemies
        );
    }

    @Override
    public void attack(Droid victim) {
        Random rand = new Random();
        double healChance = rand.nextDouble();
        if (healChance >= 0.5) {
            double resultHeal = calculateReducedValue(maxHealPower, maxHealReducer);
            for (Droid ally : allies) {
                ally.setHealth(ally.getHealth() + resultHeal);
            }
            logger.logHeal(resultHeal);
        }

        victim.takeHit(this);
    }

    @Override
    public void takeHit(Droid attacker) {
        double resultDamage = calculateReducedValue(attacker.getDamage(), maxResistance);
        logger.logAttack(attacker, this, resultDamage);

        health -= resultDamage;
        if (health > 0) logger.logTakeHit(this);
        else destroy(this);
    }
}
