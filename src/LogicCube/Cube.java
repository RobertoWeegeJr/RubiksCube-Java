//Roberto, Thiago - Trabalho 04 - 2017.1
package LogicCube;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
/**
 * Classe responsável por representar o cubo lógico.
 * Esta classe contém todos os elementos que fazem parte do cubo lógico.
 * Nesta classe em que ocorre a resolução do cubo.
 * 
 * @author Roberto Weege Jr
 * @since Versão inicial
 */
public class Cube {

    private HashMap <Color, Face> faces;
    private int dimension;
    
    /**
     * Método construtor.
     * Seta os valores default para todos os atributos.
     * Configura todas as faces e camadas do cubo.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param dimension Dimensão do cubo.
     */
    public Cube(int dimension) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("Invalid dimention");
        }
        this.dimension = dimension;
        faces = new HashMap();

        faces.put(Color.WH, new Face(Color.WH, dimension));
        faces.put(Color.BL, new Face(Color.BL, dimension));
        faces.put(Color.OR, new Face(Color.OR, dimension));
        faces.put(Color.RE, new Face(Color.RE, dimension));
        faces.put(Color.GR, new Face(Color.GR, dimension));
        faces.put(Color.YE, new Face(Color.YE, dimension));

        this.faces.get(Color.WH).setAdjacentFaces(Position.UP, faces.get(Color.GR));
        this.faces.get(Color.WH).setAdjacentFaces(Position.DW, faces.get(Color.BL));
        this.faces.get(Color.WH).setAdjacentFaces(Position.LE, faces.get(Color.RE));
        this.faces.get(Color.WH).setAdjacentFaces(Position.RI, faces.get(Color.OR));
        this.faces.get(Color.WH).setAdjacentFaces(Position.OP, faces.get(Color.YE));
        this.faces.get(Color.WH).setPositionAdjacentFaces(Position.UP, Position.DW);
        this.faces.get(Color.WH).setPositionAdjacentFaces(Position.DW, Position.UP);
        this.faces.get(Color.WH).setPositionAdjacentFaces(Position.LE, Position.RI);
        this.faces.get(Color.WH).setPositionAdjacentFaces(Position.RI, Position.LE);

        this.faces.get(Color.OR).setAdjacentFaces(Position.UP, faces.get(Color.GR));
        this.faces.get(Color.OR).setAdjacentFaces(Position.DW, faces.get(Color.BL));
        this.faces.get(Color.OR).setAdjacentFaces(Position.LE, faces.get(Color.WH));
        this.faces.get(Color.OR).setAdjacentFaces(Position.RI, faces.get(Color.YE));
        this.faces.get(Color.OR).setAdjacentFaces(Position.OP, faces.get(Color.RE));
        this.faces.get(Color.OR).setPositionAdjacentFaces(Position.UP, Position.RI);
        this.faces.get(Color.OR).setPositionAdjacentFaces(Position.DW, Position.RI);
        this.faces.get(Color.OR).setPositionAdjacentFaces(Position.LE, Position.RI);
        this.faces.get(Color.OR).setPositionAdjacentFaces(Position.RI, Position.LE);

        this.faces.get(Color.YE).setAdjacentFaces(Position.UP, faces.get(Color.GR));
        this.faces.get(Color.YE).setAdjacentFaces(Position.DW, faces.get(Color.BL));
        this.faces.get(Color.YE).setAdjacentFaces(Position.LE, faces.get(Color.OR));
        this.faces.get(Color.YE).setAdjacentFaces(Position.RI, faces.get(Color.RE));
        this.faces.get(Color.YE).setAdjacentFaces(Position.OP, faces.get(Color.WH));
        this.faces.get(Color.YE).setPositionAdjacentFaces(Position.UP, Position.UP);
        this.faces.get(Color.YE).setPositionAdjacentFaces(Position.DW, Position.DW);
        this.faces.get(Color.YE).setPositionAdjacentFaces(Position.LE, Position.RI);
        this.faces.get(Color.YE).setPositionAdjacentFaces(Position.RI, Position.LE);

        this.faces.get(Color.RE).setAdjacentFaces(Position.UP, faces.get(Color.GR));
        this.faces.get(Color.RE).setAdjacentFaces(Position.DW, faces.get(Color.BL));
        this.faces.get(Color.RE).setAdjacentFaces(Position.LE, faces.get(Color.YE));
        this.faces.get(Color.RE).setAdjacentFaces(Position.RI, faces.get(Color.WH));
        this.faces.get(Color.RE).setAdjacentFaces(Position.OP, faces.get(Color.OR));
        this.faces.get(Color.RE).setPositionAdjacentFaces(Position.UP, Position.LE);
        this.faces.get(Color.RE).setPositionAdjacentFaces(Position.DW, Position.LE);
        this.faces.get(Color.RE).setPositionAdjacentFaces(Position.LE, Position.RI);
        this.faces.get(Color.RE).setPositionAdjacentFaces(Position.RI, Position.LE);

        this.faces.get(Color.BL).setAdjacentFaces(Position.UP, faces.get(Color.WH));
        this.faces.get(Color.BL).setAdjacentFaces(Position.DW, faces.get(Color.YE));
        this.faces.get(Color.BL).setAdjacentFaces(Position.LE, faces.get(Color.RE));
        this.faces.get(Color.BL).setAdjacentFaces(Position.RI, faces.get(Color.OR));
        this.faces.get(Color.BL).setAdjacentFaces(Position.OP, faces.get(Color.GR));
        this.faces.get(Color.BL).setPositionAdjacentFaces(Position.UP, Position.DW);
        this.faces.get(Color.BL).setPositionAdjacentFaces(Position.DW, Position.DW);
        this.faces.get(Color.BL).setPositionAdjacentFaces(Position.LE, Position.DW);
        this.faces.get(Color.BL).setPositionAdjacentFaces(Position.RI, Position.DW);

        this.faces.get(Color.GR).setAdjacentFaces(Position.UP, faces.get(Color.YE));
        this.faces.get(Color.GR).setAdjacentFaces(Position.DW, faces.get(Color.WH));
        this.faces.get(Color.GR).setAdjacentFaces(Position.LE, faces.get(Color.RE));
        this.faces.get(Color.GR).setAdjacentFaces(Position.RI, faces.get(Color.OR));
        this.faces.get(Color.GR).setAdjacentFaces(Position.OP, faces.get(Color.BL));
        this.faces.get(Color.GR).setPositionAdjacentFaces(Position.UP, Position.UP);
        this.faces.get(Color.GR).setPositionAdjacentFaces(Position.DW, Position.UP);
        this.faces.get(Color.GR).setPositionAdjacentFaces(Position.LE, Position.UP);
        this.faces.get(Color.GR).setPositionAdjacentFaces(Position.RI, Position.UP);

    }
    
    /**
     * Método get do atributo faces.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param color Cor da face que deve ser retornada.
     * @return Face - Coleção de subCubesMaster.
     * 
     */
    public Face getFace(Color color) {
        if (color == null) {
            throw new IllegalArgumentException("Color is required");
        }
        return this.faces.get(color);
    }
    
    /**
     * Método set do atributo subCubesMaster.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param face Matriz que representa a face.
     */
    public void setFace(Color[][] face) {
        if (face == null) {
            throw new IllegalArgumentException("Face is required");
        }
        if (face.length != this.dimension || face[0].length != this.dimension) {
            throw new IllegalArgumentException("Face dimension is incorrect");
        }
        this.faces.get(face[1][1]).setFace(face);
    }
    
    /**
     * Método que aplica a solução ao cubo.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param color Cor utilizada como base para a solução do cubo.
     * @param solution Lista em que serão inseridos os passos executados para resolver o cubo. 
     */
    public void getSolution(Color color, ArrayList<String> solution) {
        if (color == null) {
            throw new IllegalArgumentException("Color is required");
        }
        this.solveFirstLayer(color, solution);
        this.solveSecondLayer(color, solution);
        this.solveThirdLayer(color, solution);
    }
    
    /**
     * Método que aplica a da primeira camada do cubo.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param color Cor utilizada como base para a solução do cubo.
     * @param solution Lista em que serão inseridos os passos executados para resolver o cubo. 
     */
    public void solveFirstLayer(Color color, ArrayList<String> solution) {
        if (color == null) {
            throw new IllegalArgumentException("Color is required");
        }
        Face face = this.getFace(color);
        Face oppositeFace = face.getAdjacentFace(Position.OP);
        boolean inOppositeFace = true;
        Color adj;
        Position positions;
        while (!face.isCompleteCross()) {
            while (inOppositeFace) {
                if (oppositeFace.getColor(0, 1) == face.getColor() || oppositeFace.getAdjacentColors(0, 1)[0] == face.getColor()) {
                    if (oppositeFace.getColor(0, 1) == face.getColor()) {
                        adj = oppositeFace.getAdjacentColors(0, 1)[0];
                    } else {
                        adj = oppositeFace.getColor(0, 1);
                    }
                    positions = oppositeFace.getPositionFaceColor(adj);
                    if (positions == null) {
                        throw new IllegalArgumentException("Cube with case impossible");
                    } else {
                        switch (positions) {
                            case RI:
                                this.movementU(oppositeFace, solution);
                                break;
                            case DW:
                                this.movementU(oppositeFace, solution);
                                this.movementU(oppositeFace, solution);
                                break;
                            case LE:
                                this.movementUi(oppositeFace, solution);
                        }
                        this.movementFirstLayer(positions, face, adj, solution);
                    }
                } else if (oppositeFace.getColor(1, 0) == face.getColor() || oppositeFace.getAdjacentColors(1, 0)[0] == face.getColor()) {
                    if (oppositeFace.getColor(1, 0) == face.getColor()) {
                        adj = oppositeFace.getAdjacentColors(1, 0)[0];
                    } else {
                        adj = oppositeFace.getColor(1, 0);
                    }
                    positions = oppositeFace.getPositionFaceColor(adj);
                    if (positions == null) {
                        throw new IllegalArgumentException("Cube with case impossible");
                    } else {
                        switch (positions) {
                            case UP:
                                this.movementU(oppositeFace, solution);
                                break;
                            case RI:
                                this.movementU(oppositeFace, solution);
                                this.movementU(oppositeFace, solution);
                                break;
                            case DW:
                                this.movementUi(oppositeFace, solution);
                        }
                        this.movementFirstLayer(positions, face, adj, solution);
                    }
                } else if (oppositeFace.getColor(1, 2) == face.getColor() || oppositeFace.getAdjacentColors(1, 2)[0] == face.getColor()) {
                    if (oppositeFace.getColor(1, 2) == face.getColor()) {
                        adj = oppositeFace.getAdjacentColors(1, 2)[0];
                    } else {
                        adj = oppositeFace.getColor(1, 2);
                    }
                    positions = oppositeFace.getPositionFaceColor(adj);
                    if (positions == null) {
                        throw new IllegalArgumentException("Cube with case impossible");
                    } else {
                        switch (positions) {
                            case DW:
                                this.movementU(oppositeFace, solution);
                                break;
                            case LE:
                                this.movementU(oppositeFace, solution);
                                this.movementU(oppositeFace, solution);
                                break;
                            case UP:
                                this.movementUi(oppositeFace, solution);
                        }
                        this.movementFirstLayer(positions, face, adj, solution);
                    }
                } else if (oppositeFace.getColor(2, 1) == face.getColor() || oppositeFace.getAdjacentColors(2, 1)[0] == face.getColor()) {
                    if (oppositeFace.getColor(2, 1) == face.getColor()) {
                        adj = oppositeFace.getAdjacentColors(2, 1)[0];
                    } else {
                        adj = oppositeFace.getColor(2, 1);
                    }
                    positions = oppositeFace.getPositionFaceColor(adj);
                    if (positions == null) {
                        throw new IllegalArgumentException("Cube with case impossible");
                    } else {
                        switch (positions) {
                            case LE:
                                this.movementU(oppositeFace, solution);
                                break;
                            case UP:
                                this.movementU(oppositeFace, solution);
                                this.movementU(oppositeFace, solution);
                                break;
                            case RI:
                                this.movementUi(oppositeFace, solution);
                        }
                        this.movementFirstLayer(positions, face, adj, solution);
                    }
                } else {
                    inOppositeFace = false;
                }

            }
            if (!face.isCompleteCross()) {
                Face[] adjacentFaces = new Face[4];

                adjacentFaces[0] = face.getAdjacentFace(Position.UP);
                adjacentFaces[1] = face.getAdjacentFace(Position.RI);
                adjacentFaces[2] = face.getAdjacentFace(Position.DW);
                adjacentFaces[3] = face.getAdjacentFace(Position.LE);

                int[][] mainFacePositions = new int[4][2];

                mainFacePositions[0][0] = 0;
                mainFacePositions[0][1] = 1;
                mainFacePositions[1][0] = 1;
                mainFacePositions[1][1] = 2;
                mainFacePositions[2][0] = 2;
                mainFacePositions[2][1] = 1;
                mainFacePositions[3][0] = 1;
                mainFacePositions[3][1] = 0;

                int turns = 0;

                for (int i = 0; i < adjacentFaces.length && !inOppositeFace; i++) {

                    switch (face.getPositionAdjacentFaceColor(adjacentFaces[i].getColor()))/*face.getPositionFaceColor(facesAdj[i].getCor())*/ {
                        case UP:
                            if (adjacentFaces[i].getColor(1, 0) == face.getColor() || adjacentFaces[i].getAdjacentColors(1, 0)[0] == face.getColor()) {
                                if (face.inCorrectPosition(mainFacePositions[i][0], mainFacePositions[i][1])) {
                                    turns++;
                                    this.movementU(face, solution);
                                }
                                this.movementUi(adjacentFaces[i], solution);
                                if (turns > 0) {
                                    turns--;
                                    this.movementUi(face, solution);
                                }
                                inOppositeFace = true;
                            }
                            break;
                        case RI:
                            if (adjacentFaces[i].getColor(0, 1) == face.getColor() || adjacentFaces[i].getAdjacentColors(0, 1)[0] == face.getColor()) {
                                if (face.inCorrectPosition(mainFacePositions[i][0], mainFacePositions[i][1])) {
                                    turns++;
                                    this.movementU(face, solution);
                                }
                                this.movementUi(adjacentFaces[i], solution);
                                if (turns > 0) {
                                    turns--;
                                    this.movementUi(face, solution);
                                }
                                inOppositeFace = true;
                            }
                            break;
                        case DW:
                            if (adjacentFaces[i].getColor(1, 2) == face.getColor() || adjacentFaces[i].getAdjacentColors(1, 2)[0] == face.getColor()) {
                                if (face.inCorrectPosition(mainFacePositions[i][0], mainFacePositions[i][1])) {
                                    turns++;
                                    this.movementU(face, solution);
                                }
                                this.movementUi(adjacentFaces[i], solution);
                                if (turns > 0) {
                                    turns--;
                                    this.movementUi(face, solution);
                                }
                                inOppositeFace = true;
                            }
                            break;
                        case LE:
                            if (adjacentFaces[i].getColor(2, 1) == face.getColor() || adjacentFaces[i].getAdjacentColors(2, 1)[0] == face.getColor()) {
                                if (face.inCorrectPosition(mainFacePositions[i][0], mainFacePositions[i][1])) {
                                    turns++;
                                    this.movementU(face, solution);
                                }
                                this.movementUi(adjacentFaces[i], solution);
                                if (turns > 0) {
                                    turns--;
                                    this.movementUi(face, solution);
                                }
                                inOppositeFace = true;
                            }
                    }
                }

            }
            if (!face.isCompleteCross() && !inOppositeFace) {
                Position posicao = null;
                if (!face.inCorrectPosition(0, 1)) {
                    posicao = Position.UP;
                } else {
                    if (!face.inCorrectPosition(1, 2)) {
                        posicao = Position.RI;
                    } else {
                        if (!face.inCorrectPosition(2, 1)) {
                            posicao = Position.DW;
                        } else {
                            posicao = Position.LE;
                        }

                    }
                }
                this.movementU(face.getAdjacentFace(posicao), solution);
                this.movementU(face.getAdjacentFace(posicao), solution);
                inOppositeFace = true;
            }
        }

        inOppositeFace = true;

        while (!face.isCompleteFirstLayer()) {
            while (inOppositeFace && !face.isCompleteFirstLayer()) {
                if (oppositeFace.existsColor(0, 0, color) || oppositeFace.existsColor(0, 2, color)
                        || oppositeFace.existsColor(2, 0, color) || oppositeFace.existsColor(2, 2, color)) {
                    if (oppositeFace.isInCorrectOpositePosition(0, 0, color)) {
                        int[] coorFace = face.getEquivalentPosition(0, 0);
                        while (!face.inCorrectPosition(coorFace[0], coorFace[1])) {
                            this.movementRiDiRD(oppositeFace.getAdjacentFace(Position.UP), oppositeFace, solution);
                        }
                    } else if (oppositeFace.isInCorrectOpositePosition(0, 2, color)) {
                        int[] coorFace = face.getEquivalentPosition(0, 2);
                        while (!face.inCorrectPosition(coorFace[0], coorFace[1])) {
                            this.movementRiDiRD(oppositeFace.getAdjacentFace(Position.RI), oppositeFace, solution);
                        }
                    } else if (oppositeFace.isInCorrectOpositePosition(2, 0, color)) {
                        int[] coorFace = face.getEquivalentPosition(2, 0);
                        while (!face.inCorrectPosition(coorFace[0], coorFace[1])) {
                            this.movementRiDiRD(oppositeFace.getAdjacentFace(Position.LE), oppositeFace, solution);
                        }
                    } else if (oppositeFace.isInCorrectOpositePosition(2, 2, color)) {
                        int[] coorFace = face.getEquivalentPosition(2, 2);
                        while (!face.inCorrectPosition(coorFace[0], coorFace[1])) {
                            this.movementRiDiRD(oppositeFace.getAdjacentFace(Position.DW), oppositeFace, solution);
                        }
                    } else {
                        this.movementU(oppositeFace, solution);
                    }
                } else {
                    inOppositeFace = false;
                }
            }

            if (!face.isCompleteFirstLayer()) {
                if (!face.inCorrectPosition(0, 0)) {
                    this.movementLiDL(face.getAdjacentFace(Position.LE), oppositeFace, solution);
                } else if (!face.inCorrectPosition(0, 2)) {
                    this.movementLiDL(face.getAdjacentFace(Position.UP), oppositeFace, solution);
                } else if (!face.inCorrectPosition(2, 0)) {
                    this.movementLiDL(face.getAdjacentFace(Position.DW), oppositeFace, solution);
                } else if (!face.inCorrectPosition(2, 2)) {
                    this.movementLiDL(face.getAdjacentFace(Position.RI), oppositeFace, solution);
                } else {
                    throw new IllegalArgumentException("Cube in wrong position");
                }
            }
            inOppositeFace = true;
        }
    }
    
    /**
     * Método que aplica a da segunda camada do cubo.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param color Cor utilizada como base para a solução do cubo.
     * @param solution Lista em que serão inseridos os passos executados para resolver o cubo. 
     */
    public void solveSecondLayer(Color color, ArrayList<String> solution) {
        if (color == null) {
            throw new IllegalArgumentException("Color is required");
        }
        Face face = this.getFace(color);
        if (!face.isCompleteFirstLayer()) {
            throw new IllegalArgumentException("First Layer complete is required");
        }
        Face oppositeFace = face.getAdjacentFace(Position.OP);
        Face inProgress;
        Position[] positions = new Position[]{Position.UP, Position.RI, Position.DW, Position.LE};
        int qtyTurns = 0;
        boolean change = true;
        while (!face.isCompleteSecondLayer()) {

            while (!face.isCompleteSecondLayer() && change) {
                change = false;
                for (Position posicao : positions) {
                    inProgress = face.getAdjacentFace(posicao);
                    switch (face.getPositionAdjacentFaces(posicao)) {
                        case UP:
                            if (inProgress.getColor(2, 1) == inProgress.getColor() /*&& !face.isCompleteSecondLayerFaceAdj(Posicoes.UP)*/) {
                                if (inProgress.getAdjacentColors(2, 1)[0] == inProgress.getAdjacentFace(Position.LE).getColor()) {
                                    this.movementURUiRiUiFiUF(oppositeFace, inProgress, inProgress.getAdjacentFace(Position.LE), solution);
                                    change = true;
                                    qtyTurns = 0;
                                } else if (inProgress.getAdjacentColors(2, 1)[0] == inProgress.getAdjacentFace(Position.RI).getColor()) {
                                    this.movementUiLiULUFUiFi(oppositeFace, inProgress, inProgress.getAdjacentFace(Position.RI), solution);
                                    change = true;
                                    qtyTurns = 0;
                                }
                            }
                            break;
                        case RI:

                            if (inProgress.getColor(1, 0) == inProgress.getColor()/* && !face.isCompleteSecondLayerFaceAdj(Posicoes.RI)*/) {
                                if (inProgress.getAdjacentColors(1, 0)[0] == inProgress.getAdjacentFace(Position.UP).getColor()) {
                                    this.movementURUiRiUiFiUF(oppositeFace, inProgress, inProgress.getAdjacentFace(Position.UP), solution);
                                    change = true;
                                    qtyTurns = 0;
                                } else if (inProgress.getAdjacentColors(1, 0)[0] == inProgress.getAdjacentFace(Position.DW).getColor()) {
                                    this.movementUiLiULUFUiFi(oppositeFace, inProgress, inProgress.getAdjacentFace(Position.DW), solution);
                                    change = true;
                                    qtyTurns = 0;
                                }
                            }
                            break;
                        case DW:
                            if (inProgress.getColor(0, 1) == inProgress.getColor() /*&& !face.isCompleteSecondLayerFaceAdj(Posicoes.DW)*/) {
                                if (inProgress.getAdjacentColors(0, 1)[0] == inProgress.getAdjacentFace(Position.RI).getColor()) {
                                    this.movementURUiRiUiFiUF(oppositeFace, inProgress, inProgress.getAdjacentFace(Position.RI), solution);
                                    change = true;
                                    qtyTurns = 0;
                                } else if (inProgress.getAdjacentColors(0, 1)[0] == inProgress.getAdjacentFace(Position.LE).getColor()) {
                                    this.movementUiLiULUFUiFi(oppositeFace, inProgress, inProgress.getAdjacentFace(Position.LE), solution);
                                    change = true;
                                    qtyTurns = 0;
                                }
                            }
                            break;
                        case LE:

                            if (inProgress.getColor(1, 2) == inProgress.getColor() /*&& !face.isCompleteSecondLayerFaceAdj(Posicoes.LE)*/) {
                                if (inProgress.getAdjacentColors(1, 2)[0] == inProgress.getAdjacentFace(Position.DW).getColor()) {
                                    this.movementURUiRiUiFiUF(oppositeFace, inProgress, inProgress.getAdjacentFace(Position.DW), solution);
                                    change = true;
                                    qtyTurns = 0;
                                } else if (inProgress.getAdjacentColors(1, 2)[0] == inProgress.getAdjacentFace(Position.UP).getColor()) {
                                    this.movementUiLiULUFUiFi(oppositeFace, inProgress, inProgress.getAdjacentFace(Position.UP), solution);
                                    change = true;
                                    qtyTurns = 0;
                                }
                            }
                    }
                }
            }

            if (!face.isCompleteSecondLayer()) {
                if (qtyTurns < 3) {
                    this.movementU(oppositeFace, solution);
                    change = true;
                    qtyTurns++;
                } else {
                    for (int i = 0; i < positions.length && !change; i++) {
                        inProgress = face.getAdjacentFace(positions[i]);
                        switch (face.getPositionAdjacentFaces(positions[i])) {
                            case UP:
                                if (!inProgress.inCorrectPosition(1, 0)) {
                                    this.movementURUiRiUiFiUF(oppositeFace, inProgress, inProgress.getAdjacentFace(Position.LE), solution);
                                    change = true;
                                    qtyTurns = 0;
                                } else if (!inProgress.inCorrectPosition(1, 2)) {
                                    this.movementUiLiULUFUiFi(oppositeFace, inProgress, inProgress.getAdjacentFace(Position.RI), solution);
                                    change = true;
                                    qtyTurns = 0;
                                }
                                break;
                            case RI:
                                if (!inProgress.inCorrectPosition(0, 1)) {
                                    this.movementURUiRiUiFiUF(oppositeFace, inProgress, inProgress.getAdjacentFace(Position.UP), solution);
                                    change = true;
                                    qtyTurns = 0;
                                } else if (!inProgress.inCorrectPosition(1, 2)) {
                                    this.movementUiLiULUFUiFi(oppositeFace, inProgress, inProgress.getAdjacentFace(Position.DW), solution);
                                    change = true;
                                    qtyTurns = 0;
                                }
                                break;
                            case DW:
                                if (!inProgress.inCorrectPosition(1, 0)) {
                                    this.movementUiLiULUFUiFi(oppositeFace, inProgress, inProgress.getAdjacentFace(Position.LE), solution);
                                    change = true;
                                    qtyTurns = 0;
                                } else if (!inProgress.inCorrectPosition(1, 2)) {
                                    this.movementURUiRiUiFiUF(oppositeFace, inProgress, inProgress.getAdjacentFace(Position.RI), solution);

                                    change = true;
                                    qtyTurns = 0;
                                }
                                break;
                            case LE:
                                if (!inProgress.inCorrectPosition(0, 1)) {
                                    this.movementUiLiULUFUiFi(oppositeFace, inProgress, inProgress.getAdjacentFace(Position.UP), solution);
                                    change = true;
                                    qtyTurns = 0;
                                } else if (!inProgress.inCorrectPosition(2, 1)) {
                                    this.movementURUiRiUiFiUF(oppositeFace, inProgress, inProgress.getAdjacentFace(Position.DW), solution);
                                    change = true;
                                    qtyTurns = 0;
                                }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Método que aplica a da terceira camada do cubo.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param color Cor utilizada como base para a solução do cubo.
     * @param solution Lista em que serão inseridos os passos executados para resolver o cubo. 
     */
    public void solveThirdLayer(Color color, ArrayList<String> solution) {
        if (color == null) {
            throw new IllegalArgumentException("Color is required");
        }
        Face face = this.getFace(color);
        if (!face.isCompleteSecondLayer()) {
            throw new IllegalArgumentException("Second Layer complete is required");
        }
        Face oppositeFace = face.getAdjacentFace(Position.OP);

        while (!oppositeFace.isCompleteFaceCross()) {

            if ((oppositeFace.getColor(1, 0) == oppositeFace.getColor() && oppositeFace.getColor(1, 2) == oppositeFace.getColor())
                    || (oppositeFace.getColor(0, 1) == oppositeFace.getColor() && oppositeFace.getColor(1, 0) == oppositeFace.getColor())) {
                this.movementFRURiUiFi(oppositeFace.getAdjacentFace(Position.DW), oppositeFace.getAdjacentFace(Position.RI), oppositeFace, solution);
            } else if ((oppositeFace.getColor(0, 1) == oppositeFace.getColor() && oppositeFace.getColor(2, 1) == oppositeFace.getColor())
                    || (oppositeFace.getColor(0, 1) == oppositeFace.getColor() && oppositeFace.getColor(1, 2) == oppositeFace.getColor())) {
                this.movementFRURiUiFi(oppositeFace.getAdjacentFace(Position.LE), oppositeFace.getAdjacentFace(Position.DW), oppositeFace, solution);
            } else if (oppositeFace.getColor(1, 2) == oppositeFace.getColor() && oppositeFace.getColor(2, 1) == oppositeFace.getColor()) {
                this.movementFRURiUiFi(oppositeFace.getAdjacentFace(Position.UP), oppositeFace.getAdjacentFace(Position.LE), oppositeFace, solution);
            } else {
                this.movementFRURiUiFi(oppositeFace.getAdjacentFace(Position.RI), oppositeFace.getAdjacentFace(Position.UP), oppositeFace, solution);
            }
        }

        while (!oppositeFace.isCompleteCross()) {
            if ((oppositeFace.getAdjacentColors(0, 1)[0] == oppositeFace.getAdjacentFace(Position.UP).getColor())
                    && (oppositeFace.getAdjacentColors(2, 1)[0] == oppositeFace.getAdjacentFace(Position.DW).getColor())) {
                this.movementRURiURUURi(oppositeFace.getAdjacentFace(Position.RI), oppositeFace, solution);
            } else if ((oppositeFace.getAdjacentColors(1, 0)[0] == oppositeFace.getAdjacentFace(Position.LE).getColor())
                    && (oppositeFace.getAdjacentColors(1, 2)[0] == oppositeFace.getAdjacentFace(Position.RI).getColor())) {
                this.movementRURiURUURi(oppositeFace.getAdjacentFace(Position.DW), oppositeFace, solution);
            } else if ((oppositeFace.getAdjacentColors(0, 1)[0] == oppositeFace.getAdjacentFace(Position.UP).getColor())
                    && (oppositeFace.getAdjacentColors(1, 2)[0] == oppositeFace.getAdjacentFace(Position.RI).getColor())) {
                this.movementRURiURUURi(oppositeFace.getAdjacentFace(Position.RI), oppositeFace, solution);
            } else if ((oppositeFace.getAdjacentColors(1, 2)[0] == oppositeFace.getAdjacentFace(Position.RI).getColor())
                    && (oppositeFace.getAdjacentColors(2, 1)[0] == oppositeFace.getAdjacentFace(Position.DW).getColor())) {
                this.movementRURiURUURi(oppositeFace.getAdjacentFace(Position.DW), oppositeFace, solution);
            } else if ((oppositeFace.getAdjacentColors(2, 1)[0] == oppositeFace.getAdjacentFace(Position.DW).getColor())
                    && (oppositeFace.getAdjacentColors(1, 0)[0] == oppositeFace.getAdjacentFace(Position.LE).getColor())) {
                this.movementRURiURUURi(oppositeFace.getAdjacentFace(Position.LE), oppositeFace, solution);
            } else if ((oppositeFace.getAdjacentColors(1, 0)[0] == oppositeFace.getAdjacentFace(Position.LE).getColor())
                    && (oppositeFace.getAdjacentColors(0, 1)[0] == oppositeFace.getAdjacentFace(Position.UP).getColor())) {
                this.movementRURiURUURi(oppositeFace.getAdjacentFace(Position.UP), oppositeFace, solution);
            } else {
                this.movementU(oppositeFace, solution);
            }

        }

        while ((!oppositeFace.isInCorrectOpositePosition(0, 0, oppositeFace.getColor()))
                || (!oppositeFace.isInCorrectOpositePosition(0, 2, oppositeFace.getColor()))
                || (!oppositeFace.isInCorrectOpositePosition(2, 0, oppositeFace.getColor()))
                || (!oppositeFace.isInCorrectOpositePosition(2, 2, oppositeFace.getColor()))) {
            if (oppositeFace.isInCorrectOpositePosition(0, 0, oppositeFace.getColor())) {
                this.movementURUiLiURiUiL(oppositeFace, oppositeFace.getAdjacentFace(Position.LE), oppositeFace.getAdjacentFace(Position.RI), solution);
            } else if (oppositeFace.isInCorrectOpositePosition(0, 2, oppositeFace.getColor())) {
                this.movementURUiLiURiUiL(oppositeFace, oppositeFace.getAdjacentFace(Position.UP), oppositeFace.getAdjacentFace(Position.DW), solution);
            } else if (oppositeFace.isInCorrectOpositePosition(2, 0, oppositeFace.getColor())) {
                this.movementURUiLiURiUiL(oppositeFace, oppositeFace.getAdjacentFace(Position.DW), oppositeFace.getAdjacentFace(Position.UP), solution);
            } else {
                this.movementURUiLiURiUiL(oppositeFace, oppositeFace.getAdjacentFace(Position.RI), oppositeFace.getAdjacentFace(Position.LE), solution);
            }
        }

        Position fixPosition;
        int[] fixCoord;
        if (!oppositeFace.inCorrectPosition(0, 0)) {
            fixPosition = Position.LE;
            fixCoord = new int[]{0, 0};
        } else {
            if (!oppositeFace.inCorrectPosition(0, 2)) {
                fixPosition = Position.UP;
                fixCoord = new int[]{0, 2};
            } else {
                if (!oppositeFace.inCorrectPosition(2, 0)) {
                    fixPosition = Position.DW;
                    fixCoord = new int[]{2, 0};
                } else {
                    fixPosition = Position.RI;
                    fixCoord = new int[]{2, 2};
                }
            }
        }

        while (!this.solved()) {
            while (oppositeFace.getColor(fixCoord[0], fixCoord[1]) != oppositeFace.getColor()) {
                this.movementRiDiRD(oppositeFace.getAdjacentFace(fixPosition), face, solution);
            }
            while (oppositeFace.getColor(fixCoord[0], fixCoord[1]) == oppositeFace.getColor() && !this.solved()) {
                this.movementUi(oppositeFace, solution);
            }
        }
    }
    
    /**
     * Método que realiza o movimento da primeira camada
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param position Position em que se aplica a operação.
     * @param face Face em que se aplica a operação.
     * @param corFaceAdj Cor da face adjacente.
     * @param solution Lista em que serão inseridos os passos executados para resolver o cubo. 
     */
    private void movementFirstLayer(Position position, Face face, Color corFaceAdj, ArrayList<String> solution) {
        Face faceOposta = face.getAdjacentFace(Position.OP);
        if ((position == Position.UP && faceOposta.getColor(0, 1) == face.getColor())
                || (position == Position.RI && faceOposta.getColor(1, 2) == face.getColor())
                || (position == Position.DW && faceOposta.getColor(2, 1) == face.getColor())
                || (position == Position.LE && faceOposta.getColor(1, 0) == face.getColor())) {

            this.movementU(this.getFace(corFaceAdj), solution);
            this.movementU(this.getFace(corFaceAdj), solution);
        } else {
            this.movementFULiUi(face, corFaceAdj, solution);
        }

    }
    
    /**
     * Método que realiza o movimento FULiUi
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param face Face em que se aplica a operação.
     * @param corFaceAdj Cor da face adjacente.
     * @param solution Lista em que serão inseridos os passos executados para resolver o cubo. 
     */
    private void movementFULiUi(Face face, Color corFaceAdj, ArrayList<String> solution) {
        Face frontalFace = this.faces.get(corFaceAdj);
        Face leftFace = null;
        switch (face.getPositionFaceColor(corFaceAdj)) {

            case UP:
                leftFace = face.getAdjacentFace(Position.RI);
                break;
            case RI:
                leftFace = face.getAdjacentFace(Position.DW);
                break;
            case DW:
                leftFace = face.getAdjacentFace(Position.LE);
                break;
            case LE:
                leftFace = face.getAdjacentFace(Position.UP);
        }
        frontalFace.rotate(true, solution);
        face.rotate(true, solution);
        leftFace.rotate(false, solution);
        face.rotate(false, solution);

    }
   
    /**
     * Método que realiza o movimento U
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param face Face em que se aplica a operação.
     * @param corFaceAdj Cor da face adjacente.
     * @param solution Lista em que serão inseridos os passos executados para resolver o cubo. 
     */
    private void movementU(Face upFace, ArrayList<String> solution) {
        upFace.rotate(true, solution);
    }
   
    /**
     * Método que realiza o movimento Ui
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param face Face em que se aplica a operação.
     * @param corFaceAdj Cor da face adjacente.
     * @param solution Lista em que serão inseridos os passos executados para resolver o cubo. 
     */
    private void movementUi(Face upFace, ArrayList<String> solution) {
        upFace.rotate(false, solution);
    }
    
    /**
     * Método que realiza o movimento RiDiRD
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param rightFace Face da direita em que se aplica a operação.
     * @param downFace face de baixo em que se aplica a operação.
     * @param solution Lista em que serão inseridos os passos executados para resolver o cubo. 
     */
    private void movementRiDiRD(Face rightFace, Face downFace, ArrayList<String> solution) {
        rightFace.rotate(false, solution);
        downFace.rotate(false, solution);
        rightFace.rotate(true, solution);
        downFace.rotate(true, solution);
    }
 
    /**
     * Método que realiza o movimento LiDL
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param leftFace Face da esquerda em que se aplica a operação.
     * @param downFace face de baixo em que se aplica a operação.
     * @param solution Lista em que serão inseridos os passos executados para resolver o cubo. 
     */
    private void movementLiDL(Face leftFace, Face dounwFace, ArrayList<String> solution) {
        leftFace.rotate(false, solution);
        dounwFace.rotate(true, solution);
        leftFace.rotate(true, solution);
    }

    /**
     * Método que realiza o movimento UiLiULUFUiFi
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param upFace Face de cima em que se aplica a operação.
     * @param frontFace face da frente em que se aplica a operação.
     * @param leftFace face da esquerda em que se aplica a operação.
     * @param solution Lista em que serão inseridos os passos executados para resolver o cubo. 
     */
    private void movementUiLiULUFUiFi(Face upFace, Face frontFace, Face leftFace, ArrayList<String> solution) {
        upFace.rotate(false, solution);
        leftFace.rotate(false, solution);
        upFace.rotate(true, solution);
        leftFace.rotate(true, solution);
        upFace.rotate(true, solution);
        frontFace.rotate(true, solution);
        upFace.rotate(false, solution);
        frontFace.rotate(false, solution);
    }

    /**
     * Método que realiza o movimento URUiRiUiFiUF
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param upFace Face de cima em que se aplica a operação.
     * @param frontFace face da frente em que se aplica a operação.
     * @param rightFace face da direita em que se aplica a operação.
     * @param solution Lista em que serão inseridos os passos executados para resolver o cubo. 
     */
    private void movementURUiRiUiFiUF(Face upFace, Face frontFace, Face rightFace, ArrayList<String> solution) {
        upFace.rotate(true, solution);
        rightFace.rotate(true, solution);
        upFace.rotate(false, solution);
        rightFace.rotate(false, solution);
        upFace.rotate(false, solution);
        frontFace.rotate(false, solution);
        upFace.rotate(true, solution);
        frontFace.rotate(true, solution);
    }
    
    /**
     * Método que realiza o movimento URUiRiUiFiUF
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param frontFace face da frente em que se aplica a operação.
     * @param rightFace face da direita em que se aplica a operação.
     * @param upFace Face de cima em que se aplica a operação.
     * @param solution Lista em que serão inseridos os passos executados para resolver o cubo. 
     */
    private void movementFRURiUiFi(Face frontFace, Face rightFace, Face upFace, ArrayList<String> solution) {
        frontFace.rotate(true, solution);
        rightFace.rotate(true, solution);
        upFace.rotate(true, solution);
        rightFace.rotate(false, solution);
        upFace.rotate(false, solution);
        frontFace.rotate(false, solution);
    }
    
    /**
     * Método que realiza o movimento RURiURUURi
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param rightFace face da direita em que se aplica a operação.
     * @param upFace Face de cima em que se aplica a operação.
     * @param solution Lista em que serão inseridos os passos executados para resolver o cubo. 
     */
    private void movementRURiURUURi(Face rightFace, Face upFace, ArrayList<String> solution) {
        rightFace.rotate(true, solution);
        upFace.rotate(true, solution);
        rightFace.rotate(false, solution);
        upFace.rotate(true, solution);
        rightFace.rotate(true, solution);
        upFace.rotate(true, solution);
        upFace.rotate(true, solution);
        rightFace.rotate(false, solution);
    }
    
    /**
     * Método que realiza o movimento URUiLiURiUiL
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param upFace Face de cima em que se aplica a operação.
     * @param rightFace face da direita em que se aplica a operação.
     * @param leftFace face da esquerda em que se aplica a operação.
     * @param solution Lista em que serão inseridos os passos executados para resolver o cubo. 
     */
    private void movementURUiLiURiUiL(Face upFace, Face rightFace, Face leftFace, ArrayList<String> solution) {
        upFace.rotate(true, solution);
        rightFace.rotate(true, solution);
        upFace.rotate(false, solution);
        leftFace.rotate(false, solution);
        upFace.rotate(true, solution);
        rightFace.rotate(false, solution);
        upFace.rotate(false, solution);
        leftFace.rotate(true, solution);
    }
    
    /**
     * Método que verifica se o cubo está resolvido.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return boolean - True se o cubo está resolvido.
     */
    public boolean solved() {
        return this.faces.get(Color.WH).isFaceComplete()
                && this.faces.get(Color.OR).isFaceComplete()
                && this.faces.get(Color.YE).isFaceComplete()
                && this.faces.get(Color.RE).isFaceComplete()
                && this.faces.get(Color.GR).isFaceComplete()
                && this.faces.get(Color.BL).isFaceComplete();
    }
    
    /**
     * Método que embaralha o cubo aleatóriamente.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param qtdMovements - Quantidade de movimentos reaizados.
     */
    public void shuffle(int qtdMovements) {
        int face;
        int right;
        Random random = new Random();
        ArrayList<String> ret = new ArrayList();
        for (int i = 0; i < qtdMovements; i++) {
            face = random.nextInt(6);
            right = random.nextInt(2);

            switch (face) {
                case 0:
                    this.faces.get(Color.WH).rotate(right == 1, ret);
                    break;
                case 1:
                    this.faces.get(Color.GR).rotate(right == 1, ret);
                    break;
                case 2:
                    this.faces.get(Color.BL).rotate(right == 1, ret);
                    break;
                case 3:
                    this.faces.get(Color.RE).rotate(right == 1, ret);
                    break;
                case 4:
                    this.faces.get(Color.OR).rotate(right == 1, ret);
                    break;
                case 5:
                    this.faces.get(Color.YE).rotate(right == 1, ret);

            }
        }

    }
    
    /**
     * Método que clona o cubo.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return Cube - Novo objeto de cubo.
     */
    public Cube getCopy() {
        Cube ret = new Cube(dimension);
        Color[][] cores = new Color[dimension][dimension];

        Color cor = Color.WH;
        for (int i = 0; i < cores.length; i++) {
            for (int j = 0; j < cores[i].length; j++) {
                cores[i][j] = this.getFace(cor).getFace()[i][j];
            }
        }
        ret.setFace(cores);
        cores = new Color[3][3];
        cor = Color.OR;
        for (int i = 0; i < cores.length; i++) {
            for (int j = 0; j < cores[i].length; j++) {
                cores[i][j] = this.getFace(cor).getFace()[i][j];
            }
        }
        ret.setFace(cores);
        cores = new Color[3][3];
        cor = Color.YE;
        for (int i = 0; i < cores.length; i++) {
            for (int j = 0; j < cores[i].length; j++) {
                cores[i][j] = this.getFace(cor).getFace()[i][j];
            }
        }
        ret.setFace(cores);
        cores = new Color[3][3];
        cor = Color.BL;
        for (int i = 0; i < cores.length; i++) {
            for (int j = 0; j < cores[i].length; j++) {
                cores[i][j] = this.getFace(cor).getFace()[i][j];
            }
        }
        ret.setFace(cores);
        cores = new Color[3][3];
        cor = Color.GR;
        for (int i = 0; i < cores.length; i++) {
            for (int j = 0; j < cores[i].length; j++) {
                cores[i][j] = this.getFace(cor).getFace()[i][j];
            }
        }
        ret.setFace(cores);
        cores = new Color[3][3];
        cor = Color.RE;
        for (int i = 0; i < cores.length; i++) {
            for (int j = 0; j < cores[i].length; j++) {
                cores[i][j] = this.getFace(cor).getFace()[i][j];
            }
        }
        ret.setFace(cores);

        return ret;
    }

}
