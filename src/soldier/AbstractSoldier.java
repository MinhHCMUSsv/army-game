package soldier;

public class AbstractSoldier implements Soldier {
    protected String type;
    protected int atk;  
    protected int hp;
    protected int def;

    public AbstractSoldier(String type, int atk, int hp, int def) {
        this.type = type;
        this.atk = atk;
        this.hp = hp;
        this.def = def;
    }

    @Override
    public int hit() {
        System.out.print(type + " hit the enemy ");
        return atk;
    }

    @Override
    public boolean wardOff(int strength) {
        int damage = strength - def;
        if (damage <= 0) {
            System.out.println(type + " ward off the attack");
            return true;
        } else {
            hp -= damage;
            System.out.println(type + " receive " + damage + " damage, hp left: " + hp);
            return this.hp > 0;
        }
    }

    @Override
    public void addShield() {
        addEquipment("shield");
    }

    @Override
    public void addSword() {
        addEquipment("sword");
    }

    @Override
    public void addEquipment(String equipmentType) {
        System.out.println("INFO: " + type + " cannot equip " + equipmentType + " directly. Use SoldierProxy.");
    }
}
