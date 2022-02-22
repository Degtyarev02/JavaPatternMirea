package org.example.Entity;

import org.springframework.stereotype.Component;

@Component
public class Judoka implements Fighter{
    @Override
    public void doFight() {
        System.out.println("Judoka");
    }
}
