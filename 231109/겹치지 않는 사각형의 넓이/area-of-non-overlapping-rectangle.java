import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visited = new boolean[2000][2000];

    public static void main(String[] args) {
        FastReader rd = new FastReader();

        for (int i = 0; i < 3; i++) {
            int x1 = rd.nextInt() + 1000;
            int y1 = rd.nextInt() + 1000;
            int x2 = rd.nextInt() + 1000;
            int y2 = rd.nextInt() + 1000;

            if (i == 2) {
                for (int x = x1; x < x2; x++) {
                    for (int y = y1; y < y2; y++) {
                        visited[x][y] = false;
                    }
                }
            } else {
                for (int x = x1; x < x2; x++) {
                    for (int y = y1; y < y2; y++) {
                        visited[x][y] = true;
                    }
                }
            }
        }
        int area = 0;
        for (int x = 0; x < visited.length; x++) {
            for (int y = 0; y < visited.length; y++) {
                if (visited[x][y]) {
                    area++;
                }
            }
        }
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