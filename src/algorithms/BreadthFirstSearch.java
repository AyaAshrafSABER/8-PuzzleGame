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
        startTime  = System.nanoTime();
        PuzzleStateNode root = new PuzzleStateNode(initialState);
        this.frontier.add(root);
        System.out.println("Expanded Nodes");
        while(!this.frontier.isEmpty()){
            PuzzleStateNode curr = (PuzzleStateNode)((ArrayDeque)this.frontier).pollFirst();
            explored.add(curr);
            curr.state.printConfiguration();
            searchDepth = Math.max(searchDepth, curr.getDepth());   // Update maximum depth
            if(curr.matches(goalState)){
                goal = curr;
                endTime = System.nanoTime();

                return true;
            }
            for (PuzzleStateNode node: curr.neighbors()) {
                if (!frontier.contains(node) && !explored.contains(node))
                    ((ArrayDeque)this.frontier).addLast(node);
            }
        }
        endTime = System.nanoTime();
        return false;
    }

}