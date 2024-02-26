import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr = new int[6];

    public static void main(String[] args) {
        FastReader rd = new FastReader();

        for (int i = 0; i < 6; i++) {
            arr[i] = rd.nextInt();
        }

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    minDiff = Math.min(minDiff, getDiff(i, j, k));
                }
            }
        }

        System.out.println(minDiff);
    }

    private static int getDiff(int i, int j, int k) {
        int sum1 = arr[i] + arr[j] + arr[k];
        int sum2 = 0;
        for (int l = 0; l < 6; l++) {
            sum2 += arr[l];
        }
        sum2 -= sum1;
        return Math.abs(sum1 - sum2);
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