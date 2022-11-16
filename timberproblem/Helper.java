package timberproblem;

public class Helper {
    
    public Helper() {

    }

    public static int[] max_of_arr(int[] arr) {
        int max = 0, index = 0, i = 0;
        for(int item : arr) {
            if(item > max) {
                max = item;
                index = i;
            }
            i++;
        }
        int[] toReturn = {index,max};
        return toReturn;
    }

    public static int min_of_two(int one, int two) {
        if(one <= two) {
            return one;
        }
        return two;
    }

    public static void print_line() {
        System.out.println("-----------------------------------------------------------");
    }
}
