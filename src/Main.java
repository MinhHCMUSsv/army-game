import soldier.Soldier;
import soldier.Cavalry;
import soldier.Infantry;
import equipment.Sword;
import equipment.Shield;

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
    }
}
