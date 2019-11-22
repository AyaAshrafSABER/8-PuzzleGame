package algorithms;

import puzzle.PuzzleState;

import java.util.ArrayDeque;

public class BreadthFirstSearch extends AbstractTreeSearch {

    public BreadthFirstSearch() {
        this.frontier = new ArrayDeque<>();
    }

    @Override
    public boolean search(PuzzleState initialState, PuzzleState goalState) {
        // TODO
        return false;
    }
}
