import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            String initialState = br.readLine();
            LinkedList<Character> states = new LinkedList<>();

            for (char c : initialState.toCharArray()) {
                states.add(c);
            }

            int pointer = states.size(); // 처음에는 맨 뒤를 가리킴

            for (int i = 0; i < m; i++) {
                String recipe = br.readLine();
                char command = recipe.charAt(0);

                switch (command) {
                    case 'L':
                        if (pointer > 0) {
                            pointer--;
                        }
                        break;
                    case 'R':
                        if (pointer < states.size()) {
                            pointer++;
                        }
                        break;
                    case 'D':
                        if (pointer < states.size()) {
                            states.remove(pointer);
                        }
                        break;
                    case 'P':
                        char newBread = recipe.charAt(2);
                        states.add(pointer, newBread);
                        pointer++;
                        break;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (char c : states) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}