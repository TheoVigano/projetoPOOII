package utils;

import java.net.URL;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class Util {

    public static Image getIcone() {
        URL caminhoImagem = Util.class.getResource("/images/iconlogo.png");
        ImageIcon icon = new ImageIcon(caminhoImagem);

        return icon.getImage();
    }

    public static java.util.Date converterStringToDate(String texto) {
        //construa o formato que quero transformar o texto
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        //cria minha variavel data que sera o retorno do metodo
        java.util.Date data = null;

        try {
            //tenta converter a String em Date baseado no foormato
            //construido anteriormente
            data = formato.parse(texto);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao converer a data");
        }
        return data;

    }

    public static String calcularHash(String senha) {
        String hashSHA1 = "";
        try {
            //crie uma instância do messageDigest
            //com o algoritimo SHA1
            MessageDigest sha1 = MessageDigest.getInstance("SHA1");

            //atualize o digset com os bytes do texto
            sha1.update(senha.getBytes());

            //calcule o hash SHA1
            byte[] digest = sha1.digest();

            //converta o hash de bytes para
            //uma representação hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            hashSHA1 = sb.toString();

        } catch (NoSuchAlgorithmException e) {
            System.out.println("Algoritimo SHA1 não encontrado");
        }
        return hashSHA1;
    }

}
