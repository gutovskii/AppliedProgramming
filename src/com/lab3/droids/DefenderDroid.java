package com.lab3.droids;

import java.util.ArrayList;
import java.util.Random;

public class DefenderDroid extends Droid {
    public DefenderDroid(ArrayList<Droid> allies, ArrayList<Droid> enemies) {
        super(
            "Defender",
            150,
            7.5,
            0.5,
            "Блокування атаки",
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
        Random rand = new Random();
        double blockHitChance = rand.nextDouble();

        double resultDamage = calculateReducedValue(attacker.getDamage(), maxResistance);
        logger.logAttack(attacker, this, resultDamage);

        if (blockHitChance < 0.75) health -= resultDamage;
        else logger.logBlock();

        if (health > 0) logger.logTakeHit(this);
        else destroy(this);
    }
}
