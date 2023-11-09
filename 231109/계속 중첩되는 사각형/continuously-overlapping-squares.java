import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] grid = new int[200][200];

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        int n = rd.nextInt();

        for (int i = 0; i < n; i++) {
            int x1 = rd.nextInt() + 100;
            int y1 = rd.nextInt() + 100;
            int x2 = rd.nextInt() + 100;
            int y2 = rd.nextInt() + 100;

            // 1 : 빨강, 2 : 파랑
            if (i % 2 == 0) {
                for (int x = x1; x < x2; x++) {
                    for (int y = y1; y < y2; y++) {
                        grid[x][y] = 1;
                    }
                }
            } else {
                for (int x = x1; x < x2; x++) {
                    for (int y = y1; y < y2; y++) {
                        grid[x][y] = 2;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 2) {
                    count++;
                }
            }
        }
        System.out.println(count);
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