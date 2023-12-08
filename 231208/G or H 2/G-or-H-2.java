import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static People[] people;

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        n = rd.nextInt();
        people = new People[n];

        for (int i = 0; i < n; i++) {
            people[i] = new People(rd.nextInt(), rd.next().charAt(0));
        }
        Arrays.sort(people);

        int max = getMax();
        System.out.println(max);
    }

    private static int getMax() {
        int maxSize = 0;
        for (int start = 0; start < n; start++) {
            for (int end = start + 1; end < n; end++) {
                if (isSameCount(start, end)) {
                    int size = people[end].location - people[start].location;
                    maxSize = Math.max(maxSize, size);
                }
            }
        }
        return maxSize;
    }

    private static boolean isSameCount(int start, int end) {
        int gCount = 0;
        int hCount = 0;
        for (int i = start; i <= end; i++) {
            if (people[i].alpha == 'G') {
                gCount++;
            } else {
                hCount++;
            }
        }
        return gCount == hCount;
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