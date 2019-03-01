import java.util.*;

/**
 * SetOperations
 */
public class Operations {
    public static Set<String> intersection(Set<String> a, Set<String> b) {
        Set<String> tags = new HashSet<String>();
        tags.addAll(a);
        tags.retainAll(b);
        return tags;
    }

    public static  Set<String> union(Set<String> a, Set<String> b) {
        Set<String> tags = new HashSet<String>();
        tags.addAll(a);
        tags.addAll(b);
        return tags;
    }
    
    public static  Set<String> a_b(Set<String> a, Set<String> b) {
        Set<String> tags = new HashSet<String>(); // a-b
        tags.addAll(a);
        tags.removeAll(b);
        return tags;
    }

    public static  Set<String> b_a(Set<String> a, Set<String> b) {
        Set<String> tags = new HashSet<String>();// b-a
        tags.addAll(b);
        tags.removeAll(a);
        return tags;
    }

    public static int minInterest(Set<String> a, Set<String> b) {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(intersection(a, b).size());
        scores.add(a_b(a, b).size());
        scores.add(b_a(a, b).size());
        return Collections.min(scores);
    }

    // Takes an array and forms a 2d array from it with cells as the min score
    public static Integer[][] tabulate(ArrayList<Image> images) {
        Integer table[][] = new Integer[images.size()][images.size()];
        
        for (int row = 0; row < images.size(); row++) {
            for (int col = 0; col < images.size(); col++) {
                // Can optimise: min of row x col y is same as min of row y col x
                table[row][col] = row==col ? -1 : Operations.minInterest(images.get(row).getTags(), images.get(col).getTags());
            }
        }

        return table;
    }

    public static ArrayList<String> formSlideShow(Integer[][] table, ArrayList<Image> images) {
        ArrayList<String> result = new ArrayList<>();
        int x=0, y=0, max=0;
        int score=0;
        // for a start, we need to find the max score in the array
        for (int row = 0; row < images.size(); row++) {
            for (int col = row; col < images.size(); col++) {
                if(table[row][col]>max) {
                    max=table[row][col];
                    x=row;
                    y=col;
                }
            }
        }

        result.add(images.get(x).getId());
        result.add(images.get(y).getId());
        System.out.println("ID: "+x+" \tscore: "+0);
        System.out.println("ID: "+y+" \tscore: "+table[x][y]);
        table[x][y]=-1;
        score+=max;

        // and now, jump to the row corresponding to the previous col an find max
        while(result.size()<images.size()) {
            x=y;
            max=-1;
            for (int i = 0; i < images.size(); i++) {
                if(table[x][i]>max) {
                    max=table[x][i];
                    y=i;
                }
            }
            if(!result.contains(images.get(y).getId())) {
                System.out.println("ID: "+y+" \tscore: "+max);
                score+=max;
                result.add(images.get(y).getId());
                table[x][y]=-1;
            }
        }
        System.out.println("Score: "+score);
        return result;
    }
}