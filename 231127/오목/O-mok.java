import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr = new int[19][19];

    // 동,남,서,북,동남,서남,서북,동북
    static int[] dx = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, -1, 1};

    static int winnerX = 0;
    static int winnerY = 0;

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                arr[i][j] = rd.nextInt();
            }
        }

        int winner = 0;
        // 1: 흑, 2: 백
        for (int color = 1; color <= 2; color++) {
            for (int i = 0; i < 19; i++) {
                for (int j = 0; j < 19; j++) {
                    if (arr[i][j] == color) {
                        for (int dir = 0; dir < 8; dir++) {
                            if (check(arr, i, j, color, dir, 1)) {
                                winner = color;
                                break;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(winner);
        if (winner != 0) {
            System.out.println((winnerX + 1) + " " + (winnerY + 1));
        } else {
            System.out.println(0);
        }
    }

    // dfs
    private static boolean check(int[][] arr, int x, int y, int color, int dir, int cnt) {
        if (cnt == 5) {
            winnerX = x - 2 * dx[dir]; // 5개의 돌 중 가운데 돌의 위치
            winnerY = y - 2 * dy[dir]; // 5개의 돌 중 가운데 돌의 위치
            return true;
        }

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (nx < 0 || nx >= 19 || ny < 0 || ny >= 19) {
            return false;
        }

        if (arr[nx][ny] == color) {
            return check(arr, nx, ny, color, dir, cnt + 1);
        }

        return false;
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