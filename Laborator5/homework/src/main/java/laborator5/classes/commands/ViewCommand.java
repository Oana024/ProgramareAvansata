package laborator5.classes.commands;

import laborator5.classes.Item;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ViewCommand extends Command {
    public void view(Item item) throws URISyntaxException, IOException {
        Desktop desktop = Desktop.getDesktop();
        String location = item.getLocation();
        System.out.println(location);
        if (location.contains("https"))
            desktop.browse(new URI(item.getLocation()));
        else
            desktop.open(new File(location));
    }
}
