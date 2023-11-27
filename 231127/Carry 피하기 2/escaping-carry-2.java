import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        n = rd.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rd.nextInt();
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int n1 = arr[i];
                    int n2 = arr[j];
                    int n3 = arr[k];

                    if (!isCarry(n1, n2, n3)) {
                        max = Math.max(max, n1 + n2 + n3);
                    }
                }
            }
        }
        System.out.println(max);
    }

    private static boolean isCarry(int n1, int n2, int n3) {
        int[] arr1 = new int[5];
        int[] arr2 = new int[5];
        int[] arr3 = new int[5];

        for (int i = 0; i < 5; i++) {
            arr1[i] = n1 % 10;
            arr2[i] = n2 % 10;
            arr3[i] = n3 % 10;
            n1 /= 10;
            n2 /= 10;
            n3 /= 10;
        }

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum = arr1[i] + arr2[i] + arr3[i];
            if (sum >= 10) {
                return true;
            }
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