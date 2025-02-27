package F_search_sort;
 
/*
 0   1   2   3   4   5   6   7   8   9  10  11  12  13  14
11, 18, 29, 37, 42, 49, 51, 63, 69, 72, 77, 82, 88, 91, 98
 
lowIndex:   5
highIndex: 11
 
int distance = highIndex - lowIndex;  // 6
int halfDistance = distance / 2;      // 3
int middleIndex = lowIndex + halfDistance;
 */
 
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {
                11, 18, 29, 37, 42, 49, 51, 63,
                69, 72, 77, 82, 88, 91, 98
        };
    }
 
    public static int binarySearchIterative(int[] arr, int value) {
        int lowIndex = 0, highIndex = arr.length - 1;
 
        while (lowIndex <= highIndex) {
            // int middleIndex = (lowIndex + highIndex) / 2;
            // works for normal array, but not for really
            // large ones, due to integer overflow.
 
            int distance = highIndex - lowIndex;
            int halfDistance = distance / 2;
            int middleIndex = lowIndex + halfDistance;
 
            if (value == arr[middleIndex]) {
                return middleIndex;
            } else if (value < arr[middleIndex]) {
                highIndex = middleIndex - 1;
            } else { // value > arr[middleIndex]
                lowIndex = middleIndex + 1;
            }
        }
 
        return -1;
    }
 
    public static int binarySearchRecursive(int[] arr, int value) {
        return binarySearchRecursive(arr, value, 0, arr.length - 1);
    }
 
    private static int binarySearchRecursive(int[] arr,
                                            int value,
                                            int lowIndex,
                                            int highIndex) {
        if (lowIndex > highIndex) {
            return -1;
        }
 
        int middleIndex = lowIndex + (highIndex - lowIndex) / 2;
 
        if (value == arr[middleIndex]) {
            return middleIndex;
        } else if (value < arr[middleIndex]) {
            return binarySearchRecursive(arr, value, lowIndex, middleIndex - 1);
        } else { // value > arr[middleIndex]
            return binarySearchRecursive(arr, value, middleIndex + 1, highIndex);
        }
    }
}