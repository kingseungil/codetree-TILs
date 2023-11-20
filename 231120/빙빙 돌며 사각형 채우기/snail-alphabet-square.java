import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // {동(E), 남(S), 서(W), 북(N)}
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static char[][] grid;
    static int n;
    static int m;

    // 시작점
    static int x = 0;
    static int y = 0;

    // 시작 방향
    static int dir = 0;

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        n = rd.nextInt();
        m = rd.nextInt();
        grid = new char[n][m];
        grid[x][y] = 65;

        char currentChar = 66;
        for (int i = 2; i <= n * m; i++) {
            int nx = x + dx[dir], ny = y + dy[dir];
            if (!inRange(nx, ny) || grid[nx][ny] != 0) {
                dir = (dir + 1) % 4;
            }
            x += dx[dir];
            y += dy[dir];

            grid[x][y] = currentChar;

            currentChar = (char) ((i % 26) + 65);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }


    private static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
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