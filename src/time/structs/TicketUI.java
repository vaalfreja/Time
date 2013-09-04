package time.structs;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

public class TicketUI extends StackPane implements Serializable{
        @FXML private Rectangle rect;
        @FXML private Label lbl;
        private Ticket ticket;
        public static DataFormat ticketFormat = new DataFormat("ticket");
        public TicketUI(String action) {
            this(new Ticket(action, new Date(), new Date()));
        }

    public TicketUI(Ticket ticket) {
        this.ticket = ticket;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "TicketUI.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
            lbl.setText(ticket.Action);
            // Ticket -> Dragboard
            final TicketUI selfLink = this;
            selfLink.setOnDragDetected(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
                    Dragboard db = selfLink.startDragAndDrop(TransferMode.ANY);
                    ClipboardContent cc = new ClipboardContent();
                    cc.put(ticketFormat, selfLink.getTicket());
                    db.setContent(cc);
                    Pane p = (Pane)selfLink.getParent();
                    p.getChildren().remove(selfLink);
                }
            });
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
