import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 100;
    static int n, m;
    static int[] arrA = new int[MAX], arrB = new int[MAX];
    static int[] temp = new int[MAX];

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        n = rd.nextInt();
        m = rd.nextInt();

        for (int i = 0; i < n; i++) {
            arrA[i] = rd.nextInt();
        }
        for (int i = 0; i < m; i++) {
            arrB[i] = rd.nextInt();
        }

        Arrays.sort(arrB, 0, m);

        int count = 0;
        for (int i = 0; i <= n - m; i++) {
            for (int j = 0; j < m; j++) {
                temp[j] = arrA[i + j];
            }
            Arrays.sort(temp, 0, m);

            boolean isSame = true;
            for (int j = 0; j < m; j++) {
                if (temp[j] != arrB[j]) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                count++;
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