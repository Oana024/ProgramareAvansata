package laborator5.classes.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.json.JSONException;
import org.json.JSONObject;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;

public class ReportCommand extends Command {
    private VelocityEngine velocityEngine = new VelocityEngine();
    public ReportCommand()
    {
        velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();
    }

    public void command(String templatePath, String jsonString) throws IOException, JSONException {
        JSONObject jsonObj = new JSONObject(jsonString);
        VelocityContext context = new VelocityContext();
        for (Iterator it = jsonObj.keys(); it.hasNext(); ) {
            String key = (String) it.next();
            context.put(key, jsonObj.get(key));
        }

        Writer writer = new StringWriter();
        velocityEngine.mergeTemplate(templatePath, "UTF-8", context, writer);
        writer.flush();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("d:/lab5/report.html"), writer.toString());

        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File("d:/lab5/report.html"));
    }

}
