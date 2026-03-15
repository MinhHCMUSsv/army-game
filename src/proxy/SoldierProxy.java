package proxy;

import equipment.Shield;
import equipment.Sword;
import soldier.Soldier;
import visitor.IVisitor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class SoldierProxy implements Soldier
{
    private Soldier realSoldier;
    private final Set<String> equippedTypes;
    private final Map<String, Function<Soldier, Soldier>> equipmentFactories;

    public SoldierProxy(Soldier soldier)
    {
        this.realSoldier = soldier;
        this.equippedTypes = new HashSet<>();
        this.equipmentFactories = new HashMap<>();

        registerEquipment("sword", Sword::new);
        registerEquipment("shield", Shield::new);
    }

    @Override
    public int hit()
    {
        return realSoldier.hit();
    }

    @Override
    public boolean wardOff(int strength)
    {
        return realSoldier.wardOff(strength);
    }

    @Override
    public void addShield()
    {
        addEquipment("shield");
    }

    @Override
    public void addSword()
    {
        addEquipment("sword");
    }

    @Override
    public void addEquipment(String equipmentType)
    {
        String normalizedType = normalizeEquipmentType(equipmentType);
        Function<Soldier, Soldier> decoratorFactory = equipmentFactories.get(normalizedType);

        if (decoratorFactory == null)
        {
            System.out.println("FAIL: Equipment '" + equipmentType + "' is not registered.");
            return;
        }

        if (equippedTypes.contains(normalizedType))
        {
            System.out.println("WARNING: Soldier already has equipment '" + normalizedType + "'.");
            return;
        }

        realSoldier = decoratorFactory.apply(realSoldier);
        equippedTypes.add(normalizedType);
        System.out.println("SUCCESS: Equipped '" + normalizedType + "' to soldier.");
    }

    public void registerEquipment(String equipmentType, Function<Soldier, Soldier> decoratorFactory)
    {
        if (equipmentType == null || equipmentType.trim().isEmpty())
        {
            throw new IllegalArgumentException("equipmentType must not be empty");
        }
        if (decoratorFactory == null)
        {
            throw new IllegalArgumentException("decoratorFactory must not be null");
        }

        String normalizedType = normalizeEquipmentType(equipmentType);
        equipmentFactories.put(normalizedType, decoratorFactory);
    }

    private String normalizeEquipmentType(String equipmentType)
    {
        if (equipmentType == null)
        {
            return "";
        }
        return equipmentType.trim().toLowerCase(Locale.ROOT);
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
        realSoldier.accept(visitor); // Đi xuyên qua Proxy
    }

}
