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
//        firstRect.setOnMousePressed(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                    x = firstRect.getLayoutX() - event.getSceneX();
//                    y = firstRect.getLayoutY() - event.getSceneY();
//                    logLabel.setText(x + " " + y);
//            }
//        });
//        firstRect.setOnMouseDragged(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                    logLabel.setText(logLabel.getText() + "\n"
//                            + event.getScreenX() + " " + event.getScreenY());
//                    firstRect.setLayoutX(event.getSceneX() + x);
//                    firstRect.setLayoutY(event.getSceneY() + y);
//            }
//        });
        /*final Ticket t = new Ticket("Test action",
                new Date(2012, 12,12),
                new Date(2012, 12,12));
        firstRect.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Dragboard db = firstRect.startDragAndDrop(TransferMode.ANY);
                ClipboardContent cc = new ClipboardContent();
                cc.put(rectangleFormat, t); // something should be, or doesn't work
                //TODO как запихнуть ректангл в драгбоард
                db.setContent(cc);
            }
        });
        pane2.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent dragEvent) {
                dragEvent.acceptTransferModes(TransferMode.ANY);
            }
        });
        pane2.setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                Ticket result = (Ticket)db.getContent(rectangleFormat);
                TicketUI ticket = new TicketUI();
                pane2.getChildren().add(ticket);
                event.setDropCompleted(true);
            }
        });    */
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
