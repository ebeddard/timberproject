package timberproblem;


public class TimberTable {
    int[] segments;
    int[][] table;
    int length;

    public TimberTable(int[] segs) {
        segments = segs;
        length = segments.length;
        this.initialize();
    }

    public void initialize() {
        table = new int[length][length];
        for(int i = 0; i < length; i++) {
            table[i][i] = segments[i];
            if(i < length-1) {
                if(segments[i] >= segments[i + 1]) {
                    table[i][i+1] = segments[i];
                } else {
                    table[i][i+1] = segments[i+1];
                }
            }
        }
    }

    public int solve(int i, int j) {
        if(i == j) {
            table[i][j] = segments[i];
            return segments[i];
        } else if(j == i + 1) {
            if(segments[i] >= segments[j]) {
                table[i][j] = segments[i];
                return segments[i];
            } else {
                table[i][j] = segments[i];
                return segments[j];
            }
        }
        int[] two_cases = {
            (segments[i] + Helper.min_of_two(solve(i+2,j),solve(i+1,j-1))),
            (segments[j] + Helper.min_of_two(solve(i+1,j-1),solve(i,j-2)))
        };
        int[] max = Helper.max_of_arr(two_cases);
        if(max[0] == 0) {
            table[i][j] = segments[i] + Helper.min_of_two(solve(i+2,j),solve(i+1,j-1));
        } else {
            table[i][j] = segments[j] + Helper.min_of_two(solve(i+1,j-1),solve(i,j-2));
        }
        return max[1];
    }

    public void print_table() {
        for(int[] line : table) {
            for(int item : line) {
                System.out.printf("%4d", item);
            }
            System.out.println();
        }
    }

    public int get_max(int i, int j) {
        int max = 0;
        return max;
    }

    
}
