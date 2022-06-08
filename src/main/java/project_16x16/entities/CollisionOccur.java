package project_16x16.entities;

import processing.core.PVector;
import project_16x16.objects.CollidableObject;

public class CollisionOccur {

        private PVector pos;
        private PVector velocity;
        private int width;
        private int height;
        private CollidableObject collision;

        public CollisionOccur() {
        }

        public void setPos(PVector pos_) {
                pos = pos_;
        }

        public PVector getPos() {
                return pos;
        }

        public void setVelocity(PVector velocity_) {
                velocity = velocity_;
        }

        public PVector getVelocity() {
                return velocity;
        }

        public void setWidth(int width_) {
                width = width_;
        }

        public int getWidth() {
                return width;
        }

        public void setHeight(int height_) {
                height = height_;
        }

        public int getHeight() {
                return height;
        }

        public void setCollidableObj(CollidableObject collidobj_) {
                collision = collidobj_;
        }

        public CollidableObject getCollidableObj() {
                return collision;
        }

        public boolean collides() {
                return (pos.x + width / 2 > collision.pos.x - collision.width / 2
                                && pos.x - width / 2 < collision.pos.x + collision.width / 2)
                                && (pos.y + height / 2 > collision.pos.y - collision.height / 2
                                                && pos.y - height / 2 < collision.pos.y + collision.height / 2);
        }

        public boolean collidesEqual() {

                return (pos.x + width / 2 >= collision.pos.x - collision.width / 2
                                && pos.x - width / 2 <= collision.pos.x + collision.width / 2)
                                && (pos.y + height / 2 >= collision.pos.y - collision.height / 2
                                                && pos.y - height / 2 <= collision.pos.y + collision.height / 2);
        }

        public boolean collidesFutur() {

                return (pos.x + velocity.x + width / 2 > collision.pos.x - collision.width / 2
                                && pos.x + velocity.x - width / 2 < collision.pos.x + collision.width / 2)
                                && (pos.y + velocity.y + height / 2 > collision.pos.y - collision.height / 2
                                                && pos.y + velocity.y - height / 2 < collision.pos.y
                                                                + collision.height / 2);
        }

        public boolean collidesFuturX() {

                return (pos.x + velocity.x + width / 2 > collision.pos.x - collision.width / 2
                                && pos.x + velocity.x - width / 2 < collision.pos.x + collision.width / 2)
                                && (pos.y + 0 + height / 2 > collision.pos.y - collision.height / 2
                                                && pos.y + 0 - height / 2 < collision.pos.y + collision.height / 2);
        }

        public boolean collidesFuturY() {

                return (pos.x + 0 + width / 2 > collision.pos.x - collision.width / 2
                                && pos.x + 0 - width / 2 < collision.pos.x + collision.width / 2)
                                && (pos.y + velocity.y + height / 2 > collision.pos.y - collision.height / 2
                                                && pos.y + velocity.y - height / 2 < collision.pos.y
                                                                + collision.height / 2);
        }

        public boolean checkCollides(String input) {
                switch (input) {
                        case "default":
                                return collides();
                        case "equal":
                                return collidesEqual();
                        case "futur":
                                return collidesFutur();
                        case "futurX":
                                return collidesFuturX();
                        case "futurY":
                                return collidesFuturY();
                        default:
                                return collides();
                }

        }

}
