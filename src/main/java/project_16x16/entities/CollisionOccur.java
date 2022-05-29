package project_16x16.entities;

import processing.core.PVector;
import project_16x16.objects.CollidableObject;

public class CollisionOccur {
        public boolean collides(PVector pos, int width, int height, CollidableObject collision) {
                return (pos.x + width / 2 > collision.pos.x - collision.width / 2
                                && pos.x - width / 2 < collision.pos.x + collision.width / 2)
                                && (pos.y + height / 2 > collision.pos.y - collision.height / 2
                                                && pos.y - height / 2 < collision.pos.y + collision.height / 2);
        }

        public boolean collidesEqual(PVector pos, int width, int height, CollidableObject collision) {
                return (pos.x + width / 2 >= collision.pos.x - collision.width / 2
                                && pos.x - width / 2 <= collision.pos.x + collision.width / 2)
                                && (pos.y + height / 2 >= collision.pos.y - collision.height / 2
                                                && pos.y - height / 2 <= collision.pos.y + collision.height / 2);
        }

        public boolean collidesFutur(PVector pos, PVector velocity, int width, int height, CollidableObject collision) {
                return (pos.x + velocity.x + width / 2 > collision.pos.x - collision.width / 2
                                && pos.x + velocity.x - width / 2 < collision.pos.x + collision.width / 2)
                                && (pos.y + velocity.y + height / 2 > collision.pos.y - collision.height / 2
                                                && pos.y + velocity.y - height / 2 < collision.pos.y
                                                                + collision.height / 2);
        }

        public boolean collidesFuturX(PVector pos, PVector velocity, int width, int height,
                        CollidableObject collision) {
                return (pos.x + velocity.x + width / 2 > collision.pos.x - collision.width / 2
                                && pos.x + velocity.x - width / 2 < collision.pos.x + collision.width / 2)
                                && (pos.y + 0 + height / 2 > collision.pos.y - collision.height / 2
                                                && pos.y + 0 - height / 2 < collision.pos.y + collision.height / 2);
        }

        public boolean collidesFuturY(PVector pos, PVector velocity, int width, int height,
                        CollidableObject collision) {
                return (pos.x + 0 + width / 2 > collision.pos.x - collision.width / 2
                                && pos.x + 0 - width / 2 < collision.pos.x + collision.width / 2)
                                && (pos.y + velocity.y + height / 2 > collision.pos.y - collision.height / 2
                                                && pos.y + velocity.y - height / 2 < collision.pos.y
                                                                + collision.height / 2);
        }

}
