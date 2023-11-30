import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

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

        int result = 0;
        for (int x1 = 0; x1 < n; x1++) {
            for (int y1 = 0; y1 < n - 2; y1++) {
                for (int x2 = 0; x2 < n; x2++) { // 같은 행에 있어도 ㅇㅋ
                    for (int y2 = 0; y2 < n - 2; y2++) { // 겹치지 않게 해야함
                        if (x1 == x2 && Math.abs(y1 - y2) <= 2) {
                            continue;
                        }
                        int sum1 = grid[x1][y1] + grid[x1][y1 + 1] + grid[x1][y1 + 2];
                        int sum2 = grid[x2][y2] + grid[x2][y2 + 1] + grid[x2][y2 + 2];
                        result = Math.max(result, sum1 + sum2);
                    }
                }
            }
        }
        System.out.println(result);
    }

    private static boolean isOverlap(int y1, int y2) {
        return y1 <= y2 && y2 <= y1 + 2 // 두번째 격자가 첫번째 격자에 포함되는 경우
          || y2 <= y1 && y1 <= y2 + 2; // 첫번째 격자가 두번째 격자에 포함되는 경우
    }


    private static boolean inRange(int x, int y) {
        return (x >= 0 && x < n) && (y >= 0 && y < n);
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