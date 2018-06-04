package project.RealEstateAgency;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SearchGui {
	public void show() {
		Stage window = new Stage();
		window.setTitle("Welcome to login");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Label name = new Label("Name");
		grid.add(name, 0, 1);

		TextField nameBox = new TextField();
		grid.add(nameBox, 1, 1);

		Button btn = new Button("search");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 6);

		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);

		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				String name = nameBox.getText();
				new AlertBox().show(Service.findByName(name));
			}
		});

		Scene scene = new Scene(grid, 300, 275);
		window.setScene(scene);
		window.showAndWait();
	}
}
