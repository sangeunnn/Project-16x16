package entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

import processing.core.PVector;
import project_16x16.SideScroller;
import project_16x16.entities.CollisionOccur;
import project_16x16.objects.CollidableObject;
import project_16x16.scene.GameplayScene;

public class CollisionOccurTest {

    @Test
    public void setPosTest() {
        PVector expected = new PVector(1, 1);
        CollisionOccur occur = new CollisionOccur();
        occur.setPos(expected);
        assertSame(expected, occur.getPos());
    }

    @Test
    public void setVelocityTest() {
        PVector velocity = new PVector(1, 1);
        CollisionOccur occur = new CollisionOccur();
        occur.setVelocity(velocity);
        assertSame(velocity, occur.getVelocity());
    }

    @Test
    public void setWidthTest() {
        int width = 1;
        CollisionOccur occur = new CollisionOccur();
        occur.setWidth(width);
        assertEquals(width, occur.getWidth());
    }

    @Test
    public void setHeightTest() {
        int height = 1;
        CollisionOccur occur = new CollisionOccur();
        occur.setHeight(height);
        assertEquals(height, occur.getHeight());
    }

    @Test
    public void setCollisionObjTest() {
        CollidableObject collision = new CollidableObject(new SideScroller(),
                new GameplayScene(new SideScroller(), "first"));
        CollisionOccur occur = new CollisionOccur();
        occur.setCollidableObj(collision);
        assertSame(collision, occur.getCollidableObj());
    }

    @Test
    public void collidesTest() {
        PVector pos = new PVector(1, 1);
        int width = 1;
        int height = 1;
        CollidableObject collision = new CollidableObject(new SideScroller(),
                new GameplayScene(new SideScroller(), "first"));
        CollisionOccur test = new CollisionOccur();
        test.setWidth(width);
        test.setHeight(height);
        test.setPos(pos);
        test.setCollidableObj(collision);

        assertEquals((pos.x + width / 2 > collision.pos.x - collision.width / 2
                && pos.x - width / 2 < collision.pos.x + collision.width / 2)
                && (pos.y + height / 2 > collision.pos.y - collision.height / 2
                        && pos.y - height / 2 < collision.pos.y + collision.height / 2),
                test.collides());
    }

    @Test
    public void collidesEqualTest() {
        PVector pos = new PVector(1, 1);
        int width = 1;
        int height = 1;
        CollidableObject collision = new CollidableObject(new SideScroller(),
                new GameplayScene(new SideScroller(), "first"));
        CollisionOccur test = new CollisionOccur();
        test.setWidth(width);
        test.setHeight(height);
        test.setPos(pos);
        test.setCollidableObj(collision);

        assertEquals((pos.x + width / 2 >= collision.pos.x - collision.width / 2
                && pos.x - width / 2 <= collision.pos.x + collision.width / 2)
                && (pos.y + height / 2 >= collision.pos.y - collision.height / 2
                        && pos.y - height / 2 <= collision.pos.y + collision.height / 2),
                test.collidesEqual());
    }

    @Test
    public void collidesFuturTest() {
        PVector pos = new PVector(1, 1);
        PVector velocity = new PVector(2, 2);
        int width = 1;
        int height = 1;
        CollidableObject collision = new CollidableObject(new SideScroller(),
                new GameplayScene(new SideScroller(), "first"));
        CollisionOccur test = new CollisionOccur();
        test.setWidth(width);
        test.setHeight(height);
        test.setPos(pos);
        test.setVelocity(velocity);
        test.setCollidableObj(collision);

        assertEquals((pos.x + velocity.x + width / 2 > collision.pos.x - collision.width / 2
                && pos.x + velocity.x - width / 2 < collision.pos.x + collision.width / 2)
                && (pos.y + velocity.y + height / 2 > collision.pos.y - collision.height / 2
                        && pos.y + velocity.y - height / 2 < collision.pos.y
                                + collision.height / 2),
                test.collidesFutur());
    }

    @Test
    public void collidesFuturXTest() {
        PVector pos = new PVector(1, 1);
        PVector velocity = new PVector(2, 2);
        int width = 1;
        int height = 1;
        CollidableObject collision = new CollidableObject(new SideScroller(),
                new GameplayScene(new SideScroller(), "first"));
        CollisionOccur test = new CollisionOccur();
        test.setWidth(width);
        test.setHeight(height);
        test.setPos(pos);
        test.setVelocity(velocity);
        test.setCollidableObj(collision);

        assertEquals((pos.x + velocity.x + width / 2 > collision.pos.x - collision.width / 2
                && pos.x + velocity.x - width / 2 < collision.pos.x + collision.width / 2)
                && (pos.y + 0 + height / 2 > collision.pos.y - collision.height / 2
                        && pos.y + 0 - height / 2 < collision.pos.y + collision.height / 2),
                test.collidesFuturX());
    }

    @Test
    public void collidesFuturYTest() {
        PVector pos = new PVector(1, 1);
        PVector velocity = new PVector(2, 2);
        int width = 1;
        int height = 1;
        CollidableObject collision = new CollidableObject(new SideScroller(),
                new GameplayScene(new SideScroller(), "first"));
        CollisionOccur test = new CollisionOccur();
        test.setWidth(width);
        test.setHeight(height);
        test.setPos(pos);
        test.setVelocity(velocity);
        test.setCollidableObj(collision);

        assertEquals((pos.x + 0 + width / 2 > collision.pos.x - collision.width / 2
                && pos.x + 0 - width / 2 < collision.pos.x + collision.width / 2)
                && (pos.y + velocity.y + height / 2 > collision.pos.y - collision.height / 2
                        && pos.y + velocity.y - height / 2 < collision.pos.y
                                + collision.height / 2),
                test.collidesFuturY());
    }

    @Test
    public void checkCollidesDefaultTest() {
        PVector pos = new PVector(1, 1);
        int width = 1;
        int height = 1;
        CollidableObject collision = new CollidableObject(new SideScroller(),
                new GameplayScene(new SideScroller(), "first"));
        CollisionOccur test = new CollisionOccur();
        test.setWidth(width);
        test.setHeight(height);
        test.setPos(pos);
        test.setCollidableObj(collision);
        assertEquals(test.checkCollides("default"), (pos.x + width / 2 > collision.pos.x - collision.width / 2
                && pos.x - width / 2 < collision.pos.x + collision.width / 2)
                && (pos.y + height / 2 > collision.pos.y - collision.height / 2
                        && pos.y - height / 2 < collision.pos.y + collision.height / 2));
    }

    @Test
    public void checkCollidesEqualTest() {
        PVector pos = new PVector(1, 1);
        int width = 1;
        int height = 1;
        CollidableObject collision = new CollidableObject(new SideScroller(),
                new GameplayScene(new SideScroller(), "first"));
        CollisionOccur test = new CollisionOccur();
        test.setWidth(width);
        test.setHeight(height);
        test.setPos(pos);
        test.setCollidableObj(collision);
        assertEquals(test.checkCollides("equal"), (pos.x + width / 2 >= collision.pos.x - collision.width / 2
                && pos.x - width / 2 <= collision.pos.x + collision.width / 2)
                && (pos.y + height / 2 >= collision.pos.y - collision.height / 2
                        && pos.y - height / 2 <= collision.pos.y + collision.height / 2));
    }

    @Test
    public void checkCollidesFuturTest() {
        PVector pos = new PVector(1, 1);
        PVector velocity = new PVector(2, 2);
        int width = 1;
        int height = 1;
        CollidableObject collision = new CollidableObject(new SideScroller(),
                new GameplayScene(new SideScroller(), "first"));
        CollisionOccur test = new CollisionOccur();
        test.setWidth(width);
        test.setHeight(height);
        test.setPos(pos);
        test.setVelocity(velocity);
        test.setCollidableObj(collision);

        assertEquals(test.checkCollides("futur"),
                (pos.x + velocity.x + width / 2 > collision.pos.x - collision.width / 2
                        && pos.x + velocity.x - width / 2 < collision.pos.x + collision.width / 2)
                        && (pos.y + velocity.y + height / 2 > collision.pos.y - collision.height / 2
                                && pos.y + velocity.y - height / 2 < collision.pos.y
                                        + collision.height / 2));
    }

    @Test
    public void checkCollidesFuturXTest() {
        PVector pos = new PVector(1, 1);
        PVector velocity = new PVector(2, 2);
        int width = 1;
        int height = 1;
        CollidableObject collision = new CollidableObject(new SideScroller(),
                new GameplayScene(new SideScroller(), "first"));
        CollisionOccur test = new CollisionOccur();
        test.setWidth(width);
        test.setHeight(height);
        test.setPos(pos);
        test.setVelocity(velocity);
        test.setCollidableObj(collision);

        assertEquals(test.checkCollides("futurX"),
                (pos.x + velocity.x + width / 2 > collision.pos.x - collision.width / 2
                        && pos.x + velocity.x - width / 2 < collision.pos.x + collision.width / 2)
                        && (pos.y + 0 + height / 2 > collision.pos.y - collision.height / 2
                                && pos.y + 0 - height / 2 < collision.pos.y + collision.height / 2));
    }

    @Test
    public void checkCollidesFuturYTest() {
        PVector pos = new PVector(1, 1);
        PVector velocity = new PVector(2, 2);
        int width = 1;
        int height = 1;
        CollidableObject collision = new CollidableObject(new SideScroller(),
                new GameplayScene(new SideScroller(), "first"));
        CollisionOccur test = new CollisionOccur();
        test.setWidth(width);
        test.setHeight(height);
        test.setPos(pos);
        test.setVelocity(velocity);
        test.setCollidableObj(collision);

        assertEquals(test.checkCollides("futurY"),
                (pos.x + 0 + width / 2 > collision.pos.x - collision.width / 2
                        && pos.x + 0 - width / 2 < collision.pos.x + collision.width / 2)
                        && (pos.y + velocity.y + height / 2 > collision.pos.y - collision.height / 2
                                && pos.y + velocity.y - height / 2 < collision.pos.y
                                        + collision.height / 2));
    }

}
