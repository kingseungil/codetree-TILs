import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int r;
    static int c;
    static char[][] grid;

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        r = rd.nextInt();
        c = rd.nextInt();
        grid = new char[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = rd.next().charAt(0);
            }
        }

        int cnt = 0;
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                for (int k = i + 1; k < r - 1; k++) {
                    for (int l = j + 1; l < c - 1; l++) {
                        // 색이 다른 경우에만 카운트
                        if (grid[0][0] != grid[i][j] && // 시작 지점 != 현재 지점
                          grid[i][j] != grid[k][l] && // 현재 지점 != 다음 지점
                          grid[k][l] != grid[r - 1][c - 1]) // 다음 지점 != 끝 지점
                        {
                            cnt++;
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
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