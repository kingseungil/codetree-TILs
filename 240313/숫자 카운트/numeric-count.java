import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] question;
    static int n;

    public static void main(String[] args) {
        FastReader rd = new FastReader();
        n = rd.nextInt(); // B가 묻는 질문의 수를 입력받음
        question = new int[n][3]; // 질문의 수에 맞게 배열의 크기를 설정
        for (int i = 0; i < n; i++) {
            question[i][0] = rd.nextInt(); // B가 묻는 세자리 수
            question[i][1] = rd.nextInt(); // 1번 카운트
            question[i][2] = rd.nextInt(); // 2번 카운트
        }

        int count = 0; // 가능한 수의 개수를 저장하는 변수
        for (int i = 123; i <= 987; i++) { // 가능한 모든 세자리 수에 대해
            if (check(i)) { // 만약 해당 수가 모든 질문을 만족한다면
                count++; // 가능한 수의 개수를 증가
            }
        }

        System.out.println(count); // 가능한 수의 개수를 출력
    }

    private static boolean check(int num) {
        int[] numArr = new int[3]; // num을 각 자리수별로 분리하여 저장하는 배열
        numArr[0] = num / 100; // 백의 자리
        numArr[1] = (num / 10) % 10; // 십의 자리
        numArr[2] = num % 10; // 일의 자리

        // 각 자리값이 같으면 false
        if (numArr[0] == numArr[1] || numArr[0] == numArr[2] || numArr[1] == numArr[2]) {
            return false;
        }
        // 각 자리에 0이 있으면 false
        if (numArr[0] == 0 || numArr[1] == 0 || numArr[2] == 0) {
            return false;
        }

        for (int i = 0; i < n; i++) { // 모든 질문에 대해
            int[] questionArr = new int[3]; // 질문을 각 자리수별로 분리하여 저장하는 배열
            questionArr[0] = question[i][0] / 100; // 백의 자리
            questionArr[1] = (question[i][0] / 10) % 10; // 십의 자리
            questionArr[2] = question[i][0] % 10; // 일의 자리

            int strike = 0; // 1번 카운트를 저장하는 변수
            int ball = 0; // 2번 카운트를 저장하는 변수
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (numArr[j] == questionArr[k]) { // 만약 num의 j번째 자리와 질문의 k번째 자리가 같다면
                        if (j == k) { // 그리고 그 위치도 같다면
                            strike++; // 1번 카운트 증가
                        } else { // 위치가 다르다면
                            ball++; // 2번 카운트 증가
                        }
                    }
                }
            }
            if (strike != question[i][1]
                    || ball != question[i][2]) { // 만약 1번 카운트와 2번 카운트가 질문의 카운트와 일치하지 않는다면
                return false; // false 반환
            }
        }
        return true; // 모든 질문을 만족하면 true 반환
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