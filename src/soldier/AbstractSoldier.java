package soldier;

import observer.DeathCountObserver;
import observer.DeathNotifierObserver;

public abstract class AbstractSoldier implements Soldier {
    protected String name;
    protected String type;
    protected int atk;  
    protected int hp;
    protected int def;
    private boolean deathNotified;

    public AbstractSoldier(String type, int atk, int hp, int def) {
        this.name = type + "_" + System.currentTimeMillis();
        this.type = type;
        this.atk = atk;
        this.hp = hp;
        this.def = def;
        this.deathNotified = false;
    }

    @Override
    public int hit() {
        System.out.println(String.format("[ATTACK] %s (%s) hits the enemy for %d damage.", name, type, atk));
        return atk;
    }

    @Override
    public boolean wardOff(int strength) {
        int damage = strength - def;
        if (damage <= 0) {
            System.out.println(String.format("[DEFEND] %s (%s) completely warded off the attack! (Strength: %d)", name, type, strength));
            return true;
        } else {
            hp -= damage;
            System.out.println(String.format("[DAMAGE] %s (%s) received %d damage (Strength: %d). HP left: %d", name, type, damage, strength, hp));

            if (hp <= 0 && !deathNotified) {
                deathNotified = true;
                DeathCountObserver.getInstance().onSoldierDeath(name);
                DeathNotifierObserver.getInstance().onSoldierDeath(name, type);
            }

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
