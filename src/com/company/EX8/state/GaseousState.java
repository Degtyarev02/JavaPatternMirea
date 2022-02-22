package com.company.EX8.state;

/**
 * todo Document type GaseousState
 */
public class GaseousState implements State {
    @Override
    public String getName() {
        return "gaseous";
    }

    public void freeze(StateContext context) {
        context.setState(new LiquidState());
    }

    public void heat(StateContext context) {
        System.out.println("Nothing happens.");
    }
}
