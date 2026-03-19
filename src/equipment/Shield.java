package equipment;
import soldier.Soldier;
import config.Database;

public class Shield extends EquipmentDecorator {
    private int currentDefBonus;

    public Shield(Soldier wrappee) {
        super(wrappee);
        this.currentDefBonus = Database.SHIELD_DEF;
        System.out.println("-> Equipped with a Shield (DEF +" + Database.SHIELD_DEF + ")");
    }

    @Override
    public boolean wardOff(int strength) {
        int bonusUsed = currentDefBonus;
        boolean survived = super.wardOff(strength - bonusUsed);

        int nextBonus = currentDefBonus - Database.SHIELD_DEF_DECAY_PER_USE;
        currentDefBonus = Math.max(Database.SHIELD_DEF_MIN, nextBonus);

        System.out.println("   |_ [SHIELD BLOCKED] Reduced strength by " + bonusUsed + ". Effective strength now " + (strength - bonusUsed));
        System.out.println("   |_ [WEAR] Shield degraded, next DEF bonus: +" + currentDefBonus);
        return survived;
    }
    
    @Override
    public String getEquipmentName() {
        return "Shield";
    }
}
