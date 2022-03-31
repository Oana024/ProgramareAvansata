package laborator5.classes.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import laborator5.classes.Catalog;
import laborator5.classes.InvalidCatalog;

import java.io.File;
import java.io.IOException;

public class LoadCommand extends Command {
    public Catalog load(String path)
            throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(new File(path), Catalog.class);
        return catalog;
    }
}
