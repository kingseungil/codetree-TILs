import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Map<Integer, Integer> room = new HashMap<>();


    public static void main(String[] args) {
        FastReader rd = new FastReader();
        N = rd.nextInt();
        for (int i = 1; i <= N; i++) {
            room.put(i, rd.nextInt());
        }

        int minDistance = Integer.MAX_VALUE;
        for (int start = 1; start <= N; start++) {
            int currentDistance = 0;
            for (int current = 1; current <= room.size(); current++) {
                currentDistance += getDistance(start, current, room.get(current));
            }
            minDistance = Math.min(minDistance, currentDistance);
        }

        System.out.println(minDistance);
    }

    private static int getDistance(int startRoomNumber, int currentRoomNumber, int movingPeople) {
        if (startRoomNumber > currentRoomNumber) {
            return Math.abs(N - startRoomNumber + currentRoomNumber) * movingPeople;
        } else {
            return Math.abs(currentRoomNumber - startRoomNumber) * movingPeople;
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