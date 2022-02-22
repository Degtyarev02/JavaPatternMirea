package com.company.EX8.state;

/**
 * todo Document type StateContext
 */
public class StateContext {
    private State state = new SolidState();

    public void freeze() {
        System.out.println("Freezing " + state.getName() + " substance...");
        state.freeze(this);
    }

    public void heat() {
        System.out.println("Heating " + state.getName() + " substance...");
        state.heat(this);
    }

    public void setState(State state) {
        System.out.println("Changing state to " + state.getName() + "...");
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
