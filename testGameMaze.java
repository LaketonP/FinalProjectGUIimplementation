// assistance from chatgpt for maze generation 24-37
public class TestGameMaze extends GameMaze {
    // TestGameMaze constructor
    @Override
    public void generateMaze(int difficulty) {
        int size = 5 + difficulty * 2;
        grid = new GameElement[size][size];
        startPoint = new Coordinate(1, 1);
        endPoint = new Coordinate(size - 2, size - 2);
        win = false;
        // add player at start point
        Player player = new Player(startPoint);
        grid[startPoint.getX()][startPoint.getY()] = player;
        // add walls around grid structure
        for (int i = 0; i < size; i++) {
            grid[0][i] = new Wall(new Coordinate(0, i));
            grid[size - 1][i] = new Wall(new Coordinate(size - 1, i));
            grid[i][0] = new Wall(new Coordinate(i, 0));
            grid[i][size - 1] = new Wall(new Coordinate(i, size - 1));
        }
        // add wall at end point
        grid[endPoint.getX()][endPoint.getY()] = null;
    }
    // test maze generation
    public static class TestGameMazeTest {
        private TestGameMaze maze;
        // setup method
        @org.junit.jupiter.api.BeforeEach
        public void setup() {
            maze = new TestGameMaze();
            maze.generateMaze(1);
        }
        // test maze size
        @org.junit.jupiter.api.Test
        public void testStartAndEndPoints() {
            org.junit.jupiter.api.Assertions.assertNotNull(maze.getElementAt(maze.getStartPoint()));
            org.junit.jupiter.api.Assertions.assertNotNull(maze.getEndPoint());
        }
        // test move element
        @org.junit.jupiter.api.Test
        public void testMoveElement() {
            Coordinate from = new Coordinate(1, 1);
            Coordinate to = new Coordinate(1, 2);
            Player player = new Player(from);
            maze.grid[from.getX()][from.getY()] = player;
            // move player to new coordinate
            boolean moved = maze.moveElement(from, to);
            org.junit.jupiter.api.Assertions.assertTrue(moved);
            org.junit.jupiter.api.Assertions.assertNull(maze.grid[from.getX()][from.getY()]);
            org.junit.jupiter.api.Assertions.assertEquals(player, maze.grid[to.getX()][to.getY()]);
        }
        // test win condition
        @org.junit.jupiter.api.Test
        public void testWinCondition() {
            Player player = new Player(new Coordinate(1, 1));
            Coordinate to = maze.getEndPoint();
            // remove wall at end point
            maze.grid[to.getX()][to.getY()] = null;
            maze.grid[1][1] = player;
            // move player to end point
            maze.moveElement(new Coordinate(1, 1), to);
            org.junit.jupiter.api.Assertions.assertTrue(maze.isWin());
        }
    }
}
