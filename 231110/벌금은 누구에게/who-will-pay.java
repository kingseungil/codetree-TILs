import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        int n = rd.nextInt();
        int m = rd.nextInt();
        int k = rd.nextInt();

        Map<Integer, Integer> students = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int input = rd.nextInt();
            students.put(input, students.getOrDefault(input, 0) + 1);
            if (students.get(input) == k) {
                // students의 key값 출력
                System.out.println(input);
                return;
            }
        }
        System.out.println(-1);
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