package BoringStuff;

public class MathStuff {
//CALCULATING DISTANCE
    public double distBtwnTwoPoints(int x1, int y1, int x2, int y2){
        int x = Math.abs(x1-x2);
        int y = Math.abs(y1-y2);
        return Math.sqrt(x*x+y*y); //distance formula
    }
    public double angleOfALine(int xc, int yc, int xe, int ye){
        int da1 = xe - xc; //player
        int do1 = yc - ye; //player
        double ang1 = Math.toDegrees(Math.atan(do1*1.0/da1));
        double ANG1 = ang1; //Q1
        if(da1<0&&do1>0){ //Q2
            ANG1 = 180 + ang1;
        }
        if(da1<0&&do1<0){ //Q3
            ANG1 = 180 + ang1;
        }
        if(da1>0&&do1<0){ //Q4
            ANG1 = 360 + ang1;
        }
        //just in case
        if(da1==0&&do1>0){
            ANG1 = 90;
        }
        if(do1==0&&da1<0){
            ANG1 = 180;
        }
        if(da1==0&&do1<0){
            ANG1 = 270;
        }
        return ANG1;
    }
//CALCULATING ANGLE
    public double angleBtwnTwoLines(int xc, int yc, int xe1, int ye1, int xe2, int ye2){
        double angOne = angleOfALine(xc,yc,xe1,ye1);
        double angTwo= angleOfALine(xc,yc,xe2,ye2);
        double angbtwn = Math.abs(angOne-angTwo);
        if(angbtwn>180){
            angbtwn = 360 - angbtwn; //fix
        }
        return angbtwn;
    }
}
