import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] visited = new int[10000][3]; // (검은색 수, 흰색 수, 현재 색상)

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

        // 검정 : 1, 흰색 : 2, 회색 : 3
        for (Segment s : list) {
            switch (s.direction) {
                case "R":
                    for (int i = s.start; i <= s.end; i++) {
                        visited[i][0]++; // 검은색으로 칠한 횟수 증가
                        if (visited[i][0] >= 2 && visited[i][1] >= 2) {
                            visited[i][2] = 3; // 흰색과 검은색으로 각각 두 번 이상 칠해진 경우 회색으로 바꿈
                        } else {
                            visited[i][2] = 1; // 그 외의 경우는 검은색으로 바꿈
                        }
                    }
                    break;
                case "L":
                    for (int i = s.start; i >= s.end; i--) {
                        visited[i][1]++; // 흰색으로 칠한 횟수 증가
                        if (visited[i][0] >= 2 && visited[i][1] >= 2) {
                            visited[i][2] = 3; // 흰색과 검은색으로 각각 두 번 이상 칠해진 경우 회색으로 바꿈
                        } else {
                            visited[i][2] = 2; // 그 외의 경우는 흰색으로 바꿈
                        }
                    }
                    break;
            }
        }

        int black = 0, white = 0, grey = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i][2] == 1) {
                black++;
            } else if (visited[i][2] == 2) {
                white++;
            } else if (visited[i][2] == 3) {
                grey++;
            }
        }
        System.out.println(white + " " + black + " " + grey);
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

