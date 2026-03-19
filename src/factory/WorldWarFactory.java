package factory;

import proxy.SoldierProxy;

public class WorldWarFactory extends AbstractGenerationFactory {
    @Override
    protected void registerGenerationEquipment(SoldierProxy proxy) {
        registerEquipment(proxy, "rifle", "Rifle", 30, 0);
        registerEquipment(proxy, "grenade", "Grenade", 35, 0);
        registerEquipment(proxy, "helmet", "Helmet", 0, 15);
    }

    @Override
    public String getGenerationName() {
        return "WorldWar";
    }
}
