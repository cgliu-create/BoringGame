package BoringObjects;

public class Living {
    //instance variables
    private int HP;
    private int MP;
    public Living(){
        HP = MP = 0;
    }
    public Living(int hp, int mp){
        HP = hp;
        MP = mp;
    }
    //set and get methods
    public void setHP(int hp) { HP = hp; }
    public void setMP(int mp) { MP = mp; }
    public int getHP() { return HP; }
    public int getMP() { return MP; }
    //toString
    @Override
    public String toString() {
        return "Living{" +
                "HP=" + HP +
                ", MP=" + MP +
                '}';
    }
}
