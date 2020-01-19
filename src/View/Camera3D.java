//Roberto, Thiago - Trabalho 04 - 2017.1
package View;

import GraphicCube.Ponto4D;

/**
 * Classe responsável por geranciar os dados de camera 3D.
 * Nesta classe são armazenados os dados posição de câmera, lookAt, e vetor up.
 * 
 * @author Roberto Weege Jr
 * @since Versão inicial
 */
public class Camera3D {
    
    private Ponto4D camera;
    private Ponto4D lookAt;
    private Ponto4D up;
    
    /**
     * Método construtor.
     * Seta os valores para todos os atributos.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param camera Ponto4D que contem os valores da camera.
     * @param lookAt Ponto4D que contem os valores de look at.
     * @param up Ponto4D que contem os valores da vetor up.
     */
    public Camera3D(Ponto4D camera, Ponto4D lookAt, Ponto4D up) {
        this.setCamera(camera);
        this.setLookAt(lookAt);
        this.setUp(up);
    }
 
    /**
     * Método get do atributo camera.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return Ponto4D - Objeto contendo as coordendas da câmera.
     */
    public Ponto4D getCamera() {
        return this.camera;
    }
    
    /**
     * Método set do atributo camera.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param camera Objeto contendo as coordendas da câmera.
     */
    public void setCamera(Ponto4D camera) {
        this.camera = camera;
    }
    /**
     * Método get do atributo lookAt.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return Ponto4D - Objeto contendo as coordendas de lookAt.
     */
    public Ponto4D getLookAt() {
        return lookAt;
    }
    /**
     * Método set do atributo lookAt.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param lookAt Objeto contendo as coordendas de lookAt.
     */
    public void setLookAt(Ponto4D lookAt) {
        this.lookAt = lookAt;
    }
    /**
     * Método get do atributo up.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return Ponto4D - Objeto contendo as coordendas de up.
     */
    public Ponto4D getUp() {
        return up;
    }
    /**
     * Método set do atributo up.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param up Objeto contendo as coordendas de up.
     */
    public void setUp(Ponto4D up) {
        this.up = up;
    }

}
