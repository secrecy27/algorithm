// Backtracking : 상태공간 트리를 깊이 우선 방식으로 탐색하여 해를 찾는 알고리즘
// Recursion or Stack 으로 구현

public class nQueens {
    public static void main(String[] args) {
        queens(0);
    }

    // 4*4
    private static int N = 8;
    public static int[] cols = new int[N + 1];
    public static boolean queens(int level) {
        //실패한 경우 - 이 노드뿐 아니라 밑으로도 없는 경우
        //현재까지 다른말과 충돌했는지 안했는지
        if (!promising(level)) {
            return false;

            // promising 테스트를 통과했다는 가정하에
            // level==N이면 모든 말이 놓였다는 의미이므로 성공한 경우
            // cols[i]=j는 i번 말이 (i행,j열)에 놓였음을 의미
        } else if (level == N) {
            for (int i = 1; i <= N; i++) {
                System.out.println("(" + i + ", " + cols[i] + ")");
                System.out.println(cols[i]);
            }
            return true;
        }

        //level+1번째 말을 각각의 열에 놓은 후 recursion호출
        for (int i = 1; i <= N; i++) {
            // 초기 level이 0이므로 (1,1)부터 시작
            cols[level + 1] = i;
            if (queens(level + 1)) {
                return true;
            }
        }
        //여기까지 오면 실패
        return false;

    }

    public static boolean promising(int level) {
        for (int i = 1; i < level; i++) {
            if (cols[i] == cols[level]) {
                //수직으로 만나는 경우
                return false;
            } else if (level - i == Math.abs(cols[level] - cols[i])) {
                //대각선으로 만나는 경우
                return false;
            }
        }
        return true;
    }

}
