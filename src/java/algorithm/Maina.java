package java.algorithm;
import java.util.Arrays;
import java.util.Scanner;

public class Maina {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int res = 0;
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < 3; i++) {
            num1 += str.charAt(i) - '0';
            num2 += str.charAt(i + 3) - '0';
        }
        int[] nums = new int[3];
        int start = 0;
        if (num1 < num2) {
            start = 0;
        } else
            start = 3;
        for (int i = start; i < start + 3; i++) {
            nums[i - start] = str.charAt(i) - '0';
        }
        Arrays.sort(nums);
        start = 0;
        if (num1 < num2) {
            while (num1 < num2) {
                num1 += 9 - nums[start];
                start++;
                res++;
            }
        }else{
            while(num2<num1){
                num2 += 9 - nums[start];
                start++;
                res++;
            }
        }
        System.out.println(res);

    }

}