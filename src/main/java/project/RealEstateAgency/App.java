package project.RealEstateAgency;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Welcome to Real Estate Agency!");
		Button btnRegister = new Button();
		btnRegister.setText("register");
		btnRegister.setOnAction(e -> new RegisterGui().show());

		Button btnLogin = new Button();
		btnLogin.setText("login");
		btnLogin.setOnAction(e -> new LoginGui().show());

		Button btnFind = new Button();
		btnFind.setText("search customer");
		btnFind.setOnAction(e -> new SearchGui().show());

		Button btnAddProperty = new Button();
		btnAddProperty.setText("add property");
		btnAddProperty.setOnAction(e -> new AddPropertyGui().show());

		Button btnSearchProperty = new Button();
		btnSearchProperty.setText("search property");
		btnSearchProperty.setOnAction(e -> new SearchPropertyGui().show());

		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(25, 25, 25, 25));

		root.add(btnRegister, 0, 0);
		root.add(btnLogin, 0, 1);
		root.add(btnFind, 0, 2);
		root.add(btnAddProperty, 0, 3);
		root.add(btnSearchProperty, 0, 4);

		primaryStage.setScene(new Scene(root, 500, 350));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
