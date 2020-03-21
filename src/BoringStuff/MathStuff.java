package BoringStuff;

public class MathStuff {
//CALCULATING DISTANCE
    public double distBtwnTwoPoints(int x1, int y1, int x2, int y2){
        int x = Math.abs(x1-x2);
        int y = Math.abs(y1-y2);
        return Math.sqrt(x*x+y*y); //distance formula
    }
//CALCULATING ANGLE
    public double angleBtwnTwoLines(int xc, int yc, int xe1, int ye1, int xe2, int ye2){
        int da1 = xe1 - xc;
        int do1 = ye1 - yc;
        int da2 = xe2 - xc;
        int do2 = ye2 - yc;
        double ang1 = Math.toDegrees(Math.atan(do1*1.0/da1));
        double ang2 = Math.toDegrees(Math.atan(do2*1.0/da2));
        return Math.abs(ang1-ang2); //angle dif of two triangles
    }
}
