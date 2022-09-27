package com.lab3.droids;

import java.util.ArrayList;

public class BasicDroid extends Droid {
    public BasicDroid(ArrayList<Droid> allies, ArrayList<Droid> enemies) {
        super(
            "Basic",
            100,
            15,
            0.35,
            "-",
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
    }
}
