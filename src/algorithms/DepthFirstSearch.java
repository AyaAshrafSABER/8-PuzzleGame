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
        startTime = System.nanoTime();
        PuzzleStateNode root = new PuzzleStateNode(initialState);
        this.frontier.add(root);
        System.out.println("Expanded Nodes");
        while(!this.frontier.isEmpty()){
            PuzzleStateNode curr = (PuzzleStateNode)((Stack)frontier).pop();
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
                    ((Stack)frontier).push(node);
            }
        }
        endTime = System.nanoTime();
        return false;
    }
}