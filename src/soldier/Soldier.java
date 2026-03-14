package soldier;

public interface Soldier {
    int hit();
    boolean wardOff(int strength);
    void addShield();
    void addSword();
    void addEquipment(String equipmentType);
}
