package composite;
import soldier.Soldier;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Army implements Soldier {
    private String name;
    private List<Soldier> soldiers = new ArrayList<>();

    public Army(String name) {
        this.name = name;
    }

    public void add(Soldier soldier) {
        soldiers.add(soldier);
    }

    public void remove(Soldier soldier) {
        soldiers.remove(soldier);
    }

    @Override
    public int hit() {
        int totalDamage = 0;
        for (Soldier soldier : soldiers) {
            totalDamage += soldier.hit();
            System.out.println("");
        }
        System.out.println("Army [" + name + "] deals total damage: " + totalDamage);
        return totalDamage;
    }

    @Override
    public boolean wardOff(int strength) {
        if (soldiers.isEmpty()) {
            System.out.println("Army [" + name + "] is already wiped out!");
            return false; 
        }

        int damagePerSoldier = strength / soldiers.size();
        System.out.println("Army [" + name + "] takes " + strength + " damage. Each of " + soldiers.size() + " members takes " + damagePerSoldier);

        Iterator<Soldier> iterator = soldiers.iterator();
        while (iterator.hasNext()) {
            Soldier soldier = iterator.next();
            boolean isAlive = soldier.wardOff(damagePerSoldier);
            
            if (!isAlive) {
                iterator.remove();
            }
        }

        return !soldiers.isEmpty();
    }
}
