package BoringObjects;

public abstract class CollisObject extends GameObject {
    private Colliding c = new Colliding();
    public CollisObject  (int x, int y, int wd, int ht) {
        super(x, y, wd, ht);
    }
    //check colliding
    public boolean checkAllDir(GameObject other){ return c.checkAllDir(this,other);}
    @Override
    public String toString() {
        return "CollisObject {" + "\n" +
                "g=" + super.toString() + "\n" +
                '}';
    }
}