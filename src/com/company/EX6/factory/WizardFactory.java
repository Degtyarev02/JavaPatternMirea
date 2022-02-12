package com.company.EX6.factory;

/**
 * todo Document type WizardFactory
 */
public class WizardFactory implements Factory{
    @Override
    public Enemy enemyFactory() {
        return new Wizard();
    }
}
