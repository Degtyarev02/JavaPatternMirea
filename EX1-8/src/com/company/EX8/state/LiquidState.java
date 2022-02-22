package com.company.EX8.state;

/**
 * todo Document type LiquidState
 */
public class LiquidState implements State {
    public String getName() {
        return "liquid";
    }

    public void freeze(StateContext context) {
        context.setState(new SolidState());
    }

    public void heat(StateContext context) {
        context.setState(new GaseousState());
    }
}
