import java.util.*;;

public class bubbleSort {
    public static int bubblesort(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;

                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            count++;
        }
        return count;
    }

    public static void bubblesortDesc(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;

                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = {70, 20, 50, 30, 90, 5, 15 };
       int noOfPasses = bubblesort(arr);
        System.out.println("after bubble ascending sorting the array is: " + Arrays.toString(arr) + "No of passes: "+ noOfPasses);
        System.out.println("*********************************");
        bubblesortDesc(arr);
        System.out.println("after bubble descending sorting the array is: " + Arrays.toString(arr));
    }
}




//time complexity: O(n^2)