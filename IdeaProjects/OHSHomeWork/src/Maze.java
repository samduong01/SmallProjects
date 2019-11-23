import java.util.*;

class Maze {
    int height;
    int width;
    int N;
    int S;
    int E;
    int W;
    HashMap deltaX;
    HashMap deltaY;
    HashMap OPPOSITE;
    ArrayList<Integer> heading;
    int[][] maze;

    public Maze(int width, int height) {
        maze = new int[height][width];

        deltaX = new HashMap();
        deltaY = new HashMap();
        OPPOSITE = new HashMap();

        N = 1;
        S = 2;
        E = 4;
        W = 8;

        deltaX.put(E, 1);
        deltaX.put(W, -1);
        deltaX.put(N, 0);
        deltaX.put(S, 0);

        deltaY.put(E, 0);
        deltaY.put(W, 0);
        deltaY.put(N, -1);
        deltaY.put(S, 1);

        OPPOSITE.put(E, W);
        OPPOSITE.put(W, E);
        OPPOSITE.put(N, S);
        OPPOSITE.put(S, N);

        this.width = width;
        this.height = height;
        heading = new ArrayList<>(Arrays.asList(N, S, E, W));
        createPath(0,0,maze);
    }

    public boolean isBetween(int data, int minVal, int maxVal) {
        if (data >= minVal && data <= maxVal) {
            return true;
        }else {
            return false;
        }
    }

    public void print() {
        System.out.println(" " + new String(new char[width * 2 - 1]).replace("\0", "_"));
        for (int y = 0; y < height; y++) {
            System.out.print("|");
            for (int x = 0; x < width; x++) {
                System.out.print(((maze[y][x] & S) != 0) ? " " : "_");
                if ((maze[y][x] & E) != 0) {
                    System.out.print((((maze[y][x] | maze[y][x + 1]) & S) != 0) ? " " : "_");
                } else {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    public void createPath(int currX, int currY, int[][] maze) {
        Collections.shuffle(heading, new Random());
        for (Integer direction: heading) {
            int newX = currX + (int) deltaX.get(direction);
            int newY = currY + (int) deltaY.get(direction);
            if (isBetween(newY, 0, maze.length - 1) && isBetween(newX, 0, maze[1].length - 1) && (maze[newY][newX] == 0)) {
                maze[currY][currX] |= direction;
                maze[newY][newX] |= (int) OPPOSITE.get(direction);
                createPath(newX, newY, maze);
            }
        }
    }
}