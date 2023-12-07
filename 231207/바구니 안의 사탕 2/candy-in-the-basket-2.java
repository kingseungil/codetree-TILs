import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static Candy[] candies;

    static int bestLocation = 0; // 중심점

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        n = rd.nextInt();
        k = rd.nextInt();
        candies = new Candy[n];

        for (int i = 0; i < n; i++) {
            candies[i] = new Candy();
            candies[i].setCount(rd.nextInt());
            candies[i].setLocation(rd.nextInt());
        }

        Arrays.sort(candies);

        // 0~200까지의 위치에 대해 최대값을 구한다.
        int max = 0;
        for (int i = 0; i <= 200; i++) {
            int start = bestLocation - k;
            int end = bestLocation + k;
            if (start < 0) {
                bestLocation++;
                continue;
            }

            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (candies[j].location >= start && candies[j].location <= end) {
                    sum += candies[j].count;
                }
            }
            max = Math.max(max, sum);
            bestLocation++;
        }
        System.out.println(max);
    }

    static class Candy implements Comparable<Candy> {

        private int count;
        private int location;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getLocation() {
            return location;
        }

        public void setLocation(int location) {
            this.location = location;
        }


        @Override
        public String toString() {
            return
              "{count=" + count + ", location=" + location + '}';
        }

        @Override
        public int compareTo(Candy o) {
            return this.location - o.location; // 오름차순
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