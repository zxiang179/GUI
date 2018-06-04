package project.RealEstateAgency;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegisterGui {
	public void show() {
		Stage window = new Stage();
		window.setTitle("Welcome to resister");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Label name = new Label("Name:");
		grid.add(name, 0, 1);

		TextField nameTextField = new TextField();
		grid.add(nameTextField, 1, 1);

		Label em = new Label("Email Address:");
		grid.add(em, 0, 2);

		TextField emTextField = new TextField();
		grid.add(emTextField, 1, 2);

		Label phone = new Label("Phone:");
		grid.add(phone, 0, 3);

		TextField phoneBox = new TextField();
		grid.add(phoneBox, 1, 3);

		Label pw = new Label("Password:");
		grid.add(pw, 0, 4);

		PasswordField pwBox = new PasswordField();
		grid.add(pwBox, 1, 4);

		Label gender = new Label("Gender:");
		grid.add(gender, 0, 5);

		TextField genderBox = new TextField();
		grid.add(genderBox, 1, 5);

		Label type = new Label("Type:");
		grid.add(type, 0, 6);

		TextField typeBox = new TextField();
		grid.add(typeBox, 1, 6);

		Button btn = new Button("register");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 7);

		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);

		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				String name = nameTextField.getText();
				String em = emTextField.getText();
				String phone = phoneBox.getText();
				String pw = pwBox.getText();
				String gender = genderBox.getText();
				String type = typeBox.getText();
				if (Service.register(name, em, phone, pw, gender, type))
					new AlertBox().show("register success!");
				else
					new AlertBox().show("register failed!");
			}
		});

		Scene scene = new Scene(grid, 300, 275);
		window.setScene(scene);
		window.showAndWait();
	}
}
