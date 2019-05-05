/**
 * Created by sam on 1/27/18.
 */
public class Pokemon {
    private String name;
    private String type;
    private double weight;
    private double height;
    private boolean isGuy;
    private double health;
    private double maxHealth;
    private double combatPower;

    public Pokemon(String name, String type, double weight,double height,boolean isGuy, double health, double maxHealth, double combatPower){
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.height = height;
        this.isGuy = isGuy;
        this.health = health;
        this.maxHealth = maxHealth;
        this.combatPower = combatPower;
    }
}
