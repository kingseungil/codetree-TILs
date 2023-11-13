import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int[][] grid;
    static int n;

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        n = rd.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = rd.nextInt();
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int currentCnt = 0;
            for (int j = 0; j < n; j++) {
                for (int dir = 0; dir < 4; dir++) {
                    int x = grid[i][j] + dx[dir];
                    int y = grid[i][j] + dy[dir];
                    if (inRange(x, y) && grid[x][y] == 1) {
                        currentCnt++;
                    }
                }
            }
            if (currentCnt >= 3) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean inRange(int x, int y) {
        return (0 <= x && x < n && 0 <= y && y < n);
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