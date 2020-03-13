package BoringStuff;

public class MathStuff {
//CALCULATING DISTANCE
    public double distBtwnTwoPoints(int x1, int y1, int x2, int y2){
        int x = Math.abs(x1-x2);
        int y = Math.abs(y1-y2);
        return Math.sqrt(x*x+y*y); //distance formula
    }
//CALCULATING ANGLE
    public int angleBtwnTwoLines(int x1, int y1, int x2, int y2, int x3, int y3){
        int dXa = Math.abs(x2 - x1);
        int dYa = Math.abs(y2 - y1);
        int dXb = Math.abs(x3 - x1);
        int dYb = Math.abs(y3 - y1);
        double angA = Math.toDegrees(Math.atan(dYa*1.0/dXa));
        double angB = Math.toDegrees(Math.atan(dYb*1.0/dXb));
        return (int)(Math.abs(angA-angB)); //angle dif of two triangles
    }
//CALCULATING DISTANCE BTWN POINT AND LINE
    public int distBtnPointNLine(int xOrig, int yOrig, int xL, int yL, int xP, int yP){
        double theta = angleBtwnTwoLines(xOrig, yOrig, xL, yL, xP, yP);
        double diag = distBtwnTwoPoints(xOrig,yOrig,xP,yP);
        return (int)(diag * Math.sin(Math.toRadians(theta)));
    }
}
