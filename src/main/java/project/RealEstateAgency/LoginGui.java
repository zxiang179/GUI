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

public class LoginGui {
	public void show() {
		Stage window = new Stage();
		window.setTitle("Welcome to login");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Label phone = new Label("Phone:");
		grid.add(phone, 0, 3);

		TextField phoneBox = new TextField();
		grid.add(phoneBox, 1, 3);

		Label pw = new Label("Password:");
		grid.add(pw, 0, 4);

		PasswordField pwBox = new PasswordField();
		grid.add(pwBox, 1, 4);

		Button btn = new Button("login");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 6);

		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);

		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				String phone = phoneBox.getText();
				String pwd = pwBox.getText();

				if (Service.login(phone, pwd))
					new AlertBox().show("login success!");
				else
					new AlertBox().show("login failed!");
			}
		});

		Scene scene = new Scene(grid, 300, 275);
		window.setScene(scene);
		window.showAndWait();
	}
}
