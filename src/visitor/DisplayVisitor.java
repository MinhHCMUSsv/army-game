package visitor;
import composite.Army;
import equipment.Shield;
import equipment.Sword;
import proxy.SoldierProxy;
import soldier.Cavalry;
import soldier.Infantry;

public class DisplayVisitor implements IVisitor {
    private StringBuilder indent = new StringBuilder();

    @Override
    public void visit(Army army) {
        System.out.println(indent.toString() + "- Army Group (Composite)");
        indent.append("    "); 
    }

    @Override
    public void visitEnd(Army army) {
        if (indent.length() >= 4) {
            indent.setLength(indent.length() - 4);
        }
    }

    @Override
    public void visit(SoldierProxy proxy) {
        System.out.println(indent.toString() + "* Soldier Unit:");
    }

    @Override
    public void visit(Shield shield) {
        System.out.println(indent.toString() + "   + Equipment: Shield");
    }

    @Override
    public void visit(Sword sword) {
        System.out.println(indent.toString() + "   + Equipment: Sword");
    }

    @Override
    public void visit(Infantry infantry) {
        System.out.println(indent.toString() + "   + Base: Infantry");
    }

    @Override
    public void visit(Cavalry cavalry) {
        System.out.println(indent.toString() + "   + Base: Cavalry");
    }
}