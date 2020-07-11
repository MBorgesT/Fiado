package fiado;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.SQLException;

public class Caderneta {

    public static void main(String[] args) {
        new SeletorMenu().setVisible(true);
    }

}
