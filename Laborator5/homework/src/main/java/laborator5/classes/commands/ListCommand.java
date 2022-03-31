package laborator5.classes.commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import laborator5.classes.Catalog;

public class ListCommand extends Command {

    public void list(Catalog catalog) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonInString2 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(catalog);
        System.out.println(jsonInString2);
    }

}
