package algorithms;

import heuristics.HeuristicEvaluator;
import puzzle.PuzzleState;
import puzzle.PuzzleStateNode;

import java.util.PriorityQueue;

public class AStarSearch extends AbstractTreeSearch {
    HeuristicEvaluator heuristicEvaluator;

    public AStarSearch(HeuristicEvaluator heuristicEvaluator) {
        super();
        this.frontier = new PriorityQueue<>();
        this.heuristicEvaluator = heuristicEvaluator;
    }

    @Override
    public boolean search(PuzzleState initialState, PuzzleState goalState) {
        PuzzleStateNode p = new PuzzleStateNode(initialState);
        // TODO
        return false;
    }
}

