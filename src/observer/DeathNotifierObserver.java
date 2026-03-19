package observer;

import java.util.ArrayList;
import java.util.List;

public class DeathNotifierObserver {
    private static final DeathNotifierObserver INSTANCE = new DeathNotifierObserver();
    private final List<String> logs;

    private DeathNotifierObserver() {
        this.logs = new ArrayList<>();
    }

    public static DeathNotifierObserver getInstance() {
        return INSTANCE;
    }

    public void onSoldierDeath(String soldierName, String soldierType) {
        String deathMessage = String.format(
            "[DeathNotifierObserver] Soldier %s (%s) has fallen.",
            soldierName,
            soldierType
        );
        String emailMessage = String.format(
            "[DeathNotifierObserver] Sending apology email to friends of %s...",
            soldierName
        );

        System.out.println(deathMessage);
        System.out.println(emailMessage);
        logs.add(deathMessage);
        logs.add(emailMessage);
    }

    public void reset() {
        logs.clear();
    }

    public List<String> drainLogs() {
        List<String> snapshot = new ArrayList<>(logs);
        logs.clear();
        return snapshot;
    }
}
