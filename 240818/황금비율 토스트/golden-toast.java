import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
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

            ListIterator<Character> iterator = states.listIterator(pointer);

            for (int i = 0; i < m; i++) {
                String recipe = br.readLine();
                char command = recipe.charAt(0);

                switch (command) {
                    case 'L':
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                        }
                        break;
                    case 'R':
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                        break;
                    case 'D':
                        if (iterator.hasNext()) {
                            iterator.next();
                            iterator.remove();
                        }
                        break;
                    case 'P':
                        char newBread = recipe.charAt(2);
                        iterator.add(newBread);
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