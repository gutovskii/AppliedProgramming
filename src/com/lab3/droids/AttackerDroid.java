package com.lab3.droids;

import java.util.ArrayList;
import java.util.Random;

public class AttackerDroid extends Droid {
    private final double damageMultiplier = 1.5;

    public AttackerDroid(ArrayList<Droid> allies, ArrayList<Droid> enemies) {
        super(
            "Attacker",
            50,
            30,
            0.25,
            "Критичний удар",
            allies,
            enemies
        );
    }

    @Override
    public void attack(Droid victim) {
        Random rand = new Random();
        double criticalHitChance = rand.nextDouble();
        if (criticalHitChance >= 0.75) {
            logger.logCriticalHit();
            this.damage *= damageMultiplier;
        }

        victim.takeHit(this);

        if (criticalHitChance >= 0.75) this.damage /= damageMultiplier;
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
