package composite;
import soldier.Soldier;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import visitor.IVisitor;

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
    public int getMemberCount() {
        int count = 0;
        for (Soldier soldier : soldiers) {
            count += soldier.getMemberCount();
        }
        return count;
    }

    @Override
    public int hit() {
        int totalDamage = 0;
        for (Soldier soldier : soldiers) {
            totalDamage += soldier.hit();
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

        int totalMembers = this.getMemberCount();
        System.out.println("Army [" + name + "] takes " + strength + " damage. Distributing to " + totalMembers + " members.");
        int baseDamage = strength / totalMembers;
        int remainder = strength % totalMembers;

        Iterator<Soldier> iterator = soldiers.iterator();
        while (iterator.hasNext()) {
            Soldier child = iterator.next();
            int childMembers = child.getMemberCount();

            int damageForChild = baseDamage * childMembers;

            if (remainder > 0) {
                int chunk = Math.min(remainder, childMembers);
                damageForChild += chunk;
                remainder -= chunk;
            }

            boolean isAlive = child.wardOff(damageForChild);
            
            if (!isAlive) {
                iterator.remove();
            }
        }

        return !soldiers.isEmpty();
    }

    @Override
    public void addShield() {
        for (Soldier soldier : soldiers) {
            soldier.addShield();
        }
    }

    @Override
    public void addSword() {
        for (Soldier soldier : soldiers) {
            soldier.addSword();
        }
    }

    @Override
    public void addEquipment(String equipmentType) {
        for (Soldier soldier : soldiers) {
            soldier.addEquipment(equipmentType);
        }
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this); // Cho phép Visitor xử lý Army
        for (Soldier soldier : soldiers) {
            soldier.accept(visitor); // Duyệt qua từng lính con
        }
    }
}
