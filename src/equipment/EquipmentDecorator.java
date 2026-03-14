package equipment;
import soldier.Soldier;

public abstract class EquipmentDecorator implements Soldier {
    Soldier wrappee;

    public EquipmentDecorator(Soldier wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public int hit() {
        return wrappee.hit();
    }

    @Override
    public boolean wardOff(int strength) {
        return wrappee.wardOff(strength);
    }

    @Override
    public void addShield() {
        wrappee.addShield();
    }

    @Override
    public void addSword() {
        wrappee.addSword();
    }

    @Override
    public void addEquipment(String equipmentType) {
        wrappee.addEquipment(equipmentType);
    }
}
