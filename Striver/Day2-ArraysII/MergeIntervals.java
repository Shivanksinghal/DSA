import java.util.*;

public class MergeIntervals {
    class Interval implements Comparable<Interval> {
        int start, end; 
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public int compareTo(Interval i) {
            return this.start - i.start;
        }
    }

    public int[][] merge(int[][] intervals) {
        List<Interval> intervalsList = new ArrayList<>();
        for(int i = 0; i < intervals.length; ++i) {
            intervalsList.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(intervalsList);

        List<Interval> merged = new ArrayList<>();
        merged.add(new Interval(intervalsList.get(0).start, intervalsList.get(0).end));
        for(int i = 1; i < intervals.length; ++i) {
            if(intervalsList.get(i).start <= merged.get(merged.size() - 1).end) {
                merged.get(merged.size() - 1).end = Math.max(merged.get(merged.size() - 1).end, intervalsList.get(i).end);
            } else {
                merged.add(intervalsList.get(i));
            }
        }
        int[][] res = new int[merged.size()][2];
        for(int i = 0; i < merged.size(); ++i) {
            res[i][0] = merged.get(i).start;
            res[i][1] = merged.get(i).end;
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] mergeIntervals = new MergeIntervals().merge(intervals);
        for(int i = 0; i < mergeIntervals.length; ++i) {
            for(int j = 0; j < mergeIntervals[i].length; ++j) {
                System.out.print(mergeIntervals[i][j] + " ");
            }
            System.out.println();
        }
    }
}
