package projekat;

public class MeleeEnemy extends Enemy {

    public MeleeEnemy(int x, int y, int width, int height,
                      String type, int damage, int health) {
        super(x, y, width, height, type, damage, health);
    }

    @Override
    public int getAttackDamage() {
        return getDamage();
    }

    @Override
    public String toString() {
        return "Melee" + super.toString();
    }
}
