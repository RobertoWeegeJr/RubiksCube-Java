//Roberto, Thiago - Trabalho 04 - 2017.1
package GraphicCube;

/**
 * Classe que representa uma tarefa de movimentação de face do cubo gráfico.
 * 
 * @author Roberto Weege Jr
 * @since Versão inicial
 */
public class MoveCubeTask {
    private GraficColor faceColor;
    private boolean rightMove;
    private boolean applyInLogicalCube;

    /**
     * Método construtor.
     * Seta os valores para os atributos.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param faceColor Cor da face que deve ser movimentada.
     * @param rightMove Determina se movimento é para a direita ou para a esquerda.
     * @param applyInLogicalCube Determina o movimento deve ser aplicado também no cubo lógico.
     */    
    public MoveCubeTask(GraficColor faceColor, boolean rightMove, boolean applyInLogicalCube) {
        this.setFaceColor(faceColor); 
        this.setRightMove(rightMove);
        this.setApplyInLogicalCube(applyInLogicalCube);
    }
    
    /**
     * Método get do atributo faceColor.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return Color - Enum faceColor.
     */    
    public GraficColor getFaceColor() {
        return faceColor;
    }

    /**
     * Método set do atributo faceColor.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param faceColor Valor de faceColor.
     */    
    public void setFaceColor(GraficColor faceColor) {
        this.faceColor = faceColor;
    }
    
    /**
     * Método get do atributo rightMove.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return boolean - Valor rightMove.
     */    
    public boolean isRightMove() {
        return rightMove;
    }
    
    /**
     * Método set do atributo rightMove.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param rightMove Valor rightMove.
     */
    public void setRightMove(boolean rightMove) {
        this.rightMove = rightMove;
    }
    
    /**
     * Método get do atributo applyInLogicalCube.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return boolean - Valor applyInLogicalCube.
     */    
    public boolean isApplyInLogicalCube() {
        return applyInLogicalCube;
    }
    
    /**
     * Método set do atributo applyInLogicalCube.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param applyInLogicalCube Valor applyInLogicalCube.
     */
    public void setApplyInLogicalCube(boolean applyInLogicalCube) {
        this.applyInLogicalCube = applyInLogicalCube;
    }

}
