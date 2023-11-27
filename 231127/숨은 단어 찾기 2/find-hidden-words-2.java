import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[][] arr;
    static int n;
    static int m;

    // 동,남,서,북,동남,서남,서북,동북
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, -1, 1};

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        n = rd.nextInt();
        m = rd.nextInt();
        arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            String input = rd.nextLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        int count = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                for (int dir = 0; dir < 8; dir++) {
                    StringBuilder sb = new StringBuilder();
                    if (check(x, y, dir, sb)) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

    // dfs
    private static boolean check(int x, int y, int dir, StringBuilder sb) {
        // 첫글자가 L이 아니면 false
        if (sb.length() == 0) {
            if (arr[x][y] != 'L') {
                return false;
            }
            sb.append(arr[x][y]);
        }

        // 길이가 3이면 LEE인지 확인
        if (sb.length() == 3) {
            return sb.toString().equals("LEE");
        }

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (inRange(nx, ny)) {
            sb.append(arr[nx][ny]);
            return check(nx, ny, dir, sb);
        }
        return false;

    }

    private static boolean inRange(int x, int y) {
        return (x >= 0 && x < n) && (y >= 0 && y < m);
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