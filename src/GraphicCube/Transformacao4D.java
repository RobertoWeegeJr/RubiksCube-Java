//Roberto, Thiago - Trabalho 04 - 2017.1
package GraphicCube;

/**
 * Classe responsável por realizar e guardar as tranformações aplicadas à
 * objetos gráficos. Nesta classe está armazenada a matriz de transformação do
 * objeto gráfico.
 *
 * @author GCG
 * @since Versão inicial
 */
public final class Transformacao4D {

    private static Transformacao4D matrizTmpTranslacao = new Transformacao4D();
    private static Transformacao4D matrizTmpTranslacaoInversa = new Transformacao4D();
    private static Transformacao4D matrizTmpEscala = new Transformacao4D();
    private static Transformacao4D matrizGlobal = new Transformacao4D();

    public static final double DEG_TO_RAD = 0.017453292519943295769236907684886;

    /// \brief Cria uma matriz de Trasnformacao com uma matriz Identidade.
    private double[] matriz = {
        1, 0, 0, 0,
        0, 1, 0, 0,
        0, 0, 1, 0,
        0, 0, 0, 1};

    /**
     * Atribui os valores de uma matriz Identidade a matriz de Transformacao.
     *
     * @author GCG
     * @since Versão inicial
     */
    public void atribuirIdentidade() {
        for (int i = 0; i < 16; ++i) {
            matriz[i] = 0.0;
        }
        matriz[0] = matriz[5] = matriz[10] = matriz[15] = 1.0;
    }

    /**
     * Atribui os valores de Translacao (tx,ty,tz) a matriz de Transformacao.
     * Elemento Neutro eh 0 (zero).
     *
     * @author GCG
     * @since Versão inicial
     * @param tx Valor de translação de x
     * @param ty Valor de translação de y
     * @param tz Valor de translação de z
     */
    public void atribuirTranslacao(double tx, double ty, double tz) {
        atribuirIdentidade();
        matriz[12] = tx;
        matriz[13] = ty;
        matriz[14] = tz;
    }

    /**
     * Atribui o valor de Escala (Ex,Ey,Ez) a matriz de Transformacao. Elemento
     * Neutro eh 1 (um). Se manter os valores iguais de Ex,Ey e Ez o objeto vai
     * ser reduzido ou ampliado proporcionalmente.
     *
     * @author GCG
     * @since Versão inicial
     * @param sX Valor de escala de x
     * @param sY Valor de escala de y
     * @param sZ Valor de escala de z
     */
    public void atribuirEscala(double sX, double sY, double sZ) {
        atribuirIdentidade();
        matriz[0] = sX;
        matriz[5] = sY;
        matriz[10] = sZ;
    }

    /**
     * Atribui o valor de Rotacao (angulo) no eixo X a matriz de Transformacao.
     * Elemento Neutro eh 0 (zero).
     *
     * @author GCG
     * @since Versão inicial
     * @param radians Valor de rotação
     */
    public void atribuirRotacaoX(double radians) {
        atribuirIdentidade();
        matriz[5] = Math.cos(radians);
        matriz[9] = -Math.sin(radians);
        matriz[6] = Math.sin(radians);
        matriz[10] = Math.cos(radians);
    }

    /**
     * Atribui o valor de Rotacao (angulo) no eixo Y a matriz de Transformacao.
     * Elemento Neutro eh 0 (zero).
     *
     * @author GCG
     * @since Versão inicial
     * @param radians Valor de rotação
     */
    public void atribuirRotacaoY(double radians) {
        atribuirIdentidade();
        matriz[0] = Math.cos(radians);
        matriz[8] = Math.sin(radians);
        matriz[2] = -Math.sin(radians);
        matriz[10] = Math.cos(radians);
    }

    /**
     * Atribui o valor de Rotacao (angulo) no eixo Z a matriz de Transformacao.
     * Elemento Neutro eh 0 (zero).
     *
     * @author GCG
     * @since Versão inicial
     * @param radians Valor de rotação
     */
    public void atribuirRotacaoZ(double radians) {
        atribuirIdentidade();
        matriz[0] = Math.cos(radians);
        matriz[4] = -Math.sin(radians);
        matriz[1] = Math.sin(radians);
        matriz[5] = Math.cos(radians);
    }

    /**
     * Método que multiplica um ponto pela matriz de transformação.
     *
     * @author GCG
     * @since Versão inicial
     * @param point Ponto para ser transformado.
     * @return Ponto4D - Ponto transformado.
     */
    public Ponto4D transformPoint(Ponto4D point) {
        Ponto4D pointResult = new Ponto4D(
                matriz[0] * point.obterX() + matriz[4] * point.obterY() + matriz[8] * point.obterZ() + matriz[12] * point.obterW(),
                matriz[1] * point.obterX() + matriz[5] * point.obterY() + matriz[9] * point.obterZ() + matriz[13] * point.obterW(),
                matriz[2] * point.obterX() + matriz[6] * point.obterY() + matriz[10] * point.obterZ() + matriz[14] * point.obterW(),
                matriz[3] * point.obterX() + matriz[7] * point.obterY() + matriz[11] * point.obterZ() + matriz[15] * point.obterW());
        return pointResult;
    }

    /**
     * Método que multiplica a matriz de transformação de um objeto de
     * transformação pela matriz de transformação de outro objeto de
     * transformação.
     *
     * @author GCG
     * @since Versão inicial
     * @param t Objeto de transformação para ser transformado.
     * @return Transformacao4D - Objeto de transformação transformado.
     */
    public Transformacao4D transformMatrix(Transformacao4D t) {
        Transformacao4D result = new Transformacao4D();
        for (int i = 0; i < 16; ++i) {
            result.matriz[i]
                    = matriz[i % 4] * t.matriz[i / 4 * 4] + matriz[(i % 4) + 4] * t.matriz[i / 4 * 4 + 1]
                    + matriz[(i % 4) + 8] * t.matriz[i / 4 * 4 + 2] + matriz[(i % 4) + 12] * t.matriz[i / 4 * 4 + 3];
        }
        return result;
    }

    /**
     * Método get dos valores do atributo matriz.
     *
     * @author GCG
     * @since Versão inicial
     * @param index Indice do valor que deve ser retornado.
     * @return double - Valor de r.
     */
    public double GetElement(int index) {
        return matriz[index];
    }

    /**
     * Método set dos valores do atributo matriz.
     *
     * @author GCG
     * @since Versão inicial
     * @param index Indice do valor que deve ser atribuido.
     * @param value Valor que deve ser atribuido.
     */
    public void SetElement(int index, double value) {
        matriz[index] = value;
    }

    /**
     * Método get do atributo matriz.
     *
     * @author GCG
     * @since Versão inicial
     * @return double[] - Matriz de transformação.
     */
    public double[] GetDate() {
        return matriz;
    }

    /**
     * Método set do atributo matriz.
     *
     * @author GCG
     * @since Versão inicial
     * @param data Matriz de transformação.
     */
    public void SetData(double[] data) {
        int i;
        for (i = 0; i < 16; i++) {
            matriz[i] = (data[i]);
        }
    }

    /**
     * Método que imprime os dados da matriz de transformação.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     */
    public void exibeMatriz() {
        System.out.println("______________________");
        System.out.println("|" + GetElement(0) + " | " + GetElement(4) + " | " + GetElement(8) + " | " + GetElement(12));
        System.out.println("|" + GetElement(1) + " | " + GetElement(5) + " | " + GetElement(9) + " | " + GetElement(13));
        System.out.println("|" + GetElement(2) + " | " + GetElement(6) + " | " + GetElement(10) + " | " + GetElement(14));
        System.out.println("|" + GetElement(3) + " | " + GetElement(7) + " | " + GetElement(11) + " | " + GetElement(15));
    }

    /**
     * Método que retorna a matriz inversa da matriz de transformação.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return double[] - Matriz de transformação invertida.
     */
    /*public Transformacao4D getRevercao() {
        Transformacao4D retorno = new Transformacao4D();
        Matrix m = new Matrix(this.getMatrix());
        retorno.setMatrix(m.inverse().getArray());
        return retorno;
    }*/

    /**
     * Método get do atributo matriz em forma 4x4.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return double[][] - Matriz de transformação.
     */
    public double[][] getMatrix() {
        double[][] matrix = new double[4][4];
        for (int i = 0; i < 16; i++) {
            matrix[i / 4][i % 4] = this.matriz[i];
        }
        return matrix;
    }

    /**
     * Método set do atributo matriz em forma 4x4.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param matrix Matriz de transformação.
     */
    public void setMatrix(double[][] matrix) {
        for (int i = 0; i < 16; i++) {
            this.matriz[i] = matrix[i / 4][i % 4];
        }
    }

    /**
     * Método que retorna a matriz inversa da matriz de transformação
     * considerando somente os valores responsaveis pela rotação em Z.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return Transformacao4D - Matriz de transformação invertida.
     */
    /*public Transformacao4D getRevercaoRotacaoZ() {
        Transformacao4D retorno = new Transformacao4D();
        Matrix m = new Matrix(this.getMatrix());
        retorno.setMatrix(m.inverse().getArray());
        for (int i = 0; i < retorno.matriz.length; i++) {
            if (i == 10 || i == 15) {
                retorno.matriz[i] = 1;
            } else if (i != 0 && i != 1 && i != 4 & i != 5) {
                retorno.matriz[i] = 0;
            }
        }
        return retorno;
    }*/

    /**
     * Método que aplica a transação de um ponto na matriz de transformação.
     *
     * @author GCG
     * @since Versão inicial
     * @param p4d Valores de translação.
     */
    public void aplicaTranslacaoXYZ(Ponto4D p4d) {
        Transformacao4D matrizTranslate = new Transformacao4D();
        matrizTranslate.atribuirTranslacao(p4d.obterX(), p4d.obterY(), p4d.obterZ());
        this.matriz = matrizTranslate.transformMatrix(this).matriz;
    }

    /**
     * Método que aplica a escala em um ponto fixo na matriz de transformação.
     *
     * @author GCG
     * @since Versão inicial
     * @param escala Valores de escala.
     * @param ptoFixo Ponto fixo.
     */
    public void aplicaEscalaXYZ(double escala, Ponto4D ptoFixo) {
        this.matrizGlobal.atribuirIdentidade();
        ptoFixo.inverterSinal(ptoFixo);
        this.matrizTmpTranslacao.atribuirTranslacao(ptoFixo.obterX(), ptoFixo.obterY(), ptoFixo.obterZ());
        this.matrizGlobal = this.matrizTmpTranslacao.transformMatrix(this.matrizGlobal);

        this.matrizTmpEscala.atribuirEscala(escala, escala, 1.0);
        this.matrizGlobal = this.matrizTmpEscala.transformMatrix(this.matrizGlobal);

        ptoFixo.inverterSinal(ptoFixo);
        this.matrizTmpTranslacaoInversa.atribuirTranslacao(ptoFixo.obterX(), ptoFixo.obterY(), ptoFixo.obterZ());
        this.matrizGlobal = this.matrizTmpTranslacaoInversa.transformMatrix(this.matrizGlobal);

        this.matriz = this.transformMatrix(this.matrizGlobal).matriz;
    }

    /**
     * Método que aplica a rotação em Z em um ponto fixo na matriz de
     * transformação.
     *
     * @author GCG
     * @since Versão inicial
     * @param angulo Valores de rotação.
     * @param ptoFixo Ponto fixo.
     */
    public void aplicaRotacaoZ(double angulo, Ponto4D ptoFixo) {
        this.matrizGlobal.atribuirIdentidade();
        ptoFixo.inverterSinal(ptoFixo);
        this.matrizTmpTranslacao.atribuirTranslacao(ptoFixo.obterX(), ptoFixo.obterY(), ptoFixo.obterZ());
        this.matrizGlobal = this.matrizTmpTranslacao.transformMatrix(this.matrizGlobal);

        this.matrizTmpEscala.atribuirRotacaoZ(Transformacao4D.DEG_TO_RAD * angulo);
        this.matrizGlobal = this.matrizTmpEscala.transformMatrix(this.matrizGlobal);

        ptoFixo.inverterSinal(ptoFixo);
        this.matrizTmpTranslacaoInversa.atribuirTranslacao(ptoFixo.obterX(), ptoFixo.obterY(), ptoFixo.obterZ());
        this.matrizGlobal = this.matrizTmpTranslacaoInversa.transformMatrix(this.matrizGlobal);

        this.matriz = this.transformMatrix(this.matrizGlobal).matriz;
    }
    
    /**
     * Método que aplica a rotação em Z em no ponto fixo (0,0,0) na matriz de
     * transformação.
     *
     * @author GCG
     * @since Versão inicial
     * @param angulo Valores de rotação.
     */
   /* public void aplicaRotacaoZ(double angulo) {
        Ponto4D ptoFixo = new Ponto4D(0, 0, 0, 1);
        this.matrizGlobal.atribuirIdentidade();
        ptoFixo.inverterSinal(ptoFixo);
        this.matrizTmpTranslacao.atribuirTranslacao(ptoFixo.obterX(), ptoFixo.obterY(), ptoFixo.obterZ());
        this.matrizGlobal = this.matrizTmpTranslacao.transformMatrix(this.matrizGlobal);

        this.matrizTmpEscala.atribuirRotacaoZ(Transformacao4D.DEG_TO_RAD * angulo);
        this.matrizGlobal = this.matrizTmpEscala.transformMatrix(this.matrizGlobal);

        ptoFixo.inverterSinal(ptoFixo);
        this.matrizTmpTranslacaoInversa.atribuirTranslacao(ptoFixo.obterX(), ptoFixo.obterY(), ptoFixo.obterZ());
        this.matrizGlobal = this.matrizTmpTranslacaoInversa.transformMatrix(this.matrizGlobal);

        this.matriz = this.transformMatrix(this.matrizGlobal).matriz;
    }*/

    /**
     * Método que aplica a rotação em X em no ponto fixo (0,0,0) na matriz de
     * transformação.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param axis Eixo em que será executada a rotação.
     * @param radians Valores de rotação.
     */    
    public void aplicaRotacao(Axis axis, double radians) {
        switch (axis) {
            case X:
                this.matrizTmpEscala.atribuirRotacaoX(radians);
                break;
            case Y:
                this.matrizTmpEscala.atribuirRotacaoY(radians);
                break;
            case Z:
                this.matrizTmpEscala.atribuirRotacaoZ(radians);
                break;
        }
        this.matriz = this.transformMatrix(this.matrizTmpEscala).matriz;
    }
    
    /**
     * Método que aplica a rotação em X em no ponto fixo (0,0,0) na matriz de
     * transformação.
     *
     * @author GCG
     * @since Versão inicial
     * @param angulo Valores de rotação.
     */
    /*public void aplicaRotacaoX(double angulo) {
        Ponto4D ptoFixo = new Ponto4D(0, 0, 0, 1);
        this.matrizGlobal.atribuirIdentidade();
        ptoFixo.inverterSinal(ptoFixo);
        this.matrizTmpTranslacao.atribuirTranslacao(ptoFixo.obterX(), ptoFixo.obterY(), ptoFixo.obterZ());
        this.matrizGlobal = this.matrizTmpTranslacao.transformMatrix(this.matrizGlobal);

        this.matrizTmpEscala.atribuirRotacaoX(Transformacao4D.DEG_TO_RAD * angulo);
        this.matrizGlobal = this.matrizTmpEscala.transformMatrix(this.matrizGlobal);

        ptoFixo.inverterSinal(ptoFixo);
        this.matrizTmpTranslacaoInversa.atribuirTranslacao(ptoFixo.obterX(), ptoFixo.obterY(), ptoFixo.obterZ());
        this.matrizGlobal = this.matrizTmpTranslacaoInversa.transformMatrix(this.matrizGlobal);

        this.matriz = this.transformMatrix(this.matrizGlobal).matriz;
    }*/
    
    /**
     * Método que aplica a rotação em Y em no ponto fixo (0,0,0) na matriz de
     * transformação.
     *
     * @author GCG
     * @since Versão inicial
     * @param angulo Valores de rotação.
     */
    /*public void aplicaRotacaoY(double angulo) {
        Ponto4D ptoFixo = new Ponto4D(0, 0, 0, 1);
        this.matrizGlobal.atribuirIdentidade();
        ptoFixo.inverterSinal(ptoFixo);
        this.matrizTmpTranslacao.atribuirTranslacao(ptoFixo.obterX(), ptoFixo.obterY(), ptoFixo.obterZ());
        this.matrizGlobal = this.matrizTmpTranslacao.transformMatrix(this.matrizGlobal);

        this.matrizTmpEscala.atribuirRotacaoY(Transformacao4D.DEG_TO_RAD * angulo);
        this.matrizGlobal = this.matrizTmpEscala.transformMatrix(this.matrizGlobal);

        ptoFixo.inverterSinal(ptoFixo);
        this.matrizTmpTranslacaoInversa.atribuirTranslacao(ptoFixo.obterX(), ptoFixo.obterY(), ptoFixo.obterZ());
        this.matrizGlobal = this.matrizTmpTranslacaoInversa.transformMatrix(this.matrizGlobal);

        this.matriz = this.transformMatrix(this.matrizGlobal).matriz;
    }*/
   
}
