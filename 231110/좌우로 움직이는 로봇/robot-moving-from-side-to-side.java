import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] timesForLocationA = new int[1_000_001];
    static int[] timesForLocationB = new int[1_000_001];

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        int n = rd.nextInt();
        int m = rd.nextInt();

        calcTime(rd, n, timesForLocationA);

        calcTime(rd, m, timesForLocationB);

        int count = 0;
        boolean wasDifferent = true;
        for (int i = 1; i < timesForLocationA.length; i++) {
            if (timesForLocationA[i] == timesForLocationB[i]) {
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

    private static void calcTime(FastReader rd, int n, int[] locations) {
        int curLocation = 500_000;
        int curTime = 1;
        locations[0] = curLocation;
        for (int i = 0; i < n; i++) {
            int t = rd.nextInt();
            String d = rd.next();
            if (d.equals("R")) {
                for (int time = curTime; time < curTime + t; time++) {
                    locations[time] = ++curLocation;
                }
                curTime = curTime + t;
            } else if (d.equals("L")) {
                for (int time = curTime; time < curTime + t; time++) {
                    locations[time] = --curLocation;
                }
                curTime = curTime + t;
            }
        }

        for (int time = curTime; time < locations.length; time++) {
            locations[time] = locations[curTime - 1];
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