package com.company.EX8.state;

/**
 * todo Document type SolidState
 */
public class SolidState implements State{
    @Override
    public String getName() {
        return "solid";
    }

    @Override
    public void freeze(StateContext context) {
        System.out.println("Nothing happens.");
    }

    @Override
    public void heat(StateContext context) {
        context.setState(new LiquidState());
    }
}
