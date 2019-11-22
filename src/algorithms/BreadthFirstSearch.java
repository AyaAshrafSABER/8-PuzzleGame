package algorithms;

import puzzle.PuzzleState;
import puzzle.PuzzleStateNode;

import java.util.ArrayDeque;

public class BreadthFirstSearch extends AbstractTreeSearch {

    public BreadthFirstSearch() {
        super();
        this.frontier = new ArrayDeque<>();
    }

    @Override
    public boolean search(PuzzleState initialState, PuzzleState goalState) {
        PuzzleStateNode root = new PuzzleStateNode(initialState);
        this.frontier.add(root);
        while(!this.frontier.isEmpty()){
            PuzzleStateNode curr = (PuzzleStateNode)((ArrayDeque)this.frontier).pollFirst();
            explored.add(curr);
            curr.state.printConfiguration();
            if(curr.matches(goalState)){
                return true;
            }
            for (PuzzleStateNode node: curr.neighbors()) {
                if (!frontier.contains(node) && !explored.contains(node))
                    ((ArrayDeque)this.frontier).addLast(node);
            }
        }
        return false;
    }

}