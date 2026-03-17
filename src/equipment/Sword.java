package equipment;
import soldier.Soldier;
import visitor.IVisitor;
import config.Database;

public class Sword extends EquipmentDecorator {
    private int currentAtkBonus;

    public Sword(Soldier wrappee) {
        super(wrappee);
        this.currentAtkBonus = Database.SWORD_ATK;
        System.out.println("-> Equipped with a Sword (ATK +" + Database.SWORD_ATK + ")");
    }

    @Override
    public int hit() {
        int bonusUsed = currentAtkBonus;
        int totalAttack = super.hit() + bonusUsed;

        int nextBonus = currentAtkBonus - Database.SWORD_ATK_DECAY_PER_USE;
        currentAtkBonus = Math.max(Database.SWORD_ATK_MIN, nextBonus);

        System.out.println("   |_ [SWORD BOOST] Added +" + bonusUsed + " ATK. Total attack now " + totalAttack);
        System.out.println("   |_ [WEAR] Sword degraded, next ATK bonus: +" + currentAtkBonus);
        return totalAttack;
    }
    
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
        super.accept(visitor);
    }
}
