package project_16x16.entities;

import processing.core.PConstants;

public class State {
    public boolean flying;
    public boolean attacking;
    public boolean dashing;
    public int facingDir;
    public boolean landing;
    public boolean jumping;
    public static final int RIGHT = PConstants.RIGHT;

    State() {
        flying = false;
        attacking = false;
        dashing = false;
        facingDir = RIGHT;
        jumping = false;
        landing = false;
    }

}
