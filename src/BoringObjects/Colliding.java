package BoringObjects;

public abstract class Colliding {
    public boolean hitsTop(GameObject thisThing, GameObject otherThing){
        if(otherThing.getXPos()>=thisThing.getXPos()&&otherThing.getXPos()<=(thisThing.getXPos()+thisThing.getWidth())){
            if(Math.abs((otherThing.getYPos()+otherThing.getHeight()) - thisThing.getYPos())<=10){
                return true;
            }
        }
        return false;
    }
    public boolean hitsBottom(GameObject thisThing, GameObject otherThing){
        if(otherThing.getXPos()>=thisThing.getXPos()&&otherThing.getXPos()<=(thisThing.getXPos()+thisThing.getWidth())){
            if(Math.abs(otherThing.getYPos() - (thisThing.getYPos()+thisThing.getHeight()))<=10){
                return true;
            }
        }
        return false;
    }
    public boolean hitsLeft(GameObject thisThing, GameObject otherThing){
        if(otherThing.getYPos()>=thisThing.getYPos()&&otherThing.getYPos()<=(thisThing.getYPos()+thisThing.getHeight())){
            if(Math.abs((otherThing.getXPos() + otherThing.getWidth()) -thisThing.getXPos())<=10){
                return true;
            }
        }
        return false;
    }
    public boolean hitsRight(GameObject thisThing, GameObject otherThing){
        if(otherThing.getYPos()>=thisThing.getYPos()&&otherThing.getYPos()<=(thisThing.getYPos()+thisThing.getHeight())){
            if(Math.abs(otherThing.getXPos() - (thisThing.getXPos() + thisThing.getWidth()))<= 10){
                return true;
            }
        }
        return false;
    }
}
