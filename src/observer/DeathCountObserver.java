package observer;

import java.util.ArrayList;
import java.util.List;

public class DeathCountObserver {
    private static final DeathCountObserver INSTANCE = new DeathCountObserver();
    private int deathCount;
    private final List<String> logs;

    private DeathCountObserver() {
        this.deathCount = 0;
        this.logs = new ArrayList<>();
    }

    public static DeathCountObserver getInstance() {
        return INSTANCE;
    }

    public void reset() {
        this.deathCount = 0;
        this.logs.clear();
    }

    public int getDeathCount() {
        return deathCount;
    }

    public void onSoldierDeath(String soldierName) {
        deathCount++;
        String message = String.format(
            "[DeathCountObserver] Total dead soldiers: %d (latest: %s)",
            deathCount,
            soldierName
        );
        System.out.println(message);
        logs.add(message);
    }

    public List<String> drainLogs() {
        List<String> snapshot = new ArrayList<>(logs);
        logs.clear();
        return snapshot;
    }
}
