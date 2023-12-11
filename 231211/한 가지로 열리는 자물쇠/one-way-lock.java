import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int allCases;
    static int[] arr = new int[4];

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        n = rd.nextInt();
        allCases = n * n * n;

        for (int i = 1; i <= 3; i++) {
            arr[i] = rd.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (!isInRange(i, j, k)) {
                        allCases--;
                    }
                }
            }
        }
        System.out.println(allCases);
    }

    private static boolean isInRange(int i, int j, int k) {
        if (Math.abs(i - arr[1]) <= 2 || Math.abs(j - arr[2]) <= 2 || Math.abs(k - arr[3]) <= 2) {
            return true;
        }
        return false;
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