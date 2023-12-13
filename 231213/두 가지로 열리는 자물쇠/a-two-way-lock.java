import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr1 = new int[3];
    static int[] arr2 = new int[3];

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        n = rd.nextInt();
        for (int i = 0; i < 3; i++) {
            arr1[i] = rd.nextInt();
        }
        for (int i = 0; i < 3; i++) {
            arr2[i] = rd.nextInt();
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if ((Math.abs(arr1[0] - i) <= 2 || Math.abs(arr1[0] - i) >= n - 2) &&
                      (Math.abs(arr1[1] - j) <= 2 || Math.abs(arr1[1] - j) >= n - 2) &&
                      (Math.abs(arr1[2] - k) <= 2 || Math.abs(arr1[2] - k) >= n - 2)) {
                        cnt++;
                    } else if ((Math.abs(arr2[0] - i) <= 2 || Math.abs(arr2[0] - i) >= n - 2) &&
                      (Math.abs(arr2[1] - j) <= 2 || Math.abs(arr2[1] - j) >= n - 2) &&
                      (Math.abs(arr2[2] - k) <= 2 || Math.abs(arr2[2] - k) >= n - 2)) {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
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