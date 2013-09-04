/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package time.structs;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.paint.Color;
import time.TimeController;

/**
 * @author Admin
 */
public class Ticket implements java.io.Serializable{
    public String Action;
    public Date Added, Deadline;
    public Color currentColor;
    private DateFormat formatter = new SimpleDateFormat("DD.MM.YY HH:MM");
    public int Status;

    public Ticket(String action, String added, String deadline) {
        Action = action;
        Added = stringToDate(added);
        Deadline = stringToDate(deadline);
    }

    public Ticket(String action, Date added, Date deadline) {
        Action = action;
        Added = added;
        Deadline = deadline;
    }

    private String dateToString(Date date) {
        return formatter.format(date);
    }

    private Date stringToDate(String date) {
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
