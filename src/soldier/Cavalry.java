package soldier;
import config.Database;
import visitor.IVisitor;

public class Cavalry extends AbstractSoldier {
    public Cavalry() {
        super("Cavalry", Database.CAVALRY_ATK, Database.CAVALRY_HP, Database.CAVALRY_DEF);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
