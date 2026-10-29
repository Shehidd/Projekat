package projekat;

import java.util.ArrayList;

public class Game {

    private Player player;
    private ArrayList<Enemy> enemies;
    private ArrayList<String> eventLog;

    public Game(Player player) {
        this.player = player;
        enemies = new ArrayList<>();
        eventLog = new ArrayList<>();
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public ArrayList<String> getEventLog() {
        return eventLog;
    }

    public boolean checkCollision(Player p, Enemy e) {
        return p.intersects(e);
    }

    public void decreaseHealth(Player p, Enemy e) {
        int oldHealth = p.getHealth();
        int damage = e.getAttackDamage();

        int newHealth = Math.max(0, oldHealth - damage);
        p.setHealth(newHealth);

        eventLog.add("Player hit by " + e.getType()
                + " for " + damage
                + " > HP " + oldHealth
                + " > " + newHealth);
    }

    public void addEnemy(Enemy e) {
        enemies.add(e);
        eventLog.add("Added enemy: " + e.getType());
    }

    public ArrayList<Enemy> findByType(String query) {
        ArrayList<Enemy> result = new ArrayList<>();

        for (Enemy e : enemies) {
            if (e.getType().toLowerCase().contains(query.toLowerCase())) {
                result.add(e);
            }
        }

        return result;
    }

    public ArrayList<Enemy> collidingWithPlayer() {
        ArrayList<Enemy> result = new ArrayList<>();

        for (Enemy e : enemies) {
            if (checkCollision(player, e)) {
                result.add(e);
            }
        }

        return result;
    }

    public void resolveCollision() {
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) {
                decreaseHealth(player, e);
            }
        }
    }
}
