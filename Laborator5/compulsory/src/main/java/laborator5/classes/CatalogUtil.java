package laborator5.classes;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CatalogUtil {
    public static void save(Catalog catalog, String path)
            throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), catalog.toString());
    }

    public static class InvalidCatalogException extends Exception {
        public InvalidCatalogException(Exception exception) {
            super("Invalid catalog file.", exception);
        }
    }

    public static Catalog load(String path)
            throws InvalidCatalogException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(path), Catalog.class);
    }

//    public static void view(Item item) throws IOException {
//        Desktop desktop = Desktop.getDesktop();
//        desktop.open(new File(item.getLocation()));
//    }

}
