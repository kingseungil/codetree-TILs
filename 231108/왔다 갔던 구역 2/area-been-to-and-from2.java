import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    // 2번 이상 지나간 영역을 저장하는 배열
    static int[] visited = new int[2001];

    public static class Segment {

        int start;
        int end;

        public Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    public static void main(String[] args) {
        FastReader rd = new FastReader();
        int n = rd.nextInt();

        // 현재 위치를 저장하는 변수
        int cur = 1000;

        List<Segment> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int distance = rd.nextInt();
            String direction = rd.next().trim();

            int start, end;
            switch (direction) {
                case "R":
                    start = cur;
                    cur += distance;
                    end = cur;
                    list.add(new Segment(start, end));
                    break;
                case "L":
                    start = cur;
                    cur -= distance;
                    end = cur;
                    list.add(new Segment(end, start));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + direction);
            }
        }

        for (Segment s : list) {
            for (int i = s.start; i < s.end; i++) {
                visited[i]++;
            }
        }

        int count = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] >= 2) {
                count++;
            }
        }
        System.out.println(count);
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