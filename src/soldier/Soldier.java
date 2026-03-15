package soldier;
import visitor.IVisitor;

public interface Soldier {
    int hit();
    boolean wardOff(int strength);
    void addShield();
    void addSword();
    void addEquipment(String equipmentType);
    void accept(IVisitor visitor);
    default int getMemberCount() {
        return 1; 
    }
}
