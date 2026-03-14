import proxy.SoldierProxy;
import soldier.Cavalry;
import soldier.Infantry;

public class Main {
    public static void main(String[] args) {
        SoldierProxy infantry = new SoldierProxy(new Infantry());
        SoldierProxy cavalry = new SoldierProxy(new Cavalry());

        System.out.println("=== Round 0: no equipment ===");
        int strength = infantry.hit();
        System.out.println("Attack power: " + strength);
        cavalry.wardOff(strength);

        System.out.println("\n=== Equip equipment via Proxy ===");
        infantry.addSword();
        infantry.addSword();
        cavalry.addShield();
        cavalry.addShield();

        System.out.println("\n=== Wear-and-tear simulation (5 rounds) ===");
        for (int round = 1; round <= 5; round++) {
            System.out.println("\nRound " + round + ":");
            strength = infantry.hit();
            System.out.println("Attack power: " + strength);
            boolean cavalryAlive = cavalry.wardOff(strength);

            if (!cavalryAlive) {
                System.out.println("Cavalry is defeated. Battle ends at round " + round + ".");
                break;
            }
        }
    }
}
