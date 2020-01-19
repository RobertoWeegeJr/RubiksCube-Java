//Roberto, Thiago - Trabalho 04 - 2017.1
package GraphicCube;

/**
 * Classe que representa um ponto de 4 dimensões.
 * Nesta classe estão armazenados os valores de X, Y, Z e W dos verticis que 
 * compõem os objtos gráficos.
 * 
 * @author GCG
 * @since Versão inicial
 */
public final class Ponto4D {
    private double x; /// valor X.
    private double y; /// valor Y.
    private double z; /// valor Z.
    private double w; /// valor W.

    /**
     * Método construtor.
     * Seta os valores default para todos os atributos.
     *
     * @author GCG
     * @since Versão inicial
     */
    public Ponto4D() {
        this(0, 0, 0, 1);
    }

    /**
     * Método construtor.
     * Seta os valores para todos os atributos.
     *
     * @author GCG
     * @since Versão inicial
     * @param x Valor para x.
     * @param y Valor para y.
     * @param z Valor para z.
     * @param w Valor para w.
     */
    public Ponto4D(double x, double y, double z, double w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    /**
     * Método get do atributo x.
     *
     * @author GCG
     * @since Versão inicial
     * @return double - Valor de x.
     */
    public double obterX() {
        return x;
    }

    /**
     * Método get do atributo y.
     *
     * @author GCG
     * @since Versão inicial
     * @return double - Valor de y.
     */
    public double obterY() {
        return y;
    }

    /**
     * Método get do atributo z.
     *
     * @author GCG
     * @since Versão inicial
     * @return double - Valor de z.
     */
    public double obterZ() {
        return z;
    }

    /**
     * Método get do atributo w.
     *
     * @author GCG
     * @since Versão inicial
     * @return double - Valor de w.
     */
    public double obterW() {
        return w;
    }
    
    /**
     * Método set do atributo x.
     *
     * @author GCG
     * @since Versão inicial
     * @param x Valor de x.
     */
    public void atribuirX(double x) {
        this.x = x;
    }

    /**
     * Método set do atributo y.
     *
     * @author GCG
     * @since Versão inicial
     * @param y Valor de y.
     */
    public void atribuirY(double y) {
        this.y = y;
    }

    /**
     * Método set do atributo z.
     *
     * @author GCG
     * @since Versão inicial
     * @param z Valor de z.
     */
    public void atribuirZ(double z) {
        this.z = z;
    }
    
    /**
     * Método para inverter sinal de ponto.
     *
     * @author GCG
     * @since Versão inicial
     * @param pto Ponto que será invertido.
     * @return Ponto4D - Ponto invertido. 
     */
    public Ponto4D inverterSinal(Ponto4D pto) {
        pto.atribuirX(pto.obterX()*-1);
        pto.atribuirY(pto.obterY()*-1);
        pto.atribuirZ(pto.obterZ()*-1);
        return pto;
    }
}
