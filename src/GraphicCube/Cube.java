//Roberto, Thiago - Trabalho 04 - 2017.1
package GraphicCube;

import com.sun.opengl.util.GLUT;
import java.util.ArrayList;
import java.util.HashMap;
import javax.media.opengl.GL;

/**
 * Classe responsável por representar o cubo gráfico.
 * Esta classe contém todos os elementos que fazem parte do cobu gráfico.
 * Esta classe também contem uma instância de cubo lógico, para possibilitar a resolução do cubo.
 * 
 * @author Roberto Weege Jr
 * @since Versão inicial
 */
public class Cube {

    private HashMap<GraficColor, SubCubeMaster> subCubesMaster;
    private ArrayList<SubCube> subCubes;
    private LogicCube.Cube logicCube;
    
    /**
     * Método construtor.
     * Seta os valores default para todos os atributos.
     * Configura todas as faces e camadas do cubo.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     */
    public Cube() {
        this.setLogicCube(new LogicCube.Cube(3));
        this.setSubCubes(new ArrayList<SubCube>());
        this.setSubCubesMaster(new HashMap<GraficColor, SubCubeMaster>());
        this.configWhiteFace();
        this.configBlueFace();
        this.configRedFace();
        this.configGreenFace();
        this.configOrangeFace();
        this.configYellowFace();
        this.configFirstLayer();
        this.configSecondLayer();
        this.configThirdLayer();
    }    
    
    /**
     * Método get do atributo subCubesMaster.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return HashMap - Coleção de subCubesMaster.
     */
    public HashMap<GraficColor, SubCubeMaster> getSubCubesMaster() {
        return subCubesMaster;
    }
    
    /**
     * Método set do atributo subCubesMaster.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param subCubesMaster Coleção de subCubesMaster.
     */
    public void setSubCubesMaster(HashMap<GraficColor, SubCubeMaster> subCubesMaster) {
        this.subCubesMaster = subCubesMaster;
    }
    /**
     * Método get do atributo subCubes.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return ArrayList - Lista de subCubes.
     */
    public ArrayList<SubCube> getSubCubes() {
        return subCubes;
    }
    
    /**
     * Método set do atributo subCubes.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param subCubes Lista de subCubes.
     */
    public void setSubCubes(ArrayList<SubCube> subCubes) {
        this.subCubes = subCubes;
    }
    
    /**
     * Método get do atributo logicCube.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return LogicCube.Cube - Objeto LogicCube.
     */
    public LogicCube.Cube getLogicCube() {
        return logicCube;
    }
    
    /**
     * Método set do atributo logicCube.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param logicCube Objeto LogicCube.
     */
    public void setLogicCube(LogicCube.Cube logicCube) {
        this.logicCube = logicCube;
    }
    
    /**
     * Método responsável pela configuração da face branca.
     * Este método cria um SubCube master para representar uma das faces do cubo.
     * Neste método são setadas as cores dos SubCubes master vizinhos. (cima, direita, baixo, esquerda).
     * Após, são setados os índices das faces vizinhas (cima, direita, baixo, esquerda).
     * Também é determinado neste método qual é o eixo de rotação do SubCube master, bem como seu sentido de rotação. 
     * Por fim, o SubCube master criado é adicionado à coleção de SubCube master e é aplicado nele a matriz de transformação
     * para posicioná-lo em tela.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     */
    private void configWhiteFace(){
        GraficColor[] neighborColors = new GraficColor[4];
        int[][] neiborIndexes = new int[4][3];

        neighborColors[0] = GraficColor.RE;
        neighborColors[1] = GraficColor.GR;
        neighborColors[2] = GraficColor.OR;
        neighborColors[3] = GraficColor.BL;

        neiborIndexes[0][0] = 6;
        neiborIndexes[0][1] = 5;
        neiborIndexes[0][2] = 4;
        neiborIndexes[1][0] = 0;
        neiborIndexes[1][1] = 7;
        neiborIndexes[1][2] = 6;
        neiborIndexes[2][0] = 2;
        neiborIndexes[2][1] = 1;
        neiborIndexes[2][2] = 0;
        neiborIndexes[3][0] = 4;
        neiborIndexes[3][1] = 3;
        neiborIndexes[3][2] = 2;

        this.getSubCubesMaster().put(GraficColor.WH, 
                new SubCubeMaster(this, GraficColor.WH, false, 
                        Axis.Z, neighborColors, neiborIndexes));
        this.getSubCubesMaster().get(GraficColor.WH)
                .setTransformacao4D(new Transformacao4D());
        this.getSubCubesMaster().get(GraficColor.WH).getTransformacao4D()
                .aplicaTranslacaoXYZ(new Ponto4D(0, 0, 1, 0));
        this.getSubCubesMaster().get(GraficColor.WH)
                .addFace(Orientation.FT, GraficColor.WH);
    }

    /**
     * Método responsável pela configuração da face azul.
     * Este método cria um SubCube master para representar uma das faces do cubo.
     * Neste método são setadas as cores dos SubCubes master vizinhos. (cima, direita, baixo, esquerda).
     * Após, são setados os índices das faces vizinhas (cima, direita, baixo, esquerda).
     * Também é determinado neste método qual é o eixo de rotação do SubCube master, bem como seu sentido de rotação. 
     * Por fim, o SubCube master criado é adicionado à coleção de SubCube master e é aplicado nele a matriz de transformação
     * para posicioná-lo em tela.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     */
    private void configBlueFace(){
        GraficColor[] neighborColors = new GraficColor[4];
        int[][] neiborIndexes = new int[4][3];

        neighborColors[0] = GraficColor.RE;
        neighborColors[1] = GraficColor.WH;
        neighborColors[2] = GraficColor.OR;
        neighborColors[3] = GraficColor.YE;

        neiborIndexes[0][0] = 0;
        neiborIndexes[0][1] = 7;
        neiborIndexes[0][2] = 6;
        neiborIndexes[1][0] = 0;
        neiborIndexes[1][1] = 7;
        neiborIndexes[1][2] = 6;
        neiborIndexes[2][0] = 0;
        neiborIndexes[2][1] = 7;
        neiborIndexes[2][2] = 6;
        neiborIndexes[3][0] = 0;
        neiborIndexes[3][1] = 7;
        neiborIndexes[3][2] = 6;

        this.getSubCubesMaster().put(GraficColor.BL, new SubCubeMaster(this, GraficColor.BL, true, Axis.X, neighborColors, neiborIndexes));
        this.getSubCubesMaster().get(GraficColor.BL).setTransformacao4D(new Transformacao4D());
        this.getSubCubesMaster().get(GraficColor.BL).getTransformacao4D().aplicaTranslacaoXYZ(new Ponto4D(-1, 0, 0, 0));
        this.getSubCubesMaster().get(GraficColor.BL).addFace(Orientation.LE, GraficColor.BL);
    }

    /**
     * Método responsável pela configuração da face vermelha.
     * Este método cria um SubCube master para representar uma das faces do cubo.
     * Neste método são setadas as cores dos SubCubes master vizinhos. (cima, direita, baixo, esquerda).
     * Após, são setados os índices das faces vizinhas (cima, direita, baixo, esquerda).
     * Também é determinado neste método qual é o eixo de rotação do SubCube master, bem como seu sentido de rotação. 
     * Por fim, o SubCube master criado é adicionado à coleção de SubCube master e é aplicado nele a matriz de transformação
     * para posicioná-lo em tela.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     */
    private void configRedFace(){
        GraficColor[] neighborColors = new GraficColor[4];
        int[][] neiborIndexes = new int[4][3];

        neighborColors[0] = GraficColor.YE;
        neighborColors[1] = GraficColor.GR;
        neighborColors[2] = GraficColor.WH;
        neighborColors[3] = GraficColor.BL;

        neiborIndexes[0][0] = 6;
        neiborIndexes[0][1] = 5;
        neiborIndexes[0][2] = 4;
        neiborIndexes[1][0] = 2;
        neiborIndexes[1][1] = 1;
        neiborIndexes[1][2] = 0;
        neiborIndexes[2][0] = 2;
        neiborIndexes[2][1] = 1;
        neiborIndexes[2][2] = 0;
        neiborIndexes[3][0] = 2;
        neiborIndexes[3][1] = 1;
        neiborIndexes[3][2] = 0;

        this.getSubCubesMaster().put(GraficColor.RE, new SubCubeMaster(this, GraficColor.RE, false, Axis.Y, neighborColors, neiborIndexes));
        this.getSubCubesMaster().get(GraficColor.RE).setTransformacao4D(new Transformacao4D());
        this.getSubCubesMaster().get(GraficColor.RE).getTransformacao4D().aplicaTranslacaoXYZ(new Ponto4D(0, 1, 0, 0));
        this.getSubCubesMaster().get(GraficColor.RE).addFace(Orientation.UP, GraficColor.RE);
    }

    /**
     * Método responsável pela configuração da face verde.
     * Este método cria um SubCube master para representar uma das faces do cubo.
     * Neste método são setadas as cores dos SubCubes master vizinhos. (cima, direita, baixo, esquerda).
     * Após, são setados os índices das faces vizinhas (cima, direita, baixo, esquerda).
     * Também é determinado neste método qual é o eixo de rotação do SubCube master, bem como seu sentido de rotação. 
     * Por fim, o SubCube master criado é adicionado à coleção de SubCube master e é aplicado nele a matriz de transformação
     * para posicioná-lo em tela.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     */
    private void configGreenFace(){
        GraficColor[] neighborColors = new GraficColor[4];
        int[][] neiborIndexes = new int[4][3];

        neighborColors[0] = GraficColor.RE;
        neighborColors[1] = GraficColor.YE;
        neighborColors[2] = GraficColor.OR;
        neighborColors[3] = GraficColor.WH;

        neiborIndexes[0][0] = 4;
        neiborIndexes[0][1] = 3;
        neiborIndexes[0][2] = 2;
        neiborIndexes[1][0] = 4;
        neiborIndexes[1][1] = 3;
        neiborIndexes[1][2] = 2;
        neiborIndexes[2][0] = 4;
        neiborIndexes[2][1] = 3;
        neiborIndexes[2][2] = 2;
        neiborIndexes[3][0] = 4;
        neiborIndexes[3][1] = 3;
        neiborIndexes[3][2] = 2;

        this.getSubCubesMaster().put(GraficColor.GR, new SubCubeMaster(this, GraficColor.GR, false, Axis.X, neighborColors, neiborIndexes));
        this.getSubCubesMaster().get(GraficColor.GR).setTransformacao4D(new Transformacao4D());
        this.getSubCubesMaster().get(GraficColor.GR).getTransformacao4D().aplicaTranslacaoXYZ(new Ponto4D(1, 0, 0, 0));
        this.getSubCubesMaster().get(GraficColor.GR).addFace(Orientation.RI, GraficColor.GR);
    }
    
    /**
     * Método responsável pela configuração da face laranja.
     * Este método cria um SubCube master para representar uma das faces do cubo.
     * Neste método são setadas as cores dos SubCubes master vizinhos. (cima, direita, baixo, esquerda).
     * Após, são setados os índices das faces vizinhas (cima, direita, baixo, esquerda).
     * Também é determinado neste método qual é o eixo de rotação do SubCube master, bem como seu sentido de rotação. 
     * Por fim, o SubCube master criado é adicionado à coleção de SubCube master e é aplicado nele a matriz de transformação
     * para posicioná-lo em tela.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     */
    private void configOrangeFace(){
        GraficColor[] neighborColors = new GraficColor[4];
        int[][] neiborIndexes = new int[4][3];

        neighborColors[0] = GraficColor.WH;
        neighborColors[1] = GraficColor.GR;
        neighborColors[2] = GraficColor.YE;
        neighborColors[3] = GraficColor.BL;

        neiborIndexes[0][0] = 6;
        neiborIndexes[0][1] = 5;
        neiborIndexes[0][2] = 4;
        neiborIndexes[1][0] = 6;
        neiborIndexes[1][1] = 5;
        neiborIndexes[1][2] = 4;
        neiborIndexes[2][0] = 2;
        neiborIndexes[2][1] = 1;
        neiborIndexes[2][2] = 0;
        neiborIndexes[3][0] = 6;
        neiborIndexes[3][1] = 5;
        neiborIndexes[3][2] = 4;

        this.getSubCubesMaster().put(GraficColor.OR, new SubCubeMaster(this, GraficColor.OR, true, Axis.Y, neighborColors, neiborIndexes));
        this.getSubCubesMaster().get(GraficColor.OR).setTransformacao4D(new Transformacao4D());
        this.getSubCubesMaster().get(GraficColor.OR).getTransformacao4D().aplicaTranslacaoXYZ(new Ponto4D(0, -1, 0, 0));
        this.getSubCubesMaster().get(GraficColor.OR).addFace(Orientation.DW, GraficColor.OR);
    }
    
    /**
     * Método responsável pela configuração da face amarela.
     * Este método cria um SubCube master para representar uma das faces do cubo.
     * Neste método são setadas as cores dos SubCubes master vizinhos. (cima, direita, baixo, esquerda).
     * Após, são setados os índices das faces vizinhas (cima, direita, baixo, esquerda).
     * Também é determinado neste método qual é o eixo de rotação do SubCube master, bem como seu sentido de rotação. 
     * Por fim, o SubCube master criado é adicionado à coleção de SubCube master e é aplicado nele a matriz de transformação
     * para posicioná-lo em tela.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     */
    private void configYellowFace(){
        GraficColor[] neighborColors = new GraficColor[4];
        int[][] neiborIndexes = new int[4][3];

        neighborColors[0] = GraficColor.OR;
        neighborColors[1] = GraficColor.GR;
        neighborColors[2] = GraficColor.RE;
        neighborColors[3] = GraficColor.BL;

        neiborIndexes[0][0] = 6;
        neiborIndexes[0][1] = 5;
        neiborIndexes[0][2] = 4;
        neiborIndexes[1][0] = 4;
        neiborIndexes[1][1] = 3;
        neiborIndexes[1][2] = 2;
        neiborIndexes[2][0] = 2;
        neiborIndexes[2][1] = 1;
        neiborIndexes[2][2] = 0;
        neiborIndexes[3][0] = 0;
        neiborIndexes[3][1] = 7;
        neiborIndexes[3][2] = 6;

        this.getSubCubesMaster().put(GraficColor.YE, new SubCubeMaster(this, GraficColor.YE, true, Axis.Z, neighborColors, neiborIndexes));
        this.getSubCubesMaster().get(GraficColor.YE).setTransformacao4D(new Transformacao4D());
        this.getSubCubesMaster().get(GraficColor.YE).getTransformacao4D().aplicaTranslacaoXYZ(new Ponto4D(0, 0, -1, 0));
        this.getSubCubesMaster().get(GraficColor.YE).addFace(Orientation.OP, GraficColor.YE);
    }
    
    /**
     * Método responsável pela configuração da primeira camada do cubo.
     * Este método é responsável por criar os SubeCubes e as faces da camada.
     * Neste método se cria e se aplica a transformação geométrica nos SubeCubes.
     * Também se criam os SubFaces aplicando suas transformações geométricas e os associando
     * ao SubCube master, na possição correspondente.
     * Por fim os SubCubes são adicionados à lista de SubCubes desta classe.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     */
    private void configFirstLayer(){
        SubCube subCube = new SubCube();
        subCube.setTransformacao4D(new Transformacao4D());
        subCube.getTransformacao4D().aplicaTranslacaoXYZ(new Ponto4D(-1, 1, 1, 0));
        SubFace subFace = subCube.addFace(Orientation.FT, GraficColor.WH);
        this.getSubCubesMaster().get(GraficColor.WH).getFace()[0] = subFace;
        subFace = subCube.addFace(Orientation.LE, GraficColor.BL);
        this.getSubCubesMaster().get(GraficColor.BL).getFace()[2] = subFace;
        subFace = subCube.addFace(Orientation.UP, GraficColor.RE);
        this.getSubCubesMaster().get(GraficColor.RE).getFace()[6] = subFace;
        this.getSubCubes().add(subCube);

        subCube = new SubCube();
        subCube.setTransformacao4D(new Transformacao4D());
        subCube.getTransformacao4D().aplicaTranslacaoXYZ(new Ponto4D(0, 1, 1, 0));
        subFace = subCube.addFace(Orientation.FT, GraficColor.WH);
        this.getSubCubesMaster().get(GraficColor.WH).getFace()[1] = subFace;
        subFace = subCube.addFace(Orientation.UP, GraficColor.RE);
        this.getSubCubesMaster().get(GraficColor.RE).getFace()[5] = subFace;
        this.getSubCubes().add(subCube);

        subCube = new SubCube();
        subCube.setTransformacao4D(new Transformacao4D());
        subCube.getTransformacao4D().aplicaTranslacaoXYZ(new Ponto4D(1, 1, 1, 0));
        subFace = subCube.addFace(Orientation.FT, GraficColor.WH);
        this.getSubCubesMaster().get(GraficColor.WH).getFace()[2] = subFace;
        subFace = subCube.addFace(Orientation.UP, GraficColor.RE);
        this.getSubCubesMaster().get(GraficColor.RE).getFace()[4] = subFace;
        subFace = subCube.addFace(Orientation.RI, GraficColor.GR);
        this.getSubCubesMaster().get(GraficColor.GR).getFace()[0] = subFace;
        this.getSubCubes().add(subCube);

        subCube = new SubCube();
        subCube.setTransformacao4D(new Transformacao4D());
        subCube.getTransformacao4D().aplicaTranslacaoXYZ(new Ponto4D(1, 0, 1, 0));
        subFace = subCube.addFace(Orientation.FT, GraficColor.WH);
        this.getSubCubesMaster().get(GraficColor.WH).getFace()[3] = subFace;
        subFace = subCube.addFace(Orientation.RI, GraficColor.GR);
        this.getSubCubesMaster().get(GraficColor.GR).getFace()[7] = subFace;
        this.getSubCubes().add(subCube);

        subCube = new SubCube();
        subCube.setTransformacao4D(new Transformacao4D());
        subCube.getTransformacao4D().aplicaTranslacaoXYZ(new Ponto4D(1, -1, 1, 0));
        subFace = subCube.addFace(Orientation.FT, GraficColor.WH);
        this.getSubCubesMaster().get(GraficColor.WH).getFace()[4] = subFace;
        subFace = subCube.addFace(Orientation.RI, GraficColor.GR);
        this.getSubCubesMaster().get(GraficColor.GR).getFace()[6] = subFace;
        subFace = subCube.addFace(Orientation.DW, GraficColor.OR);
        this.getSubCubesMaster().get(GraficColor.OR).getFace()[2] = subFace;
        this.getSubCubes().add(subCube);

        subCube = new SubCube();
        subCube.setTransformacao4D(new Transformacao4D());
        subCube.getTransformacao4D().aplicaTranslacaoXYZ(new Ponto4D(0, -1, 1, 0));
        subFace = subCube.addFace(Orientation.FT, GraficColor.WH);
        this.getSubCubesMaster().get(GraficColor.WH).getFace()[5] = subFace;
        subFace = subCube.addFace(Orientation.DW, GraficColor.OR);
        this.getSubCubesMaster().get(GraficColor.OR).getFace()[1] = subFace;
        this.getSubCubes().add(subCube);

        subCube = new SubCube();
        subCube.setTransformacao4D(new Transformacao4D());
        subCube.getTransformacao4D().aplicaTranslacaoXYZ(new Ponto4D(-1, -1, 1, 0));
        subFace = subCube.addFace(Orientation.FT, GraficColor.WH);
        this.getSubCubesMaster().get(GraficColor.WH).getFace()[6] = subFace;
        subFace = subCube.addFace(Orientation.DW, GraficColor.OR);
        this.getSubCubesMaster().get(GraficColor.OR).getFace()[0] = subFace;
        subFace = subCube.addFace(Orientation.LE, GraficColor.BL);
        this.getSubCubesMaster().get(GraficColor.BL).getFace()[4] = subFace;
        this.getSubCubes().add(subCube);

        subCube = new SubCube();
        subCube.setTransformacao4D(new Transformacao4D());
        subCube.getTransformacao4D().aplicaTranslacaoXYZ(new Ponto4D(-1, 0, 1, 0));
        subFace = subCube.addFace(Orientation.FT, GraficColor.WH);
        this.getSubCubesMaster().get(GraficColor.WH).getFace()[7] = subFace;
        subFace = subCube.addFace(Orientation.LE, GraficColor.BL);
        this.getSubCubesMaster().get(GraficColor.BL).getFace()[3] = subFace;
        this.getSubCubes().add(subCube);

    }

    /**
     * Método responsável pela configuração da segunda camada do cubo.
     * Este método é responsável por criar os SubeCubes e as faces da camada.
     * Neste método se cria e se aplica a transformação geométrica nos SubeCubes.
     * Também se criam os SubFaces aplicando suas transformações geométricas e os associando
     * ao SubCube master, na possição correspondente.
     * Por fim os SubCubes são adicionados à lista de SubCubes desta classe.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     */
    private void configSecondLayer(){
        SubCube subCube = new SubCube();
        subCube.setTransformacao4D(new Transformacao4D());
        subCube.getTransformacao4D().aplicaTranslacaoXYZ(new Ponto4D(-1, -1, 0, 0));
        SubFace subFace = subCube.addFace(Orientation.DW, GraficColor.OR);
        this.getSubCubesMaster().get(GraficColor.OR).getFace()[7] = subFace;
        subFace = subCube.addFace(Orientation.LE, GraficColor.BL);
        this.getSubCubesMaster().get(GraficColor.BL).getFace()[5] = subFace;
        this.getSubCubes().add(subCube);

        subCube = new SubCube();
        subCube.setTransformacao4D(new Transformacao4D());
        subCube.getTransformacao4D().aplicaTranslacaoXYZ(new Ponto4D(-1, 1, 0, 0));
        subFace = subCube.addFace(Orientation.LE, GraficColor.BL);
        this.getSubCubesMaster().get(GraficColor.BL).getFace()[1] = subFace;
        subFace = subCube.addFace(Orientation.UP, GraficColor.RE);
        this.getSubCubesMaster().get(GraficColor.RE).getFace()[7] = subFace;
        this.getSubCubes().add(subCube);

        subCube = new SubCube();
        subCube.setTransformacao4D(new Transformacao4D());
        subCube.getTransformacao4D().aplicaTranslacaoXYZ(new Ponto4D(1, 1, 0, 0));
        subFace = subCube.addFace(Orientation.UP, GraficColor.RE);
        this.getSubCubesMaster().get(GraficColor.RE).getFace()[3] = subFace;
        subFace = subCube.addFace(Orientation.RI, GraficColor.GR);
        this.getSubCubesMaster().get(GraficColor.GR).getFace()[1] = subFace;
        this.getSubCubes().add(subCube);

        subCube = new SubCube();
        subCube.setTransformacao4D(new Transformacao4D());
        subCube.getTransformacao4D().aplicaTranslacaoXYZ(new Ponto4D(1, -1, 0, 0));
        subFace = subCube.addFace(Orientation.RI, GraficColor.GR);
        this.getSubCubesMaster().get(GraficColor.GR).getFace()[5] = subFace;
        subFace = subCube.addFace(Orientation.DW, GraficColor.OR);
        this.getSubCubesMaster().get(GraficColor.OR).getFace()[3] = subFace;
        this.getSubCubes().add(subCube);
    }

    /**
     * Método responsável pela configuração da terceira camada do cubo.
     * Este método é responsável por criar os SubeCubes e as faces da camada.
     * Neste método se cria e se aplica a transformação geométrica nos SubeCubes.
     * Também se criam os SubFaces aplicando suas transformações geométricas e os associando
     * ao SubCube master, na possição correspondente.
     * Por fim os SubCubes são adicionados à lista de SubCubes desta classe.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     */
    private void configThirdLayer(){
        SubCube subCube = new SubCube();
        subCube.setTransformacao4D(new Transformacao4D());
        subCube.getTransformacao4D().aplicaTranslacaoXYZ(new Ponto4D(-1, -1, -1, 0));
        SubFace subFace = subCube.addFace(Orientation.OP, GraficColor.YE);
        this.getSubCubesMaster().get(GraficColor.YE).getFace()[0] = subFace;
        subFace = subCube.addFace(Orientation.DW, GraficColor.OR);
        this.getSubCubesMaster().get(GraficColor.OR).getFace()[6] = subFace;
        subFace = subCube.addFace(Orientation.LE, GraficColor.BL);
        this.getSubCubesMaster().get(GraficColor.BL).getFace()[6] = subFace;
        this.getSubCubes().add(subCube);

        subCube = new SubCube();
        subCube.setTransformacao4D(new Transformacao4D());
        subCube.getTransformacao4D().aplicaTranslacaoXYZ(new Ponto4D(0, -1, -1, 0));
        subFace = subCube.addFace(Orientation.OP, GraficColor.YE);
        this.getSubCubesMaster().get(GraficColor.YE).getFace()[1] = subFace;
        subFace = subCube.addFace(Orientation.DW, GraficColor.OR);
        this.getSubCubesMaster().get(GraficColor.OR).getFace()[5] = subFace;
        this.getSubCubes().add(subCube);

        subCube = new SubCube();
        subCube.setTransformacao4D(new Transformacao4D());
        subCube.getTransformacao4D().aplicaTranslacaoXYZ(new Ponto4D(1, -1, -1, 0));
        subFace = subCube.addFace(Orientation.OP, GraficColor.YE);
        this.getSubCubesMaster().get(GraficColor.YE).getFace()[2] = subFace;
        subFace = subCube.addFace(Orientation.RI, GraficColor.GR);
        this.getSubCubesMaster().get(GraficColor.GR).getFace()[4] = subFace;
        subFace = subCube.addFace(Orientation.DW, GraficColor.OR);
        this.getSubCubesMaster().get(GraficColor.OR).getFace()[4] = subFace;
        this.getSubCubes().add(subCube);

        subCube = new SubCube();
        subCube.setTransformacao4D(new Transformacao4D());
        subCube.getTransformacao4D().aplicaTranslacaoXYZ(new Ponto4D(1, 0, -1, 0));
        subFace = subCube.addFace(Orientation.OP, GraficColor.YE);
        this.getSubCubesMaster().get(GraficColor.YE).getFace()[3] = subFace;
        subFace = subCube.addFace(Orientation.RI, GraficColor.GR);
        this.getSubCubesMaster().get(GraficColor.GR).getFace()[3] = subFace;
        this.getSubCubes().add(subCube);

        subCube = new SubCube();
        subCube.setTransformacao4D(new Transformacao4D());
        subCube.getTransformacao4D().aplicaTranslacaoXYZ(new Ponto4D(1, 1, -1, 0));
        subFace = subCube.addFace(Orientation.OP, GraficColor.YE);
        this.getSubCubesMaster().get(GraficColor.YE).getFace()[4] = subFace;
        subFace = subCube.addFace(Orientation.UP, GraficColor.RE);
        this.getSubCubesMaster().get(GraficColor.RE).getFace()[2] = subFace;
        subFace = subCube.addFace(Orientation.RI, GraficColor.GR);
        this.getSubCubesMaster().get(GraficColor.GR).getFace()[2] = subFace;
        this.getSubCubes().add(subCube);

        subCube = new SubCube();
        subCube.setTransformacao4D(new Transformacao4D());
        subCube.getTransformacao4D().aplicaTranslacaoXYZ(new Ponto4D(0, 1, -1, 0));
        subFace = subCube.addFace(Orientation.OP, GraficColor.YE);
        this.getSubCubesMaster().get(GraficColor.YE).getFace()[5] = subFace;
        subFace = subCube.addFace(Orientation.UP, GraficColor.RE);
        this.getSubCubesMaster().get(GraficColor.RE).getFace()[1] = subFace;
        this.getSubCubes().add(subCube);

        subCube = new SubCube();
        subCube.setTransformacao4D(new Transformacao4D());
        subCube.getTransformacao4D().aplicaTranslacaoXYZ(new Ponto4D(-1, 1, -1, 0));
        subFace = subCube.addFace(Orientation.OP, GraficColor.YE);
        this.getSubCubesMaster().get(GraficColor.YE).getFace()[6] = subFace;
        subFace = subCube.addFace(Orientation.LE, GraficColor.BL);
        this.getSubCubesMaster().get(GraficColor.BL).getFace()[0] = subFace;
        subFace = subCube.addFace(Orientation.UP, GraficColor.RE);
        this.getSubCubesMaster().get(GraficColor.RE).getFace()[0] = subFace;
        this.getSubCubes().add(subCube);

        subCube = new SubCube();
        subCube.setTransformacao4D(new Transformacao4D());
        subCube.getTransformacao4D().aplicaTranslacaoXYZ(new Ponto4D(-1, 0, -1, 0));
        subFace = subCube.addFace(Orientation.OP, GraficColor.YE);
        this.getSubCubesMaster().get(GraficColor.YE).getFace()[7] = subFace;
        subFace = subCube.addFace(Orientation.LE, GraficColor.BL);
        this.getSubCubesMaster().get(GraficColor.BL).getFace()[7] = subFace;
        this.getSubCubes().add(subCube);
    }
    
    /**
     * Método responsável pela execução da rotação de uma face do cubo.
     * Este método executa a rotação no SubCube master correspondente à cor passada por parâmetro.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param faceColor Cor da face a ser movida.
     * @param rightMove Determina se o movimento é para a direita ou para a esquerda.
     * @param moveLogicalCube Determina se a alteração se aplica ao cubo lógico.
     */
    public void rotateFace(GraficColor faceColor, boolean rightMove, boolean moveLogicalCube){
        if (rightMove){
            this.getSubCubesMaster().get(faceColor).rightRotate(moveLogicalCube);
        } else {
            this.getSubCubesMaster().get(faceColor).leftRotate(moveLogicalCube);
        }
    }
    
    /**
     * Método responsável pela execução da rotação de uma face do cubo lógico.
     * Este método executa a rotação na face do cubo lógico correspondente à cor passada por parâmetro.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param faceColor Cor da face a ser movida.
     * @param rightMove Determina se o movimento é para a direita ou para a esquerda.
     */
    public void applyLogicalRotation(GraficColor faceColor, boolean rightMove){
        this.getLogicCube().getFace(EnumManager.convertGraficLogicColorEnum(faceColor)).rotate(rightMove, null);
    }
    
    /**
     * Método responsável obter, do cubo lógico, a lista de passos para resolver o cubo gráfico.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return ArrayList Lista de movimentos para realizar a solução do cubo.
     */
    public ArrayList<String> getLogicalSolution(){
        ArrayList<String> solution = new ArrayList();
        this.getLogicCube().getSolution(LogicCube.Color.WH, solution);
        return solution;
    }

    /**
     * Método responsável por exibir o cubo gráfico.
     * Este método realiza o desenho dos SubCubes master, seguido do desenho da 
     * rotação do SubCube master, seguido do desenho dos restantes SubCubes. 
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param gl Parâmetro OpenGL
     * @param glut Parâmetro OpenGL
     * @param useTexture Determina se será utilizada a textura.
     * @return boolean - true se todas a movimentações foram finalizadas.
     */
    public boolean glDisplay(GL gl, GLUT glut, boolean useTexture) {

        this.getSubCubesMaster().get(GraficColor.WH).glDisplay(gl, glut, useTexture);
        this.getSubCubesMaster().get(GraficColor.BL).glDisplay(gl, glut, useTexture);
        this.getSubCubesMaster().get(GraficColor.RE).glDisplay(gl, glut, useTexture);
        this.getSubCubesMaster().get(GraficColor.GR).glDisplay(gl, glut, useTexture);
        this.getSubCubesMaster().get(GraficColor.OR).glDisplay(gl, glut, useTexture);
        this.getSubCubesMaster().get(GraficColor.YE).glDisplay(gl, glut, useTexture);

        boolean isComplete = true;
        isComplete = isComplete && this.getSubCubesMaster()
                .get(GraficColor.WH).glDisplayOperation(gl, glut, useTexture);
        isComplete = isComplete && this.getSubCubesMaster()
                .get(GraficColor.BL).glDisplayOperation(gl, glut, useTexture);
        isComplete = isComplete && this.getSubCubesMaster()
                .get(GraficColor.RE).glDisplayOperation(gl, glut, useTexture);
        isComplete = isComplete && this.getSubCubesMaster()
                .get(GraficColor.GR).glDisplayOperation(gl, glut, useTexture);
        isComplete = isComplete && this.getSubCubesMaster()
                .get(GraficColor.OR).glDisplayOperation(gl, glut, useTexture);
        isComplete = isComplete && this.getSubCubesMaster()
                .get(GraficColor.YE).glDisplayOperation(gl, glut, useTexture);

        for (SubCube subCube : this.getSubCubes()) {
            subCube.glDisplay(gl, glut, useTexture);
        }
        return isComplete;
    }
    
    /**
     * Método responsável por exibir o mapa do cubo gráfico.
     * Este método realiza o desenho do mapa dos SubCubes master, aplicando as 
     * matrizes de transformação para cada face.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param gl Parâmetro OpenGL
     * @param glut Parâmetro OpenGL
     * @param useTexture Determina se será utilizada a textura.
     */
    public void glDisplayCubeMap(GL gl, GLUT glut, boolean useTexture) {
        Transformacao4D transformacao4D;
        this.getSubCubesMaster().get(GraficColor.WH).glDisplayCubeMap(gl, glut, false, useTexture);
        gl.glPushMatrix();
        transformacao4D = new Transformacao4D();
        transformacao4D.aplicaTranslacaoXYZ(new Ponto4D(-3, 0, 0, 0));
        gl.glMultMatrixd(transformacao4D.GetDate(), 0);
        this.getSubCubesMaster().get(GraficColor.BL).glDisplayCubeMap(gl, glut, false, useTexture);
        gl.glPopMatrix();
        gl.glPushMatrix();
        transformacao4D = new Transformacao4D();
        transformacao4D.aplicaTranslacaoXYZ(new Ponto4D(0, 3, 0, 0));
        gl.glMultMatrixd(transformacao4D.GetDate(), 0);
        this.getSubCubesMaster().get(GraficColor.RE).glDisplayCubeMap(gl, glut, false, useTexture);
        gl.glPopMatrix();
        gl.glPushMatrix();
        transformacao4D = new Transformacao4D();
        transformacao4D.aplicaTranslacaoXYZ(new Ponto4D(0, -3, 0, 0));
        gl.glMultMatrixd(transformacao4D.GetDate(), 0);
        this.getSubCubesMaster().get(GraficColor.OR).glDisplayCubeMap(gl, glut, false, useTexture);
        gl.glPopMatrix();
        gl.glPushMatrix();
        transformacao4D = new Transformacao4D();
        transformacao4D.aplicaTranslacaoXYZ(new Ponto4D(3, 0, 0, 0));
        gl.glMultMatrixd(transformacao4D.GetDate(), 0);
        this.getSubCubesMaster().get(GraficColor.GR).glDisplayCubeMap(gl, glut, false, useTexture);
        gl.glPopMatrix();
        gl.glPushMatrix();
        transformacao4D = new Transformacao4D();
        transformacao4D.aplicaTranslacaoXYZ(new Ponto4D(6, 0, 0, 0));
        gl.glMultMatrixd(transformacao4D.GetDate(), 0);
        this.getSubCubesMaster().get(GraficColor.YE).glDisplayCubeMap(gl, glut, true, useTexture);
        gl.glPopMatrix();
    }
    
}
