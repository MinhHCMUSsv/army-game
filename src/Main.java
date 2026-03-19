import proxy.SoldierProxy;
import soldier.Cavalry;
import soldier.Infantry;
import composite.Army;
import factory.MedievalFactory;
import factory.ScienceFictionFactory;
import factory.SoldierGenerationFactory;
import factory.WorldWarFactory;
import observer.DeathCountObserver;
import observer.DeathNotifierObserver;
import soldier.Soldier;
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
        countVisitor.printReport();

        // ==========================================
        // PART 3.1: TEST OBSERVER (CONSOLE DEMO)
        // ==========================================
        runObserverConsoleDemo();

        // ==========================================
        // PART 3.2: TEST SINGLETON
        // ==========================================
        runSingletonDemo();

        // ==========================================
        // PART 3.3: TEST ABSTRACT FACTORY
        // ==========================================
        runAbstractFactoryDemo();

        // ==========================================
        // PART 3.2: TEST SINGLETON
        // ==========================================
        runSingletonDemo();
    }

    private static void runObserverConsoleDemo() {
        System.out.println("\n--- Observer Pattern Demo ---");

        DeathCountObserver deathCountObserver = DeathCountObserver.getInstance();
        DeathNotifierObserver deathNotifierObserver = DeathNotifierObserver.getInstance();
        deathCountObserver.reset();
        deathNotifierObserver.reset();

        Army redArmy = new Army("Red Legion");
        redArmy.add(new SoldierProxy(new Infantry()));
        redArmy.add(new SoldierProxy(new Infantry()));
        redArmy.add(new SoldierProxy(new Cavalry()));
        redArmy.addSword();

        Army blueArmy = new Army("Blue Guard");
        blueArmy.add(new SoldierProxy(new Infantry()));
        blueArmy.add(new SoldierProxy(new Cavalry()));
        blueArmy.add(new SoldierProxy(new Cavalry()));
        blueArmy.addShield();

        System.out.println("[Observer Demo] Red Legion members: " + redArmy.getMemberCount());
        System.out.println("[Observer Demo] Blue Guard members: " + blueArmy.getMemberCount());

        int round = 1;
        while (redArmy.getMemberCount() > 0 && blueArmy.getMemberCount() > 0 && round <= 20) {
            System.out.println("\n[Observer Demo] Round " + round);

            int redAtk = redArmy.hit();
            boolean blueAlive = blueArmy.wardOff(redAtk);
            System.out.println("[Observer Demo] Blue Guard alive: " + blueArmy.getMemberCount());
            if (!blueAlive) {
                break;
            }

            int blueAtk = blueArmy.hit();
            boolean redAlive = redArmy.wardOff(blueAtk);
            System.out.println("[Observer Demo] Red Legion alive: " + redArmy.getMemberCount());
            if (!redAlive) {
                break;
            }

            round++;
        }

        String winner;
        if (redArmy.getMemberCount() == 0 && blueArmy.getMemberCount() == 0) {
            winner = "Draw";
        } else if (redArmy.getMemberCount() > 0) {
            winner = "Red Legion";
        } else {
            winner = "Blue Guard";
        }

        System.out.println("[Observer Demo] Winner: " + winner);

        System.out.println("[Observer Demo] Total dead soldiers recorded: " + deathCountObserver.getDeathCount());
    }

    private static void runSingletonDemo() {
        System.out.println("\n--- Singleton Pattern Demo ---");

        DeathCountObserver countObserverA = DeathCountObserver.getInstance();
        DeathCountObserver countObserverB = DeathCountObserver.getInstance();

        DeathNotifierObserver notifierObserverA = DeathNotifierObserver.getInstance();
        DeathNotifierObserver notifierObserverB = DeathNotifierObserver.getInstance();

        System.out.println("[Singleton] DeathCountObserver single instance: " + (countObserverA == countObserverB));
        System.out.println("[Singleton] DeathNotifierObserver single instance: " + (notifierObserverA == notifierObserverB));

        System.out.println("[Singleton] Meaning: death counting and death notification stay globally consistent in one battle.");
    }

    private static void runAbstractFactoryDemo() {
        System.out.println("\n--- Abstract Factory Demo ---");

        SoldierGenerationFactory medievalFactory = new MedievalFactory();
        SoldierGenerationFactory worldWarFactory = new WorldWarFactory();
        SoldierGenerationFactory scienceFictionFactory = new ScienceFictionFactory();

        Soldier medievalInfantry = medievalFactory.createInfantry();
        Soldier worldWarCavalry = worldWarFactory.createCavalry();
        Soldier sciFiInfantry = scienceFictionFactory.createInfantry();

        System.out.println("[Factory] Created " + medievalFactory.getGenerationName() + " infantry.");
        medievalInfantry.addEquipment("sword");
        medievalInfantry.addEquipment("armor");

        System.out.println("[Factory] Created " + worldWarFactory.getGenerationName() + " cavalry.");
        worldWarCavalry.addEquipment("rifle");
        worldWarCavalry.addEquipment("helmet");

        System.out.println("[Factory] Created " + scienceFictionFactory.getGenerationName() + " infantry.");
        sciFiInfantry.addEquipment("laser_sword");
        sciFiInfantry.addEquipment("nano_armor");

        System.out.println("[Factory] Cross-generation constraint checks:");
        medievalInfantry.addEquipment("laser_sword");
        worldWarCavalry.addEquipment("spear");
        sciFiInfantry.addEquipment("rifle");
    }
}
