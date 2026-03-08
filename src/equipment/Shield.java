package equipment;
import soldier.Soldier;
import config.Database;

public class Shield extends EquipmentDecorator {
    public Shield(Soldier wrappee) {
        super(wrappee);
        System.out.println("-> Equipped with a Shield (DEF +" + Database.SHIELD_DEF + ")");
    }

    @Override
    public boolean wardOff(int strength) {
        return super.wardOff(strength - Database.SHIELD_DEF);
    }
    
}
