public class Coordinate {
    // coordinate variables
    private int x;
    private int y;
    // constructor
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    // getters and setters
    public int getX() { return x; }
    public int getY() { return y; }
    // setters
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    // equals method
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Coordinate)) return false;
        Coordinate other = (Coordinate) o;
        return this.x == other.x && this.y == other.y;
    }
    // hashCode method
    public static class CoordinateTest {
        @org.junit.jupiter.api.Test
        public void testConstructorAndGetters() { // test constructor and getters
            Coordinate coord = new Coordinate(3, 7);
            org.junit.jupiter.api.Assertions.assertEquals(3, coord.getX());
            org.junit.jupiter.api.Assertions.assertEquals(7, coord.getY());
        }
        // test setters
        @org.junit.jupiter.api.Test
        public void testSetters() {
            Coordinate coord = new Coordinate(0, 0);
            coord.setX(3);
            coord.setY(9);
            org.junit.jupiter.api.Assertions.assertEquals(5, coord.getX());
            org.junit.jupiter.api.Assertions.assertEquals(9, coord.getY());
        }
        // test equals method
        @org.junit.jupiter.api.Test
        public void testEquality() {
            Coordinate a = new Coordinate(2, 4);
            Coordinate b = new Coordinate(2, 4);
            org.junit.jupiter.api.Assertions.assertEquals(a, b);
        }
    }
}
