import algorithms.AStarSearch;
import heuristics.ManhattanHeuristic;
import puzzle.PuzzleState;

public class Main {
    public static void main(String args[]) {
//        102435678 actual cost = 1
//         458106732 acutal cost =
        int[] initialState = {4, 5, 8, 1, 0, 6, 7, 3, 2};
        int[] goalState = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        AStarSearch aStar = new AStarSearch(new ManhattanHeuristic());
        if (aStar.search(new PuzzleState(initialState), new PuzzleState(goalState))) {
            System.out.println("Success!");
        } else {
            System.out.println("Failure");
        }


    }

}
