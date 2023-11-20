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
    static int k;

    // 시작점
    static int x = 0;
    static int y = 0;

    // 시작 방향
    static int dir = 0;

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        n = rd.nextInt();
        grid = new char[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = rd.nextLine().split("");
            grid[i][0] = input[0].charAt(0);
            grid[i][1] = input[1].charAt(0);
            grid[i][2] = input[2].charAt(0);
        }

        k = rd.nextInt();

        checkLocationAndDir();

        int count = getCount();
        System.out.println(count);
    }

    private static int getCount() {
        int count = 0;
        while (inRange(x, y)) {
            if (grid[x][y] == '/') {
                if (dir == 0 || dir == 2) {
                    dir = (dir + 3) % 4;
                } else {
                    dir = (dir + 1) % 4;
                }
            } else if (grid[x][y] == '\\') {
                if (dir == 0 || dir == 2) {
                    dir = (dir + 1) % 4;
                } else {
                    dir = (dir + 3) % 4;
                }
            }
            x += dx[dir];
            y += dy[dir];
            count++;
        }
        return count;
    }

    private static void checkLocationAndDir() {
        if (k <= n) {
            x = 0;
            y = k - 1;
            dir = 1; // 남쪽
        } else if (k <= n * 2) {
            x = k - n - 1;
            y = n - 1;
            dir = 2; // 서쪽
        } else if (k <= n * 3) {
            x = n - 1;
            y = n * 3 - k;
            dir = 3; // 북쪽
        } else {
            x = n * 4 - k;
            y = 0;
            dir = 0; // 동쪽
        }
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