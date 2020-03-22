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
        int da1 = xe1 - xc; //player
        int do1 = yc - ye1; //player
        int da2 = xe2 - xc; //aim
        int do2 = yc - ye2; //aim
        double ang1 = Math.toDegrees(Math.atan(do1*1.0/da1));
        double ANG1 = ang1; //Q1
        if(da1<=0&&do1>=0){ //Q2
            ANG1 = 180 + ang1;
        }
        if(da1<=0&&do1<=0){ //Q3
            ANG1 = 180 + ang1;
        }
        if(da1>=0&&do1<=0){ //Q4
            ANG1 = 360 + ang1;
        }
        double ang2 = Math.toDegrees(Math.atan(do2*1.0/da2));
        double ANG2 = ang2; //Q1
        if(da2<=0&&do2>=0){ //Q2
            ANG2 = 180 + ang2;
        }
        if(da2<=0&&do2<=0){ //Q3
            ANG2 = 180 + ang2;
        }
        if(da2>=0&&do2<=0){ //Q4
            ANG2 = 360 + ang2;
        }
        double angbtwn = Math.abs(ANG1-ANG2);
        if(angbtwn>180){
            angbtwn = 360 - angbtwn;
        }
        return angbtwn;
    }
}
