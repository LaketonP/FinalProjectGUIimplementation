public class GameElement {
    private ElementType type;
    private boolean solid;
    private Coordinate position;
    // constructor
    public GameElement(ElementType type, boolean solid, Coordinate position) {
        this.type = type;
        this.solid = solid;
        this.position = position;
    }
    // getters
    public ElementType getType() { return type; }
    public boolean isSolid() { return solid; }
    public Coordinate getPosition() { return position; }
    public void setPosition(Coordinate c) { this.position = c; }
    // equals method
    public static class GameElementTest {
        @org.junit.jupiter.api.Test
        public void testTypeAndSolid() {
            Coordinate pos = new Coordinate(1, 1);
            GameElement element = new GameElement(ElementType.WALL, true, pos);
            org.junit.jupiter.api.Assertions.assertEquals(ElementType.WALL, element.getType());
            org.junit.jupiter.api.Assertions.assertTrue(element.isSolid());
        }
        // test position
        @org.junit.jupiter.api.Test
        public void testPosition() {
            Coordinate pos = new Coordinate(5, 5);
            GameElement element = new GameElement(ElementType.ENEMY, true, pos);
            org.junit.jupiter.api.Assertions.assertEquals(5, element.getPosition().getX());
            org.junit.jupiter.api.Assertions.assertEquals(5, element.getPosition().getY());
            // test setPosition
            Coordinate newPos = new Coordinate(4, 4);
            element.setPosition(newPos);
            org.junit.jupiter.api.Assertions.assertEquals(4, element.getPosition().getX());
            org.junit.jupiter.api.Assertions.assertEquals(4, element.getPosition().getY());
        }
    }
}
