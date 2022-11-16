package timberproblem;


public class Timber {

    public int[] segments;

    public Timber(int[] segs) {
        segments = segs;        
    }


    int solve(int i, int j) {
        if(i == j) { 
            return segments[i];
        } else if(j == (i + 1)) {
            int[] temp_segs = {segments[i],segments[j]};
            int[] max_of_ij = Helper.max_of_arr(temp_segs);
            return max_of_ij[1];
        }
        int[] two_cases = {
            (segments[i] + Helper.min_of_two(solve(i+2,j),solve(i+1,j-1))),
            (segments[j] + Helper.min_of_two(solve(i+1,j-1),solve(i,j-2)))
        };
        int[] max = Helper.max_of_arr(two_cases);
        return max[1]
;    }

    public static void main(String args[]) {
        int[] segments = {33,28,35,23,23,25,37,40,42,24,38,29,22,40,36,42,39,37,45,32};
        //{33,28,35,25,29,34,28,32};
        int i = 0;
        int j = segments.length-1;

        Timber timber = new Timber(segments);
        int max1 = timber.solve(i,j);
        System.out.println(max1);
        TimberTable timberTable = new TimberTable(segments);
        Helper.print_line();
        int max2 = timberTable.solve(i,j);
        System.out.println(max2);
        timberTable.print_table();
    }
}
