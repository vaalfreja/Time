package time.structs;

import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.*;

import java.io.IOException;

public class TicketUI extends StackPane{
        @FXML private Rectangle rect;
        @FXML private Label lbl;
        private Ticket ticket;
        public static DataFormat ticketFormat = new DataFormat("ticket");
        public TicketUI() {
            // Ticket -> Dragboard
            final TicketUI selfLink = this;
            selfLink.setOnDragDetected(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                    Dragboard db = selfLink.startDragAndDrop(TransferMode.ANY);
                    ClipboardContent cc = new ClipboardContent();
                    cc.put(ticketFormat, selfLink.getTicket());
                    db.setContent(cc);
                }
            });
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                    "TicketUI.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);
            try {
                fxmlLoader.load();
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        }

        public Ticket getTicket() {
            return ticket;
        }

        @FXML
        protected void doSomething() {
            System.out.println("The button was clicked!");
        }
}
