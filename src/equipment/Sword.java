package equipment;
import soldier.Soldier;
import config.Database;

public class Sword extends EquipmentDecorator {
    public Sword(Soldier wrappee) {
        super(wrappee);
        System.out.println("-> Equipped with a Sword (ATK +" + Database.SWORD_ATK + ")");
    }

    @Override
    public int hit() {
        return super.hit() + Database.SWORD_ATK;
    }
    
}
