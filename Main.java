package projekat;

public class Main {

    public static void main(String[] args) {

        Player player = new Player(
                10, 5, 32, 32, "Petar Petrovic", 85
        );

        Game game = new Game(player);

        Enemy enemy1 = new MeleeEnemy(
                10, 5, 16, 16, "Orc", 20, 60
        );

        game.addEnemy(enemy1);

        Enemy enemy2 = new BossEnemy(
                12, 5, 16, 16, "Goblin", 20, 100
        );

        game.addEnemy(enemy2);

        System.out.println("Svi neprijatelji:");

        for (Enemy e : game.getEnemies()) {
            System.out.println(e);
        }

        System.out.println("Pretraga za gob:");

        for (Enemy e : game.findByType("gob")) {
            System.out.println(e);
        }

        System.out.println("Neprijatelji koji se sudaraju:");

        for (Enemy e : game.collidingWithPlayer()) {
            System.out.println(e);
        }

        System.out.println("Prije sudara:");
        System.out.println(player);

        game.resolveCollision();

        System.out.println("Poslije sudara:");
        System.out.println(player);

        System.out.println("Dnevnik dogadjaja:");

        for (String event : game.getEventLog()) {
            System.out.println(event);
        }
    }
}
