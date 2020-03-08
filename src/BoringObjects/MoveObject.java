package BoringObjects;

import java.awt.*;

public class MoveObject extends GameObject {
        private Colliding c = new Colliding(this);
        private Moving m = new Moving();
        public MoveObject (int x, int y, int wd, int ht) {
            super(x, y, wd, ht);
        }
        @Override
        public int getRadius() {
                return c.getRadius();
        }
        @Override
        public void setRadius(int r) {
                c.setRadius(r);
        }
        @Override
        public void draw(Graphics window) {
                window.setColor(Color.WHITE);
                window.drawOval(getXPos(),getYPos(),getWidth(),getHeight());
        }
        //check colliding
        public boolean checkAllDir(GameObject other){ return c.checkAllDir(this,other);}
        //set and get moving
        public void setSpeed( int s) { m.setSpeed(s);}
        public void setDir(int degrees) { m.setDir(degrees);}
        public int getDir() { return m.getDir(); }
        public int getSpeed() { return m.getSpeed(); }
        public int getXspeed() { return m.getXspeed(); }
        public int getYspeed() { return m.getYspeed(); }
        @Override
        public String toString() {
            return "MoveObject{" + "\n" +
                    "g=" + super.toString() + "\n" +
                    ", m=" + m + "\n" +
                    '}';
        }
    }
