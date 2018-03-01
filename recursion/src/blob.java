
// image pixel의 집합 :blob
// 서로 인접한 pixel들의 개수 구하기
public class blob {
    private static int N=8;
    private static int [][] grid={
            {1,0,0,0,0,0,0,1},
            {0,1,1,0,0,1,0,0},
            {1,1,0,0,1,0,1,0},
            {0,0,0,0,0,1,0,0},
            {0,1,0,1,0,1,0,0},
            {0,1,0,1,0,1,0,0},
            {1,0,0,0,1,0,0,1},
            {0,1,1,0,0,1,1,1}
    };

    public static int BACKGROUND_COLOR=0;
    public static int IMAGE_COLOR=1;
    public static int ALREADY_COUNTED=2;

    public static int countCells(int x, int y){
        if(x<0 || y<0|| x>=N || y>=N){
            return 0;
        }else if(grid[x][y]!=IMAGE_COLOR){
            return 0;
        }else {
            grid[x][y]=ALREADY_COUNTED;
            return 1+countCells(x-1,y+1)+countCells(x,y+1)+countCells(x+1,y+1)+
                    countCells(x-1,y)+countCells(x+1,y)+countCells(x-1,y-1)+
                    countCells(x,y-1)+countCells(x+1,y-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(countCells(5,3));
    }

}
