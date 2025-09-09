package utils;

import java.awt.Graphics2D;
import java.net.URL;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

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
            JOptionPane.showMessageDialog(null, "Erro ao converter a data");
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

    public static String converterDateToString(Date data) {
        //construa o formato que quero transformar o texto
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String texto = "";

        try {
            //tenta converter a String em Date baseado no foormato
            //construido anteriormente
            texto = formato.format(data);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao formatar a data");
        }
        return texto;

    }

    public static File escolherImagem() {
        File arquivo = null;

        // CORRIGIDO: usa a palavra-chave 'new' para instanciar a classe
        JFileChooser exploradorArquivos = new JFileChooser();

        exploradorArquivos.setDialogTitle("Escolha um arquivo");

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagens", "jpg", "jpeg", "png");
        exploradorArquivos.setFileFilter(filtro);

        // CORRIGIDO: nome correto do método é setMultiSelectionEnabled
        exploradorArquivos.setMultiSelectionEnabled(false);

        int resultado = exploradorArquivos.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            arquivo = exploradorArquivos.getSelectedFile();
        }

        return arquivo;
    }

    public static Icon converterFileToIcon(File arquivo) {
        ImageIcon icon = new ImageIcon(arquivo.getAbsolutePath());

        return icon;
    }

    public static ImageIcon redimensionarImageIcon(Icon icone, int largura, int altura) {
        Image imagemOriginal = ((ImageIcon) icone).getImage();
        Image novaImagem = imagemOriginal.getScaledInstance(largura, altura, Image.SCALE_SMOOTH);

        return new ImageIcon(novaImagem);
    }

    public static byte[] converterIconToBytes(Icon icon) {
        BufferedImage image = new BufferedImage(
                icon.getIconWidth(),
                icon.getIconHeight(),
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        icon.paintIcon(null, g2d, 0, 0);
        g2d.dispose();
        
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        try{
            ImageIO.write(image, "png", byteArray);
        } catch (IOException erro) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, erro);
        }
        return byteArray.toByteArray();
    }
}
