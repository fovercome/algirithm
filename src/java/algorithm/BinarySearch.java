package java.algorithm;

public class BinarySearch {
    public static int binarySearchDif(Integer[] numbers, int key) {
        int length = numbers.length;
        int l = 0;
        int h = length - 1;
        while(l <= h) {
            int m = l + (h - l) / 2;
            if(numbers[m] == key) return m;
            else if(numbers[m] > key) h = m - 1;
            else l = m + 1;
        }
        return -1;
    }
    public static int binarySearchSam(int[] nums, int key){
        int l = 0;
        int h = nums.length - 1;
        while(l < h){
            int m = l + (h - l) / 2;
            if(nums[m] >= key) h = m;
            else l = m + 1;
        }
        return l;
    }
}
