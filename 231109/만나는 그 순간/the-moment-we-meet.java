import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] posA = new int[1_000_001];
    static int[] posB = new int[1_000_001];

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        int n = rd.nextInt();
        int m = rd.nextInt();

        // A가 매 초마다 서있는 위치를 기록
        int timeA = recordPosition(n, rd, posA);
        // B가 매 초마다 서있는 위치를 기록
        int timeB = recordPosition(m, rd, posB);

        int firstMeetTime = -1;
        for (int i = 1; i < timeA; i++) {
            if (posA[i] == posB[i]) {
                firstMeetTime = i;
                break;
            }
        }
        System.out.println(firstMeetTime);
    }

    public static int recordPosition(int limit, FastReader rd, int[] pos) {
        int time = 1;
        for (int i = 0; i < limit; i++) {
            char d = rd.next().charAt(0);
            int t = rd.nextInt();

            while (t-- > 0) {
                if (d == 'R') {
                    pos[time] = pos[time - 1] + 1;
                } else {
                    pos[time] = pos[time - 1] - 1;
                }

                time++;
            }
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