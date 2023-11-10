import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] distancePerTime1 = new int[1_000_000];
    static int[] distancePerTime2 = new int[1_000_000];

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        int n = rd.nextInt();
        int m = rd.nextInt();

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
            if (!lead.equals(lastLead)) {
                if (!lastLead.equals("none")) {
                    count++;
                }
                lastLead = lead;
            }
        }
        System.out.println(count);
    }

    private static void calcDistance(FastReader rd, int n, int[] distancePerTime) {
        int currentTime = 1;
        for (int i = 0; i < n; i++) {
            int v = rd.nextInt();
            int t = rd.nextInt();
            for (int time = currentTime; time < currentTime + t; time++) {
                distancePerTime[time] = distancePerTime[time - 1] + v;
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