public class Player extends GameElement {
    public Player(Coordinate start) {
        super(ElementType.PLAYER, false, start);
    }
    // move player
    public void moveTo(Coordinate newCoord) {
        setPosition(newCoord);
    }
    // test player movement
    public static class PlayerTest {
        @org.junit.jupiter.api.Test
        public void testPlayerMovement() {
            Coordinate start = new Coordinate(0, 0);
            Player player = new Player(start);
            org.junit.jupiter.api.Assertions.assertEquals(start, player.getPosition());
            // move player to new coordinate and test
            Coordinate newPos = new Coordinate(1, 1);
            player.moveTo(newPos);
            org.junit.jupiter.api.Assertions.assertEquals(1, player.getPosition().getX());
            org.junit.jupiter.api.Assertions.assertEquals(1, player.getPosition().getY());
        }
    }
}
