//Roberto, Thiago - Trabalho 04 - 2017.1
package GraphicCube;

/**
 * Classe responsável por geranciar os dados de cor de objatos gráficos ou 
 * outros componentes.
 * Nesta classe estão armazenados os valores de R, G e B.
 * 
 * @author Roberto Weege Jr
 * @since Versão inicial
 */
public class Color {
    private float r;
    private float g;
    private float b;
       
    /**
     * Método construtor.
     * Seta os valores default para todos os atributos.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     */
    public Color() {
        this.setR(0);
        this.setG(0);
        this.setB(0);
    }
   
    /**
     * Método construtor.
     * Seta os valores para todos os atributos.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param r Valor para r.
     * @param g Valor para g.
     * @param b Valor para b.
     */
    public Color(float r, float g, float b) {
        this.setR(r);
        this.setG(g);
        this.setB(b);
    }

    /**
     * Método get do atributo r.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return float - Valor de r.
     */
    public float getR() {
        return r;
    }
    
    /**
     * Método set do atributo r.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param r Valor de r.
     */
    public void setR(float r) {
        this.r = r;
    }
    
    /**
     * Método get do atributo g.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return float - Valor de g.
     */
    public float getG() {
        return g;
    }
    
    /**
     * Método set do atributo g.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param g Valor de g.
     */
    public void setG(float g) {
        this.g = g;
    }

    /**
     * Método get do atributo b.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return float - Valor de b.
     */
    public float getB() {
        return b;
    }
    
    /**
     * Método set do atributo b.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param b Valor de b.
     */
    public void setB(float b) {
        this.b = b;
    }
    
    /**
     * Método set dos atributo r, g e b.
     * Este método seta os valores de r, g e b conforme o Enum passado por parâmetro.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param color Enum que representa uma cor.
     */
    public void setColor(GraficColor color){
        switch (color){
            case BL:
                this.setR(0);
                this.setG(0);
                this.setB(1);
                break;
            case GR:
                this.setR(0);
                this.setG(1);
                this.setB(0);
                break;
            case OR:
                this.setR(1);
                this.setG(0.5f);
                this.setB(0);
                break;
            case RE:
                this.setR(1);
                this.setG(0);
                this.setB(0);
                break;
            case WH:
                this.setR(1f);
                this.setG(1f);
                this.setB(1f);
                break;
            case YE:
                this.setR(1);
                this.setG(1);
                this.setB(0);
                break;
        }
    }
    
    /**
     * Método set dos atributo r, g e b.
     * Este método retorna os valores de r, g e b em forma de array.
     * Também se retorna o valor de a, sempre como 1.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return float[] - Array contendo os valores de r, g, b e a (sempre 1) nas posições respectivas.
     * 
     */
    public float[] getArray4f() {
        float[] color4f = {this.getR(),this.getG(), this.getB(), 1f };
        return color4f;
    }
       
    
}
