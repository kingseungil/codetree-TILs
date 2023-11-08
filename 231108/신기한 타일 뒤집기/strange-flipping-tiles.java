import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] color = new int[10000];

    public static class Segment {

        int start;
        int end;
        String direction;

        public Segment(int start, int end, String direction) {
            this.start = start;
            this.end = end;
            this.direction = direction;
        }
    }


    public static void main(String[] args) {
        FastReader rd = new FastReader();
        int n = rd.nextInt();

        // 현재 위치를 저장하는 변수
        int cur = 5000;

        List<Segment> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int distance = rd.nextInt();
            String direction = rd.next().trim();

            int start, end;
            switch (direction) {
                case "R":
                    start = cur;
                    cur += distance - 1;
                    end = cur;
                    list.add(new Segment(start, end, direction));
                    break;
                case "L":
                    start = cur;
                    cur -= (distance - 1);
                    end = cur;
                    list.add(new Segment(start, end, direction));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + direction);
            }
        }

        // 검정 : 1, 흰색 : 2
        for (Segment s : list) {
            switch (s.direction) {
                case "R":
                    for (int i = s.start; i <= s.end; i++) {
                        color[i] = 1; // 검은색
                    }
                    break;
                case "L":
                    for (int i = s.start; i >= s.end; i--) {
                        color[i] = 2; // 흰색
                    }
                    break;
            }
        }

        int black = 0, white = 0;
        for (int i = 0; i < color.length; i++) {
            if (color[i] == 1) {
                black++;
            } else if (color[i] == 2) {
                white++;
            }
        }
        System.out.println(white + " " + black);
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