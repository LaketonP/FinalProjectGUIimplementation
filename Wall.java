public class Wall extends GameElement {
    public Wall(Coordinate position) {
        super(ElementType.WALL, true, position);
    }
    // test wall is solid
    public static class WallTest {
        @org.junit.jupiter.api.Test 
        // test wall is solid
        public void testWallIsSolid() {
            Wall wall = new Wall(new Coordinate(1, 1));
            org.junit.jupiter.api.Assertions.assertTrue(wall.isSolid());
            org.junit.jupiter.api.Assertions.assertEquals(ElementType.WALL, wall.getType());
        }
    }
}
