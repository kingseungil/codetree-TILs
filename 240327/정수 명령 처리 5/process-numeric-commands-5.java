import java.io.*;
import java.util.*;

public class Main {
    
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String first = st.nextToken();

            switch (first) {
                case "push_back":
                    list.add(Integer.parseInt(st.nextToken()));
                    break;
                case "get":
                    int index = Integer.parseInt(st.nextToken());
                    System.out.println(list.get(index-1));
                    break;
                case "pop_back":
                    int lastIdx = list.size() - 1;
                    list.remove(lastIdx);
                    break;
                case "size":
                    System.out.println(list.size());
                    break;
            }
        }
    }
}