package BoringObjects;

public abstract class BreakObject extends GameObject {
    private Colliding c = new Colliding();
    private Living l;
    public BreakObject (int x, int y, int wd, int ht, int hp, int mp) {
        super(x, y, wd, ht);
        l = new Living(hp, mp);
    }
    //check colliding
    public boolean checkAllDir(GameObject other){ return c.checkAllDir(this,other);}
    //set and get living
    public void setHP(int hp) { l.setHP(hp); }
    public void setMP(int mp) { l.setMP(mp); }
    public int getHP() { return l.getHP(); }
    public int getMP() { return l.getMP(); }
    @Override
    public String toString() {
        return "BreakObject{" + "\n" +
                "g=" + super.toString() + "\n" +
                ", l=" + l + "\n" +
                '}';
    }
}