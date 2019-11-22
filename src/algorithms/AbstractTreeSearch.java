package algorithms;

import javafx.util.Pair;
import puzzle.PuzzleState;
import puzzle.PuzzleStateNode;

import java.util.Collection;
import java.util.HashMap;

public abstract class AbstractTreeSearch {
    Collection<PuzzleStateNode> frontier;

    public abstract boolean search(PuzzleState initialState, PuzzleState goalState);

}
