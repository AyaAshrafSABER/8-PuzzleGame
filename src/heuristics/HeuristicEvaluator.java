package heuristics;

import puzzle.PuzzleState;

public interface HeuristicEvaluator {
    public double evaluate(PuzzleState state);
}
