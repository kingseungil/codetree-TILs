import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr1 = new int[3];
    static int[] arr2 = new int[3];

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        n = rd.nextInt();
        for (int i = 0; i < 3; i++) {
            arr1[i] = rd.nextInt();
        }
        for (int i = 0; i < 3; i++) {
            arr2[i] = rd.nextInt();
        }

        // 첫번째 조합에서 가능한 숫자들
        List<List<Integer>> lists = new ArrayList<>();
        // 첫번째 조합에서 가능한 숫자들 채워넣기 (거리가 2 이내인 숫자들)
        for (int i = 0; i < 3; i++) {
            List<Integer> list = new ArrayList<>();
            generateValidNum(list, arr1[i]);
            lists.add(list);
        }

        // 두번째 조합에서 가능한 숫자들
        List<List<Integer>> lists2 = new ArrayList<>();
        // 두번째 조합에서 가능한 숫자들 채워넣기 (거리가 2 이내인 숫자들)
        for (int i = 0; i < 3; i++) {
            List<Integer> list = new ArrayList<>();
            generateValidNum(list, arr2[i]);
            lists2.add(list);
        }

        // 첫번째 조합 * 두번째 조합 - 중복되는 경우의 수
        int comb1 = lists.get(0).size() * lists.get(1).size() * lists.get(2).size();
        int comb2 = lists2.get(0).size() * lists2.get(1).size() * lists2.get(2).size();
        int comb = comb1 + comb2;

        // 중복되는 경우의 수를 빼준다.
        int overlap = 1;
        for (int i = 0; i < 3; i++) {
            List<Integer> list1 = lists.get(i);
            List<Integer> list2 = lists2.get(i);
            list1.retainAll(list2);
            overlap *= list1.size();
        }

        comb -= overlap;
        System.out.println(comb);
    }

    private static void generateValidNum(List<Integer> list, int num) {
        list.add((num - 2 + n - 1) % n + 1);
        list.add((num - 1 + n - 1) % n + 1);
        list.add(num);
        list.add((num + 1 - 1) % n + 1);
        list.add((num + 2 - 1) % n + 1);
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