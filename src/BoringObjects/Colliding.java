package BoringObjects;

public class Colliding {
    private int radius;
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
        int cx = thisThing.getXPos() + thisThing.getWidth()/2;
        int cy = thisThing.getYPos() + thisThing.getHeight()/2;
        int r  = thisThing.getRadius();
        int cox = otherThing.getXPos() + otherThing.getWidth()/2;
        int coy = otherThing.getYPos() + otherThing.getHeight()/2;
        int ro = otherThing.getRadius();
        int rr = r + ro;
        //distance formula
        int x = Math.abs(cox-cx);
        int y = Math.abs(coy-cy);
        int d = (int)(Math.sqrt(x*x+y*y));
        //heh
        if (d == 0)
            return false;
        return d <= rr;
    }
}
