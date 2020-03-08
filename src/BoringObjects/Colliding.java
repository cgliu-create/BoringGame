package BoringObjects;

public class Colliding {
    //other = what this is hitting
    public boolean hitsTop(GameObject thisThing, GameObject otherThing){
                //top right
        if(otherThing.getXPos()>=thisThing.getXPos()&&otherThing.getXPos()<=(thisThing.getXPos()+thisThing.getWidth())
                //top left
        || otherThing.getXPos()<=thisThing.getXPos()&&thisThing.getXPos()<=(otherThing.getXPos()+otherThing.getWidth())){
            if(Math.abs((otherThing.getYPos()+otherThing.getHeight()) - thisThing.getYPos())<=1){
                return true;
            }
        }
        return false;
    }
    public boolean hitsBottom(GameObject thisThing, GameObject otherThing){
                //bottom right
        if(otherThing.getXPos()>=thisThing.getXPos()&&otherThing.getXPos()<=(thisThing.getXPos()+thisThing.getWidth())
                //bottom left
        || otherThing.getXPos()<=thisThing.getXPos()&&thisThing.getXPos()<=(otherThing.getXPos()+otherThing.getWidth())){
            if(Math.abs(otherThing.getYPos() - (thisThing.getYPos()+thisThing.getHeight()))<=1){
                return true;
            }
        }
        return false;
    }
    public boolean hitsLeft(GameObject thisThing, GameObject otherThing){
                //left top
        if(otherThing.getYPos()>=thisThing.getYPos()&&otherThing.getYPos()<=(thisThing.getYPos()+thisThing.getHeight())
                //left bottom
        || otherThing.getYPos()<=thisThing.getYPos()&&thisThing.getYPos()<=(otherThing.getYPos()+otherThing.getHeight())){
            if(Math.abs((otherThing.getXPos() + otherThing.getWidth()) -thisThing.getXPos())<=1){
                return true;
            }
        }
        return false;
    }
    public boolean hitsRight(GameObject thisThing, GameObject otherThing){
                //left top
        if(otherThing.getYPos()>=thisThing.getYPos()&&otherThing.getYPos()<=(thisThing.getYPos()+thisThing.getHeight())
                //left bottom
        || otherThing.getYPos()<=thisThing.getYPos()&&thisThing.getYPos()<=(otherThing.getYPos()+otherThing.getHeight())){
            if(Math.abs(otherThing.getXPos() - (thisThing.getXPos() + thisThing.getWidth()))<= 1){
                return true;
            }
        }
        return false;
    }
    public boolean checkAllDir(GameObject thisThing, GameObject otherThing){
        if (hitsTop(thisThing, otherThing))
            return true;
        if (hitsBottom(thisThing, otherThing))
            return true;
        if (hitsLeft(thisThing, otherThing))
            return true;
        if (hitsRight(thisThing, otherThing))
            return true;
        return false;
    }
}
