package persistence;

import model.MealWishList;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// Represents a writer that writes JSON representation of meal wishlist file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    //          be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter((new File(destination)));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of meal wishlist to file
    public void write(MealWishList ml) {
        JSONObject json = ml.toJson();
        saveToFile(json.toString(TAB));
    }

    public void close() {

        writer.close();
    }

    private void saveToFile(String json) {

        writer.print(json);
    }
}
