import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // {동,남,서,북)
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int dir = 3; // 처음엔 북쪽
    static int nx = 0, ny = 0;

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        char[] input = rd.nextLine().toCharArray();
        for (char c : input) {
            switch (c) {
                case 'L':
                    // 반시계방향으로 회전
                    dir = (dir - 1 + 4) % 4;
                    break;
                case 'R':
                    // 시계방향으로 회전
                    dir = (dir + 1) % 4;
                    break;
                case 'F':
                    // 바라보고 있는 방향으로 한칸 전진
                    nx = nx + dx[dir];
                    ny = ny + dy[dir];
                    break;
            }
        }
        System.out.println(nx + " " + ny);
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