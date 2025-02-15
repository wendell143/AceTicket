package com.example.demo3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    TextField login_ID = new TextField();


    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    private final ObjectProperty<ObservableList<TicketProperty>> tickets = new SimpleObjectProperty<>(FXCollections.observableArrayList());




    @FXML
    private TableView<TicketProperty> ticketTableView;

    @FXML
    private TableColumn<TicketProperty, Long> idTableColumn;

    @FXML
    private TableColumn<TicketProperty, String> nameTableColumn;

    @FXML
    private TableColumn<TicketProperty, String> departmentTableColumn;


    @FXML
    private TableColumn<TicketProperty, String> concernTableColumn;


    @FXML
    private TableColumn<TicketProperty, String> staffTableColumn;

    @FXML
    private TableColumn<TicketProperty, String> statusTableColumn;


    private final ObjectMapper objectMapper;

    public HelloController() {
        this.objectMapper = this.objectMapper();
    }


    private ObjectMapper objectMapper() {
        final var om = new ObjectMapper();
        om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        om.registerModule(new JavaTimeModule());

        return om;
    }


    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.initTicketTableView();
        this.ticketTableView.itemsProperty().bind(this.tickets);
        this.getTickets();


    }

    private void getTickets() {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("http://localhost:8080/v1/tickets"))
                    .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                String body = response.body();
                if (body != null) {
                    var ticketDtos = this.objectMapper.readValue(body, TicketDto[].class);
                    var ticketProperties = Arrays.stream(ticketDtos)
                            .map(ticketDto -> {
                                var ticketProperty = new TicketProperty();
                                ticketProperty.setId(ticketDto.id());
                                ticketProperty.setName(ticketDto.name());
                                ticketProperty.setDepartment(ticketDto.department());
                                ticketProperty.setConcern(ticketDto.concern());
                                ticketProperty.setstaff(ticketDto.staff());
                                ticketProperty.setStatus(ticketDto.Status());

                                return ticketProperty;
                            })
                            .toList();
                    this.tickets.get()
                            .setAll(ticketProperties);
                }
            }
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());


        }
    }

    private void initTicketTableView() {
        this.idTableColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        this.nameTableColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        this.departmentTableColumn.setCellValueFactory(cellData -> cellData.getValue().departmentProperty());
        this.concernTableColumn.setCellValueFactory(cellData -> cellData.getValue().concernProperty());
        this.staffTableColumn.setCellValueFactory(cellData -> cellData.getValue().staffProperty());
        this.statusTableColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());





    }
}

