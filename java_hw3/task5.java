// При входном массиве, вернуть массив массивов со всеми перестановками его элементов.
// Пример входных данных: [1,2,3];
// Пример выходных данных:[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]].
public class task5{
public static String[][] getAllPermutations(String[] str) {
    LinkedList<Integer> current = new LinkedList<>();
    LinkedList<Integer[]> permutations = new LinkedList<>();

    int length = str.length;
    current.add(-1);

    while (!current.isEmpty()) {
        int position = Integer.MAX_VALUE;
        position = getNextUnused(current, current.pop() + 1);
        while (position >= length && !current.isEmpty()) {
            position = getNextUnused(current, current.pop() + 1);
        }
        if (position < length) {
            current.push(position);
        } else {
            break;
        }

        while (current.size() < length) {
            // find first unused index.
            int unused = getNextUnused(current, 0);

            current.push(unused);
        }
        permutations.add(current.toArray(new Integer[0]));
    }

    int numPermutations = permutations.size();
    String[][] result = new String[numPermutations][length];
    for (int i = 0; i < numPermutations; ++i) {
        Integer[] indexes = permutations.get(i);
        String[] row = new String[length];
        for (int d = 0; d < length; ++d) {
            row[d] = str[indexes[d]];
        }
        result[i] = row;
    }

    return result;
}

public static int getNextUnused(LinkedList<Integer> used, Integer current) {
    int unused = current != null ? current : 0;
    while (used.contains(unused)) {
        ++unused;
    }
    return unused;
}
}
