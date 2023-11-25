import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        int a = rd.nextInt(); // 2진수라고 가정

        StringBuilder sb = new StringBuilder();
        // a 각 자리 숫자 sb에 저장
        while (a > 0) {
            sb.append(a % 10);
            a /= 10;
        }
        int max = getDecimal(a);

        // sb 역순
        sb.reverse();

        // sb 순회하면서 0을 1로 바꿔보고 10진수로 변환
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                sb.setCharAt(i, '1');
                int decimal = getDecimal(Integer.parseInt(sb.toString()));
                max = Math.max(max, decimal);
                sb.setCharAt(i, '0');
            }
        }

        System.out.println(max);
    }

    private static int getDecimal(int a) {
        int decimal = 0;
        int digit = 1;
        while (a > 0) {
            decimal += (a % 10) * digit;
            a /= 10;
            digit *= 2;
        }
        return decimal;
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