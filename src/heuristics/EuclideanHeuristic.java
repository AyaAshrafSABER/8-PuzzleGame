package heuristics;

import puzzle.PuzzleState;

public class EuclideanHeuristic implements HeuristicEvaluator {

    private int[][] coordinates = {{0, 0}, {0, 1}, {0, 2},
            {1, 0}, {1, 1}, {1, 2},
            {2, 0}, {2, 1}, {2, 2}};

    @Override
    public int evaluate(PuzzleState state) {
        state.printConfiguration();
        int[] currentState = state.getConfiguration();
        int minimumCost = Integer.MAX_VALUE;
        int cost;
        for (int i = 0; i < currentState.length; i++) {
            cost = (int)Math.sqrt(Math.pow(Math.abs((i / 3) - coordinates[currentState[i]][0]), 2)
                    + Math.pow(Math.abs((i % 3) - coordinates[currentState[i]][1]), 2));
            if (cost < minimumCost) {
                minimumCost = cost;
            }
        }
        return minimumCost;
    }
}
