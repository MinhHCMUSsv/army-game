package soldier;
import config.Database;

public class Infantry extends AbstractSoldier {
    public Infantry() {
        super("Infantry", Database.INFANTRY_ATK, Database.INFANTRY_HP, Database.INFANTRY_DEF);
    }
}
