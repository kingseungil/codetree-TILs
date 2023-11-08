import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    static boolean[][] visited = new boolean[201][201];
    
    public static void main(String[] args) {
        FastReader rd = new FastReader();
        int n = rd.nextInt();
        for (int i = 0; i < n; i++) {
            List<Integer> input = Arrays.stream(rd.nextLine().split(" ")).map(Integer::parseInt)
                                        .collect(Collectors.toList());

            int x1 = input.get(0) + 100;
            int y1 = input.get(1) + 100;
            int x2 = input.get(2) + 100;
            int y2 = input.get(3) + 100;

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    visited[x][y] = true;
                }
            }
        }

        int area = 0;
        for (int x = 0; x < 201; x++) {
            for (int y = 0; y < 201; y++) {
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