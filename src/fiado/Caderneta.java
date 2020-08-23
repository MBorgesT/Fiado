package fiado;

public class Caderneta {

    public static void main(String[] args) {
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");

        new SeletorMenu().setVisible(true);
    }

}
