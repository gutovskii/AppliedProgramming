package com.lab3.droids;

import java.util.ArrayList;
import java.util.Random;

public class SpikyDroid extends Droid {
    private final double maxReflectionReducer = 0.75;

    public SpikyDroid(ArrayList<Droid> allies, ArrayList<Droid> enemies) {
        super(
            "Spiky",
            130,
            5,
            0.4,
            "Поверення удару",
            allies,
            enemies
        );
    }

    @Override
    public void attack(Droid victim) {
        victim.takeHit(this);
    }

    @Override
    public void takeHit(Droid attacker) {
        double resultDamage = calculateReducedValue(attacker.getDamage(), maxResistance);
        logger.logAttack(attacker, this, resultDamage);

        health -= resultDamage;
        if (health > 0) logger.logTakeHit(this);
        else destroy(this);

        Random rand = new Random();
        double returnDamageChance = rand.nextDouble();
        if (returnDamageChance >= 0.5) {
            double resultReturnDamage = calculateReducedValue(resultDamage, maxReflectionReducer);
            this.damage += resultReturnDamage;
            logger.logReturnAttack();
            attacker.takeHit(this);
            this.damage -= resultReturnDamage;
        }
    }
}
