import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // {동(E), 남(S), 서(W), 북(N)}
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int[][] grid;
    static int n;

    // 시작점
    static int x = 0;
    static int y = 0;

    // 시작 방향
    static int dir = 0;

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        n = rd.nextInt();
        int m = rd.nextInt();
        grid = new int[n][n];

        for (int i = 0; i < m; i++) {
            int x = rd.nextInt() - 1;
            int y = rd.nextInt() - 1;
            // 색칠
            grid[x][y] = 1;
            // 확인
            if (check(x, y)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    private static boolean check(int x, int y) {
        // 상 하 좌 우 체크
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (inRange(nx, ny) && grid[nx][ny] == 1) {
                count++;
            }
        }
        return count == 3;
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