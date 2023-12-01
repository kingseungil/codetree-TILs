import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int k;
    static People[] people;

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        n = rd.nextInt(); // 사람 수
        k = rd.nextInt(); // 사진 크기
        people = new People[n];
        for (int i = 0; i < n; i++) {
            people[i] = new People(rd.nextInt(), rd.next().charAt(0));
        }
        Arrays.sort(people);

        int maxScore = getMaxScore();
        System.out.println(maxScore);
    }

    private static int getMaxScore() {
        int maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int pictureSize = 0;
            int score = convertToInt(people[i].alpha);
            for (int j = i + 1; j < n; j++) {
                if (pictureSize >= k) {
                    break;
                }
                int size = people[j].location - people[j - 1].location;
                pictureSize += size;
                score += convertToInt(people[j].alpha);
            }
            if (pictureSize == k) {
                maxScore = Math.max(maxScore, score);
            }
        }
        return maxScore;
    }

    private static int convertToInt(char alpha) {
        if (alpha == 'G') {
            return 1;
        } else {
            return 2;
        }
    }

    public static class People implements Comparable<People> {

        private final int location;
        private final char alpha;

        public People(int location, char alpha) {
            this.location = location;
            this.alpha = alpha;
        }

        @Override
        public String toString() {
            return "{location=" + location + ", alpha=" + alpha + "}";
        }

        @Override
        public int compareTo(People p) {
            // 위치 오름차순 정렬
            return this.location - p.location;
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