package entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import processing.core.PVector;
import project_16x16.SideScroller;
import project_16x16.entities.CleanerRobot;
import project_16x16.scene.GameplayScene;

public class CleanerRobotTest {

    @Test
    public void CleanerRobotConstructorTest() {
        SideScroller a = new SideScroller();
        GameplayScene b = new GameplayScene(new SideScroller(), "first");
        CleanerRobot cleanerRobot = new CleanerRobot(a, b, new PVector(0, 1), new PVector(1, 2));
        assertTrue(cleanerRobot.notNull());
    }

    @Test
    public void getDistanceTest() {
        PVector a = new PVector(1, 2);
        PVector b = new PVector(3, 4);
        CleanerRobot cleanerRobot = new CleanerRobot(new SideScroller(), new GameplayScene(new SideScroller(), "abc"),
                a, b);
        double expected = Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
        assertEquals(expected, cleanerRobot.getDistance(a, b));

    }
}
