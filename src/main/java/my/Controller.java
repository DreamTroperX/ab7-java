package my;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.List;

public class Controller {


    @FXML
    private TextField areaT;
    @FXML
    private TextField floorT;
    @FXML
    private TextField numberT;
    @FXML
    private TextField streetT;
    @FXML
    private Button addButton;
    @FXML
    private TextArea listTF;
    @FXML
    private Button removeButton;
    @FXML
    private TextField indexT;
    @FXML
    private TextArea removeTF;
    @FXML
    private Button searchNumberOfRoomsAndFloorB;
    @FXML
    private TextField NumOfRT;
    @FXML
    private TextArea NumAndFloorTF;
    @FXML
    private Button searchArea;
    @FXML
    private TextField areaSortT;
    @FXML
    private TextArea areaTF;
    @FXML
    private Button areaSortB;
    @FXML
    private TextArea areaSortTF;
    @FXML
    private TextField floorFromT;
    @FXML
    private TextField floorToT;
    @FXML
    private Button floorSortB;
    @FXML
    private TextArea floorSortTF;
    @FXML
    private Button listApartmentB;
    @FXML
    private TextArea listOfApartmentTF;
    @FXML
    private Button searchNumberOfRoomsButton;
    @FXML
    private TextField NumberOfRooms;
    @FXML
    private TextArea NumberOfRoomsTF;
    @FXML
    private TextField numberOfRoomsT;

    @FXML
    public void remove() {
        Logic logic = new Logic();
        removeButton.setOnAction(event -> {
            boolean success = true;
            int index = 0;
            try {
                index = (Integer.parseInt(indexT.getText()));
            } catch (NumberFormatException err) {
                Alert b = new Alert(Alert.AlertType.ERROR);
                b.setTitle("Помилка");
                b.setHeaderText("Некоректно введено значення");
                b.show();
                success = false;
            }
            if (success) {
                List<House> list = logic.fillList();
                removeTF.setText(String.valueOf(logic.remove(list, index)));
            }
        });
    }

    @FXML
    public void toList() {
        Logic logic = new Logic();
        addButton.setOnAction(event -> {
            boolean success = true;
            int addNumberOfApartment = 0;
            double addArea = 0;
            int addFloor = 0;
            int addNumberOfRooms = 0;
            String addStreet = null;
            try {
                addNumberOfApartment = Integer.parseInt(numberT.getText());
                addArea = Double.parseDouble(areaT.getText());
                addFloor = Integer.parseInt(floorT.getText());
                addNumberOfRooms = Integer.parseInt(numberOfRoomsT.getText());
                addStreet = streetT.getText();
            } catch (NumberFormatException err) {
                Alert b = new Alert(Alert.AlertType.ERROR);
                b.setTitle("Помилка");
                b.setHeaderText("Некоректно введено значення");
                b.show();
                success = false;
            }
            if (success) {
                List<House> list = logic.fillList();
                listTF.setText(String.valueOf(logic.AddToList(list, addNumberOfApartment, addArea, addFloor, addNumberOfRooms, addStreet)));
            }
        });
    }
    @FXML
    public void searchNumberOfRooms() {
        Logic logic = new Logic();
        searchNumberOfRoomsButton.setOnAction(event -> {
            boolean success = true;
            int numberOfRooms = 0;
            try {
                numberOfRooms = Integer.parseInt(NumberOfRooms.getText());

            } catch (NumberFormatException err) {
                Alert b = new Alert(Alert.AlertType.ERROR);
                b.setTitle("Помилка");
                b.setHeaderText("Некоректно введено значення");
                b.show();
                success = false;
            }
            if (success) {
                List<House> list = logic.fillList();
                NumberOfRoomsTF.setText(String.valueOf(logic.searchByNumberOfRooms(list, numberOfRooms)));
            }
        });
    }
    @FXML
    public void searchNumFloor() {
        Logic logic = new Logic();
        searchNumberOfRoomsAndFloorB.setOnAction(event -> {
            boolean success = true;
            int numberOfRooms = 0;
            int floorFrom = 0;
            int floorTo =0;
            try {
                numberOfRooms = Integer.parseInt(NumOfRT.getText());
                floorFrom = Integer.parseInt(floorFromT.getText());
                floorTo = Integer.parseInt(floorToT.getText());

            } catch (NumberFormatException err) {
                Alert b = new Alert(Alert.AlertType.ERROR);
                b.setTitle("Помилка");
                b.setHeaderText("Некоректно введено значення");
                b.show();
                success = false;
            }
            if (success) {
                List<House> list = logic.fillList();
                NumAndFloorTF.setText(String.valueOf(logic.searchByNumberOfRoomsAndFloorRange(list, numberOfRooms, floorFrom, floorTo)));
            }
        });
    }
    @FXML
    public void searchArea() {
        Logic logic = new Logic();
        searchArea.setOnAction(event -> {
            boolean success = true;
            double area = 0;
            try {
                area = Double.parseDouble(areaSortT.getText());

            } catch (NumberFormatException err) {
                Alert b = new Alert(Alert.AlertType.ERROR);
                b.setTitle("Помилка");
                b.setHeaderText("Некоректно введено значення");
                b.show();
                success = false;
            }
            if (success) {
                List<House> list = logic.fillList();
                areaTF.setText(String.valueOf(logic.searchByArea(list, area)));
            }
        });
    }

    @FXML
    public void floorListApartment() {
        Logic logic = new Logic();
        List<House> list = logic.fillList();
        listOfApartmentTF.setText(String.valueOf(logic.apartmentListOfFloor(list)));
    }

    @FXML
    public void sortByFloor() {
        Logic logic = new Logic();
        List<House> list = logic.fillList();
        floorSortTF.setText(String.valueOf(logic.sortByFloor(list)));
    }

    @FXML
    public void sortByArea() {
        Logic logic = new Logic();
        List<House> list = logic.fillList();
        areaSortTF.setText(String.valueOf(logic.sortByArea(list)));
    }




}
