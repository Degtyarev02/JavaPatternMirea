package com.company.EX6.factory;

/**
 * todo Document type WarriorFactory
 */
public class WarriorFactory implements Factory {

    @Override
    public Enemy enemyFactory() {
        return new Warrior();
    }
}
