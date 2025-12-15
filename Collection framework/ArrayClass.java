import java.util.Arrays;

public class ArrayClass {
    public static void main(String[] args) {
        int[]  num = {1,2,3,4,5,6,7,8,9};
        // to search a number in an array
        int index = Arrays.binarySearch(num, 10);

        System.out.println(index);

        Integer[] numbers = {10,58,96,36,77,12,89};
        Arrays.sort(num);


        // this is mostly used in dp when we have to initially assign -1 to all the index
        // for this altenative we use the for loop
        Arrays.fill(numbers, 12);
        for(int i:num){
            System.out.print(i + " ");
        }
    }
}
