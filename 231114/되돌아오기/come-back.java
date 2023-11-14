import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // {동(E), 남(S), 서(W), 북(N)}
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int n;

    // 시작점
    static int x = 0;
    static int y = 0;

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        n = rd.nextInt();

        int result = 0;

        loop:
        for (int i = 0; i < n; i++) {
            String dir = rd.next();
            int dirNum = getDirNum(dir);
            int distance = rd.nextInt();

            for (int time = 1; time <= distance; time++) {
                x += dx[dirNum];
                y += dy[dirNum];

                result++;

                if (x == 0 && y == 0) {
                    break loop;
                }
            }
        }

        if (x != 0 || y != 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }

    private static int getDirNum(String s) {
        int dir = -1;
        switch (s) {
            case "E":
                dir = 0;
                break;
            case "S":
                dir = 1;
                break;
            case "W":
                dir = 2;
                break;
            case "N":
                dir = 3;
                break;
        }
        return dir;
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