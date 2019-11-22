package heuristics;

import puzzle.PuzzleState;

public class ManhattanHeuristic implements HeuristicEvaluator {

    private int[][] coordinates = {{0, 0}, {0, 1}, {0, 2},
            {1, 0}, {1, 1}, {1, 2},
            {2, 0}, {2, 1}, {2, 2}};

    @Override
    public double evaluate(PuzzleState state) {
        state.printConfiguration();
        int[] currentState = state.getConfiguration();
        double cost = 0;
        for (int i = 0; i < currentState.length; i++) {
            cost += (Math.pow(Math.abs((i / 3) - coordinates[currentState[i]][0]), 2)
                    + Math.pow(Math.abs((i % 3) - coordinates[currentState[i]][1]), 2));
        }
        return cost;
    }
}
