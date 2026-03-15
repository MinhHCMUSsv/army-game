import proxy.SoldierProxy;
import soldier.Cavalry;
import soldier.Infantry;
import composite.Army;
import visitor.CountVisitor;
import visitor.DisplayVisitor;

public class Main {
    public static void main(String[] args) {
        // ==========================================
        // PART 1: TEST PROXY & DECORATOR
        // ==========================================
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

        System.out.println("\n==========================================");

        // ==========================================
        // PART 2.1: TEST COMPOSITE
        // ==========================================
        Army group1 = new Army("Vikings");
        group1.add(new SoldierProxy(new Infantry()));
        group1.add(new SoldierProxy(new Infantry()));
        group1.add(new SoldierProxy(new Cavalry()));
        System.out.println("\n--- Vikings Action ---");
        group1.hit();
        group1.wardOff(100);

        Army group2 = new Army("Samurai");
        group2.add(new SoldierProxy(new Infantry()));
        group2.add(new SoldierProxy(new Cavalry()));
        System.out.println("\n--- Samurai Action ---");
        group2.hit();
        group2.wardOff(150);

        Army army = new Army("Special Forces");
        army.add(group1);
        army.add(group2);

        System.out.println("\n--- Special Forces Mass Equip ---");
        army.addShield();
        army.addSword();

        System.out.println("\n--- Special Forces Action ---");
        army.hit();
        army.wardOff(300);

        // ==========================================
        // PART 2.2: TEST VISITOR
        // ==========================================
        System.out.println("\n--- Displaying Special Forces Structure ---");
        DisplayVisitor displayVisitor = new DisplayVisitor();
        army.accept(displayVisitor);

        System.out.println("\n--- Counting Special Forces Members ---");
        CountVisitor countVisitor = new CountVisitor();
        army.accept(countVisitor);
    }
}
