package equipment;

import soldier.Soldier;

public class CustomEquipment extends EquipmentDecorator {
    private final String equipmentName;
    private final int atkBonus;
    private final int defBonus;

    public CustomEquipment(Soldier wrappee, String equipmentName, int atkBonus, int defBonus) {
        super(wrappee);
        this.equipmentName = equipmentName;
        this.atkBonus = atkBonus;
        this.defBonus = defBonus;
        System.out.println("-> Equipped with " + equipmentName + " (ATK +" + atkBonus + ", DEF +" + defBonus + ")");
    }

    @Override
    public int hit() {
        int baseAttack = super.hit();
        int totalAttack = baseAttack + atkBonus;
        if (atkBonus > 0) {
            System.out.println("   |_ [" + equipmentName.toUpperCase() + " BOOST] Added +" + atkBonus + " ATK. Total attack now " + totalAttack);
        }
        return totalAttack;
    }

    @Override
    public boolean wardOff(int strength) {
        int effectiveStrength = strength - defBonus;
        if (defBonus > 0) {
            System.out.println("   |_ [" + equipmentName.toUpperCase() + " BLOCK] Reduced strength by " + defBonus + ". Effective strength now " + effectiveStrength);
        }
        return super.wardOff(effectiveStrength);
    }

    @Override
    public String getEquipmentName() {
        return this.equipmentName;
    }
}
