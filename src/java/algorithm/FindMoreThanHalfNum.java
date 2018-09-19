package java.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FindMoreThanHalfNum {
    public static int findMoreThanHalfNum(int[] numbers) {
        int length = numbers.length;
        if(length == 0) return 0;

        int count = 1;
        int num = numbers[0];
        for(int i = 1; i < length; i++) {
            if(num == numbers[i])
                count++;
            else count--;
            if(count == 0) {
                num = numbers[i];
                count = 1;
            }
        }

        count = 0;
        for(int i = 0; i < length; i++) {
            if(num == numbers[i])
                count++;
        }
        return count * 2 > length ? num : 0;
    }
    public static int findMoreEqualThanHalfNum(Integer[] numbers) {
        int length = numbers.length;
        List<Integer> list = Arrays.asList(numbers);
        HashSet<Integer> hashSet = new HashSet<>(list);
        for(Integer i : hashSet) {
            int count = 0;
            for(Integer j : list){
                if(i == j) count++;
            }
            if(count * 2 >= length) return i;
        }
        return 0;
    }
}

/*我们把数组想象为一群士兵，这些士兵来自不同阵营，士兵们一个一个走出军营去攻打阵地，
第一个兵占领阵地以后，后面来的兵可能是自己人，也可能不是自己人，是自己人的话，count+1，
不是自己人的话，同归于尽，最后肯定剩下一个人活到最后，但是这个人并不一定属于人最多的那
一个阵营。比如:'3,3,3,1,2,0'，第一个3先上去，第二个3再上去，第三个3再上去，这时候count=3，
后面1上去，3-1=2，2上去，2-1=1，1上去，1-1=0，这时候留在最后的是0，但是0显然不是人数最多
那个阵营的兵，人数最多的那个阵营都被别的阵营消耗掉了。如果出场顺序变为:'3,1,3,3,2,0'，
那最后留下的人就是3，但是3个3并没有> (6/2)。如果3的数量再多一个，那么不论怎么出场，
最后剩下的就是3，毕竟人多，与一半的人同归于尽后总会剩下人的，这时候显然4个3>(7/2)。*/