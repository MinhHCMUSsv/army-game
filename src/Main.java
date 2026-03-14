import soldier.Soldier;
import soldier.Cavalry;
import soldier.Infantry;
import equipment.Sword;
import equipment.Shield;
import composite.Army;

public class Main {
    public static void main(String[] args) {
        Soldier infantry = new Infantry();
        Soldier cavalry = new Cavalry();

        // Test Soldiers
        int strength = infantry.hit();
        System.out.println(strength);
        cavalry.wardOff(strength);

        // Test Sword
        infantry = new Sword(infantry);
        strength = infantry.hit();
        System.out.println(strength);
        cavalry.wardOff(strength);

        // Test Shield
        cavalry = new Shield(cavalry);
        strength = infantry.hit();
        System.out.println(strength);
        cavalry.wardOff(strength);

        // Test Army
        Army group1 = new Army("Vikings");
        group1.add(infantry);
        group1.add(cavalry);
        group1.hit();
        group1.wardOff(100);

        Army group2 = new Army("Samurai");
        group2.add(new Infantry());
        group2.add(new Cavalry());
        group2.hit();
        group2.wardOff(150);

    }
}
