package soldier;
import config.Database;
import visitor.IVisitor;

public class Infantry extends AbstractSoldier {
    public Infantry() {
        super("Infantry", Database.INFANTRY_ATK, Database.INFANTRY_HP, Database.INFANTRY_DEF);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
