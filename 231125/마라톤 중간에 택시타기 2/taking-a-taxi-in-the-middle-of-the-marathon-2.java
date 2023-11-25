import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] checkPoint;

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        N = rd.nextInt();

        checkPoint = new int[N][2];
        for (int i = 0; i < N; i++) {
            int x = rd.nextInt();
            int y = rd.nextInt();
            checkPoint[i][0] = x;
            checkPoint[i][1] = y;
        }

        // 시작과 끝 체크포인트를 제외하고 하나씩 제외해보면서 거리 구하기
        int minDistance = Integer.MAX_VALUE;
        for (int i = 1; i < N - 1; i++) {
            int distance = getDistance(checkPoint[0], checkPoint[i]) + getDistance(checkPoint[i], checkPoint[N - 1]);
            minDistance = Math.min(minDistance, distance);
        }
        System.out.println(minDistance);
    }

    private static int getDistance(int[] a, int[] b) {
        // Manhattan distance
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
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