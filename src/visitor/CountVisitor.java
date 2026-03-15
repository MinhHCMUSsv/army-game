package visitor;

import composite.Army;
import equipment.Shield;
import equipment.Sword;
import proxy.SoldierProxy;
import soldier.Cavalry;
import soldier.Infantry;

public class CountVisitor implements IVisitor {
    private int infantryCount = 0;
    private int cavalryCount = 0;

    public int getInfantryCount() { return infantryCount; }
    public int getCavalryCount() { return cavalryCount; }

    @Override public void visit(Army army) { /* Do not count Army */ }
    
    @Override 
    public void visit(Infantry infantry) { 
        infantryCount++; 
    }
    
    @Override 
    public void visit(Cavalry cavalry) { 
        cavalryCount++; 
    }
    
    @Override public void visit(Shield shield) { /* Do not count shield */ }
    @Override public void visit(Sword sword) { /* Do not count sword */ }
    @Override public void visit(SoldierProxy proxy) { /* Do not count proxy */ }
    
    public void printReport() {
        System.out.println("--- UNIT COUNT REPORT ---");
        System.out.println("Infantry: " + infantryCount);
        System.out.println("Cavalry: " + cavalryCount);
        System.out.println("Total: " + (infantryCount + cavalryCount));
    }
}