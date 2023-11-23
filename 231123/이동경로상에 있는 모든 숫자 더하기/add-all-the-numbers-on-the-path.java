import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // {동(E), 북(N), 서(W), 북(N), 남(S)}
    static int[] dx = new int[]{0, -1, 0, 1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int[][] grid;
    static int n, t;

    // 시작점
    static int x, y;

    // 시작 방향
    static int dir = 1; // 북쪽

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        n = rd.nextInt(); // 홀수
        t = rd.nextInt();
        grid = new int[n][n];

        String command = rd.next();

        for (int i = 0; i < n; i++) {
            grid[i][0] = rd.nextInt();
            grid[i][1] = rd.nextInt();
            grid[i][2] = rd.nextInt();
        }

        // 시작점 설정(가운데)
        x = n / 2;
        y = n / 2;

        int result = grid[x][y];
        for (char c : command.toCharArray()) {
            if ('F' == c) {
                int nx = x + dx[dir], ny = y + dy[dir];
                if (inRange(nx, ny)) {
                    x += dx[dir];
                    y += dy[dir];
                    result += grid[x][y];
                }
            } else if ('L' == c) {
                dir = (dir + 1) % 4;
            } else if ('R' == c) {
                dir = (dir + 3) % 4;
            }
        }
        System.out.println(result);
    }


    private static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
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