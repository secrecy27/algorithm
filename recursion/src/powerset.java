
/*
    멱집합(powerset) : 그 집합의 모든 부분집합을 모은 집합

    부분집합의 갯수 2^6
    {a,b,c,d,e,f}의 모든 부분집을 나열하려면
    a를 제외한 {b,c,d,e,f}의 모든 부분집합들을 나열하고 = 2^5
    {b,c,d,e,f}의 모든 부분집합에 {a}를 추가한 집합들을 나열한다. = 2^5

    2^6 = 2^5(a포함) + 2^5(a포함x)



    State space tree
    - 해를 찾기 위해 탐색할 필요가 있는 모든 후보들을 포함하는 트리
    - 트리의 모든 노드들을 방문하면 해를 찾을 수 있다.
    - 루트에서 출발하여 모든 노드를 탐색하는 절차

 */
public class powerset {
    public static void main(String[] args) {
        powerSet(0);

    }
    //집합 s = k번째 원소부터 끝까지
    //집합 p = 0번째부터 k-1번째까지
    private static char data[] = {'a', 'b', 'c', 'd'};
    private static int n = data.length;
    private static boolean[] include = new boolean[n]; // true: 원소가 속해있는 경우, 트리상에서 현재 위치

    public static void powerSet(int k) {
        //집합 s가 공집합인 경우 집합 p출력
        if (k == n) {
            for (int i = 0; i < n; i++) {
                if (include[i])
                    System.out.print(data[i] + " ");
            }
            System.out.println();
            return;
        }
        // data[k]를 포함하지 않는경우
        include[k]=false;
        powerSet(k+1);
        // data[k]를 포함하는 경우
        include[k]=true;
        powerSet(k+1);
    }

}

