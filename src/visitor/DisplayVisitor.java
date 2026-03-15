package visitor;
import composite.Army;
import equipment.Shield;
import equipment.Sword;
import proxy.SoldierProxy;
import soldier.Cavalry;
import soldier.Infantry;

public class DisplayVisitor implements IVisitor {
    private String indent = "";

    @Override
    public void visit(Army army) {
        System.out.println(indent + "Army / Group (Army composite)");
        indent += "    "; 
    }

    @Override
    public void visit(SoldierProxy proxy) {
        System.out.println(indent + "Soldier (Proxy):"); //English please
        indent += "  ";
    }

    @Override
    public void visit(Shield shield) {
        System.out.println(indent + "Equipment: Shield");
    }

    @Override
    public void visit(Sword sword) {
        System.out.println(indent + "Equipment: Sword");
    }

    @Override
    public void visit(Infantry infantry) {
        System.out.println(indent + "Soldier: Infantry");
        indent = indent.substring(0, Math.max(0, indent.length() - 2));
    }

    @Override
    public void visit(Cavalry cavalry) {
        System.out.println(indent + "Soldier: Cavalry");
        indent = indent.substring(0, Math.max(0, indent.length() - 2));
    }
}