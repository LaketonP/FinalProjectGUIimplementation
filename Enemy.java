public class Enemy extends GameElement {
    public Enemy(Coordinate start) {
        super(ElementType.ENEMY, true, start);
    }
    // track player
    public Coordinate trackPlayer(Player player) {
        int dx = Integer.compare(player.getPosition().getX(), getPosition().getX());
        int dy = Integer.compare(player.getPosition().getY(), getPosition().getY());
        return new Coordinate(getPosition().getX() + dx, getPosition().getY() + dy);
    }
    // test enemy tracking player
    public static class EnemyTest {
        @org.junit.jupiter.api.Test
        public void testEnemyTrackingPlayer() {
            Player player = new Player(new Coordinate(4, 4));
            Enemy enemy = new Enemy(new Coordinate(2, 2));
            Coordinate newEnemyPos = enemy.trackPlayer(player);
            // assert that newEnemyPos is within 1 unit of player's position
            org.junit.jupiter.api.Assertions.assertNotNull(newEnemyPos);
            org.junit.jupiter.api.Assertions.assertTrue(
                Math.abs(newEnemyPos.getX() - 2) <= 1 &&
                Math.abs(newEnemyPos.getY() - 2) <= 1
            );
        }
    }
}
