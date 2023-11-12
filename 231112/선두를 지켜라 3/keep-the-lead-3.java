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

        int timeA = recordLocation(rd, n, posA);

        int timeB = recordLocation(rd, m, posB);

        // A와 B 중 더 앞서 있는 경우를 확인합니다.
        // A가 리더면 1, B가 리더면 2, 둘 다 리더면 3으로 관리합니다.
        int leader = 0, ans = 0;
        for (int i = 1; i < timeA; i++) {
            if (posA[i] > posB[i]) {
                // 조합이 바뀌었다면
                // 답을 갱신합니다.
                if (leader != 1) {
                    ans++;
                }

                // 리더를 A로 변경합니다.
                leader = 1;
            } else if (posA[i] < posB[i]) {
                // 조합이 바뀌었다면
                // 답을 갱신합니다.
                if (leader != 2) {
                    ans++;
                }

                // 리더를 B로 변경합니다.
                leader = 2;
            } else {
                // 조합이 바뀌었다면
                // 답을 갱신합니다.
                if (leader != 3) {
                    ans++;
                }

                // 리더를 둘 다로 변경합니다.
                leader = 3;
            }
        }

        System.out.print(ans);
    }

    private static int recordLocation(FastReader rd, int n, int[] pos) {
        int time = 1;
        for (int i = 0; i < n; i++) {
            int v = rd.nextInt();
            int t = rd.nextInt();

            while (t-- > 0) {
                pos[time] = pos[time - 1] + v;
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