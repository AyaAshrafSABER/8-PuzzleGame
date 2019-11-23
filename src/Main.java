import algorithms.AStarSearch;
import heuristics.EuclideanHeuristic;
import puzzle.PuzzleState;

public class Main {
    public static void main(String args[]) {
//        102435678
//        458106732
//        508421736
        int[] initialState = {4, 5, 8, 1, 0, 6, 7, 3, 2};
        int[] goalState = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        AStarSearch aStar = new AStarSearch(new EuclideanHeuristic());
        if (aStar.search(new PuzzleState(initialState), new PuzzleState(goalState))) {
            System.out.println("Success!");
        } else {
            System.out.println("Failure");
        }


    }

}
