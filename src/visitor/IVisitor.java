package visitor;

import composite.Army;
import equipment.EquipmentDecorator;
import proxy.SoldierProxy;
import soldier.Cavalry;
import soldier.Infantry;

public interface IVisitor {
    default void visit(Army army) {}
    default void visit(Infantry infantry) {}
    default void visit(Cavalry cavalry) {}
    default void visit(SoldierProxy proxy) {}
    default void visit(EquipmentDecorator equipment) {}
    default void visitEnd(Army army) {}
}
