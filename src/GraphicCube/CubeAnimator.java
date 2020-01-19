//Roberto, Thiago - Trabalho 04 - 2017.1
package GraphicCube;

import View.Main;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe responsável por gerenciar as alteraçõe gráficas do cubo gráfico.
 * Esta classe é um thread do projeto, que recebe os inputs da interface gráfica 
 * e gerencia a aplicação das alterações no cubo.
 * Este objeto contem uma fila de movimentos, alimentada pela interface gráfica. 
 * 
 * @author Roberto Weege Jr
 * @since Versão inicial
 */
public class CubeAnimator extends Thread {

    private Main main;
    private Cube cube;
    private ArrayList <CubeTask> cubeMoves;
    private boolean viewChange;
    private boolean isAlive;
    private long lastExecution;
    
    /**
     * Método construtor.
     * Seta os valores para os atributos.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param main Objeto controlador da interface gráfica.
     */
    public CubeAnimator(Main main) {
        super();
        this.setMain(main);
        this.setCube(main.getCube());
        this.setCubeMoves(new ArrayList());
        this.setViewChange(false);
        this.setIsAtive(true);
    }
    
    /**
     * Método get do atributo main.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return Main - Objeto Main.
     */
    public Main getMain() {
        return main;
    }

    /**
     * Método set do atributo main.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param main objeto Main.
     */
    public void setMain(Main main) {
        this.main = main;
    }
    
    /**
     * Método get do atributo cube.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return Cube - Objeto Cube.
     */
    public Cube getCube() {
        return this.cube;
    }

    /** 
     * Método set do atributo cube.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param cube Objeto Cube.
     */
    public void setCube(Cube cube) {
        this.cube = cube;
    }

    /** 
     * Método get do atributo cubeMoves.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return ArrayList - Lista de movimentos de cubo.
     */
    public ArrayList<CubeTask> getCubeMoves() {
        return cubeMoves;
    }

    /** 
     * Método set do atributo cubeMoves.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param cubeMoves Lista de movimentos de cubo.
     */    
    public void setCubeMoves(ArrayList<CubeTask> cubeMoves) {
        this.cubeMoves = cubeMoves;
    }

    /** 
     * Método get do atributo cubeMoves.size().
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return int - Tamanho da lista de movimentos de cubo.
     */    
    public int getCubeMovesSize() {
        synchronized (this) {
            return this.cubeMoves.size();
        }
    }
    
    /** 
     * Método add do atributo cubeMoves.
     * Adiciona um elemento à fila de movimentos de cubo.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param moveTask Tarefa para ser adicionada à lista de movimentos de cubo.
     */    
    public void addMoveTask(CubeTask moveTask) {
        synchronized (this) {
            this.cubeMoves.add(moveTask);
        }
        this.setViewChange(true);
    }

    /** 
     * Método remove do atributo cubeMoves.
     * Retira e retorna o primeiro elemento fila de movimentações de cubo.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return MoveTask - Primeiro elemento fila de movimentações de cubo.
     */
    public CubeTask getMoveTask() {
        synchronized (this) {
            return this.cubeMoves.remove(0);
        }
    }

    /** 
     * Método get do atributo viewChange;
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return boolean - Atributo viewChange.
     */
    public boolean isViewChange() {
        synchronized (this) {
            return this.viewChange;
        }
    }

    /** 
     * Método set do atributo viewChange;
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param viewChange - Atributo viewChange.
     */
    public void setViewChange(boolean viewChange) {
        synchronized (this) {
            this.viewChange = viewChange;
        }
    }
    
    /** 
     * Método get do atributo isAtive;
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return boolean - Atributo isAtive.
     */
    public boolean isIsAtive() {
        synchronized (this) {
            return isAlive;
        }
    }
    
    /** 
     * Método set do atributo isAtive;
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param isAtive - Atributo isAtive.
     */
    public void setIsAtive(boolean isAtive) {
        synchronized (this) {
            this.isAlive = isAtive;
        }
    }
    
    /** 
     * Método get do atributo lastExecution;
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return long - Atributo lastExecution.
     */
    public long getLastExecution() {
        return lastExecution;
    }
    
    /** 
     * Método set do atributo lastExecution;
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param lastExecution - Atributo lastExecution.
     */
    public void setLastExecution(long lastExecution) {
        this.lastExecution = lastExecution;
    }

    /** 
     * Método run da classe Thread
     * Este método monitora a fila de tarefas de movimentações.
     * Enquanto existem elementos na fila os movimentos são consumidos da fila e executados.
     * Quando não existem elementos na fila, mas ocorreram alterações na interface grafica (câmera por exemplo),
     * a tela é atualizada.
     * Quando são existem elementos na fila e nenhuma alteração é realizada na interface gráfica por mais de 20s, 
     * o cubo entra em modo de animação até que alguma interação seja realizda na interface gráfica.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     */    
    @Override
    public void run() {
        this.setLastExecution(System.currentTimeMillis());
        try {
            while (this.isAlive()) {
                if (getCubeMovesSize() > 0) {
                    CubeTask moveTask = getMoveTask();
                    if (moveTask.getCubeTaskType() == CubeTaskType.Solve){
                        this.executeSolveCube(this.getCube().getLogicalSolution());
                    } else if (moveTask.getCubeTaskType() == CubeTaskType.Move){
                        this.getCube().rotateFace(moveTask.getMoveCubeTask().getFaceColor(), 
                                                  moveTask.getMoveCubeTask().isRightMove(), 
                                                  moveTask.getMoveCubeTask().isApplyInLogicalCube());
                        this.setViewChange(false);
                        this.getMain().displayWithPartial();
                        this.setLastExecution(System.currentTimeMillis());
                    }
                } else {
                    if (this.isViewChange()) {
                        this.setViewChange(false);
                        this.getMain().displayWithPartial();
                        this.setLastExecution(System.currentTimeMillis());
                    } else {
                        try {
                            sleep(50);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(CubeAnimator.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (System.currentTimeMillis() - this.getLastExecution() > 20 * 1000) {
                            while (!this.isViewChange() && this.isAlive()) {
                                this.getMain().setViewRotationX(this.getMain().getViewRotationX() + 0.2f);
                                this.getMain().setViewRotationY(this.getMain().getViewRotationY() + 0.2f);
                                this.getMain().displayWithPartial();
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
    }
    
    /** 
     * Método que executa as movimentações para resolver o cubo gráfico.
     * Este método analisa o retorno do cubo lógico e executa as movimentações.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * 
     * @param solution Lista contendo a lista de movimentos necessários para resolver o cubo.
     */  
    public void executeSolveCube(ArrayList<String> solution){
        for (int i = 0; i < solution.size() && this.isAlive(); i++){
            switch (solution.get(i)) {
                case "WH":
                    this.getCube().rotateFace(GraficColor.WH, true, false);
                    break;
                case "WHi":
                    this.getCube().rotateFace(GraficColor.WH, false, false);
                    break;
                case "RE":
                    this.getCube().rotateFace(GraficColor.RE, true, false);
                    break;
                case "REi":
                    this.getCube().rotateFace(GraficColor.RE, false, false);
                    break;
                case "GR":
                    this.getCube().rotateFace(GraficColor.GR, true, false);
                    break;
                case "GRi":
                    this.getCube().rotateFace(GraficColor.GR, false, false);
                    break;
                case "BL":
                    this.getCube().rotateFace(GraficColor.BL, true, false);
                    break;
                case "BLi":
                    this.getCube().rotateFace(GraficColor.BL, false, false);
                    break;
                case "OR":
                    this.getCube().rotateFace(GraficColor.OR, true, false);
                    break;
                case "ORi":
                    this.getCube().rotateFace(GraficColor.OR, false, false);
                    break;
                case "YE":
                    this.getCube().rotateFace(GraficColor.YE, true, false);
                    break;
                case "YEi":
                    this.getCube().rotateFace(GraficColor.YE, false, false);
                    break;
            }
            this.getMain().displayWithPartial();
            this.setViewChange(false);
            this.setLastExecution(System.currentTimeMillis());
        }
    }

}
