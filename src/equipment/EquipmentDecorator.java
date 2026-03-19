package equipment;
import soldier.Soldier;
import visitor.IVisitor;

public abstract class EquipmentDecorator implements Soldier {
    protected Soldier wrappee;

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

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
        wrappee.accept(visitor);
    }

    public abstract String getEquipmentName();
}
