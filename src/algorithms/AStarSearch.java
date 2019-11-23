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
        System.out.println("Initial State:");
        initialState.printConfiguration();
        this.frontier.add(new PuzzleStateNode(initialState, heuristicEvaluator));
        long startTime = System.nanoTime();
        while (!this.frontier.isEmpty()) {
            PuzzleStateNode state = (PuzzleStateNode) ((PriorityQueue)frontier).poll();
            System.out.println("Current State: depth = " + state.getDepth() + ", cost (f = h + g) = " + state.getCost());
            state.state.printConfiguration();
            this.explored.add(state);
            if (state.matches(goalState)) {
                long endTime   = System.nanoTime();
                long totalTime = (endTime - startTime)/1000000;
                System.out.println(" ------------------------------- Depth of the solution path = " + state.getDepth());
                printSolPath(state);
                System.out.println("Running time = " + totalTime + " msec");
                return true;
            }
            for (PuzzleStateNode neighbor: state.neighbors(heuristicEvaluator)) {
                System.out.println("Neighbor: depth = " + neighbor.getDepth() + ", cost (f = h + g) = " + neighbor.getCost());
                neighbor.state.printConfiguration();
                if (!explored.contains(neighbor) && !frontier.contains(neighbor)) {
                    frontier.add(neighbor);
                } else if (frontier.contains(neighbor)) {
                    Object[] arr = frontier.toArray();
                    for (Object element : arr) {
                        if (((PuzzleStateNode)element).equals(neighbor)) {
                            if (((PuzzleStateNode)element).getCost() > neighbor.getCost()) {
                                frontier.remove((PuzzleStateNode) element);
                                frontier.add(neighbor);
                            }
                            break;
                        }
                    }
                }
            }

        }
        long endTime   = System.nanoTime();
        long totalTime = (endTime - startTime)/1000000;
        System.out.println("Running time = " + totalTime + " msec");
        return false;
    }

    private void printSolPath(PuzzleStateNode finalState) {
        if (finalState.parent == null) {
            System.out.println("Cost = " + finalState.getCost());
            finalState.state.printConfiguration();
            return;
        }
        printSolPath(finalState.parent);
        System.out.println("Cost = " + finalState.getCost());
        finalState.state.printConfiguration();
    }
}

