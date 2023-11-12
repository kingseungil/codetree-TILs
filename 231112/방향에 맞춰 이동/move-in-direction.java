import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // {동,남,서,북)
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int nx = 0, ny = 0;

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        int n = rd.nextInt();
        for (int i = 0; i < n; i++) {
            String dir = rd.next();
            int distance = rd.nextInt();
            int dirIdx = 1;
            switch (dir) {
                case "E":
                    dirIdx = 0;
                    break;
                case "S":
                    dirIdx = 1;
                    break;
                case "W":
                    dirIdx = 2;
                    break;
                case "N":
                    dirIdx = 3;
                    break;
            }
            moveToDir(distance, dirIdx);
        }
        System.out.println(nx + " " + ny);
    }

    private static void moveToDir(int distance, int dirIdx) {
        nx = nx + dx[dirIdx] * distance;
        ny = ny + dy[dirIdx] * distance;
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