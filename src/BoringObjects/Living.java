package BoringObjects;

public class Living {
//Status
    private int HP, MP;
    public Living(int hp, int mp){
        HP = hp;
        MP = mp;
    }
//CHANGING STATUS
    public void setHP(int hp) { HP = hp; }
    public void setMP(int mp) { MP = mp; }
//ACCESSING STATUS
    public int getHP() { return HP; }
    public int getMP() { return MP; }
//PRINTING
    @Override
    public String toString() {
        return "Living{" +
                "HP=" + HP +
                ", MP=" + MP +
                '}';
    }
}
