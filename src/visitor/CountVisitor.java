package visitor;

import soldier.Cavalry;
import soldier.Infantry;

public class CountVisitor implements IVisitor {
    private int infantryCount = 0;
    private int cavalryCount = 0;

    public int getInfantryCount() { return infantryCount; }
    public int getCavalryCount() { return cavalryCount; }
    
    @Override 
    public void visit(Infantry infantry) { 
        infantryCount++; 
    }
    
    @Override 
    public void visit(Cavalry cavalry) { 
        cavalryCount++; 
    }

    public void printReport() {
        System.out.println("--- UNIT COUNT REPORT ---");
        System.out.println("Infantry: " + infantryCount);
        System.out.println("Cavalry: " + cavalryCount);
        System.out.println("Total: " + (infantryCount + cavalryCount));
    }
}