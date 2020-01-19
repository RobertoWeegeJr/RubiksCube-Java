//Roberto, Thiago - Trabalho 04 - 2017.1
package View;
import com.sun.opengl.util.texture.TextureData;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;
import javax.media.opengl.GL;
import javax.swing.JOptionPane;

/**
 * Classe responsável por geranciar as texturas das subfaces do cubo.
 * 
 * @author GCG
 * @since Versão inicial
 */
public class FaceTextureManager {
    private int[] idTexture;
    private ByteBuffer[] buffer;	
    private TextureData td;
    private BufferedImage image;
    
    /**
     * Método get do atributo idTexture.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return int[] - Conjunto de ids de texturas.
     */
    public int[] getIdTexture() {
        return idTexture;
    }
    
    /**
     * Método set do atributo idTexture.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param idTexture Conjunto de ids de texturas.
     */
    public void setIdTexture(int[] idTexture) {
        this.idTexture = idTexture;
    }
    
    /**
     * Método get do atributo buffer.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return ByteBuffer[] - Objetos de buffer.
     */
    public ByteBuffer[] getBuffer() {
        return buffer;
    }
    
    /**
     * Método set do atributo buffer.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param buffer Objetos de buffer.
     */
    public void setBuffer(ByteBuffer[] buffer) {
        this.buffer = buffer;
    }
    
    /**
     * Método get do atributo td.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return TextureData - Objeto td.
     */
    public TextureData getTd() {
        return td;
    }

    /**
     * Método set do atributo td.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param td Objeto td.
     */
    public void setTd(TextureData td) {
        this.td = td;
    }
    
    /**
     * Método get do atributo image.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return BufferedImage - Objeto imagem.
     */
    public BufferedImage getImage() {
        return image;
    }
    
    /**
     * Método set do atributo image.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param image Objeto imagem.
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
    /**
     * Método get de width da imagem.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return int - Width da imagem.
     */
    public int getImageWidth() {
        return this.getImage().getWidth();
    }
    
    /**
     * Método get de height da imagem.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return int - Height da imagem.
     */
    public int getImageHeight() {
        return this.getImage().getHeight();
    }
    
    /**
     * Método que configura a textura.
     *
     * @author GCG
     * @since Versão inicial
     * @param gl Parâmetro OpenGL.
     * @param fileName Caminho do arquivo de textura.
     */
    public void configureTextures(GL gl, String fileName){
        this.setIdTexture(new int[3]);
        gl.glGenTextures(1, this.getIdTexture(), 2);
        gl.glTexParameteri(GL.GL_TEXTURE_2D,GL.GL_TEXTURE_MIN_FILTER,GL.GL_LINEAR);	
        gl.glTexParameteri(GL.GL_TEXTURE_2D,GL.GL_TEXTURE_MAG_FILTER,GL.GL_LINEAR);
        this.setBuffer(new ByteBuffer [1]);
        this.loadImage(0,fileName); 
    }
    
     /**
     * Método que carrega uma imagem para configurar a textura.
     *
     * @author GCG
     * @since Versão inicial
     * @param ind Indice da imagem no buffer.
     * @param fileName Caminho do arquivo de textura.
     */
    private void loadImage(int ind, String fileName){
        try {
            this.setImage(ImageIO.read(new File(fileName)));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Fail to load " + fileName);
        }
        this.setTd(new TextureData(0,0,false,this.getImage()));
        this.getBuffer()[ind] = (ByteBuffer) this.getTd().getBuffer();
    }
}
