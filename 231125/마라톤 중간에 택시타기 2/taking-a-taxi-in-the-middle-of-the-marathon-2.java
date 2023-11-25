import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<String> checkPoint;

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        N = rd.nextInt();

        checkPoint = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            checkPoint.add(rd.nextLine());
        }

        // 시작과 끝 체크포인트를 제외하고 하나씩 제외해보면서 거리 구하기
        int minDistance = Integer.MAX_VALUE;
        for (int i = 1; i < N - 1; i++) {
            int distance = 0;
            // 복사본 생성
            List<String> copyCheckPoint = new ArrayList<>(checkPoint);
            // i번째 체크포인트를 제외하고 거리 구하기
            copyCheckPoint.remove(i);
            for (int j = 0; j < copyCheckPoint.size() - 1; j++) {
                distance += getDistance(copyCheckPoint.get(j), copyCheckPoint.get(j + 1));
            }
            minDistance = Math.min(minDistance, distance);
        }

        System.out.println(minDistance);
    }

    private static int getDistance(String start, String end) {
        int startX = Integer.parseInt(start.split(" ")[0]);
        int startY = Integer.parseInt(start.split(" ")[1]);
        int endX = Integer.parseInt(end.split(" ")[0]);
        int endY = Integer.parseInt(end.split(" ")[1]);

        return Math.abs(startX - endX) + Math.abs(startY - endY);
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