import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, h, t;
    static int[] arr;

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        n = rd.nextInt(); // n개의 밭
        h = rd.nextInt(); // h 높이
        t = rd.nextInt(); // t번

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rd.nextInt();
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            int cur = 0;
            int[] curArr = Arrays.copyOf(arr, arr.length);
            for (int j = i; j < n - 1; j++) {
                // curArr에 h인 값이 연속 t개 있는지 확인
                int count = getCount(curArr, h);
                if (count == t) {
                    break;
                }

                // curArr을 완전탐색으로 h로 만들기
                if (curArr[j] < h) {
                    curArr[j] = h;
                    cur = cur + (h - arr[j]);
                } else if (curArr[j] > h) {
                    curArr[j] = h;
                    cur = cur + (arr[j] - h);
                }
            }
            min = Math.min(min, cur);
        }
        System.out.println(min);
    }

    private static int getCount(int[] curArr, int h) {
        int count = 0;
        // 연속으로 h가 존재해야 count 증가
        for (int i = 0; i < curArr.length; i++) {
            if (curArr[i] == h) {
                count++;
            } else {
                count = 0;
            }
        }
        return count;
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