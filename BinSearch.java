import java.util.function.BiFunction;

public class BinSearch {

    private int binSearch(int[] a, int target, char mode, BiFunction<Integer, Integer, Boolean> f) {
        int l = -1;
        int r = a.length;
        while (r > l + 1) {
            int m = l + (r - l) / 2;
            if (f.apply(a[m], target)) {
                r = m;
            } else {
                l = m;
            }
        }
        return mode == 'r' ? r : l;
    }

    // left - левый бин поиск, если элемента нет, то возвращает меньший индекс, на котором он должен быть
    // right - правый бин поиск, если элемента нет, то возвращает больший индекс, на котором он должен быть
    // up - для массива отсортированного по возрастанию
    // down - для массива отсортированного по убыванию

    public int leftSearchUp(int[] a, int target) {
        return binSearch(a, target, 'l', (x, y) -> x > y);
    }

    public int rightSearchUp(int[] a, int target) {
        return binSearch(a, target, 'r', (x, y) -> x >= y);
    }

    public int leftSearchDown(int[] a, int target) {
        return binSearch(a, target, 'l', (x, y) -> x < y);
    }

    public int rightSearchDown(int[] a, int target) {
        return binSearch(a, target, 'r', (x, y) -> x <= y);
    }
}
