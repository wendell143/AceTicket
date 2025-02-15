package com.example.demo3;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Arrays;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

public class LoginController  implements Initializable {

    private  static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();
        @FXML
        private CheckBox login_shpassword;

        @FXML
        private ComboBox<String> login_switchuser;

        @FXML
        private Button login_signup;

        @FXML
        private Button login_login;

        @FXML
        private TextField login_username;

        @FXML
        private PasswordField login_password;

        @FXML
        private Button login_login1;
        private ObjectMapper objectMapper;



    public LoginController(){

    }


        private HttpRequest.BodyPublisher getParamsUrlEncoded(java.util.Map<String,String> parameters) {
        String urlEncoded = parameters.entrySet()
                .stream()
                .map(e -> e.getKey() + "=" + URLEncoder.encode(e.getValue(), StandardCharsets.UTF_8))
                .collect(Collectors.joining("&"));
        return HttpRequest.BodyPublishers.ofString(urlEncoded);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        loginUser();
        switchUser();

    }
    public void loginUser() {
       /* try {
           /* HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("http://localhost:8080/customer-support-management/api/v1/tickets"))
                    .setHeader("User-Agent", "Java 11 HttpClient bot")
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            if(response.statusCode()==200){
                 String body = response.body();
                 if(body!=null){
                     var ticketDtos =this.objectMapper.readValue(body, TicketDto[].class);
                     var ticketproperties = Arrays.stream(ticketDtos)
                             .map(ticketDto -> {
                                 var ticketProperty = new TicketProperty();
                                         ticketProperty.setId(ticketDto.id());
                                         ticketProperty.setName(ticketDto.name());
                                 return ticketProperty;
                             });
                 }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/
        //-------------------------------403 real code -----------------------------------------------

            var params = Map.of("username",login_login“,"password”,);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .POST(getParamsUrlEncoded(params))
                    .headers("Content-Type", "application/x-www-form-urlencoded")
                    .build();
            System.getLogger("").log(System.Logger.Level.INFO, request.toString());
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }



        public void userLogin() throws IOException {

        Stage stage = new Stage();
        Class<HelloController> helloControllerClass = HelloController.class;
        URL helloControllerUrL= helloControllerClass.getResource(helloControllerClass.getSimpleName() + ".fxml");
        FXMLLoader loader = new FXMLLoader(helloControllerUrL);
        AnchorPane anchorPane = loader.load();
        Scene scene = new Scene(anchorPane);


        stage.setScene(scene);
        stage.show();
    }
}
