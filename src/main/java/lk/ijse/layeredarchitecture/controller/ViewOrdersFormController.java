package lk.ijse.layeredarchitecture.controller;

import lk.ijse.layeredarchitecture.dao.custom.CustomerDAO;
import lk.ijse.layeredarchitecture.dao.custom.Impl.CustomerDAOImpl;
import lk.ijse.layeredarchitecture.dao.custom.Impl.OrderDAOImpl;
import lk.ijse.layeredarchitecture.dao.custom.Impl.QueryDAOImpl;
import lk.ijse.layeredarchitecture.dao.custom.OrderDAO;
import lk.ijse.layeredarchitecture.dao.custom.QueryDAO;
import lk.ijse.layeredarchitecture.dto.CustomerDTO;
import lk.ijse.layeredarchitecture.dto.ViewOrderDetailDTO;
import lk.ijse.layeredarchitecture.entity.Customer;
import lk.ijse.layeredarchitecture.view.tdm.ViewOrderDetailTM;
import com.jfoenix.controls.JFXComboBox;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ViewOrdersFormController {
    @FXML
    private JFXComboBox<String> cmbCustomerId;

    @FXML
    private JFXComboBox<String> cmbOrderId;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private Label lblDate;

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

    OrderDAO orderDAO = new OrderDAOImpl();

    @FXML
    void navigateToHome(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/lk/ijse/layeredarchitecture/main-form.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        Platform.runLater(() -> primaryStage.sizeToScene());

    }

   /* public void viewCustomerOrderDetail() throws SQLException, ClassNotFoundException {
        String id = cmbCustomerId.getValue();
        ArrayList<ViewOrderDetailDTO> dtoList = queryDAO.addTableAllCustomrOrderDetails(id);

        for (ViewOrderDetailDTO dto: dtoList){
            String customerId = dto.getId();

            dto.getName(),
            d
        }

    }
*/
   @FXML
   void orderIDOnAction(ActionEvent event) {
       String oid = cmbOrderId.getValue();
       //txtCustomerName.setText();


       ObservableList<ViewOrderDetailTM> obList = FXCollections.observableArrayList();
       try {
           tblViewCustomerOrderDetails.getItems().clear();
           ArrayList<ViewOrderDetailDTO> dtoList = queryDAO.addTableAllCustomrOrderDetails(oid) ;

           for (ViewOrderDetailDTO dto : dtoList){
               txtCustomerName.setText(dto.getName());
               obList.add(new ViewOrderDetailTM(
                       dto.getId(),
                       dto.getName(),
                       dto.getOid(),
                       dto.getDate(),
                       dto.getItemcode(),
                       dto.getQty(),
                       dto.getUnitprice()
               ));
               for (ViewOrderDetailDTO test : dtoList) {

                   System.out.println(test.getId());
                   System.out.println(test.getName());
                   System.out.println(test.getOid());
                   System.out.println(test.getDate());
                   System.out.println(test.getItemcode());
                   System.out.println(test.getQty());
                   System.out.println(test.getUnitprice());
               }
               tblViewCustomerOrderDetails.setItems(obList);
               initialize();

           }
//            colCustomerId.setCellValueFactory(new PropertyValueFactory<>("id"));
//            colCustomerName.setCellValueFactory(new PropertyValueFactory<>("name"));
//            colOrderId.setCellValueFactory(new PropertyValueFactory<>("oid"));
//            colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
//            colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
//           colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
//           colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

       } catch (Exception e) {
           e.printStackTrace();
       }

   }
    @FXML
    void customerIDOnAction(ActionEvent event){
        String id = cmbCustomerId.getValue();
        //txtCustomerName.setText();


        ObservableList<ViewOrderDetailTM> obList = FXCollections.observableArrayList();
        try {
            tblViewCustomerOrderDetails.getItems().clear();
            ArrayList<ViewOrderDetailDTO> dtoList = queryDAO.addTableAllCustomrOrderDetails(id) ;

            for (ViewOrderDetailDTO dto : dtoList){
                txtCustomerName.setText(dto.getName());
                obList.add(new ViewOrderDetailTM(
                        dto.getId(),
                        dto.getName(),
                        dto.getOid(),
                        dto.getDate(),
                        dto.getItemcode(),
                        dto.getQty(),
                        dto.getUnitprice()
                ));
                for (ViewOrderDetailDTO test : dtoList) {

                    System.out.println(test.getId());
                    System.out.println(test.getName());
                    System.out.println(test.getOid());
                    System.out.println(test.getDate());
                    System.out.println(test.getItemcode());
                    System.out.println(test.getQty());
                    System.out.println(test.getUnitprice());
                }
                tblViewCustomerOrderDetails.setItems(obList);
                initialize();

            }
//            colCustomerId.setCellValueFactory(new PropertyValueFactory<>("id"));
//            colCustomerName.setCellValueFactory(new PropertyValueFactory<>("name"));
//            colOrderId.setCellValueFactory(new PropertyValueFactory<>("oid"));
//            colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
//            colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
//           colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
//           colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAllCustomers() throws SQLException, ClassNotFoundException {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {


            List<Customer> idList = customerDAO.getAll();
            ArrayList<CustomerDTO> customerDTOS =  new ArrayList<>();

            for (Customer customer : idList) {
                obList.add(customer.getId());
            }
            cmbCustomerId.setItems(obList);

        }catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to load customer ids").show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public  void initialize() throws SQLException, ClassNotFoundException {
        setDate();
        setCellValues();
        loadAllCustomers();


    }



    private void setDate() {
        lblDate.setText(String.valueOf(LocalDate.now()));
    }

    private void setCellValues() {
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colOrderId.setCellValueFactory(new PropertyValueFactory<>("oid"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
    }

   /* private void setCellValueFactory() {

    }
*/






}
