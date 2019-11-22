package heuristics;

import puzzle.PuzzleState;

public interface HeuristicEvaluator {
    public int evaluate(PuzzleState state);
}
