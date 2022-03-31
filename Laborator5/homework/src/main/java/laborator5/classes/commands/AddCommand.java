package laborator5.classes.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import laborator5.classes.Catalog;

import java.io.File;
import java.io.IOException;

public class AddCommand extends Command {
    public void save(Catalog catalog, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), catalog);
    }
}
