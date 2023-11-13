import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = new int[]{0, 1, -1, 0};
    static int[] dy = new int[]{1, 0, 0, -1};
    static int[][] grid;
    static int n;
    static int t;

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        n = rd.nextInt();
        t = rd.nextInt();
        grid = new int[n][n];

        int r = rd.nextInt(); // r행
        int c = rd.nextInt(); // c열
        String s = rd.next();
        int dir = getDir(s);

        while (t-- > 0) {
            // 범위 벗어나면 방향 전환 (1초 소모)
            if (!inRange(r + dx[dir], c + dy[dir])) {
                dir = 3 - dir;
                continue;
            }
            // 범위 안에 있으면 이동
            r += dx[dir];
            c += dy[dir];
        }
        System.out.println(r + " " + c);
    }

    private static boolean inRange(int x, int y) {
        return (1 <= x && x <= grid.length && 1 <= y && y <= grid.length);
    }

    private static int getDir(String s) {
        int dir = -1;
        switch (s) {
            case "U":
                dir = 2;
                break;
            case "D":
                dir = 1;
                break;
            case "R":
                dir = 0;
                break;
            case "L":
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