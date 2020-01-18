import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLDocumentController implements Initializable {

    SeanseList seanseList = new SeanseList();
    Widz widz = new Widz();
    Pracownik pracownik = new Pracownik();
    Kierownik kierownik = new Kierownik();
    int pozycjaOblugiwania = 0;

    @FXML
    private AnchorPane loginAnchorPane;

    @FXML
    private Button signInButton;

    @FXML
    private Button logOutButton;

    @FXML
    private TextField passwordTextField;

    @FXML
    private AnchorPane actionAnchorPane;

    @FXML
    private AnchorPane seanseListAnchorPane;

    @FXML
    private TextField titleTextField;

    @FXML
    private TextField gatunekTextField;

    @FXML
    private TextField ticketNumberTextField;

    @FXML
    private Button addSeansButton;

    @FXML
    private Button delateSeansButton;

    @FXML
    private AnchorPane ticketAnchorPane;

    @FXML
    private Button rezerwujButton;

    @FXML
    private Button buyButton;

    @FXML
    private Button zwrocButton;

    @FXML
    private TextField titleTicketTextField;

    @FXML
    private TextField ticketnumberTextField;

    @FXML
    private Button sellButton;

    @FXML
    private AnchorPane searchAnchorPane;

    @FXML
    private Button showAllButton;

    @FXML
    private Button searchTitleButton;

    @FXML
    private TextField parametrTextFiled;

    @FXML
    private Button searchGatunekButton;

    @FXML
    private TextField infoSys;

    @FXML
    private TextArea opisTextArea;

    @FXML
    void dodajSeansAction(ActionEvent event) {
        if (pozycjaOblugiwania == 1) {
            int wynik = kierownik.dodajSeans(seanseList, titleTextField.getText(), gatunekTextField.getText(), Integer.valueOf(ticketNumberTextField.getText()));
            infoSys.setText(error(wynik));
        } else {
            infoSys.setText("Nie masz uprawnien!");
        }

    }

    @FXML
    void wylogujAction(ActionEvent event){
        if (pozycjaOblugiwania == 2) pracownik.wyloguj();
        if (pozycjaOblugiwania == 1) kierownik.wyloguj();
        else infoSys.setText("Nie jesteś zalogowany!");
    }

    @FXML
    void kupBiletAction(ActionEvent event) {
        if (pozycjaOblugiwania == 0) {
            int pozycja = widz.wyszukaj(seanseList, titleTicketTextField.getText());
            System.out.println(pozycja);
            if (pozycja >= 0) {
                widz.kupBilet(seanseList, titleTicketTextField.getText(), Integer.valueOf(ticketnumberTextField.getText()));
                infoSys.setText(error(pozycja));
            } else {
                infoSys.setText(error(pozycja));
            }
        } else {
            infoSys.setText("Nie masz uprawnień do tej akcji!");
        }
    }

    @FXML
    void rezerwujBiletAction(ActionEvent event) {
        if (pozycjaOblugiwania == 2) {
            int pozycja = pracownik.rezerwuj(seanseList, titleTicketTextField.getText(), Integer.valueOf(ticketnumberTextField.getText()));
            infoSys.setText(error(pozycja));

        }
        if (pozycjaOblugiwania == 0) {
            int wynik = widz.rezerwuj(seanseList, titleTicketTextField.getText(), Integer.valueOf(ticketnumberTextField.getText()));
            infoSys.setText(error(wynik));
        } else {
            infoSys.setText("Nie masz uprawnień");
        }
    }


    @FXML
    void searchTitleAction(ActionEvent event) {
        String tytul = parametrTextFiled.getText();
        if (pozycjaOblugiwania == 2) pracownik.wyszukaj(seanseList, tytul);
        if (pozycjaOblugiwania == 1) kierownik.wyszukaj(seanseList, tytul);


    }

    @FXML
    void showAllAction(ActionEvent event) {
        String wynik = "";
        for (int i = 0; i < seanseList.getIloscSeansow(); i++) {
            wynik = wynik + "\n" + seanseList.getSeans(i).toString();
        }
        opisTextArea.setEditable(true);
        opisTextArea.setText(wynik);

        }

    @FXML
    void sprzedajBiletAction(ActionEvent event) {

        if (pozycjaOblugiwania == 2) {
            int pozycja = pracownik.wyszukaj(seanseList, titleTicketTextField.getText());
            System.out.println(pozycja);
            if (pozycja >= 0) {
                pracownik.sprzedajBilet(seanseList, titleTicketTextField.getText(), Integer.valueOf(ticketnumberTextField.getText()));
                infoSys.setText(error(pozycja));
            } else {
                infoSys.setText(error(pozycja));
            }
        }
    }


    @FXML
    void usunSeansAction(ActionEvent event) {
        if (pozycjaOblugiwania == 1) {
            int wynik = kierownik.usunSeans(seanseList, titleTextField.getText());
            infoSys.setText(error(wynik));
        } else {
            infoSys.setText("Nie masz uprawnień!");
        }
    }

    @FXML
    void zalogujAction(ActionEvent event) {
        if (passwordTextField.getText().equals(Kierownik.login)) {
            int wynik = kierownik.loguj(passwordTextField.getText());
            System.out.println(wynik);
            infoSys.setText(error(wynik));
            pozycjaOblugiwania = 1;
        } else if (passwordTextField.getText().equals(Pracownik.login)) {
            int wynik = pracownik.loguj(passwordTextField.getText());
            System.out.println(wynik);
            infoSys.setText(error(wynik));
            pozycjaOblugiwania = 2;
        }
    }

    @FXML
    void zwrocBiletAction(ActionEvent event) {
        if (pozycjaOblugiwania == 2) {
            int pozycja = pracownik.anulujRezerwacje(seanseList, titleTicketTextField.getText(), Integer.valueOf(ticketnumberTextField.getText()));
            infoSys.setText(error(pozycja));
        }
        if (pozycjaOblugiwania == 0) {
            int pozycja = widz.anulujRezerwacje(seanseList, titleTicketTextField.getText(), Integer.valueOf(ticketnumberTextField.getText()));
            infoSys.setText(error(pozycja));
        } else {
            infoSys.setText("Nie masz uprawnień!");
        }
    }

    static String error(int nr) {
        String info;
        switch (nr) {
            case -1:
                info = "Bilety wyprzedane";
                break;
            case -2:
                info = "Nie ma takiej pozycji";
                break;
            case -4:
                info = "Nie jesteś zalogowany";
                break;
            case -5:
                info = "Zbyt duża ilość biletów do zwrotu";
                break;
            default:
                info = "OK.";
        }
        return info;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
