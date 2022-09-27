package com.lab3.droids;

import com.lab3.logger.FightLogger;

import java.util.ArrayList;
import java.util.Random;

public abstract class Droid {
    protected String name;
    protected double health;
    protected double damage;
    protected double maxResistance;
    protected String skillDescription;

    protected ArrayList<Droid> allies;
    protected ArrayList<Droid> enemies;

    protected FightLogger logger;

    public Droid(String name, double health, double damage, double maxResistance, String skillDescription,
                 ArrayList<Droid> allies, ArrayList<Droid> enemies) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.maxResistance = maxResistance;
        this.skillDescription = skillDescription;

        this.allies = allies;
        this.enemies = enemies;

        this.logger = new FightLogger(allies, enemies);
    }

    public abstract void attack(Droid victim);

    public abstract void takeHit(Droid attacker);

    protected void destroy(Droid defender) {
        logger.logDestroy(defender);
        allies.remove(defender);
    }

    protected double calculateReducedValue(double value, double maxReducer) {
        Random rand = new Random();
        double resultReducer = rand.nextDouble(maxReducer);
        double resultValue = (int)(value - value * resultReducer);
        return resultValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getMaxResistance() {
        return maxResistance;
    }

    public void setMaxResistance(double maxResistance) {
        if (maxResistance > 1) maxResistance = 1;
        else if (maxResistance < 0) maxResistance = 0;

        this.maxResistance = maxResistance;
    }

    public String toString() {
        return this.name + ": " +
                this.health + "❤ " +
                this.damage + "⚔ " +
                this.maxResistance + "\uD83D\uDEE1\n" +
                "Особливість: " + this.skillDescription;
    }
}
