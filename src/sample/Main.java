package sample;

import algorithms.BreadthFirstSearch;
import algorithms.DepthFirstSearch;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import puzzle.PuzzleState;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("8 Puzzle Solver");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        int[] configInt = new int[]{1,4,2,3,0,5,6,7,8};
        int[] configfinal = new int[]{0,1,2,3,4,5,6,7,8};

        launch(args);
        PuzzleState state = new PuzzleState(configInt);
        PuzzleState fState = new PuzzleState(configfinal);
        DepthFirstSearch s = new DepthFirstSearch();
        BreadthFirstSearch b = new BreadthFirstSearch();
        s.search(state,fState);
        //b.search(state,fState);

    }
}
