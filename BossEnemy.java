package projekat;

public class BossEnemy extends Enemy {

    public BossEnemy(int x, int y, int width, int height,
                     String type, int damage, int health) {
        super(x, y, width, height, type, damage, health);
    }

    @Override
    public int getAttackDamage() {
        return getDamage() * 2;
    }

    @Override
    public String toString() {
        return "Boss" + super.toString();
    }
}
