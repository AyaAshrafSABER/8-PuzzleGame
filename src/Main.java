import algorithms.AStarSearch;
import algorithms.BreadthFirstSearch;
import algorithms.DepthFirstSearch;
import heuristics.EuclideanHeuristic;
import puzzle.PuzzleState;

public class Main {
    public static void main(String args[]) {
//        102435678
//        458106732
//        508421736
//        int[] initialState = {4, 5, 8, 1, 0, 6, 7, 3, 2};
//        int[] initialState = {1, 0, 2, 3, 4, 5, 6, 7, 8};
        int[] initialState = {1,2,5,3,4,0,6,7,8};
        int[] goalState = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("************A**********");
        AStarSearch aStar = new AStarSearch(new EuclideanHeuristic());
        if (aStar.search(new PuzzleState(initialState), new PuzzleState(goalState))) {
            System.out.println("Success!");
        } else {
            System.out.println("Failure");
        }

        System.out.println("************BFS*********");
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        if (bfs.search(new PuzzleState(initialState), new PuzzleState(goalState))) {
            System.out.println("Success!");
        } else {
            System.out.println("Failure");
        }

        System.out.println("************DFS*********");
        DepthFirstSearch dfs = new DepthFirstSearch();
        if (dfs.search(new PuzzleState(initialState), new PuzzleState(goalState))) {
            System.out.println("Success!");
        } else {
            System.out.println("Failure");
        }

    }

}
