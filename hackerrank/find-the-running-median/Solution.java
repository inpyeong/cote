import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> result = new LinkedList<>();
        List<Integer> sorted = new LinkedList<>();

        for (int idx = 0; idx < a.size(); ++idx) {
            int i = a.get(idx);
            sorted.add(i);
        }

        Collections.sort(sorted);

        for (int idx = a.size() - 1; idx >= 0; --idx) {
            int i = a.get(idx);

            boolean odd = sorted.size() % 2 == 1;
            Double median = null;

            if (odd) {
                int mid = sorted.size() / 2;
                median = (double) sorted.get(mid);    
            } else {
                int le = sorted.size() / 2 - 1;
                int ri = le + 1;

                median = (double) (sorted.get(le) + sorted.get(ri)) / 2;
            }

            result.add(median);
            sorted.remove(binarySearch(sorted, i));
        }

        processDecimalPlace(result);
        Collections.reverse(result);

        return result;
    }

    public static void processDecimalPlace(List<Double> target) {
        for (int i = 0; i < target.size(); ++i) {
            BigDecimal bd = new BigDecimal(target.get(i));
            bd.setScale(1, RoundingMode.DOWN);

            target.set(i, bd.doubleValue());
        }
    }

    public static int binarySearch(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Prevents overflow

            if (arr.get(mid) == target) {
                return mid; // Element found
            }

            if (arr.get(mid) < target) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }

        return -1; // Element not found
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Double> result = Result.runningMedian(a);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

