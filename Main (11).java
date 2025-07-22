import javax.swing.*;
// start game
public class Main {
    public static void main(String[] args) {
        TestGameMaze maze = new TestGameMaze();
        maze.generateMaze(1); // difficulty 1
        // create frame and panel
        JFrame frame = new JFrame("Game Maze");
        MazePanel panel = new MazePanel(maze);
        // add panel to frame
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
