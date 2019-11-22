package algorithms;

import puzzle.PuzzleState;
import puzzle.PuzzleStateNode;

import java.util.ArrayDeque;
import java.util.Stack;

public class DepthFirstSearch extends AbstractTreeSearch {

    public DepthFirstSearch() {
        super();
        this.frontier = new Stack<>();
    }

    @Override
    public boolean search(PuzzleState initialState, PuzzleState goalState) {
        PuzzleStateNode root = new PuzzleStateNode(initialState);
        this.frontier.add(root);
        while(!this.frontier.isEmpty()){
            PuzzleStateNode curr = (PuzzleStateNode)((Stack)frontier).pop();
            explored.add(curr);
            curr.state.printConfiguration();
            if(curr.matches(goalState)){
                return true;
            }
            for (PuzzleStateNode node: curr.neighbors()) {
                if (!frontier.contains(node) && !explored.contains(node))
                    ((Stack)frontier).push(node);
            }
        }
        return false;
    }
}