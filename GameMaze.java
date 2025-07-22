public abstract class GameMaze {
    protected GameElement[][] grid;
    protected Coordinate startPoint;
    protected Coordinate endPoint;
    protected boolean win;
    // generate maze
    public abstract void generateMaze(int difficulty);
    // move element
    public boolean moveElement(Coordinate from, Coordinate to) {
        if (grid[to.getX()][to.getY()] != null && grid[to.getX()][to.getY()].isSolid()) {
            return false;
        }
        // move element from 'from' to 'to'
        GameElement element = grid[from.getX()][from.getY()];
        if (element == null) return false;
        // update grid and element position
        grid[to.getX()][to.getY()] = element;
        grid[from.getX()][from.getY()] = null;
        element.setPosition(to);
        // check win condition
        if (element.getType() == ElementType.PLAYER && to.equals(endPoint)) {
            win = true;
        }
        return true;
    }
    // get element at coordinate
    public GameElement getElementAt(Coordinate c) {
        return grid[c.getX()][c.getY()];
    }
    // getters
    public boolean isWin() {
        return win;
    }
    public Coordinate getStartPoint() {
        return startPoint;
    }
    public Coordinate getEndPoint() {
        return endPoint;
    }
    public GameElement[][] getGrid() {
        return grid;
    }
}
