import javafx.application.Application;
import javafx.collections.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.chart.*;

public class GUI extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	int typeSort = 1;
	int totalcalories = 0;
	int totalprotein = 0;
	int totalcarbo = 0;
	int totalfat = 0;

	public void start(Stage stage) throws Exception {

		Label goal = new Label("The total amount of calories: " + totalcalories + "/2000\tThe total amount of protein: "
				+ totalprotein + "/100\nThe total amount of carbo: " + totalcarbo + "/300\t\tThe total amount of fat: "
				+ totalfat + "/50");

//////////////////////////////////////////////////////////////////////////////////

		patient.MainMenufood();

		ObservableList<String> AllMealListO = FXCollections.observableArrayList();

		Button increaseSort = new Button("Low to high  Sort");
		increaseSort.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event2) {
				typeSort = 1;
			}
		});

		Button decreseSort = new Button("High to low Sort");
		decreseSort.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event2) {
				typeSort = 2;
			}
		});

		Button NameSort = new Button("Name Sort");
		NameSort.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event2) {
				AllMealListO.remove(0, AllMealListO.size());
				patient.sort2(0, typeSort);
				for (int i = 0; i < patient.food.size(); i++) {
					AllMealListO.add((i + 1) + "\t" + patient.food.get(i).toString2());
				}
			}
		});
		Button caloricSort = new Button("Caloric Sort");
		caloricSort.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event2) {
				AllMealListO.remove(0, AllMealListO.size());
				patient.sort2(1, typeSort);
				for (int i = 0; i < patient.food.size(); i++) {
					AllMealListO.add((i + 1) + "\t" + patient.food.get(i).toString2());
				}
			}
		});
		Button proteinSort = new Button("Protein Sort");
		proteinSort.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event3) {
				AllMealListO.remove(0, AllMealListO.size());
				patient.sort2(2, typeSort);
				for (int i = 0; i < patient.food.size(); i++) {
					AllMealListO.add((i + 1) + "\t" + patient.food.get(i).toString2());
				}
			}
		});

		Button foodOnlyB = new Button("Food Only");
		foodOnlyB.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				AllMealListO.remove(0, AllMealListO.size());
				for (int i = 0; i < patient.food.size(); i++) {
					if (patient.food.get(i).getUnit().equals("g"))
						AllMealListO.add((i + 1) + "\t" + patient.food.get(i).toString2());
				}
			}
		});
		Button beveragesOnlyB = new Button("beverages Only");
		beveragesOnlyB.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				AllMealListO.remove(0, AllMealListO.size());
				for (int i = 0; i < patient.food.size(); i++) {
					if (patient.food.get(i).getUnit().equals("ml"))
						AllMealListO.add((i + 1) + "\t" + patient.food.get(i).toString2());
				}
			}
		});

		VBox sort2 = new VBox();
		sort2.setAlignment(Pos.CENTER);
		sort2.getChildren().add(new Label("Type of sort"));
		sort2.getChildren().add(increaseSort);
		sort2.getChildren().add(decreseSort);
		VBox sort = new VBox();
		sort.getChildren().add(new Label("Kind of sort"));
		sort.setAlignment(Pos.CENTER);
		sort.getChildren().add(NameSort);
		sort.getChildren().add(new Label());
		sort.getChildren().add(caloricSort);
		sort.getChildren().add(new Label());
		sort.getChildren().add(proteinSort);
		sort2.getChildren().add(new Label());
		sort2.getChildren().add(foodOnlyB);
		sort2.getChildren().add(beveragesOnlyB);
////////////////////////////////////////////////////////////////////////////////

		ListView<String> AllMealList = new ListView<String>(AllMealListO);
		AllMealList.setMinWidth(420);
		AllMealList.setMaxHeight(240);
		ObservableList<String> Meal1ListO = FXCollections.observableArrayList();
		ListView<String> Meal1List = new ListView<String>(Meal1ListO);
		Meal1List.setMaxHeight(72);

		ObservableList<String> Meal2ListO = FXCollections.observableArrayList();
		ListView<String> Meal2List = new ListView<String>(Meal2ListO);
		Meal2List.setMaxHeight(72);

		ObservableList<String> Meal3ListO = FXCollections.observableArrayList();
		ListView<String> Meal3List = new ListView<String>(Meal3ListO);
		Meal3List.setMaxHeight(72);

///////////////////////////////////////////////////////////////////////////////

		Label searchL = new Label("Enter specific name to search ");
		TextField searchF = new TextField();
		Button searchB = new Button("Search");
		searchB.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event2) {
				AllMealListO.remove(0, AllMealListO.size());
				for (int i = 0; i < patient.food.size(); i++) {
					if (patient.food.get(i).getName().contains(searchF.getText()))
						AllMealListO.add((i + 1) + "\t" + patient.food.get(i).toString2());
					if (patient.food.get(i).getName()
							.contains(searchF.getText().substring(0, 1).toUpperCase() + searchF.getText().substring(1)))
						AllMealListO.add((i + 1) + "\t" + patient.food.get(i).toString2());
				}
			}
		});
		VBox searchBox = new VBox();
		searchBox.setAlignment(Pos.CENTER);
		searchBox.getChildren().add(searchL);
		searchBox.getChildren().add(searchF);
		searchBox.getChildren().add(searchB);

///////////////////////////////////////////////////////////////////////////////////////////////	

		Label meal1 = new Label("BreakFast");
		Label meal2 = new Label("Lunch");
		Label meal3 = new Label("Dinner");

		Button Meal1B1 = new Button("Add");
		Button Meal2B1 = new Button("Add");
		Button Meal3B1 = new Button("Add");

		Button Meal1B2 = new Button("Remove All");
		Button Meal2B2 = new Button("Remove All");
		Button Meal3B2 = new Button("Remove All");

		VBox Meal1B = new VBox();
		Meal1B.getChildren().add(Meal1B1);
		Meal1B.getChildren().add(Meal1B2);

		VBox Meal2B = new VBox();
		Meal2B.getChildren().add(Meal2B1);
		Meal2B.getChildren().add(Meal2B2);

		VBox Meal3B = new VBox();
		Meal3B.getChildren().add(Meal3B1);
		Meal3B.getChildren().add(Meal3B2);

		Label Meal1L = new Label("Enter the meal number ");
		TextField Meal1F = new TextField();
		VBox Meal1Box = new VBox();
		Meal1Box.setAlignment(Pos.CENTER);
		Meal1Box.getChildren().add(Meal1L);
		Meal1Box.getChildren().add(Meal1F);

		Label Meal2L = new Label("Enter the meal number");
		TextField Meal2F = new TextField();
		VBox Meal2Box = new VBox();
		Meal2Box.setAlignment(Pos.CENTER);
		Meal2Box.getChildren().add(Meal2L);
		Meal2Box.getChildren().add(Meal2F);

		Label Meal3L = new Label("Enter the meal number");
		TextField Meal3F = new TextField();
		VBox Meal3Box = new VBox();
		Meal3Box.setAlignment(Pos.CENTER);
		Meal3Box.getChildren().add(Meal3L);
		Meal3Box.getChildren().add(Meal3F);

///////////////////////////////////////////////////////////////////////////////////////////////

		Meal1B1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				int choose;
				if (Integer.parseInt(Meal1F.getText()) < 817) {
					choose = Integer.parseInt(Meal1F.getText());
					Meal1ListO.add(patient.food.get(choose - 1).toString2());
					totalcalories += patient.food.get(choose - 1).getCal();
					totalprotein += patient.food.get(choose - 1).getProtein();
					totalcarbo += patient.food.get(choose - 1).getCarbon();
					totalfat += patient.food.get(choose - 1).getFat();
					goal.setText(
							"The total amount of calories: " + totalcalories + "/2000\tThe total amount of protein: "
									+ totalprotein + "/100\nThe total amount of carbo: " + totalcarbo
									+ "/300\t\tThe total amount of fat: " + totalfat + "/50");
				}
			}
		});
		Meal2B1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				int choose;
				if (Integer.parseInt(Meal2F.getText()) < 800) {
					choose = Integer.parseInt(Meal2F.getText());
					Meal2ListO.add(patient.food.get(choose - 1).toString2());
					totalcalories += patient.food.get(choose - 1).getCal();
					totalprotein += patient.food.get(choose - 1).getProtein();
					totalcarbo += patient.food.get(choose - 1).getCarbon();
					totalfat += patient.food.get(choose - 1).getFat();
					goal.setText(
							"The total amount of calories: " + totalcalories + "/2000\tThe total amount of protein: "
									+ totalprotein + "/100\nThe total amount of carbo: " + totalcarbo
									+ "/300\t\tThe total amount of fat: " + totalfat + "/50");

				}
			}
		});
		Meal3B1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				int choose;
				if (Integer.parseInt(Meal3F.getText()) < 800) {
					choose = Integer.parseInt(Meal3F.getText());
					Meal3ListO.add(patient.food.get(choose - 1).toString2());
					totalcalories += patient.food.get(choose - 1).getCal();
					totalprotein += patient.food.get(choose - 1).getProtein();
					totalcarbo += patient.food.get(choose - 1).getCarbon();
					totalfat += patient.food.get(choose - 1).getFat();
					goal.setText(
							"The total amount of calories: " + totalcalories + "/2000\tThe total amount of protein: "
									+ totalprotein + "/100\nThe total amount of carbo: " + totalcarbo
									+ "/300\t\tThe total amount of fat: " + totalfat + "/50");

				}
			}
		});

		Meal1B2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Meal1ListO.remove(0, Meal1ListO.size());
			}
		});
		Meal2B2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Meal2ListO.remove(0, Meal2ListO.size());
			}
		});
		Meal3B2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Meal3ListO.remove(0, Meal3ListO.size());
			}
		});
/////////////////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////////

		CategoryAxis xAxis = new CategoryAxis();

		// defining the y Axis
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Fruit units");

		LineChart<String, Number> areaChart = new LineChart(xAxis, yAxis);

		XYChart.Series series1 = new XYChart.Series();
		series1.setName("John");
		series1.getData().add(new XYChart.Data("M",totalcalories));
		series1.getData().add(new XYChart.Data("T", totalprotein));
		series1.getData().add(new XYChart.Data("W", totalcarbo));
		series1.getData().add(new XYChart.Data("T",totalfat));
		
		areaChart.getData().addAll(series1);

//////////////////////////////////////////////////////////////////////////////////		
		GridPane root = new GridPane();
		root.setVgap(20);
		root.setHgap(50);
		root.add(meal1, 0, 1);
		root.add(meal2, 0, 2);
		root.add(meal3, 0, 3);
		root.add(Meal1B, 1, 1);
		root.add(Meal2B, 1, 2);
		root.add(Meal3B, 1, 3);
		root.add(Meal1List, 3, 1);
		root.add(Meal2List, 3, 2);
		root.add(Meal3List, 3, 3);

		root.add(sort2, 1, 0);
		root.add(searchBox, 2, 0);
		root.add(sort, 0, 0);
		root.add(AllMealList, 3, 0);
		root.setAlignment(Pos.CENTER);

		root.add(Meal1Box, 2, 1);
		root.add(Meal2Box, 2, 2);
		root.add(Meal3Box, 2, 3);
		root.add(goal, 3, 4);
		// root.add(areaChart, 3, 5);

///////////////////////////////////////////////////////////////////////////////////////////////		

		stage.setScene(new Scene(root, 960, 600));
		stage.setTitle("Nutritionist works at the hospital to specify edibles to patients");
		stage.show();
	}
}
