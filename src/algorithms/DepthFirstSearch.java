package algorithms;

import puzzle.PuzzleState;

import java.util.Stack;

public class DepthFirstSearch extends AbstractTreeSearch {

    public DepthFirstSearch() {
        super();
        this.frontier = new Stack<>();
    }

    @Override
    public boolean search(PuzzleState initialState, PuzzleState goalState) {
        // TODO
        return false;
    }
}
