package leetcode.T100_T200;

public class T167 {

    private static int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while(low<high){
            int sum = numbers[low] + numbers[high];
            if(sum == target){
                return new int[]{low+1, high+1};
            }else if(sum<target){
                ++low;
            }else{
                --high;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        for (int elem : twoSum(new int[]{2, 7, 11, 15}, 9)) {
            System.out.println(elem);
        }
    }

}
