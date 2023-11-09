import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] grid = new int[2001][2001];

    public static void main(String[] args) {
        FastReader rd = new FastReader();

        // {x1, y1, x2, y2}
        int[] rect1 = {rd.nextInt() + 1000, rd.nextInt() + 1000, rd.nextInt() + 1000, rd.nextInt() + 1000};
        int[] rect2 = {rd.nextInt() + 1000, rd.nextInt() + 1000, rd.nextInt() + 1000, rd.nextInt() + 1000};

        // rect1이 rect2에 덮히는 경우
        if (rect1[0] >= rect2[0] && rect1[1] >= rect2[1] && rect1[2] <= rect2[2] && rect1[3] <= rect2[3]) {
            System.out.println(0);
            return;
        }

        for (int i = rect1[0]; i < rect1[2]; i++) {
            for (int j = rect1[1]; j < rect1[3]; j++) {
                grid[i][j] = 1;
            }
        }
        for (int i = rect2[0]; i < rect2[2]; i++) {
            for (int j = rect2[1]; j < rect2[3]; j++) {
                grid[i][j] = 0;
            }
        }

        int minX = 2001, minY = 2001, maxX = -1, maxY = -1;
        for (int i = 0; i < 2001; i++) {
            for (int j = 0; j < 2001; j++) {
                if (grid[i][j] == 1) {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }


        int result = (maxX - minX + 1) * (maxY - minY + 1); // 잔해를 덮는 최소 크기의 직사각형의 넓이
        System.out.println(result);
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