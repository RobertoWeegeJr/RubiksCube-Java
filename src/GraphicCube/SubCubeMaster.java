//Roberto, Thiago - Trabalho 04 - 2017.1
package GraphicCube;

import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;

/**
 * Classe que representa um sub cubo mestre, que compõe o cubo.
 * Nesta classe ocorrem as movimentações das faces do cubo, e, por consequencia, 
 * as atualizações das faces envolvidas na movimentação.
 * 
 * @author Roberto Weege Jr
 * @since Versão inicial
 */
public class SubCubeMaster extends SubCube {

    private Cube cube;
    private GraficColor color;
    private SubFace[] face = new SubFace[8];

    private boolean reverseMovement;
    private Axis axis;

    private GraficColor[] neighborColors;
    private int[][] neighborIndexes;

    private Operation incompleteOperation;
    private boolean incompleteApplyInLogicalCube;
    private double actualAngle;

    /**
     * Método construtor.
     * Seta os valores para os atributos.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param cube Objeto Cubo.
     * @param color Valor de cor.
     * @param reverseMovement Determina se a movimentação da face é realizada de forma inversa.
     * @param axis Determina o eixo em que a face rotaciona durante o movimento.
     * @param neighborColors Array contendo as cores das faces vizinhas (cima, direita, baixo, esquerda)
     * @param neighborIndexes Matriz contendo ois indices das faces vizinhas que fazem diviza com a face do objeto. 
     * Cada linha é referente a cor do array neighborColors. As colunas estão na sequencia do movimento para a direita.
     */   
    public SubCubeMaster(Cube cube, GraficColor color, boolean reverseMovement, Axis axis, GraficColor[] neighborColors, int[][] neighborIndexes) {
        this.setCube(cube);
        this.setGraficColor(color);
        this.setReverseMovement(reverseMovement);
        this.setAxis(axis);
        this.setNeighborColors(neighborColors);
        this.setNeighborIndexes(neighborIndexes);
        this.setIncompleteOperation(Operation.None);
    }
    
    /**
     * Método get do atributo cube.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return Cube - Objeto cube.
     */
    public Cube getCube() {
        return cube;
    }
    
    /**
     * Método set do atributo cube.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param cube Objeto cube.
     */   
    public void setCube(Cube cube) {
        this.cube = cube;
    }
    
    /**
     * Método get do atributo color.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return Color - Valor de color.
     */
    public GraficColor getGraficColor() {
        return color;
    }
    
    /**
     * Método set do atributo color.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param color Valor color.
     */  
    public void setGraficColor(GraficColor color) {
        this.color = color;
    }

    /**
     * Método get do atributo face.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return SubFace[] - Objeto face.
     */
    public SubFace[] getFace() {
        return face;
    }
    
    /**
     * Método set do atributo face.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param face Objeto face.
     */  
    public void setFace(SubFace[] face) {
        this.face = face;
    }

    /**
     * Método get do atributo reverseMovement.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return boolean - Valor reverseMovement.
     */    
    public boolean isReverseMovement() {
        return reverseMovement;
    }
    
    /**
     * Método set do atributo reverseMovement.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param reverseMovement Valor reverseMovement.
     */  
    public void setReverseMovement(boolean reverseMovement) {
        this.reverseMovement = reverseMovement;
    }

    /**
     * Método get do atributo axis.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return Axis - Valor axis.
     */     
    public Axis getAxis() {
        return axis;
    }
    
    /**
     * Método set do atributo axis.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param axis Valor axis.
     */  
    public void setAxis(Axis axis) {
        this.axis = axis;
    }

    /**
     * Método get do atributo neighborColors.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return Color[] - Valor neighborColors.
     */     
    public GraficColor[] getNeighborColors() {
        return neighborColors;
    }
    
    /**
     * Método set do atributo neighborColors.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param neighborColors Valores neighborColors.
     */  
    public void setNeighborColors(GraficColor[] neighborColors) {
        this.neighborColors = neighborColors;
    }
    
    /**
     * Método get do atributo neighborIndexes.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return int[][] - Valor neighborIndexes.
     */
    public int[][] getNeighborIndexes() {
        return neighborIndexes;
    }

    /**
     * Método set do atributo neighborIndexes.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param neighborIndexes Valores neighborIndexes.
     */      
    public void setNeighborIndexes(int[][] neighborIndexes) {
        this.neighborIndexes = neighborIndexes;
    }
    
    /**
     * Método get do atributo incompleteOperation.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return Operation - Valor incompleteOperation.
     */
    public Operation getIncompleteOperation() {
        return incompleteOperation;
    }
    
    /**
     * Método set do atributo incompleteOperation.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param incompleteOperation Valor incompleteOperation.
     */         
    public void setIncompleteOperation(Operation incompleteOperation) {
        this.incompleteOperation = incompleteOperation;
    }
    
    /**
     * Método get do atributo incompleteApplyInLogicalCube.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return boolean - Valor incompleteApplyInLogicalCube.
     */
    public boolean isIncompleteApplyInLogicalCube() {
        return incompleteApplyInLogicalCube;
    }

    /**
     * Método set do atributo incompleteApplyInLogicalCube.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param incompleteApplyInLogicalCube Valor incompleteApplyInLogicalCube.
     */      
    public void setIncompleteApplyInLogicalCube(boolean incompleteApplyInLogicalCube) {
        this.incompleteApplyInLogicalCube = incompleteApplyInLogicalCube;
    }
    
    /**
     * Método get do atributo actualAngle.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return double - Valor actualAngle.
     */
    public double getActualAngle() {
        return actualAngle;
    }

    /**
     * Método set do atributo actualAngle.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param actualAngle Valor actualAngle.
     */     
    public void setActualAngle(double actualAngle) {
        this.actualAngle = actualAngle;
    }
    
    /**
     * Método responsável por realizar a rotação da face para a direita.
     * Este método executará o movimento em 1 grau, para que o cubo seja animado.
     * Assim que o movimento se concluír (quanto o ângulo chegar em 90) o cubo lógico 
     * é atualizado de acordo com o parâmetro e todas as alterações de referência 
     * são aplicadas na face atual e nas faces vizinhas.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param applyInLogicalCube Determina se o movimento será aplicado ou não ao cubo lógico.
     */    
    public void rightRotate(boolean applyInLogicalCube) {
        if (this.getIncompleteOperation() == Operation.None) {
            this.setIncompleteOperation(Operation.RightMove);
            this.setIncompleteApplyInLogicalCube(applyInLogicalCube);
            this.setActualAngle(0);
        } else {
            this.rotate((this.isReverseMovement() ? 1 : -1));
            this.setActualAngle(this.getActualAngle() + 1);
            if (this.getActualAngle() >= 90) {
                if (applyInLogicalCube) {
                    this.getCube().applyLogicalRotation(this.getGraficColor(), true);
                }
                this.updateFacesRightRotate();
                this.setIncompleteOperation(Operation.None);
            }
        }
    }
    
    /**
     * Método responsável por realizar a rotação da face para a esquerda.
     * Este método executará o movimento em 1 grau, para que o cubo seja animado.
     * Assim que o movimento se concluír (quanto o ângulo chegar em 90) o cubo lógico 
     * é atualizado de acordo com o parâmetro e todas as alterações de referência 
     * são aplicadas na face atual e nas faces vizinhas.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param applyInLogicalCube Determina se o movimento será aplicado ou não ao cubo lógico.
     */    
    public void leftRotate(boolean applyInLogicalCube) {
        if (this.getIncompleteOperation() == Operation.None) {
            this.setIncompleteOperation(Operation.LeftMove);
            this.setIncompleteApplyInLogicalCube(applyInLogicalCube);
            this.setActualAngle(0);
        } else {
            this.rotate((this.isReverseMovement() ? -1 : 1));
            this.setActualAngle(this.getActualAngle() + 1);
            if (this.getActualAngle() >= 90) {
                if (applyInLogicalCube) {
                    this.getCube().applyLogicalRotation(this.getGraficColor(), false);
                }
                this.updateFacesLeftRotate();
                this.setIncompleteOperation(Operation.None);
            }
        }
    }
    
    /**
     * Método responsável por aplicar a rotação no sub cubo atual e nos subcubos 
     * vizinhos.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param angle Angulo da rotação.
     */    
    private void rotate(double angle) {
        double radians = Transformacao4D.DEG_TO_RAD * angle;
        this.getTransformacao4D().aplicaRotacao(this.getAxis(), radians);
        Transformacao4D transformacao4D = new Transformacao4D();
        transformacao4D.aplicaRotacao(this.getAxis(), radians);
        for (int i = 0; i < this.getFace().length; i++) {
            this.getFace()[i].getParentSubCube().setTransformacao4D(transformacao4D.transformMatrix(this.getFace()[i].getParentSubCube().getTransformacao4D()));
        }
    }

    /**
     * Método responsável por aplicar as atualizações de referência na face do sub cubo atual
     * e nas faces dos sub cubos vizinhos quando a movimentação para a direita é finalizada.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param angle Angulo da rotação.
     */    
    private void updateFacesRightRotate() {

        SubFace[] tempSubFaces = {getCube().getSubCubesMaster().get(this.getNeighborColors()[0]).getFace()[this.getNeighborIndexes()[0][0]],
            getCube().getSubCubesMaster().get(this.getNeighborColors()[0]).getFace()[this.getNeighborIndexes()[0][1]],
            getCube().getSubCubesMaster().get(this.getNeighborColors()[0]).getFace()[this.getNeighborIndexes()[0][2]]};

        getCube().getSubCubesMaster().get(this.getNeighborColors()[0]).getFace()[this.getNeighborIndexes()[0][0]] = getCube().getSubCubesMaster().get(this.getNeighborColors()[3]).getFace()[this.getNeighborIndexes()[3][0]];
        getCube().getSubCubesMaster().get(this.getNeighborColors()[0]).getFace()[this.getNeighborIndexes()[0][1]] = getCube().getSubCubesMaster().get(this.getNeighborColors()[3]).getFace()[this.getNeighborIndexes()[3][1]];
        getCube().getSubCubesMaster().get(this.getNeighborColors()[0]).getFace()[this.getNeighborIndexes()[0][2]] = getCube().getSubCubesMaster().get(this.getNeighborColors()[3]).getFace()[this.getNeighborIndexes()[3][2]];

        getCube().getSubCubesMaster().get(this.getNeighborColors()[3]).getFace()[this.getNeighborIndexes()[3][0]] = getCube().getSubCubesMaster().get(this.getNeighborColors()[2]).getFace()[this.getNeighborIndexes()[2][0]];
        getCube().getSubCubesMaster().get(this.getNeighborColors()[3]).getFace()[this.getNeighborIndexes()[3][1]] = getCube().getSubCubesMaster().get(this.getNeighborColors()[2]).getFace()[this.getNeighborIndexes()[2][1]];
        getCube().getSubCubesMaster().get(this.getNeighborColors()[3]).getFace()[this.getNeighborIndexes()[3][2]] = getCube().getSubCubesMaster().get(this.getNeighborColors()[2]).getFace()[this.getNeighborIndexes()[2][2]];

        getCube().getSubCubesMaster().get(this.getNeighborColors()[2]).getFace()[this.getNeighborIndexes()[2][0]] = getCube().getSubCubesMaster().get(this.getNeighborColors()[1]).getFace()[this.getNeighborIndexes()[1][0]];
        getCube().getSubCubesMaster().get(this.getNeighborColors()[2]).getFace()[this.getNeighborIndexes()[2][1]] = getCube().getSubCubesMaster().get(this.getNeighborColors()[1]).getFace()[this.getNeighborIndexes()[1][1]];
        getCube().getSubCubesMaster().get(this.getNeighborColors()[2]).getFace()[this.getNeighborIndexes()[2][2]] = getCube().getSubCubesMaster().get(this.getNeighborColors()[1]).getFace()[this.getNeighborIndexes()[1][2]];

        getCube().getSubCubesMaster().get(this.getNeighborColors()[1]).getFace()[this.getNeighborIndexes()[1][0]] = tempSubFaces[0];
        getCube().getSubCubesMaster().get(this.getNeighborColors()[1]).getFace()[this.getNeighborIndexes()[1][1]] = tempSubFaces[1];
        getCube().getSubCubesMaster().get(this.getNeighborColors()[1]).getFace()[this.getNeighborIndexes()[1][2]] = tempSubFaces[2];

        SubFace[] tempSubFace = {this.getFace()[6],
            this.getFace()[7]};

        this.getFace()[7] = this.getFace()[5];
        this.getFace()[6] = this.getFace()[4];
        this.getFace()[5] = this.getFace()[3];
        this.getFace()[4] = this.getFace()[2];
        this.getFace()[3] = this.getFace()[1];
        this.getFace()[2] = this.getFace()[0];
        this.getFace()[1] = tempSubFace[1];
        this.getFace()[0] = tempSubFace[0];
    }
    
    /**
     * Método responsável por aplicar as atualizações de referência na face do sub cubo atual
     * e nas faces dos sub cubos vizinhos quando a movimentação para a esquerda é finalizada.
     * As sub faces adjacentes à face atual são atualizadas de forma que uma recebe a configuração da outra.
     * Se o movimento for para a direita, a transferência ocorre na sequencia cima, direita , baixo esquerta.
     * Se o movimento for para a esquerda, a transferência ocorre na sequencia cima, esquerda, baixo direita.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param angle Angulo da rotação.
     */    
    private void updateFacesLeftRotate() {
        SubFace[] tempSubFaces = {getCube().getSubCubesMaster().get(this.getNeighborColors()[0]).getFace()[this.getNeighborIndexes()[0][0]],
            getCube().getSubCubesMaster().get(this.getNeighborColors()[0]).getFace()[this.getNeighborIndexes()[0][1]],
            getCube().getSubCubesMaster().get(this.getNeighborColors()[0]).getFace()[this.getNeighborIndexes()[0][2]]};

        getCube().getSubCubesMaster().get(this.getNeighborColors()[0]).getFace()[this.getNeighborIndexes()[0][0]] = getCube().getSubCubesMaster().get(this.getNeighborColors()[1]).getFace()[this.getNeighborIndexes()[1][0]];
        getCube().getSubCubesMaster().get(this.getNeighborColors()[0]).getFace()[this.getNeighborIndexes()[0][1]] = getCube().getSubCubesMaster().get(this.getNeighborColors()[1]).getFace()[this.getNeighborIndexes()[1][1]];
        getCube().getSubCubesMaster().get(this.getNeighborColors()[0]).getFace()[this.getNeighborIndexes()[0][2]] = getCube().getSubCubesMaster().get(this.getNeighborColors()[1]).getFace()[this.getNeighborIndexes()[1][2]];

        getCube().getSubCubesMaster().get(this.getNeighborColors()[1]).getFace()[this.getNeighborIndexes()[1][0]] = getCube().getSubCubesMaster().get(this.getNeighborColors()[2]).getFace()[this.getNeighborIndexes()[2][0]];
        getCube().getSubCubesMaster().get(this.getNeighborColors()[1]).getFace()[this.getNeighborIndexes()[1][1]] = getCube().getSubCubesMaster().get(this.getNeighborColors()[2]).getFace()[this.getNeighborIndexes()[2][1]];
        getCube().getSubCubesMaster().get(this.getNeighborColors()[1]).getFace()[this.getNeighborIndexes()[1][2]] = getCube().getSubCubesMaster().get(this.getNeighborColors()[2]).getFace()[this.getNeighborIndexes()[2][2]];

        getCube().getSubCubesMaster().get(this.getNeighborColors()[2]).getFace()[this.getNeighborIndexes()[2][0]] = getCube().getSubCubesMaster().get(this.getNeighborColors()[3]).getFace()[this.getNeighborIndexes()[3][0]];
        getCube().getSubCubesMaster().get(this.getNeighborColors()[2]).getFace()[this.getNeighborIndexes()[2][1]] = getCube().getSubCubesMaster().get(this.getNeighborColors()[3]).getFace()[this.getNeighborIndexes()[3][1]];
        getCube().getSubCubesMaster().get(this.getNeighborColors()[2]).getFace()[this.getNeighborIndexes()[2][2]] = getCube().getSubCubesMaster().get(this.getNeighborColors()[3]).getFace()[this.getNeighborIndexes()[3][2]];

        getCube().getSubCubesMaster().get(this.getNeighborColors()[3]).getFace()[this.getNeighborIndexes()[3][0]] = tempSubFaces[0];
        getCube().getSubCubesMaster().get(this.getNeighborColors()[3]).getFace()[this.getNeighborIndexes()[3][1]] = tempSubFaces[1];
        getCube().getSubCubesMaster().get(this.getNeighborColors()[3]).getFace()[this.getNeighborIndexes()[3][2]] = tempSubFaces[2];

        SubFace[] tempSubFace = {this.getFace()[0],
            this.getFace()[1]};

        this.getFace()[0] = this.getFace()[2];
        this.getFace()[1] = this.getFace()[3];
        this.getFace()[2] = this.getFace()[4];
        this.getFace()[3] = this.getFace()[5];
        this.getFace()[4] = this.getFace()[6];
        this.getFace()[5] = this.getFace()[7];
        this.getFace()[6] = tempSubFace[0];
        this.getFace()[7] = tempSubFace[1];
    }

    /**
     * Método responsável por exibir o sub cubo gráfico.
     * Este método realiza o desenho do SubCubes master, caso não exista movimentação em andamento.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param gl Parâmetro OpenGL
     * @param glut Parâmetro OpenGL
     * @param useTexture Determina se será utilizada a textura.
     */
    @Override
    public void glDisplay(GL gl, GLUT glut, boolean useTexture) {
        if (this.getIncompleteOperation() == Operation.None) {
            super.glDisplay(gl, glut, useTexture);
        }
    }
    
    public boolean glDisplayOperation(GL gl, GLUT glut, boolean useTexture) {
        switch (this.getIncompleteOperation()) {
            case RightMove:
                this.rightRotate(this.isIncompleteApplyInLogicalCube());
                super.glDisplay(gl, glut, useTexture);
                break;
            case LeftMove:
                this.leftRotate(this.isIncompleteApplyInLogicalCube());
                super.glDisplay(gl, glut, useTexture);
                break;
        }
        return this.getIncompleteOperation() == Operation.None;
    }

    /**
     * Método responsável por exibir o mapa do sub cubo gráfico.
     * Este método realiza o desenho uma representação dos sub cubos da face e 
     * das sub faces existentes na face do sub cubo mestre.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param gl Parâmetro OpenGL
     * @param glut Parâmetro OpenGL
     * @param reverseFace Determina de a face é desenhada de forma inversa.
     * @param useTexture Determina se será utilizada a textura.
     */    
    public void glDisplayCubeMap(GL gl, GLUT glut, boolean reverseFace, boolean useTexture) {

        Ponto4D ponto1 = new Ponto4D(-0.5f, -0.5f, 0, 1);
        Ponto4D ponto2 = new Ponto4D(0.5f, -0.5f, 0, 1);
        Ponto4D ponto3 = new Ponto4D(0.5f, 0.5f, 0, 1);
        Ponto4D ponto4 = new Ponto4D(-0.5f, 0.5f, 0, 1);

        Ponto4D pontoFace1 = new Ponto4D(-0.45f, -0.45f, 0.1, 1);
        Ponto4D pontoFace2 = new Ponto4D(0.45f, -0.45f, 0.1, 1);
        Ponto4D pontoFace3 = new Ponto4D(0.45f, 0.45f, 0.1, 1);
        Ponto4D pontoFace4 = new Ponto4D(-0.45f, 0.45f, 0.1, 1);

        this.glDisplayCubeMap(gl, glut, ponto1, ponto2, ponto3, ponto4, 0, 0, 0);
        this.glDisplayCubeMap(gl, glut, ponto1, ponto2, ponto3, ponto4, -1, 1, 0);
        this.glDisplayCubeMap(gl, glut, ponto1, ponto2, ponto3, ponto4, 0, 1, 0);
        this.glDisplayCubeMap(gl, glut, ponto1, ponto2, ponto3, ponto4, 1, 1, 0);
        this.glDisplayCubeMap(gl, glut, ponto1, ponto2, ponto3, ponto4, -1, 0, 0);
        this.glDisplayCubeMap(gl, glut, ponto1, ponto2, ponto3, ponto4, 1, 0, 0);
        this.glDisplayCubeMap(gl, glut, ponto1, ponto2, ponto3, ponto4, -1, -1, 0);
        this.glDisplayCubeMap(gl, glut, ponto1, ponto2, ponto3, ponto4, 0, -1, 0);
        this.glDisplayCubeMap(gl, glut, ponto1, ponto2, ponto3, ponto4, 1, -1, 0);

        Color color = new Color();
        color.setColor(this.getGraficColor());

        if (reverseFace) {
            glDisplayCubeMapFace(gl, glut, pontoFace1, pontoFace2, pontoFace3, pontoFace4, color, 0, 0, 0, useTexture);
            glDisplayCubeMapFace(gl, glut, pontoFace1, pontoFace2, pontoFace3, pontoFace4, this.getFace()[4].getColor(), -1, 1, 0, useTexture);
            glDisplayCubeMapFace(gl, glut, pontoFace1, pontoFace2, pontoFace3, pontoFace4, this.getFace()[5].getColor(), 0, 1, 0, useTexture);
            glDisplayCubeMapFace(gl, glut, pontoFace1, pontoFace2, pontoFace3, pontoFace4, this.getFace()[6].getColor(), 1, 1, 0, useTexture);
            glDisplayCubeMapFace(gl, glut, pontoFace1, pontoFace2, pontoFace3, pontoFace4, this.getFace()[7].getColor(), 1, 0, 0, useTexture);
            glDisplayCubeMapFace(gl, glut, pontoFace1, pontoFace2, pontoFace3, pontoFace4, this.getFace()[0].getColor(), 1, -1, 0, useTexture);
            glDisplayCubeMapFace(gl, glut, pontoFace1, pontoFace2, pontoFace3, pontoFace4, this.getFace()[1].getColor(), 0, -1, 0, useTexture);
            glDisplayCubeMapFace(gl, glut, pontoFace1, pontoFace2, pontoFace3, pontoFace4, this.getFace()[2].getColor(), -1, -1, 0, useTexture);
            glDisplayCubeMapFace(gl, glut, pontoFace1, pontoFace2, pontoFace3, pontoFace4, this.getFace()[3].getColor(), -1, 0, 0, useTexture);
        } else {
            glDisplayCubeMapFace(gl, glut, pontoFace1, pontoFace2, pontoFace3, pontoFace4, color, 0, 0, 0, useTexture);
            glDisplayCubeMapFace(gl, glut, pontoFace1, pontoFace2, pontoFace3, pontoFace4, this.getFace()[0].getColor(), -1, 1, 0, useTexture);
            glDisplayCubeMapFace(gl, glut, pontoFace1, pontoFace2, pontoFace3, pontoFace4, this.getFace()[1].getColor(), 0, 1, 0, useTexture);
            glDisplayCubeMapFace(gl, glut, pontoFace1, pontoFace2, pontoFace3, pontoFace4, this.getFace()[2].getColor(), 1, 1, 0, useTexture);
            glDisplayCubeMapFace(gl, glut, pontoFace1, pontoFace2, pontoFace3, pontoFace4, this.getFace()[3].getColor(), 1, 0, 0, useTexture);
            glDisplayCubeMapFace(gl, glut, pontoFace1, pontoFace2, pontoFace3, pontoFace4, this.getFace()[4].getColor(), 1, -1, 0, useTexture);
            glDisplayCubeMapFace(gl, glut, pontoFace1, pontoFace2, pontoFace3, pontoFace4, this.getFace()[5].getColor(), 0, -1, 0, useTexture);
            glDisplayCubeMapFace(gl, glut, pontoFace1, pontoFace2, pontoFace3, pontoFace4, this.getFace()[6].getColor(), -1, -1, 0, useTexture);
            glDisplayCubeMapFace(gl, glut, pontoFace1, pontoFace2, pontoFace3, pontoFace4, this.getFace()[7].getColor(), -1, 0, 0, useTexture);
        }
    }
    
    /**
     * Método responsável por exibir o mapa do sub cubo gráfico.
     * Este método realiza o desenho uma representação de sub cubo considerando 
     * delocamentos recebidos por parâmetro.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param gl Parâmetro OpenGL
     * @param glut Parâmetro OpenGL
     * @param ponto1 Ponto 1 do polígno que representa o sub cubo.
     * @param ponto2 Ponto 2 do polígno que representa o sub cubo.
     * @param ponto3 Ponto 3 do polígno que representa o sub cubo.
     * @param ponto4 Ponto 4 do polígno que representa o sub cubo.
     * @param deslocamentoX Valor de delocamento do sub cubo em X.
     * @param deslocamentoY Valor de delocamento do sub cubo em Y.
     * @param deslocamentoZ Valor de delocamento do sub cubo em Z.
     */       
    private void glDisplayCubeMap(GL gl, GLUT glut, Ponto4D ponto1, Ponto4D ponto2, 
            Ponto4D ponto3, Ponto4D ponto4, double deslocamentoX, double deslocamentoY, 
            double deslocamentoZ) {     
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT_AND_DIFFUSE, this.getColor().getArray4f(), 0);
        gl.glColor3f(this.getColor().getR(),this.getColor().getG(),this.getColor().getB());
        gl.glNormal3d(0, 0, 1);
        gl.glBegin(GL.GL_QUADS);
            gl.glVertex3d(ponto1.obterX() + deslocamentoX,
                    ponto1.obterY() + deslocamentoY,
                    ponto1.obterZ() + deslocamentoZ);
            gl.glVertex3d(ponto2.obterX() + deslocamentoX,
                    ponto2.obterY() + deslocamentoY,
                    ponto2.obterZ() + deslocamentoZ);
            gl.glVertex3d(ponto3.obterX() + deslocamentoX,
                    ponto3.obterY() + deslocamentoY,
                    ponto3.obterZ());
            gl.glVertex3d(ponto4.obterX() + deslocamentoX,
                    ponto4.obterY() + deslocamentoY,
                    ponto4.obterZ() + deslocamentoZ);
        gl.glEnd();
    }
    
    /**
     * Método responsável por exibir o mapa do sub cubo gráfico.
     * Este método realiza o desenho uma representação de sub face considerando 
     * delocamentos recebidos por parâmetro.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param gl Parâmetro OpenGL
     * @param glut Parâmetro OpenGL
     * @param pontoFace1 Ponto 1 do polígno que representa a sub face.
     * @param pontoFace2 Ponto 2 do polígno que representa a sub face.
     * @param pontoFace3 Ponto 3 do polígno que representa a sub face.
     * @param pontoFace4 Ponto 4 do polígno que representa a sub face.
     * @param color Cor da sub face
     * @param deslocamentoX Valor de delocamento da sub face em X.
     * @param deslocamentoY Valor de delocamento da sub face em Y.
     * @param deslocamentoZ Valor de delocamento da sub face em Z.
     * @param useTexture Determina se será utilizada a textura.
     */
    private void glDisplayCubeMapFace(GL gl, GLUT glut, Ponto4D pontoFace1, 
            Ponto4D pontoFace2, Ponto4D pontoFace3, Ponto4D pontoFace4, 
            Color color, double deslocamentoX, double deslocamentoY, 
            double deslocamentoZ, boolean useTexture) {
        if (useTexture){
            gl.glEnable(GL.GL_TEXTURE_2D);
        }
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT_AND_DIFFUSE, color.getArray4f(), 0);
        gl.glColor3f(color.getR(), color.getG(), color.getB());
        gl.glBegin(GL.GL_QUADS);
            if (useTexture) gl.glTexCoord2f(0.0f, 1.0f);
            gl.glVertex3d(pontoFace1.obterX() + deslocamentoX,
                    pontoFace1.obterY() + deslocamentoY,
                    pontoFace1.obterZ() + deslocamentoZ);
            if (useTexture) gl.glTexCoord2f(1.0f, 1.0f);
            gl.glVertex3d(pontoFace2.obterX() + deslocamentoX,
                    pontoFace2.obterY() + deslocamentoY,
                    pontoFace2.obterZ() + deslocamentoZ);
            if (useTexture) gl.glTexCoord2f(1.0f, 0.0f);
            gl.glVertex3d(pontoFace3.obterX() + deslocamentoX,
                    pontoFace3.obterY() + deslocamentoY,
                    pontoFace3.obterZ() + deslocamentoZ);
            if (useTexture) gl.glTexCoord2f(0.0f, 0.0f);
            gl.glVertex3d(pontoFace4.obterX() + deslocamentoX,
                    pontoFace4.obterY() + deslocamentoY,
                    pontoFace4.obterZ() + deslocamentoZ);
        gl.glEnd();
        if (useTexture){
            gl.glDisable(GL.GL_TEXTURE_2D);
        }
    }

}
