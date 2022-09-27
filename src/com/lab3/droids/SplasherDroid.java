package com.lab3.droids;

import java.util.ArrayList;
import java.util.Random;

public class SplasherDroid extends Droid {
    public SplasherDroid(ArrayList<Droid> allies, ArrayList<Droid> enemies) {
        super(
            "Splasher",
            100,
            12.5,
            0.3,
            "Масовий удар",
            allies,
            enemies
        );
    }

    @Override
    public void attack(Droid victim) {
        Random rand = new Random();
        double splashChance = rand.nextDouble();
        if (splashChance >= 0.75) {
            logger.logSplashAttack();
            for (Droid enemy : enemies) {
                // ConcurrentModificationException ;(((
                enemy.takeHit(this);
            }
        } else {
            victim.takeHit(this);
        }
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
