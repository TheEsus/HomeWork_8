package Weapon;

public class Weapons {

    public String title;
    public int cost;
    public int quantity;

    public Weapons(String title, int cost, int quantity){
        this.title = title;
        this.cost = cost;
        this.quantity = quantity;
    }

    public String getTitle(){return title;}
    public int getCost(){return cost;}
    public int getQuantity() {return quantity;}
}
