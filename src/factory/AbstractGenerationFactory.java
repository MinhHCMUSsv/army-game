package factory;

import equipment.CustomEquipment;
import proxy.SoldierProxy;
import soldier.Cavalry;
import soldier.Infantry;
import soldier.Soldier;

public abstract class AbstractGenerationFactory implements SoldierGenerationFactory {
    @Override
    public Soldier createInfantry() {
        SoldierProxy proxy = new SoldierProxy(new Infantry(), false);
        registerGenerationEquipment(proxy);
        return proxy;
    }

    @Override
    public Soldier createCavalry() {
        SoldierProxy proxy = new SoldierProxy(new Cavalry(), false);
        registerGenerationEquipment(proxy);
        return proxy;
    }

    protected void registerEquipment(SoldierProxy proxy, String equipmentType, String displayName, int atkBonus, int defBonus) {
        proxy.registerEquipment(equipmentType, soldier -> new CustomEquipment(soldier, displayName, atkBonus, defBonus));
    }

    protected abstract void registerGenerationEquipment(SoldierProxy proxy);
}
