import javafx.application.Application;
import javafx.collections.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.Pos;

public class Days extends GUI {
	GUI[] g = new GUI[7];
	String[] arg;
	public static void main(String[] args) {

		launch(args);
	}

	public void start(Stage stage) {

		Button b = new Button("Start");
		b.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event2) {
				try {
					g[1].start(stage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		StackPane root = new StackPane();
		root.getChildren().add(b);

		stage.setScene(new Scene(root, 200, 200));
		stage.show();
	}

}
