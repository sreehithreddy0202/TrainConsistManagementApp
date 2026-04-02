import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Before Sorting: " + Arrays.toString(capacities));

        bubbleSort(capacities);

        System.out.println("After Bubble Sort: " + Arrays.toString(capacities));
    }

    // UC16: Manual Bubble Sort Algorithm
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // If the left element is greater than the right, swap them
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}