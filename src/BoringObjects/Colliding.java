package BoringObjects;

import BoringStuff.MathStuff;

public class Colliding {
    private int radius;
    private MathStuff m = new MathStuff();
    public Colliding(GameObject thisThing){
        radius = thisThing.getWidth()/2;
    }
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    //other = what this is hitting
    public boolean checkAllDir(GameObject thisThing, GameObject otherThing){
        //sort of like the atomic radius
        int rr = thisThing.getRadius() + otherThing.getRadius();
        //distance formula
        double d = m.distBtwnTwoPoints(thisThing.getCenterX(),thisThing.getCenterY(),otherThing.getCenterX(),otherThing.getCenterY());
        return d <= rr;
    }
}
