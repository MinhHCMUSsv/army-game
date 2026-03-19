package factory;

import proxy.SoldierProxy;

public class MedievalFactory extends AbstractGenerationFactory {
    @Override
    protected void registerGenerationEquipment(SoldierProxy proxy) {
        registerEquipment(proxy, "sword", "Medieval Sword", 25, 0);
        registerEquipment(proxy, "spear", "Spear", 20, 0);
        registerEquipment(proxy, "armor", "Armor", 0, 20);
    }

    @Override
    public String getGenerationName() {
        return "Medieval";
    }
}
