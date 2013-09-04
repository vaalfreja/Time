package time;

import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import time.structs.Ticket;
import time.structs.TicketUI;

/**
 * FXML Controller class
 *
 * @author Vaalfreja
 */
public class TimeController implements Initializable {

    //region Dragger

    @FXML
    AnchorPane main;
    @FXML
    Pane todo, completed, passed;

    static public List<Ticket> data;
    static double x, y;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TicketUI tick1 = new TicketUI("t1");
        TicketUI tick2 = new TicketUI("t2");
        TicketUI tick3 = new TicketUI("t3");
        todo.getChildren().add(tick1);
        completed.getChildren().add(tick2);
        passed.getChildren().add(tick3);
        initPane(todo);
        initPane(completed);
        initPane(passed);
    }

    private void initPane(Pane pane) {
        pane.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent dragEvent) {
                dragEvent.acceptTransferModes(TransferMode.ANY);
            }
        });
        pane.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent dragEvent) {
                Dragboard db = dragEvent.getDragboard();
                Ticket result = (Ticket)db.getContent(TicketUI.ticketFormat);
                TicketUI ticketUI = new TicketUI(result);
                Pane source = (Pane)dragEvent.getSource();
                source.getChildren().add(ticketUI);
            }
        });
    }

    @FXML
    private void onTicketDrag() {
    }
    //endregion

    //region Ticker
    AudioClip sound;
    @FXML
    TextField hoursText;
    @FXML
    TextField minutesText;
    @FXML
    TextField secondsText;
    @FXML
    private void tickerOn() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        sound = new AudioClip(file.toURI().toString());
        Timer timer = new Timer();
        Date date = new Date();
        date.setMinutes(date.getMinutes() + 1);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                sound.play();
            }
        }, date, 60*60L * 1000L);
    }

    @FXML
    private void tickerOff() {
        if (sound != null) {
            sound.stop();
        }
    }
    //endregion
}
