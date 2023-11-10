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

        int timeA = calcTime(rd, n, timesForLocationA);
        int timeB = calcTime(rd, m, timesForLocationB);

        // 최적화 (원래 전체를 전 값으로 채웠음)
        if (timeA < timeB) {
            for (int i = timeA; i < timeB; i++) {
                timesForLocationA[i] = timesForLocationA[timeA - 1];
            }
        } else if (timeA > timeB) {
            for (int i = timeB; i < timeA; i++) {
                timesForLocationB[i] = timesForLocationB[timeB - 1];
            }
        }

        int maxTime = Math.max(timeA, timeB);
        int count = 0;
        for (int i = 1; i < maxTime; i++) {
            if (timesForLocationA[i] == timesForLocationB[i]) {
                if ((timesForLocationA[i - 1] != timesForLocationB[i - 1])) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static int calcTime(FastReader rd, int n, int[] locations) {
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
        return curTime;
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