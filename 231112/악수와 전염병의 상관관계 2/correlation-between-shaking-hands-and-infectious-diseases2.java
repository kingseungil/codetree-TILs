import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Handshake {

    int time;
    int x;
    int y;

    public Handshake(int time, int x, int y) {
        this.time = time;
        this.x = x;
        this.y = y;
    }
}

class Developer {

    int idx;
    int isInfect;
    int infectionCount;

    Developer(int idx) {
        this.idx = idx;
        this.isInfect = 0;
        this.infectionCount = 0;
    }

    void infect() {
        this.isInfect = 1;
    }

    boolean canInfect(int K) {
        return this.isInfect == 1 && this.infectionCount < K;
    }

    void increaseInfectionCount() {
        this.infectionCount++;
    }
}

public class Main {

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        int N = rd.nextInt(); // N명
        int K = rd.nextInt(); // K번 악수동안만 전염병 옮김
        int P = rd.nextInt(); // 처음 전염병 걸린 개발자 번호
        int T = rd.nextInt(); // T번 악수

        Developer[] developers = new Developer[N + 1];
        for (int i = 1; i <= N; i++) {
            developers[i] = new Developer(i);
        }
        developers[P].infect();

        List<Handshake> handshakes = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            int t = rd.nextInt(); // 시간
            int x = rd.nextInt(); // 개발자 x
            int y = rd.nextInt(); // 개발자 y

            handshakes.add(new Handshake(t, x, y));
        }

        handshakes.sort(Comparator.comparingInt(h -> h.time));

        for (Handshake handshake : handshakes) {
            Developer x = developers[handshake.x];
            Developer y = developers[handshake.y];

            if (x.canInfect(K)) {
                if (y.isInfect == 1) { // 둘 다 감염
                    x.increaseInfectionCount();
                    y.increaseInfectionCount();
                } else { // x만 감염
                    x.increaseInfectionCount();
                    y.infect();
                }
            } else if (y.canInfect(K)) {
                if (x.isInfect == 1) { // 둘 다 감염
                    x.increaseInfectionCount();
                    y.increaseInfectionCount();
                } else { // y만 감염
                    y.increaseInfectionCount();
                    x.infect();
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(developers[i].isInfect);
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