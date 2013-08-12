/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package time.operations;

import time.TimeController;
import time.structs.Ticket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import time.Time;

/**
 *
 * @author Admin
 */
public class FileOperations {
/*
    public static ObservableList<Ticket> getFromFile() {
        ObservableList<Ticket> res = FXCollections.observableArrayList();
        try {
            BufferedReader fr = new BufferedReader(new FileReader("data.dat"));
            String variable = null;
            while ((variable = fr.readLine()) != null) {
                String[] structs = variable.split("\t");
                String last = structs.length > 5 ? structs[5] : "";
                if ("".equals(structs[2])) {
                    structs[2] = "0";
                }
                if ("".equals(structs[3]) || "".equals(structs[4])) {
                    break;
                }
                Ticket t = new Ticket(
                        new TimeStruct(
                        structs[0],
                        structs[1],
                        new Interval(structs[2]),
                        new Interval(structs[3]),
                        Integer.parseInt(structs[4]),
                        last));
                res.add(t);
            }
            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(Time.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public static void writeToFile(ObservableList<Ticket> fileData) {
        try (BufferedWriter bf = new BufferedWriter(new FileWriter("data.dat"))) {
            for (Ticket tsi : fileData) {
                if (!tsi.getDate().isEmpty()) {
                    bf.write(String.format("%s\t%s\t%s\t%s\t%s\t%s",
                            tsi.getAction(),
                            tsi.getDate(),
                            tsi.getPlan(),
                            tsi.getTime(),
                            tsi.getK(),
                            tsi.getComment()));
                    bf.write(System.getProperty("line.separator"));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(TimeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}
