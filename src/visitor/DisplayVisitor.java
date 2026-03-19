package visitor;
import composite.Army;
import equipment.EquipmentDecorator;
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
    public void visit(Infantry infantry) {
        System.out.println(indent.toString() + "   + Name: " + infantry.getName());
        System.out.println(indent.toString() + "   + Base: Infantry");
    }

    @Override
    public void visit(Cavalry cavalry) {
        System.out.println(indent.toString() + "   + Name: " + cavalry.getName());
        System.out.println(indent.toString() + "   + Base: Cavalry");
    }

    @Override
    public void visit(EquipmentDecorator equipment) {
        System.out.println(indent.toString() + "   + Equipment: " + equipment.getEquipmentName());
    }
}