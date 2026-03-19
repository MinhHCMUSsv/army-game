package factory;

import proxy.SoldierProxy;

public class ScienceFictionFactory extends AbstractGenerationFactory {
    @Override
    protected void registerGenerationEquipment(SoldierProxy proxy) {
        registerEquipment(proxy, "laser_sword", "Laser Sword", 40, 0);
        registerEquipment(proxy, "bio_weapon", "Bio Weapon", 45, 0);
        registerEquipment(proxy, "nano_armor", "Nano Armor", 0, 30);
    }

    @Override
    public String getGenerationName() {
        return "ScienceFiction";
    }
}
