package project_16x16.entities;

import processing.core.PVector;

public class Update {
    public void update(PVector velocity) {
        if (velocity.y != 0) {
            enemyState.flying = true;
        }
        pos.add(velocity);

        if (pos.y > 2000) { // out of bounds check
            // Destroy(gameObject);
        }

        if (applet.isKeyDown(KeyEvent.VK_9)) {

        }

        if (applet.debug == debugType.ALL) {
            applet.noFill();
            applet.stroke(255, 0, 0);
            applet.strokeWeight(1);
            applet.ellipse(pos.x, pos.y, collisionRange * 2, collisionRange * 2);
        }
    }
}
