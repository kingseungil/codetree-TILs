import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] visited = new int[200][200];

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        int n = rd.nextInt();

        int area = 0;
        for (int i = 0; i < n; i++) {
            int x1 = rd.nextInt() + 100;
            int y1 = rd.nextInt() + 100;

            for (int x = x1; x < x1 + 8; x++) {
                for (int y = y1; y < y1 + 8; y++) {
                    if (visited[x][y] == 0) {
                        visited[x][y]++;
                        area++;
                    }
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