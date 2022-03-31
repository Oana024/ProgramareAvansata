package laborator5.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import laborator5.classes.*;
import laborator5.classes.commands.*;
import org.json.JSONException;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        try {
            app.testCreateSave();
        } catch (IOException | InvalidCatalog e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            app.testLoadView();
        } catch (InvalidCatalog | URISyntaxException | IOException e) {
            e.printStackTrace();
        }

    }

    private void testCreateSave() throws IOException, InvalidCatalog, JSONException {

        Catalog catalog = new Catalog("MyRefs");
        var book = new Book("knuth67", "The Art of Computer Programming", "d:/research/adeverinta.pdf");
        var article = new Article("java17", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html");

        catalog.add(book);
        catalog.add(article);

        Command command = new AddCommand();

        command.save(catalog, "d:/research/catalog.json");

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(catalog);

        ReportCommand report = new ReportCommand();
        report.command("./index.vm", jsonString);
    }

    private void testLoadView() throws InvalidCatalog, IOException, URISyntaxException {
        Command command = new LoadCommand();
        Catalog catalog = command.load("d:/research/catalog.json");

        Command viewC = new ViewCommand();
        viewC.view(catalog.findById("knuth67"));
        viewC.view(catalog.findById("java17"));
    }

}
