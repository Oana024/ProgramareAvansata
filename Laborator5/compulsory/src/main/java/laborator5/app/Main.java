package laborator5.app;

import laborator5.classes.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        try {
            app.testCreateSave();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            app.testLoadView();
        } catch (CatalogUtil.InvalidCatalogException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("MyRefs");
        var book = new Book("knuth67", "The Art of Computer Programming", "d:/books/programming/tacp.ps");
        var article = new Article("java17", "The Java Language Specification", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html");

        catalog.add(book);
        catalog.add(article);

        CatalogUtil.save(catalog, "d:/research/catalog.json");
    }

    private void testLoadView() throws CatalogUtil.InvalidCatalogException, IOException {
        Catalog catalog = CatalogUtil.load("d:/research/catalog.json");
        // CatalogUtil.view(catalog.findById("knuth67"));
        //  CatalogUtil.view(catalog.findById("java17"));
    }

}
