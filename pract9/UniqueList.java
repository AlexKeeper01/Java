import java.util.ArrayList;

public class UniqueList {
    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {
        ArrayList<T> result = new ArrayList<>();
        for (T element : list) {
            if (!result.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }
}
