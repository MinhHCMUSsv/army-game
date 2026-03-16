package visitor;

import composite.Army;
import equipment.Shield;
import equipment.Sword;
import proxy.SoldierProxy;
import soldier.Cavalry;
import soldier.Infantry;

public interface IVisitor {
    void visit(Army army);
    void visit(Infantry infantry);
    void visit(Cavalry cavalry);
    void visit(Shield shield);
    void visit(Sword sword);
    void visit(SoldierProxy proxy);
    void visitEnd(Army army);
}
