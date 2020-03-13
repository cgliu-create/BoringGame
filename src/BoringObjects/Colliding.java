package BoringObjects;

import BoringStuff.MathStuff;

public class Colliding {
//Detection radius
    private int radius;
//Math
    private MathStuff m = new MathStuff();
//CONSTRUCTING 
    public Colliding(GameObject thisThing){
        radius = thisThing.getWidth()/2;
    }
//CHANGING RADIUS
    public int getRadius() { return radius;}
//ACCESSING RADIUS
    public void setRadius(int radius) { this.radius = radius;}
//CHECKING COLLISION
    public boolean checkAllDir(GameObject thisThing, GameObject otherThing){
        //sort of like the atomic radius
        int rr = thisThing.getRadius() + otherThing.getRadius();
        double d = m.distBtwnTwoPoints(thisThing.getCenterX(),thisThing.getCenterY(),otherThing.getCenterX(),otherThing.getCenterY());
        return d <= rr;
    }
}
