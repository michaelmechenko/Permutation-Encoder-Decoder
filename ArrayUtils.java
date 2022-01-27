import java.util.*;
import java.util.function.Function;

public class ArrayUtils {
  // swaps the elements of two indices in a list
  <T> void swap(ArrayList<T> arr, int index1, int index2) {
    arr.set(index2, arr.set(index1, arr.get(index2)));
  }

  // maps the given function on every element of the list
  <T, U> ArrayList<U> map(ArrayList<T> arr, Function<T, U> func) {
    ArrayList<U> result = new ArrayList<U>();
    for (T t : arr) {
      result.add(func.apply(t));
    }
    return result;
  }
}
