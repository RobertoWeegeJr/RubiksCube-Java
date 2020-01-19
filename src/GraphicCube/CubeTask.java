//Roberto, Thiago - Trabalho 04 - 2017.1
package GraphicCube;

/**
 * Classe que representa uma tarefa de movimentação de face do cubo gráfico.
 * Esta tarefa pode ser de movimentação de face ou de resolução do cubo.
 * 
 * @author Roberto Weege Jr
 * @since Versão inicial
 */
public class CubeTask {
    
    private CubeTaskType cubeTaskType;
    private MoveCubeTask moveCubeTask;

    /**
     * Método construtor.
     * Seta o valor para o atributo de tipo de tarefa.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param cubeTaskType Tipo da tarefa
     */   
    public CubeTask(CubeTaskType cubeTaskType) {
        this.cubeTaskType = cubeTaskType;
    }
    
    /**
     * Método construtor.
     * Seta o valor para o atributo de tipo de tarefa e lista de movimentos.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param cubeTaskType Tipo da tarefa
     * @param moveCubeTask Lista de movimentos que devem ser realizados no cubo.
     */   
    public CubeTask(CubeTaskType cubeTaskType, MoveCubeTask moveCubeTask) {
        this.cubeTaskType = cubeTaskType;
        this.moveCubeTask = moveCubeTask;
    }
    
    /**
     * Método get do atributo cubeTaskType.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return CubeTaskType - Valor de cubeTaskType.
     */
    public CubeTaskType getCubeTaskType() {
        return cubeTaskType;
    }
    
    /**
     * Método set do atributo cubeTaskType.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param cubeTaskType Valor de cubeTaskType.
     */
    public void setCubeTaskType(CubeTaskType cubeTaskType) {
        this.cubeTaskType = cubeTaskType;
    }
    
    /**
     * Método get do atributo moveCubeTask.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return MoveCubeTask - Lista moveCubeTask.
     */
    public MoveCubeTask getMoveCubeTask() {
        return moveCubeTask;
    }
    
    /**
     * Método set do atributo moveCubeTask.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param moveCubeTask Lista moveCubeTask.
     */
    public void setMoveCubeTask(MoveCubeTask moveCubeTask) {
        this.moveCubeTask = moveCubeTask;
    }
    
}