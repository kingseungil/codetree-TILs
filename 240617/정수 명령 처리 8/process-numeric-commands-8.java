import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static LinkedList<Integer> linkedList = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();

                if (st.hasMoreTokens()) {
                    int value = Integer.parseInt(st.nextToken());

                    switch (command) {
                        case "push_front":
                            linkedList.addFirst(value);
                            break;
                        case "push_back":
                            linkedList.addLast(value);
                            break;
                    }
                } else {
                    switch (command) {
                        case "pop_front":
                            Integer pollFirst = linkedList.pollFirst();
                            System.out.println(pollFirst);
                            break;
                        case "pop_back":
                            Integer pollLast = linkedList.pollLast();
                            System.out.println(pollLast);
                            break;
                        case "size":
                            int size = linkedList.size();
                            System.out.println(size);
                            break;
                        case "empty":
                            boolean isEmpty = linkedList.isEmpty();
                            System.out.println(isEmpty ? 1 : 0);
                            break;
                        case "front":
                            Integer i1 = linkedList.peekFirst();
                            System.out.println(i1);
                            break;
                        case "back":
                            Integer i2 = linkedList.peekLast();
                            System.out.println(i2);
                            break;
                    }
                }
            }
        }
    }
}