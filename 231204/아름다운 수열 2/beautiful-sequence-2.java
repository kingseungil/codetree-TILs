import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arrA, arrB;
    static Map<Integer, Integer> mapA, mapB; // 수열 A와 B의 원소의 빈도수를 저장할 맵

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        n = rd.nextInt();
        m = rd.nextInt();
        arrA = new int[n];
        arrB = new int[m];
        mapA = new HashMap<>();
        mapB = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arrA[i] = rd.nextInt();
        }
        for (int i = 0; i < m; i++) {
            arrB[i] = rd.nextInt();
            mapB.put(arrB[i], mapB.getOrDefault(arrB[i], 0) + 1);
        }

        int count = 0;
        for (int i = 0; i < Math.min(n,m); i++) {
            mapA.put(arrA[i], mapA.getOrDefault(arrA[i], 0) + 1);
        }
        if (mapA.equals(mapB)) {
            count++;
        }

        for (int i = m; i < n; i++) {
            mapA.put(arrA[i - m], mapA.get(arrA[i - m]) - 1);
            if (mapA.get(arrA[i - m]) == 0) {
                mapA.remove(arrA[i - m]);
            }
            mapA.put(arrA[i], mapA.getOrDefault(arrA[i], 0) + 1);
            if (mapA.equals(mapB)) {
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