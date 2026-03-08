package soldier;
import config.Database;

public class Cavalry extends AbstractSoldier {
    public Cavalry() {
        super("Cavalry", Database.CAVALRY_ATK, Database.CAVALRY_HP, Database.CAVALRY_DEF);
    }
}
