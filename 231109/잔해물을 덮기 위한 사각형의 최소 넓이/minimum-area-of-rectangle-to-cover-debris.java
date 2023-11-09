import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] visited = new int[2000][2000];

    public static void main(String[] args) {
        FastReader rd = new FastReader();

        // {x1, y1, x2, y2}
        int[] rect1 = {rd.nextInt(), rd.nextInt(), rd.nextInt(), rd.nextInt()};
        int[] rect2 = {rd.nextInt(), rd.nextInt(), rd.nextInt(), rd.nextInt()};

        // rect1이 rect2 안에 있는 경우
        if (rect2[0] <= rect1[0] && rect2[1] <= rect1[1] && rect1[2] <= rect2[2] && rect1[3] <= rect2[3]) {
            System.out.println((rect1[2] - rect1[0]) * (rect1[3] - rect1[1]));
            return;
        }
        // rect1넓이 - 겹치는 부분
        System.out.println((rect1[2] - rect1[0]) * (rect1[3] - rect1[1]) - getOverlapArea(rect1, rect2));
    }

    private static int getOverlapArea(int[] rect1, int[] rect2) {
        int area = 0;
        for (int i = rect1[0]; i < rect1[2]; i++) {
            for (int j = rect1[1]; j < rect1[3]; j++) {
                if (isInRect(i, j, rect2)) {
                    area++;
                }
            }
        }
        return area;
    }

    private static boolean isInRect(int x, int y, int[] rect2) {
        return rect2[0] <= x && x < rect2[2] && rect2[1] <= y && y < rect2[3];
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