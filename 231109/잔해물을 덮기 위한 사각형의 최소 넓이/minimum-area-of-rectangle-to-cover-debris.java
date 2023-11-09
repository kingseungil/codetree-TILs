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

        int x1 = Math.min(rect1[0], rect1[2]);
        int y1 = Math.min(rect1[1], rect1[3]);
        int x2 = Math.max(rect1[0], rect1[2]);
        int y2 = Math.max(rect1[1], rect1[3]);

        // 넓이
        int area = (x2 - x1) * (y2 - y1);
        System.out.println(area);
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