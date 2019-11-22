package algorithms;

import heuristics.HeuristicEvaluator;
import puzzle.PuzzleState;
import puzzle.PuzzleStateNode;

import java.util.PriorityQueue;

public class AStarSearch extends AbstractTreeSearch {
    HeuristicEvaluator heuristicEvaluator;

    public AStarSearch(HeuristicEvaluator heuristicEvaluator) {
        super();
        this.frontier = new PriorityQueue<PuzzleStateNode>();
        this.heuristicEvaluator = heuristicEvaluator;
    }

    @Override
    public boolean search(PuzzleState initialState, PuzzleState goalState) {
        this.frontier.add(new PuzzleStateNode(initialState));
        while (!this.frontier.isEmpty()) {
            PuzzleStateNode state = (PuzzleStateNode) ((PriorityQueue)frontier).poll();
            this.explored.add(state);
            if (state.matches(goalState)) {
                return true;
            }
            for (PuzzleStateNode neighbor: state.neighbors()) {
                if (!explored.contains(neighbor) && !frontier.contains(neighbor)) {
                    frontier.add(neighbor);
                } else if (frontier.contains(neighbor)) {
                    
                }
            }

        }
        return false;
    }
}

