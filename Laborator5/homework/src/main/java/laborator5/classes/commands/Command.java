package laborator5.classes.commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import laborator5.classes.Catalog;
import laborator5.classes.Item;

import java.io.IOException;
import java.net.URISyntaxException;

public abstract class Command {
    public void save(Catalog catalog, String path) throws IOException {

    }

    public Catalog load(String path) throws IOException {
        return null;
    }

    public void view(Item item) throws URISyntaxException, IOException {

    }

    public void list(Catalog catalog) throws JsonProcessingException {

    }

    public void report() {

    }
}
