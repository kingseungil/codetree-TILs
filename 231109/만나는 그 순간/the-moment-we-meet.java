import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] aPos = new int[2001];
    static int[] bPos = new int[2001];

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        int n = rd.nextInt();
        int m = rd.nextInt();

        int aTime = 0, bTime = 0;

        aTime = getTime(rd, n, aPos, aTime);

        bTime = getTime(rd, m, bPos, bTime);

        int maxTime = Math.max(aTime, bTime);
        for (int i = 1; i <= maxTime; i++) {
            if (aPos[i + 1000] == bPos[i + 1000]) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }

    private static int getTime(FastReader rd, int m, int[] pos, int time) {
        for (int i = 0; i < m; i++) {
            String d = rd.next();
            int t = rd.nextInt();
            if (d.equals("L")) {
                for (int j = 1; j <= t; j++) {
                    pos[time + j + 1000] = pos[time + j - 1 + 1000] - 1;
                }
            } else {
                for (int j = 1; j <= t; j++) {
                    pos[time + j + 1000] = pos[time + j - 1 + 1000] + 1;
                }
            }
            time += t;
        }
        return time;
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