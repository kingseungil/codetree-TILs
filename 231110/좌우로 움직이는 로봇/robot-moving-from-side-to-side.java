import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] distanceA = new int[1_000_000];
    static int[] distanceB = new int[1_000_000];

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        int n = rd.nextInt();
        int m = rd.nextInt();

        calcDistance(rd, n, distanceA);
        calcDistance(rd, m, distanceB);

        int count = 0;
        boolean wasDifferent = true;
        for (int i = 0; i < distanceA.length; i++) {
            if (distanceA[i] == distanceB[i]) {
                if (wasDifferent) {
                    count++;
                    wasDifferent = false;
                }
            } else {
                wasDifferent = true;
            }
        }
        System.out.println(count);
    }

    private static void calcDistance(FastReader rd, int n, int[] distances) {
        int current = 500_000;
        for (int i = 0; i < n; i++) {
            int t = rd.nextInt();
            String d = rd.next();
            if (d.equals("R")) {
                for (int time = current; time < current + t; time++) {
                    distances[time]++;
                }
                current = current + t;
            } else if (d.equals("L")) {
                for (int time = current; time > current - t; time--) {
                    distances[time]++;
                }
                current = current - t;
            }
        }
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