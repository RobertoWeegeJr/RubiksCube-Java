//Roberto, Thiago - Trabalho 04 - 2017.1
package View;
/**
 * Classe responsável por geranciar os dados de camera 2D.
 * Nesta classe são armazenados os dados de inicio e fim dos eixos X e Y.
 * Somente são tratadas duas dimensões.
 * 
 * @author Roberto Weege Jr
 * @since Versão inicial
 */
public class Camera2D {
    
    private float gluOrtho2DInicioX;
    private float gluOrtho2DFimX;
    private float gluOrtho2DInicioY;
    private float gluOrtho2DFimY;

     /**
     * Método construtor.
     * Seta os valores para todos os atributos.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param gluOrtho2DInicioX Valor de início no eixo X.
     * @param gluOrtho2DFimX Valor de fim no eixo X.
     * @param gluOrtho2DInicioY Valor de início no eixo Y.
     * @param gluOrtho2DFimY Valor de fim no eixo Y.
     */
    public Camera2D(float gluOrtho2DInicioX, float gluOrtho2DFimX, float gluOrtho2DInicioY, float gluOrtho2DFimY) {
        this.setGluOrtho2DInicioX(gluOrtho2DInicioX);
        this.setGluOrtho2DFimX(gluOrtho2DFimX);
        this.setGluOrtho2DInicioY(gluOrtho2DInicioY);
        this.setGluOrtho2DFimY(gluOrtho2DFimY);
    }
    
    /**
     * Método get do atributo getGluOrtho2DInicioX.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return float - Valor de início no eixo X.
     */
    public float getGluOrtho2DInicioX() {
        return gluOrtho2DInicioX;
    }
    
    /**
     * Método set do atributo getGluOrtho2DInicioX.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param gluOrtho2DInicioX Valor de início no eixo X.
     */
    public void setGluOrtho2DInicioX(float gluOrtho2DInicioX) {
        this.gluOrtho2DInicioX = gluOrtho2DInicioX;
    }
    
    /**
     * Método get do atributo gluOrtho2DFimX.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return float - Valor de fim no eixo X.
     */
    public float getGluOrtho2DFimX() {
        return gluOrtho2DFimX;
    }
    
    /**
     * Método set do atributo gluOrtho2DFimX.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param gluOrtho2DFimX Valor de fim no eixo X.
     */
    public void setGluOrtho2DFimX(float gluOrtho2DFimX) {
        this.gluOrtho2DFimX = gluOrtho2DFimX;
    }

    /**
     * Método get do atributo gluOrtho2DInicioY.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return float - Valor de início no eixo Y.
     */
    public float getGluOrtho2DInicioY() {
        return gluOrtho2DInicioY;
    }
    
    /**
     * Método set do atributo gluOrtho2DInicioY.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param gluOrtho2DInicioY Valor de início no eixo Y.
     */
    public void setGluOrtho2DInicioY(float gluOrtho2DInicioY) {
        this.gluOrtho2DInicioY = gluOrtho2DInicioY;
    }

    /**
     * Método get do atributo gluOrtho2DFimY.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return float - Valor de fim no eixo Y.
     */
    public float getGluOrtho2DFimY() {
        return gluOrtho2DFimY;
    }
    
    /**
     * Método set do atributo gluOrtho2DFimY.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param gluOrtho2DFimY Valor de fim no eixo Y.
     */
    public void setGluOrtho2DFimY(float gluOrtho2DFimY) {
        this.gluOrtho2DFimY = gluOrtho2DFimY;
    }

}
