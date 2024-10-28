public class MaxElement {
    public static <T extends Comparable<T>> T findMax(T[] array) { // Ограничивает T типами, которые реализуют Comparable
        T max = array[0];
        for (T element : array) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }
}
