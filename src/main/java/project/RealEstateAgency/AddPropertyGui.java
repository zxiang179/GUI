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

public class AddPropertyGui {
	public void show() {
		Stage window = new Stage();
		window.setTitle("Welcome to add property interface");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Label state = new Label("State:");
		grid.add(state, 0, 1);

		TextField stateTextField = new TextField();
		grid.add(stateTextField, 1, 1);

		Label suburb = new Label("Suburb:");
		grid.add(suburb, 0, 2);

		TextField suburbTextField = new TextField();
		grid.add(suburbTextField, 1, 2);

		Label rentalPrice = new Label("RentalPrice:");
		grid.add(rentalPrice, 0, 3);

		TextField rentalPriceTextField = new TextField();
		grid.add(rentalPriceTextField, 1, 3);

		Label buyPrice = new Label("BuyPrice:");
		grid.add(buyPrice, 0, 4);

		TextField buyPriceTextField = new TextField();
		grid.add(buyPriceTextField, 1, 4);

		Label type = new Label("Type:");
		grid.add(type, 0, 5);

		TextField typeTextField = new TextField();
		grid.add(typeTextField, 1, 5);

		Label description = new Label("description:");
		grid.add(description, 0, 6);

		TextField descriptionTextField = new TextField();
		grid.add(descriptionTextField, 1, 6);

		Label status = new Label("Status:");
		grid.add(status, 0, 7);

		TextField statusTextField = new TextField();
		grid.add(statusTextField, 1, 7);

		Label contactName = new Label("ContactName:");
		grid.add(contactName, 0, 8);

		TextField contactNameTextField = new TextField();
		grid.add(contactNameTextField, 1, 8);

		Label Phone = new Label("Phone:");
		grid.add(Phone, 0, 9);

		TextField PhoneTextField = new TextField();
		grid.add(PhoneTextField, 1, 9);

		Label bedrooms = new Label("Number of bedrooms:");
		grid.add(bedrooms, 0, 10);

		TextField bedroomsTextField = new TextField();
		grid.add(bedroomsTextField, 1, 10);

		Label bathrooms = new Label("Number of bathrooms:");
		grid.add(bathrooms, 0, 11);

		TextField bathroomsTextField = new TextField();
		grid.add(bathroomsTextField, 1, 11);

		Label parking = new Label("Number of parking space:");
		grid.add(parking, 0, 12);

		TextField parkingTextField = new TextField();
		grid.add(parkingTextField, 1, 12);

		Button btn = new Button("add");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 13);

		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);

		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				String state = stateTextField.getText();
				String suburb = suburbTextField.getText();
				String rentalPrice = rentalPriceTextField.getText();
				String buyPrice = buyPriceTextField.getText();
				String type = typeTextField.getText();
				String description = descriptionTextField.getText();
				String status = statusTextField.getText();
				String contactName = contactNameTextField.getText();
				String Phone = PhoneTextField.getText();
				String bedrooms = bedroomsTextField.getText();
				String bathrooms = bathroomsTextField.getText();
				String parking = parkingTextField.getText();
				if (Service.saveProperty(state, suburb, rentalPrice, buyPrice, type, description, status, contactName,
						Phone, bedrooms, bathrooms, parking))
					new AlertBox().show("add success!");
				else
					new AlertBox().show("add failed!");
			}
		});

		Scene scene = new Scene(grid, 500, 575);
		window.setScene(scene);
		window.showAndWait();
	}
}
