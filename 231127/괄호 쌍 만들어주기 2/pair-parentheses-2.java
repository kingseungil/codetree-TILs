import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) {
        FastReader rd = new FastReader();
        String input = rd.nextLine();

        int cnt = 0, result = 0;
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == '(' && input.charAt(i + 1) == '(') {
                cnt++;
            } else if (input.charAt(i) == ')' && input.charAt(i + 1) == ')') {
                result += cnt;
            }
        }
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