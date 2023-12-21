package com.example.layeredarchitecture.controller;

import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.dao.custom.Impl.CustomerDAOImpl;
import com.example.layeredarchitecture.dao.custom.Impl.QueryDAOImpl;
import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ViewOrderDetailDTO;
import com.example.layeredarchitecture.view.tdm.ViewOrderDetailTM;
import com.jfoenix.controls.JFXComboBox;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewOrdersFormController {
    @FXML
    private JFXComboBox<String> cmbCustomerId;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<ViewOrderDetailTM> tblViewCustomerOrderDetails;

    @FXML
    private TableColumn<?, ?> colCustomerId;

    @FXML
    private TableColumn<?, ?> colCustomerName;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colItemCode;

    @FXML
    private TableColumn<?, ?> colOrderId;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colUnitPrice;


    CustomerDAO customerDAO = new CustomerDAOImpl();
    QueryDAO queryDAO = new QueryDAOImpl();

    @FXML
    void navigateToHome(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/com/example/layeredarchitecture/main-form.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        Platform.runLater(() -> primaryStage.sizeToScene());

    }

    @FXML
    void customerIDOnAction(ActionEvent event) {
        String id = cmbCustomerId.getValue();
        //txtCustomerName.setText();


        ObservableList<ViewOrderDetailTM> obList = FXCollections.observableArrayList();
        try {
            tblViewCustomerOrderDetails.getItems().clear();
            ArrayList<ViewOrderDetailDTO> dtoList = queryDAO.addTableAllCustomrOrderDetails(id) ;

            for (ViewOrderDetailDTO dto : dtoList){
                obList.add(new ViewOrderDetailTM(
                        dto.getId(),
                        dto.getName(),
                        dto.getOid(),
                        dto.getDate(),
                        dto.getItemcode(),
                        dto.getQty(),
                        dto.getUnitprice()
                ));
                tblViewCustomerOrderDetails.setItems(obList);

            }
            colCustomerId.setCellValueFactory(new PropertyValueFactory<>("id"));
            colCustomerName.setCellValueFactory(new PropertyValueFactory<>("name"));
            colOrderId.setCellValueFactory(new PropertyValueFactory<>("oid"));
            colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
            colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
           colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
           colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        }
    }


    public  void initialize() throws SQLException, ClassNotFoundException {
        loadAllCustomers();




    }

   /* private void setCellValueFactory() {

    }
*/


    private void loadAllCustomers() throws SQLException, ClassNotFoundException {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {

            List<CustomerDTO> idList = customerDAO.getAll();

            for (CustomerDTO dto : idList) {
                obList.add(dto.getId());
            }
            cmbCustomerId.setItems(obList);

        }catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to load customer ids").show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



}
