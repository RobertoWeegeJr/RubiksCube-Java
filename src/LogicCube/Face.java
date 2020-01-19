//Roberto, Thiago - Trabalho 04 - 2017.1
package LogicCube;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe responsável por representar uma face do cubo lógico.
 * Esta classe contém todos os elementos de modelagem das faces do cubo lógico.
 * 
 * @author Roberto Weege Jr
 * @since Versão inicial
 */
public class Face {

    private Color[][] face;
    private int dimension;

    private HashMap<Position, Face> adjacentFaces = new HashMap();
    private HashMap<Position, Position> positionAdjacentFaces = new HashMap();
    
    /**
     * Método construtor.
     * Seta os valores default para todos os atributos.
     * Configura todas os elememtos da face com a cor da face.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param color Cor da face.
     * @param dimension Dimensão da face.
     */
    public Face(Color color, int dimension) {
        if (color == null) {
            throw new IllegalArgumentException("Color is required");
        }
        if (dimension <= 0) {
            throw new IllegalArgumentException("Invalid dimention");
        }
        this.dimension = dimension;
        this.face = new Color[dimension][dimension];

        for (int i = 0; i < face.length; i++) {
            for (int j = 0; j < face[i].length; j++) {
                face[i][j] = color;
            }
        }
    }
    
    /**
     * Método get do atributo face.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return Color[][] - Matriz de elementos da face.
     */
    public Color[][] getFace() {
        return face;
    }

    /**
     * Método set do atributo face.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param face Matriz que representa os elementos da face.
     */
    public void setFace(Color[][] face) {
        if (face == null) {
            throw new IllegalArgumentException("Face is required");
        }
        if (face.length != this.dimension || face[0].length != this.dimension) {
            throw new IllegalArgumentException("Face dimension is incorrect");
        }
        this.face = face;
    }
    
    /**
     * Método get de face adjacente.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param position Posição em que ocorre a adjacencia.
     * @return Face - Face adjacente conforme posição.
     */
    public Face getAdjacentFace(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Position is required");
        }
        return this.adjacentFaces.get(position);
    }

    /**
     * Método set de face adjacente.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param position Posição em que a face é adjacente.
     * @param face Face adjacente.
     */
    public void setAdjacentFaces(Position position, Face face) {
        if (position == null) {
            throw new IllegalArgumentException("Position is required");
        }
        if (face == null) {
            throw new IllegalArgumentException("Face is required");
        }
        this.adjacentFaces.put(position, face);
    }

    /**
     * Método get de posição de face adjacente.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param position Posição em que ocorre a adjacencia.
     * @return Face - Face adjacente conforme posição.
     */
    public Position getPositionAdjacentFaces(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Position is required");
        }
        return this.positionAdjacentFaces.get(position);
    }
    
    /**
     * Método set de posição de adjacência de face adjacente.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param position Posição em que a face é adjacente.
     * @param adjacentPosition Posição em que a face adjacente é adjacente.
     */
    public void setPositionAdjacentFaces(Position position, Position adjacentPosition) {
        if (position == null || adjacentPosition == null) {
            throw new IllegalArgumentException("Position and Adjacent Position are required");
        }
        this.positionAdjacentFaces.put(position, adjacentPosition);
    }
    
    /**
     * Método get da cor da face.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return Color - Valor da cor da face.
     */
    public Color getColor() {
        return this.face[1][1];
    }
    
    /**
     * Método get da cor de elemento da face.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param i Linha em que se encontra oelemento na matriz da face.
     * @param j Coluna em que se encontra oelemento na matriz da face.
     * @return Color - Valor da cor do elementoda face.
     */
    public Color getColor(int i, int j) {
        if (i >= this.dimension || i < 0 || j >= this.dimension || j < 0) {
            throw new IllegalArgumentException("Coordinates outside face dimension");
        }
        return this.face[i][j];
    }
    
    /**
     * Método get de cores adjacentes.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param i Linha em que se encontra o elemento na matriz da face.
     * @param j Coluna em que se encontra o elemento na matriz da face.
     * @return Color[] - Array contendo cores adjacentes.
     */
    public Color[] getAdjacentColors(int i, int j) {
        if (i >= this.dimension || i < 0 || j >= this.dimension || j < 0) {
            throw new IllegalArgumentException("Coordinates outside face dimension");
        }
        if (i == 1 && j == 1) {
            return new Color[]{};
        }
        Color[] colors = null;
        switch (i) {
            case 0:
                switch (j) {
                    case 0:
                        colors = new Color[2];
                        switch (this.positionAdjacentFaces.get(Position.UP)) {
                            case UP:
                                colors[0] = this.adjacentFaces.get(Position.UP).getColor(0, 2);
                                break;
                            case RI:
                                colors[0] = this.adjacentFaces.get(Position.UP).getColor(2, 2);
                                break;
                            case LE:
                                colors[0] = this.adjacentFaces.get(Position.UP).getColor(0, 0);
                                break;
                            case DW:
                                colors[0] = this.adjacentFaces.get(Position.UP).getColor(2, 0);
                        }
                        switch (this.positionAdjacentFaces.get(Position.LE)) {
                            case UP:
                                colors[1] = this.adjacentFaces.get(Position.LE).getColor(0, 0);
                                break;
                            case RI:
                                colors[1] = this.adjacentFaces.get(Position.LE).getColor(0, 2);
                                break;
                            case LE:
                                colors[1] = this.adjacentFaces.get(Position.LE).getColor(2, 0);
                                break;
                            case DW:
                                colors[1] = this.adjacentFaces.get(Position.LE).getColor(2, 2);
                        }
                        break;
                    case 1:
                        colors = new Color[1];
                        switch (this.positionAdjacentFaces.get(Position.UP)) {
                            case UP:
                                colors[0] = this.adjacentFaces.get(Position.UP).getColor(0, 1);
                                break;
                            case RI:
                                colors[0] = this.adjacentFaces.get(Position.UP).getColor(1, 2);
                                break;
                            case LE:
                                colors[0] = this.adjacentFaces.get(Position.UP).getColor(1, 0);
                                break;
                            case DW:
                                colors[0] = this.adjacentFaces.get(Position.UP).getColor(2, 1);
                        }
                        break;
                    case 2:
                        colors = new Color[2];
                        switch (this.positionAdjacentFaces.get(Position.UP)) {
                            case UP:
                                colors[0] = this.adjacentFaces.get(Position.UP).getColor(0, 0);
                                break;
                            case RI:
                                colors[0] = this.adjacentFaces.get(Position.UP).getColor(0, 2);
                                break;
                            case LE:
                                colors[0] = this.adjacentFaces.get(Position.UP).getColor(2, 0);
                                break;
                            case DW:
                                colors[0] = this.adjacentFaces.get(Position.UP).getColor(2, 2);
                        }
                        switch (this.positionAdjacentFaces.get(Position.RI)) {
                            case UP:
                                colors[1] = this.adjacentFaces.get(Position.RI).getColor(0, 2);
                                break;
                            case RI:
                                colors[1] = this.adjacentFaces.get(Position.RI).getColor(2, 2);
                                break;
                            case LE:
                                colors[1] = this.adjacentFaces.get(Position.RI).getColor(0, 0);
                                break;
                            case DW:
                                colors[1] = this.adjacentFaces.get(Position.RI).getColor(2, 0);
                        }
                }
                break;
            case 1:
                colors = new Color[1];
                switch (j) {
                    case 0:
                        switch (this.positionAdjacentFaces.get(Position.LE)) {
                            case UP:
                                colors[0] = this.adjacentFaces.get(Position.LE).getColor(0, 1);
                                break;
                            case RI:
                                colors[0] = this.adjacentFaces.get(Position.LE).getColor(1, 2);
                                break;
                            case LE:
                                colors[0] = this.adjacentFaces.get(Position.LE).getColor(1, 0);
                                break;
                            case DW:
                                colors[0] = this.adjacentFaces.get(Position.LE).getColor(2, 1);
                        }
                        break;
                    case 2:
                        switch (this.positionAdjacentFaces.get(Position.RI)) {
                            case UP:
                                colors[0] = this.adjacentFaces.get(Position.RI).getColor(0, 1);
                                break;
                            case RI:
                                colors[0] = this.adjacentFaces.get(Position.RI).getColor(1, 2);
                                break;
                            case LE:
                                colors[0] = this.adjacentFaces.get(Position.RI).getColor(1, 0);
                                break;
                            case DW:
                                colors[0] = this.adjacentFaces.get(Position.RI).getColor(2, 1);
                        }

                }
                break;
            case 2:
                colors = new Color[2];
                switch (j) {
                    case 0:
                        colors = new Color[2];
                        switch (this.positionAdjacentFaces.get(Position.DW)) {
                            case UP:
                                colors[0] = this.adjacentFaces.get(Position.DW).getColor(0, 0);
                                break;
                            case RI:
                                colors[0] = this.adjacentFaces.get(Position.DW).getColor(0, 2);
                                break;
                            case LE:
                                colors[0] = this.adjacentFaces.get(Position.DW).getColor(2, 0);
                                break;
                            case DW:
                                colors[0] = this.adjacentFaces.get(Position.DW).getColor(2, 2);
                        }
                        switch (this.positionAdjacentFaces.get(Position.LE)) {
                            case UP:
                                colors[1] = this.adjacentFaces.get(Position.LE).getColor(0, 2);
                                break;
                            case RI:
                                colors[1] = this.adjacentFaces.get(Position.LE).getColor(2, 2);
                                break;
                            case LE:
                                colors[1] = this.adjacentFaces.get(Position.LE).getColor(0, 0);
                                break;
                            case DW:
                                colors[1] = this.adjacentFaces.get(Position.LE).getColor(2, 0);
                        }
                        break;
                    case 1:
                        colors = new Color[1];
                        switch (this.positionAdjacentFaces.get(Position.DW)) {
                            case UP:
                                colors[0] = this.adjacentFaces.get(Position.DW).getColor(0, 1);
                                break;
                            case RI:
                                colors[0] = this.adjacentFaces.get(Position.DW).getColor(1, 2);
                                break;
                            case LE:
                                colors[0] = this.adjacentFaces.get(Position.DW).getColor(1, 0);
                                break;
                            case DW:
                                colors[0] = this.adjacentFaces.get(Position.DW).getColor(2, 1);
                        }
                        break;
                    case 2:
                        colors = new Color[2];
                        switch (this.positionAdjacentFaces.get(Position.DW)) {
                            case UP:
                                colors[0] = this.adjacentFaces.get(Position.DW).getColor(0, 2);
                                break;
                            case RI:
                                colors[0] = this.adjacentFaces.get(Position.DW).getColor(2, 2);
                                break;
                            case LE:
                                colors[0] = this.adjacentFaces.get(Position.DW).getColor(0, 0);
                                break;
                            case DW:
                                colors[0] = this.adjacentFaces.get(Position.DW).getColor(2, 0);
                        }
                        switch (this.positionAdjacentFaces.get(Position.RI)) {
                            case UP:
                                colors[1] = this.adjacentFaces.get(Position.RI).getColor(0, 0);
                                break;
                            case RI:
                                colors[1] = this.adjacentFaces.get(Position.RI).getColor(0, 2);
                                break;
                            case LE:
                                colors[1] = this.adjacentFaces.get(Position.RI).getColor(2, 0);
                                break;
                            case DW:
                                colors[1] = this.adjacentFaces.get(Position.RI).getColor(2, 2);
                        }
                }
        }
        return colors;
    }

    /**
     * Método get de posição de face adjacente por cor.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param color Cor da face adjacente.
     * @return Position - Posição em que a face com a cor passada por parâmetro é adjacente.
     */    
    public Position getPositionFaceColor(Color color) {
        if (color == null) {
            throw new IllegalArgumentException("Color is required");
        }
        if (this.adjacentFaces.get(Position.UP).getColor() == color) {
            return Position.UP;
        }
        if (this.adjacentFaces.get(Position.RI).getColor() == color) {
            return Position.RI;
        }
        if (this.adjacentFaces.get(Position.DW).getColor() == color) {
            return Position.DW;
        }
        if (this.adjacentFaces.get(Position.LE).getColor() == color) {
            return Position.LE;
        }
        return null;
    }
    
    /**
     * Método get de posição de face adjacente por cor.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param color Cor da face adjacente.
     * @return Position - Posição em que a face com a cor passada por parâmetro é adjacente.
     */  
    public Position getPositionAdjacentFaceColor(Color color) {
        if (color == null) {
            throw new IllegalArgumentException("Color is required");
        }
        if (this.adjacentFaces.get(Position.UP).getColor() == color) {
            return this.getPositionAdjacentFaces(Position.UP);
        }
        if (this.adjacentFaces.get(Position.RI).getColor() == color) {
            return this.getPositionAdjacentFaces(Position.RI);
        }
        if (this.adjacentFaces.get(Position.DW).getColor() == color) {
            return this.getPositionAdjacentFaces(Position.DW);
        }
        if (this.adjacentFaces.get(Position.LE).getColor() == color) {
            return this.getPositionAdjacentFaces(Position.LE);
        }
        return null;

    }
    
    /**
     * Método get de posição de face adjacente por posição de componente.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param i Linha em que se encontra o elemento na matriz da face.
     * @param j Coluna em que se encontra o elemento na matriz da face.
     * @return Position[] - Posições em que o componente da face é adjacente.
     */  
    public Position[] getAdjacentFace(int i, int j) {
        if (i >= this.dimension || i < 0 || j >= this.dimension || j < 0) {
            throw new IllegalArgumentException("Coordinates outside face dimension");
        }
        if ((i == 0 && j == 1)) {
            return new Position[]{Position.UP};
        }
        if ((i == 1 && j == 0)) {
            return new Position[]{Position.LE};
        }
        if ((i == 1 && j == 2)) {
            return new Position[]{Position.RI};
        }
        if ((i == 2 && j == 1)) {
            return new Position[]{Position.DW};
        }
        if ((i == 0 && j == 0)) {
            return new Position[]{Position.UP, Position.LE};
        }
        if ((i == 0 && j == 2)) {
            return new Position[]{Position.UP, Position.RI};
        }
        if ((i == 2 && j == 0)) {
            return new Position[]{Position.DW, Position.LE};
        }
        if ((i == 2 && j == 2)) {
            return new Position[]{Position.DW, Position.RI};
        }
        return null;
    }
  
    /**
     * Método get de posição equivalente por posição de componente.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param i Linha em que se encontra o elemento na matriz da face.
     * @param j Coluna em que se encontra o elemento na matriz da face.
     * @return int[] - Posições de posição equivalente.
     */  
    public int[] getEquivalentPosition(int i, int j) {
        if (i >= this.dimension || i < 0 || j >= this.dimension || j < 0) {
            throw new IllegalArgumentException("Coordinates outside face dimension");
        }
        if (this.getAdjacentFace(Position.UP) == this.getAdjacentFace(Position.OP).getAdjacentFace(Position.UP)) {
            if (j == 0) {
                return new int[]{i, 2};
            } else {
                return new int[]{i, 0};
            }
        } else if (this.getAdjacentFace(Position.UP) == this.getAdjacentFace(Position.OP).getAdjacentFace(Position.RI)) {
            return new int[]{2 - j, 2 - i};
        } else if (this.getAdjacentFace(Position.UP) == this.getAdjacentFace(Position.OP).getAdjacentFace(Position.DW)) {
            if (i == 0) {
                return new int[]{2, j};
            } else {
                return new int[]{0, j};
            }
        } else if (this.getAdjacentFace(Position.UP) == this.getAdjacentFace(Position.OP).getAdjacentFace(Position.LE)) {
            return new int[]{j, i};
        }
        return null;
    }
    
    /**
     * Método realiza a rotação da face, atualizando os dados de referência entre as faces.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param right Determina se o movimento é para a direita.
     * @param solution Coluna em que se encontra o elemento na matriz da face.
     */  
    public void rotate(boolean right, ArrayList<String> solution) {

        if (solution != null) {
            solution.add(right ? this.getColor() + "" : this.getColor() + "i");
        } else {
          //  System.out.println(right ? this.getColor() + " " : this.getColor() + "i ");
        }

        Color[] superiorSeq = this.getSegment(Position.UP);
        Color[] inferiorSeq = this.getSegment(Position.DW);
        Color[] leftSeq = this.getSegment(Position.LE);
        Color[] rightSeq = this.getSegment(Position.RI);

        Color[] superiorSeqFace = this.adjacentFaces.get(Position.UP).getSegment(positionAdjacentFaces.get(Position.UP));
        Color[] inferiorSeqFace = this.adjacentFaces.get(Position.DW).getSegment(positionAdjacentFaces.get(Position.DW));
        Color[] leftSeqFace = this.adjacentFaces.get(Position.LE).getSegment(positionAdjacentFaces.get(Position.LE));
        Color[] rightSeqFace = this.adjacentFaces.get(Position.RI).getSegment(positionAdjacentFaces.get(Position.RI));

        if (right) {
            this.setSegment(Position.RI, superiorSeq, false);
            this.setSegment(Position.DW, rightSeq, true);
            this.setSegment(Position.LE, inferiorSeq, false);
            this.setSegment(Position.UP, leftSeq, true);

            this.adjacentFaces.get(Position.RI).setSegment(this.positionAdjacentFaces.get(Position.RI), superiorSeqFace, this.getInversion(this.positionAdjacentFaces.get(Position.UP), this.positionAdjacentFaces.get(Position.RI)));
            this.adjacentFaces.get(Position.DW).setSegment(this.positionAdjacentFaces.get(Position.DW), rightSeqFace, this.getInversion(this.positionAdjacentFaces.get(Position.RI), this.positionAdjacentFaces.get(Position.DW)));
            this.adjacentFaces.get(Position.LE).setSegment(this.positionAdjacentFaces.get(Position.LE), inferiorSeqFace, this.getInversion(this.positionAdjacentFaces.get(Position.DW), this.positionAdjacentFaces.get(Position.LE)));
            this.adjacentFaces.get(Position.UP).setSegment(this.positionAdjacentFaces.get(Position.UP), leftSeqFace, this.getInversion(this.positionAdjacentFaces.get(Position.LE), this.positionAdjacentFaces.get(Position.UP)));
        } else {
            this.setSegment(Position.LE, superiorSeq, true);
            this.setSegment(Position.DW, leftSeq, false);
            this.setSegment(Position.RI, inferiorSeq, true);
            this.setSegment(Position.UP, rightSeq, false);

            this.adjacentFaces.get(Position.LE).setSegment(this.positionAdjacentFaces.get(Position.LE), superiorSeqFace, this.getInversion(this.positionAdjacentFaces.get(Position.UP), this.positionAdjacentFaces.get(Position.LE)));
            this.adjacentFaces.get(Position.DW).setSegment(this.positionAdjacentFaces.get(Position.DW), leftSeqFace, this.getInversion(this.positionAdjacentFaces.get(Position.LE), this.positionAdjacentFaces.get(Position.DW)));
            this.adjacentFaces.get(Position.RI).setSegment(this.positionAdjacentFaces.get(Position.RI), inferiorSeqFace, this.getInversion(this.positionAdjacentFaces.get(Position.DW), this.positionAdjacentFaces.get(Position.RI)));
            this.adjacentFaces.get(Position.UP).setSegment(this.positionAdjacentFaces.get(Position.UP), rightSeqFace, this.getInversion(this.positionAdjacentFaces.get(Position.RI), this.positionAdjacentFaces.get(Position.UP)));
        }
    }

    /**
     * Método get de segmento de componentes por posição.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param position Posição do segmento.
     * @return Color[] Segmento de componente gerado.
     */ 
    private Color[] getSegment(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Position is required");
        }
        switch (position) {
            case UP:
                return this.face[0].clone();
            case DW:
                return this.face[2].clone();
            case LE:
                return new Color[]{this.face[0][0], this.face[1][0], this.face[2][0]};
            case RI:
                return new Color[]{this.face[0][2], this.face[1][2], this.face[2][2]};
        }

        return null;
    }
    
    /**
     * Método set de segmento de componentes por posição.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param position Posição em que ocorrerá o set.
     * @param colors Segmento de componente gerado.
     * @param invert Determina o set é realizado em posição inversa.
     */ 
    private void setSegment(Position position, Color[] colors, boolean invert) {
        if (position == null) {
            throw new IllegalArgumentException("Position is required");
        }
        if (colors == null) {
            throw new IllegalArgumentException("Colors segment is required");
        }
        if (colors.length != this.dimension) {
            throw new IllegalArgumentException("Colors segment dimension is incorrect");
        }
        if (invert) {
            Color temp = colors[0];
            colors[0] = colors[2];
            colors[2] = temp;
        }
        switch (position) {
            case UP:
                for (int i = 0; i < this.face.length; i++) {
                    this.face[0][i] = colors[i];
                }
                break;
            case DW:
                for (int i = 0; i < this.face.length; i++) {
                    this.face[2][i] = colors[i];
                }
                break;
            case LE:
                for (int i = 0; i < this.face.length; i++) {
                    this.face[i][0] = colors[i];
                }
                break;
            case RI:
                for (int i = 0; i < this.face.length; i++) {
                    this.face[i][2] = colors[i];
                }
        }

    }

    /**
     * Método vetificador de posição invertida.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param iPosition Posição inicial.
     * @param fPosition Posição final.
     * @return boolean - Valor de inversão
     */ 
    private boolean getInversion(Position iPosition, Position fPosition) {
        if (iPosition == null || fPosition == null) {
            throw new IllegalArgumentException("Initial Position and Final Position are required");
        }
        return !(iPosition == fPosition
                || (iPosition == Position.UP && fPosition == Position.RI)
                || (iPosition == Position.RI && fPosition == Position.UP)
                || (iPosition == Position.DW && fPosition == Position.LE)
                || (iPosition == Position.LE && fPosition == Position.DW));
    }
    
    /**
     * Método vetificador de existência de cor na face.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param i Linha em que se encontra o elemento na matriz da face.
     * @param j Coluna em que se encontra o elemento na matriz da face.
     * @param color Cor que é buscada.
     * @return boolean - Valor de existencia de cor
     */ 
    public boolean existsColor(int i, int j, Color color) {
        if (i >= this.dimension || i < 0 || j >= this.dimension || j < 0) {
            throw new IllegalArgumentException("Coordinates outside face dimension");
        }
        if (color == null) {
            throw new IllegalArgumentException("Color is required");
        }
        if (this.face[i][j] == color) {
            return true;
        }
        Color[] adjacentColors = this.getAdjacentColors(i, j);
        for (int k = 0; k < adjacentColors.length; k++) {
            if (adjacentColors[k] == color) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Método vetificador de posição correta de componente da face
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param i Linha em que se encontra o elemento na matriz da face.
     * @param j Coluna em que se encontra o elemento na matriz da face.
     * @return boolean - Valor posição correta.
     */ 
    public boolean inCorrectPosition(int i, int j) {
        if (i >= this.dimension || i < 0 || j >= this.dimension || j < 0) {
            throw new IllegalArgumentException("Coordinates outside face dimension");
        }
        if (this.face[i][j] != this.getColor()) {
            return false;
        }
        Color[] adjacentColors = this.getAdjacentColors(i, j);
        Position[] facesAdj = this.getAdjacentFace(i, j);
        for (int k = 0; k < adjacentColors.length; k++) {
            if (adjacentColors[k] != this.getAdjacentFace(facesAdj[k]).getColor()) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Método vetificador de posição oposta correta de componente da face
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param i Linha em que se encontra o elemento na matriz da face.
     * @param j Coluna em que se encontra o elemento na matriz da face.
     * @param color Cor que é buscada.
     * @return boolean - Valor posição correta.
     */ 
    public boolean isInCorrectOpositePosition(int i, int j, Color color) {
        if (i >= this.dimension || i < 0 || j >= this.dimension || j < 0) {
            throw new IllegalArgumentException("Coordinates outside face dimension");
        }
        if (color == null) {
            throw new IllegalArgumentException("Color is required");
        }
        Color[] coresAdj = this.getAdjacentColors(i, j);
        Position[] facesAdj = this.getAdjacentFace(i, j);

        Color[] colorInCube = new Color[coresAdj.length + 1];
        Color[] correctColors = new Color[facesAdj.length + 1];

        for (int k = 0; k < coresAdj.length; k++) {
            colorInCube[k] = coresAdj[k];
            correctColors[k] = this.getAdjacentFace(facesAdj[k]).getColor();
        }
        colorInCube[colorInCube.length - 1] = this.getColor(i, j);
        correctColors[correctColors.length - 1] = color;

        boolean foundColor = false;

        for (int k = 0; k < colorInCube.length; k++) {
            foundColor = false;
            for (int l = 0; l < correctColors.length && !foundColor; l++) {
                if (colorInCube[k] == correctColors[l]) {
                    foundColor = true;
                }
            }
            if (!foundColor) {
                return foundColor;
            }
        }

        return true;
    }
    
    /**
     * Método vetificador de cruz completa
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return boolean - Valor de cruz completa.
     */ 
    public boolean isCompleteCross() {
        return (this.face[0][1] == this.getColor() && this.getAdjacentColors(0, 1)[0] == this.adjacentFaces.get(Position.UP).getColor()
                && this.face[1][0] == this.getColor() && this.getAdjacentColors(1, 0)[0] == this.adjacentFaces.get(Position.LE).getColor()
                && this.face[1][2] == this.getColor() && this.getAdjacentColors(1, 2)[0] == this.adjacentFaces.get(Position.RI).getColor()
                && this.face[2][1] == this.getColor() && this.getAdjacentColors(2, 1)[0] == this.adjacentFaces.get(Position.DW).getColor());

    }
    
    /**
     * Método vetificador de cruz completa
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return boolean - Valor de cruz completa.
     */ 
    public boolean isCompleteFaceCross() {
        return (this.face[0][1] == this.getColor()
                && this.face[1][0] == this.getColor()
                && this.face[1][2] == this.getColor()
                && this.face[2][1] == this.getColor());

    }

    /**
     * Método vetificador de face completa
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return boolean - Valor de face completa.
     */ 
    public boolean isFaceComplete() {
        for (int i = 0; i < face.length; i++) {
            for (int j = 0; j < face[i].length; j++) {
                if (face[i][j] != this.getColor()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Método vetificador de primeira camada completa
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return boolean - Valor de primeira camada completa.
     */ 
    public boolean isCompleteFirstLayer() {
        for (int i = 0; i < face.length; i++) {
            for (int j = 0; j < face[i].length; j++) {
                if (!this.inCorrectPosition(i, j)) {
                    return false;
                }
            }

        }
        return true;
    }
    
    /**
     * Método vetificador de segunda camada completa
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return boolean - Valor de segunda camada completa.
     */
    public boolean isCompleteSecondLayer() {
        return this.isCompleteFirstLayer() && this.isCompleteSecondLayerAdjacentFace(Position.UP)
                && this.isCompleteSecondLayerAdjacentFace(Position.RI)
                && this.isCompleteSecondLayerAdjacentFace(Position.DW)
                && this.isCompleteSecondLayerAdjacentFace(Position.LE);

    }
    
    /**
     * Método vetificador de segunda camada adjacente completa
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param position Posição de adjacência.
     * @return boolean - Valor de segunda camada adjacente completa.
     */
    private boolean isCompleteSecondLayerAdjacentFace(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Position is required");
        }
        return this.getAdjacentFace(position).isSecondLayerFace(this.getPositionAdjacentFaces(position));
    }
    
    /**
     * Método vetificador de segunda camada completa
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param position Posição de adjacência.
     * @return boolean - Valor de segunda camada completa.
     */
    private boolean isSecondLayerFace(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Position is required");
        }
        switch (position) {
            case UP:
            case DW:
                if (!(this.inCorrectPosition(1, 0) && this.inCorrectPosition(1, 2))) {
                    return false;
                }
                break;
            case RI:
            case LE:
                if (!(this.inCorrectPosition(0, 1) && this.inCorrectPosition(2, 1))) {
                    return false;
                }
        }
        return true;
    }

}
