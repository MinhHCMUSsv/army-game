package factory;

import soldier.Soldier;

public interface SoldierGenerationFactory {
    Soldier createInfantry();
    Soldier createCavalry();
    String getGenerationName();
}
