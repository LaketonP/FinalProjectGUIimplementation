import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// handles events and displays maze to user
public class MazePanel extends JPanel implements KeyListener {
    private GameMaze maze;
    private Player player;
    private final int TILE_SIZE = 40;
    // constructor
    public MazePanel(GameMaze maze) {
        this.maze = maze;
        this.setFocusable(true);
        this.addKeyListener(this);
        findPlayer();
    }
    // find player in maze
    private void findPlayer() {
        GameElement[][] grid = maze.getGrid();
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                GameElement e = grid[x][y];
                if (e != null && e.getType() == ElementType.PLAYER) {
                    this.player = (Player) e;
                    return;
                }
            }
        }
    }
    // paint maze
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        GameElement[][] grid = maze.getGrid();
        // draw grid
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                GameElement element = grid[x][y];
                Color color = Color.WHITE;

                if (element != null) {
                    switch (element.getType()) {
                        case PLAYER -> color = Color.BLUE;
                        case ENEMY -> color = Color.RED;
                        case WALL -> color = Color.BLACK;
                        default -> color = Color.LIGHT_GRAY;
                    }
                }
                // draw tile
                g.setColor(color);
                g.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                g.setColor(Color.GRAY);
                g.drawRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }
    // move player
    private void movePlayer(int dx, int dy) {
        if (player == null) return;
        // calculate new position
        Coordinate from = player.getPosition();
        Coordinate to = new Coordinate(from.getX() + dx, from.getY() + dy);
        // check bounds
        if (to.getX() < 0 || to.getY() < 0 ||
            to.getX() >= maze.getGrid().length ||
            to.getY() >= maze.getGrid()[0].length) return;
        // move element
        boolean moved = maze.moveElement(from, to);
        if (moved) {
            repaint();
            if (maze.isWin()) {
                JOptionPane.showMessageDialog(this, "🎉 You Win!");
            }
        }
    }
    // key listener methods
    @Override public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> movePlayer(0, -1);
            case KeyEvent.VK_DOWN -> movePlayer(0, 1);
            case KeyEvent.VK_LEFT -> movePlayer(-1, 0);
            case KeyEvent.VK_RIGHT -> movePlayer(1, 0);
        }
    }
    // key listeners
    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
    // preferred size
    @Override
    public Dimension getPreferredSize() {
        int rows = maze.getGrid().length;
        int cols = maze.getGrid()[0].length;
        return new Dimension(cols * TILE_SIZE, rows * TILE_SIZE);
    }
}
