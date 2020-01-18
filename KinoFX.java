import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class KinoFX extends Application {

    SeanseList seanseList = new SeanseList();
    Widz widz = new Widz();
    Pracownik pracownik = new Pracownik();
    Kierownik kierownik = new Kierownik();
    int pozycjaOblugiwania = 0;
    int iloscSeansow = 0;

    @Override
    public void start(Stage primaryStage) {

        HBox glownaScena = new HBox(5);
        glownaScena.setPadding(new Insets(5));
        VBox siatkaPionowaVBox = new VBox(5);
        siatkaPionowaVBox.setPadding(new Insets(5));

        HBox siatkaPoziomaLogowaniaHBox = new HBox(5);
        siatkaPoziomaLogowaniaHBox.setPadding(new Insets(5));

        Label logowanieLabel = new Label();
        logowanieLabel.setText("Logowanie:");
        siatkaPoziomaLogowaniaHBox.getChildren().add(logowanieLabel);

        TextField logowanieTextField = new TextField();
        siatkaPoziomaLogowaniaHBox.getChildren().add(logowanieTextField);

        Button logujButton = new Button("Loguj");
        logujButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (logowanieTextField.getText().equals(Kierownik.login)) {
                    int wynik = kierownik.loguj(logowanieTextField.getText());
                    System.out.println(wynik);
                    logowanieTextField.setText(error(wynik));
                    pozycjaOblugiwania = 1;
                } else if (logowanieTextField.getText().equals(Pracownik.login)) {
                    int wynik = pracownik.loguj(logowanieTextField.getText());
                    System.out.println(wynik);
                    logowanieTextField.setText(error(wynik));
                    pozycjaOblugiwania = 2;
                }
            }
        });
        siatkaPoziomaLogowaniaHBox.getChildren().add(logujButton);

        Button wylogujButton = new Button("Wyloguj");
        siatkaPoziomaLogowaniaHBox.getChildren().add(wylogujButton);
        wylogujButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (pozycjaOblugiwania == 1) {
                    int wynik = kierownik.wyloguj();
                    logowanieTextField.setText(error(wynik));
                    pozycjaOblugiwania = 0;
                } else if (pozycjaOblugiwania == 2) {
                    int wynik = pracownik.wyloguj();
                    logowanieTextField.setText(error(wynik));
                    pozycjaOblugiwania = 0;
                }
            }
        });
        siatkaPionowaVBox.getChildren().add(siatkaPoziomaLogowaniaHBox);

        HBox siatkaPoziomaAutorHBox = new HBox(5);

        Label gatunekLabel = new Label();
        gatunekLabel.setText("Gatunek");
        gatunekLabel.setPadding(new Insets(0, 0, 0, 40));
        siatkaPoziomaAutorHBox.getChildren().add(gatunekLabel);

        Label tytulLabel = new Label();
        tytulLabel.setPadding(new Insets(0, 0, 0, 80));
        tytulLabel.setText("Tytuł");
        siatkaPoziomaAutorHBox.getChildren().add(tytulLabel);

        Label iloscMiejscLabel = new Label();
        iloscMiejscLabel.setPadding(new Insets(0, 0, 0, 120));
        iloscMiejscLabel.setText("IloscMiejsc");
        siatkaPoziomaAutorHBox.getChildren().add(iloscMiejscLabel);

        siatkaPionowaVBox.getChildren().add(siatkaPoziomaAutorHBox);


        HBox siatkaPoziomaPoleTekstoweHBox = new HBox(5);

        TextField gatunekTextField = new TextField();
        siatkaPoziomaPoleTekstoweHBox.getChildren().add(gatunekTextField);

        TextField tytulTextField = new TextField();
        siatkaPoziomaPoleTekstoweHBox.getChildren().add(tytulTextField);

        TextField iloscMiejscTextField = new TextField();
        siatkaPoziomaPoleTekstoweHBox.getChildren().add(iloscMiejscTextField);

        siatkaPionowaVBox.getChildren().add(siatkaPoziomaPoleTekstoweHBox);


        HBox siatkaPoziomaModyfikacjaSeansow = new HBox(5);

        Button dodajButton = new Button("Dodaj Seans");
        dodajButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (pozycjaOblugiwania == 1) {
                    int wynik = kierownik.dodajSeans(seanseList, tytulTextField.getText(), gatunekTextField.getText(), Integer.valueOf(iloscMiejscTextField.getText()));
                    logowanieTextField.setText(error(wynik));
                    iloscSeansow++;
                } else {
                    logowanieTextField.setText("Nie masz uprawnien!");
                }
            }
        });
        siatkaPoziomaModyfikacjaSeansow.getChildren().add(dodajButton);

        Button usunButton = new Button("Usun Seans");
        usunButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (pozycjaOblugiwania == 1) {
                    int wynik = kierownik.usunSeans(seanseList, tytulTextField.getText());
                    logowanieTextField.setText(error(wynik));
                } else {
                    logowanieTextField.setText("Nie masz uprawnień!");
                }

            }
        });
        siatkaPoziomaModyfikacjaSeansow.getChildren().add(usunButton);

        Button wyszukajButton = new Button("Wyszukaj");
        siatkaPoziomaModyfikacjaSeansow.getChildren().add(wyszukajButton);
        siatkaPionowaVBox.getChildren().add(siatkaPoziomaModyfikacjaSeansow);

        Label ileBiletowLabel = new Label();
        ileBiletowLabel.setText("Ilosc biletów:");
        siatkaPionowaVBox.getChildren().add(ileBiletowLabel);

        HBox siatkaPoziomaRezerwujHBox = new HBox(5);

        TextField ileBiletowTextField = new TextField();
        siatkaPoziomaRezerwujHBox.getChildren().add(ileBiletowTextField);

        Button rezerwujButton = new Button("Rezerwuj");
        rezerwujButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (pozycjaOblugiwania == 2) {
                    int pozycja = pracownik.rezerwuj(seanseList, tytulTextField.getText(), Integer.valueOf(ileBiletowTextField.getText()));
                    logowanieTextField.setText(error(pozycja));

                }
                if (pozycjaOblugiwania == 0) {
                    int wynik = widz.rezerwuj(seanseList, tytulTextField.getText(), Integer.valueOf(ileBiletowTextField.getText()));
                    logowanieTextField.setText(error(wynik));
                } else {
                    logowanieTextField.setText("Nie masz uprawnień");
                }
            }
        });
        siatkaPoziomaRezerwujHBox.getChildren().add(rezerwujButton);

        Button kupBiletButton = new Button("Kup Bilet");
        kupBiletButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (pozycjaOblugiwania == 0) {
                    int pozycja = widz.wyszukaj(seanseList, tytulTextField.getText());
                    System.out.println(pozycja);
                    if (pozycja >= 0) {
                        widz.kupBilet(seanseList, tytulTextField.getText(), Integer.valueOf(ileBiletowTextField.getText()));
                        logowanieTextField.setText(error(pozycja));
                    } else {
                        logowanieTextField.setText(error(pozycja));
                    }
                } else {
                    logowanieTextField.setText("Nie masz uprawnień do tej akcji!");
                }
            }
        });
        siatkaPoziomaRezerwujHBox.getChildren().add(kupBiletButton);

        Button sprzedajBiletButton = new Button("Sprzedaj");
        sprzedajBiletButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (pozycjaOblugiwania == 2) {
                    int pozycja = pracownik.wyszukaj(seanseList, tytulTextField.getText());
                    System.out.println(pozycja);
                    if (pozycja >= 0) {
                        pracownik.sprzedajBilet(seanseList, tytulTextField.getText(), Integer.valueOf(ileBiletowTextField.getText()));
                        logowanieTextField.setText(error(pozycja));
                    } else {
                        logowanieTextField.setText(error(pozycja));
                    }
                }
            }
        });
        siatkaPoziomaRezerwujHBox.getChildren().add(sprzedajBiletButton);

        Button zwrotButton = new Button("Zwrot");
        zwrotButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (pozycjaOblugiwania == 2) {
                    int pozycja = pracownik.anulujRezerwacje(seanseList, tytulTextField.getText(), Integer.valueOf(ileBiletowTextField.getText()));
                    logowanieTextField.setText(error(pozycja));
                }
                if (pozycjaOblugiwania == 0) {
                    int pozycja = widz.anulujRezerwacje(seanseList, tytulTextField.getText(), Integer.valueOf(ileBiletowTextField.getText()));
                    logowanieTextField.setText(error(pozycja));
                } else {
                    logowanieTextField.setText("Nie masz uprawnień!");
                }
            }
        });
        siatkaPoziomaRezerwujHBox.getChildren().add(zwrotButton);

        siatkaPionowaVBox.getChildren().add(siatkaPoziomaRezerwujHBox);

        Button zakonczButton = new Button("Zakończ");
        zakonczButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        siatkaPionowaVBox.getChildren().add(zakonczButton);
        glownaScena.getChildren().add(siatkaPionowaVBox);
        VBox siatkaPionowa2 = new VBox(5);
        siatkaPionowa2.setPadding(new Insets(5));
        glownaScena.getChildren().add(siatkaPionowa2);
        Label opisLabel = new Label();
        opisLabel.setText("Opis seansu:");
        siatkaPionowa2.getChildren().add(opisLabel);

        TextArea opisSeansuTextArea = new TextArea();
        opisSeansuTextArea.setEditable(false);
        opisSeansuTextArea.setWrapText(true);
        wyszukajButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (pozycjaOblugiwania == 1) {
                    int pozycja = kierownik.wyszukaj(seanseList, tytulTextField.getText());
                    System.out.println(pozycja);
                    if (pozycja >= 0) {
                        String opis = seanseList.getSeans(pozycja).toString();
                        opisSeansuTextArea.setText(opis);
                    } else opisSeansuTextArea.setText("Nie ma takiego seansu");
                }
                if (pozycjaOblugiwania == 2) {
                    int pozycja = pracownik.wyszukaj(seanseList, tytulTextField.getText());
                    System.out.println(pozycja);
                    if (pozycja >= 0) {
                        String opis = seanseList.getSeans(pozycja).toString();
                        opisSeansuTextArea.setText(opis);
                    } else opisSeansuTextArea.setText("Nie ma takiego seansu");
                } else {
                    int pozycja = widz.wyszukaj(seanseList, tytulTextField.getText());
                    System.out.println(pozycja);
                    if (pozycja >= 0) {
                        String opis = seanseList.getSeans(pozycja).toString();
                        opisSeansuTextArea.setText(opis);
                    } else opisSeansuTextArea.setText("Nie ma takiego seansu");
                }
            }
        });

        siatkaPionowa2.getChildren().add(opisSeansuTextArea);

        Scene scene1 = new Scene(glownaScena, 1000, 250);
        primaryStage.setTitle("Kino");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
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
}
