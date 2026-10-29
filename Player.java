package projekat;


public class Player extends GameObject {

    private String name;
    private int health;

    public Player(int x, int y, int width, int height,
                  String name, int health) {
        super(x, y, width, height);
        setName(name);
        setHealth(health);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "Ime igraca ne smije biti prazno."
            );
        }

        String[] words = name.trim().toLowerCase()
                             .split("\\s+");

        StringBuilder formattedName = new StringBuilder();

        for (String word : words) {
            formattedName.append(
                Character.toUpperCase(word.charAt(0))
            );
            formattedName.append(word.substring(1));
            formattedName.append(" ");
        }

        this.name = formattedName.toString().trim();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0 || health > 100) {
            throw new IllegalArgumentException(
                "Health mora biti izmedju 0 i 100."
            );
        }
        this.health = health;
    }

    @Override
    public String toString() {
        return "Player[" + name + "] @ ("
                + getX() + "," + getY() + ") "
                + getWidth() + "x" + getHeight()
                + " HP=" + health;
    }
}
