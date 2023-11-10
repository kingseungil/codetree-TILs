import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static double[] distancePerTime1 = new double[1_000];
    static double[] distancePerTime2 = new double[1_000];

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        int n = rd.nextInt();
        int m = rd.nextInt();

        // {속도, 시간}
        calcDistance(rd, n, distancePerTime1);

        calcDistance(rd, m, distancePerTime2);

        int count = 0;
        String lead = "none";
        String lastLead = "none";
        for (int i = 0; i < distancePerTime1.length; i++) {
            if (distancePerTime1[i] > distancePerTime2[i]) {
                lead = "A";
            } else if (distancePerTime1[i] < distancePerTime2[i]) {
                lead = "B";
            }
            if (!lead.equals(lastLead) && !lastLead.equals("none")) {
                count++;
            }
            lastLead = lead;
        }
        System.out.println(count);
    }

    private static void calcDistance(FastReader rd, int n, double[] distancePerTime) {
        double current = 0;
        int currentTime = 0;
        for (int i = 0; i < n; i++) {
            int v = rd.nextInt();
            int t = rd.nextInt();
            double perHour = (double) v / t;
            for (int j = currentTime; j < currentTime + t; j++) {
                distancePerTime[j] = current + perHour;
                current = distancePerTime[j];
            }
            currentTime = currentTime + t;
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