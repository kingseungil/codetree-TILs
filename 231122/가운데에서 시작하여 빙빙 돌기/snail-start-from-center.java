import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // {동(E), 북(N), 서(W), 북(N), 남(S)}
    static int[] dx = new int[]{0, -1, 0, 1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int[][] grid;
    static int n;

    // 시작점
    static int x;
    static int y;

    // 시작 방향
    static int dir = 0; // 동쪽부터 시작

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        n = rd.nextInt(); // 항상 홀수라고 가정해도 OK
        grid = new int[n][n];

        // 시작점 설정(정가운데)
        x = n / 2;
        y = n / 2;
        grid[x][y] = 1;

        int count = 0; // 방향을 바꾸는 횟수를 카운트하는 변수
        int limit = 1; // 현재 방향으로 이동해야 하는 횟수
        int dirCount = 0; // 현재 방향으로 이동한 횟수

        for (int i = 2; i <= n * n; i++) {
            // 현재 방향으로 이동
            x += dx[dir];
            y += dy[dir];
            grid[x][y] = i;
            dirCount++;

            // 현재 방향으로 이동해야 하는 횟수(limit)를 모두 이동했다면 방향을 바꾸고, 카운트와 제한을 업데이트
            if (dirCount == limit) {
                dir = (dir + 1) % 4;
                dirCount = 0;
                count++;
                if (count % 2 == 0) { // 방향을 바꾼 횟수가 2의 배수라면 limit을 1 증가(즉, 1, 1, 2, 2, 3, 3, ...)
                    limit++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }


    private static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n && grid[x][y] == 0;
    }

    private static boolean isEmpty(int x, int y) {
        return grid[x][y] == 0;
    }


    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}