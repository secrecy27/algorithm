// 미로찾기
public class maze {
    private static int N = 8;
    private static int[][] maze = {
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 1, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 0, 0, 1, 1, 0, 0},
            {0, 1, 1, 1, 0, 0, 1, 1},
            {0, 1, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0, 1, 0, 0}
    };
    //  통로:0, 벽 :1

    private static final int PATHWAY = 0;
    private static final int WALL = 1;
    private static final int BLOCKED = 2;// visited이며 출구까지의 경로가 될 가능성 없음
    private static final int PATH = 3;// visited이며 출구로 가는 경로가 될 가능성 있음

    public static boolean findMazePath(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N)
            //x>=N >> 미로범위밖
            return false;
        else if (maze[x][y] != PATHWAY)
            return false;
        else if (x == N - 1 && y == N - 1) {
            maze[x][y] = PATH;
            return true;
        } else {
            maze[x][y] = PATH;
            if (findMazePath(x - 1, y) || findMazePath(x, y + 1) || findMazePath(x + 1, y) || findMazePath(x, y - 1)) {
                return true;
            }
            maze[x][y] = BLOCKED;    //여기가 실행됐다는 것은 어떤방향으로도 막혀있다
            return false;
        }
    }

    public static void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j]);

                // 한 줄의 끝이 아닐때
                if (j != maze[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        findMazePath(0, 0);
        printMaze();
    }

}
