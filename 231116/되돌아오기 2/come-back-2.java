import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // {동(E), 남(S), 서(W), 북(N)}
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    //    static int[][] grid = new int[100_000][100_000];

    // 시작점
    static int x = 0;
    static int y = 0;

    // 시작 방향
    static int dir = 0;

    public static void main(String[] args) {
        FastReader rd = new FastReader();

        String[] input = rd.next().split("");

        int time = 0;
        for (String command : input) {
            // 왼쪽으로 90도
            if ("L".equals(command)) {
                dir = (dir + 3) % 4;
                time++;
            }
            // 오른쪽으로 90도
            else if ("R".equals(command)) {
                dir = (dir + 1) % 4;
                time++;
            } else {
                x += dx[dir];
                y += dy[dir];
                time++;
            }

            if (x == 0 && y == 0) {
                break;
            }
        }

        if (x != 0 || y != 0) {
            System.out.println(-1);
        } else {
            System.out.println(time);
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