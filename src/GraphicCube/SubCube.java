//Roberto, Thiago - Trabalho 04 - 2017.1
package GraphicCube;

import com.sun.opengl.util.GLUT;
import java.util.HashMap;
import javax.media.opengl.GL;

/**
 * Classe que representa um sub cubo, que compõe o cubo.
 * 
 * @author Roberto Weege Jr
 * @since Versão inicial
 */
public class SubCube {
        
    private HashMap /*<Orientation, SubFace>*/ faces;
    private Transformacao4D transformacao4D;
    //private float cubeColor[] = new float[4];
    private Color color;
    private float cubeSize;
    private float[] specularity;
    private int materialType;
    
    /**
     * Método construtor.
     * Seta os valores default para os atributos.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     */   
    public SubCube() {
        this.setCubeSize(1);
        this.setFaces(new HashMap<Orientation, SubFace>());
        this.setColor(new Color(0.1f, 0.1f, 0.1f));      
        this.setTransformacao4D(new Transformacao4D());
        this.setSpecularity(new float[]{1f,1f,1f,1f});
        this.setMaterialType(64);
    }

    /**
     * Método get do atributo faces.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return HashMap - Valor faces.
     */       
    public HashMap<Orientation, SubFace> getFaces() {
        return faces;
    }
    
    /**
     * Método set do atributo faces.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param faces Valor de faces.
     */    
    public void setFaces(HashMap<Orientation, SubFace> faces) {
        this.faces = faces;
    }
    
    /**
     * Método get do atributo transformacao4D.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return Transformacao4D - Valor transformacao4D.
     */   
    public Transformacao4D getTransformacao4D() {
        return transformacao4D;
    }
    
    /**
     * Método set do atributo transformacao4D.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param transformacao4D Valor de transformacao4D.
     */    
    public void setTransformacao4D(Transformacao4D transformacao4D) {
        this.transformacao4D = transformacao4D;
    }
    
    /**
     * Método get do atributo color.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return Color - Valor color.
     */  
    public Color getColor() {
        return color;
    }
    
    /**
     * Método set do atributo color.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param color Valor de color.
     */ 
    public void setColor(Color color) {
        this.color = color;
    }
    
    /**
     * Método get do atributo cubeSize.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return float - Valor cubeSize.
     */   
    public float getCubeSize() {
        return cubeSize;
    }
    
    /**
     * Método set do atributo cubeSize.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param cubeSize Valor de cubeSize.
     */    
    public void setCubeSize(float cubeSize) {
        this.cubeSize = cubeSize;
    }
    
    /**
     * Método get do atributo specularity.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return float[] - Valores de especularidade.
     */
    public float[] getSpecularity() {
        return specularity;
    }
    
    /**
     * Método set do atributo specularity.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param specularity Valores de especularidade.
     */    
    public void setSpecularity(float[] specularity) {
        this.specularity = specularity;
    }
    
    /**
     * Método get do atributo materialType.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return int - Valor de tipo de material.
     */
    public int getMaterialType() {
        return materialType;
    }
    
    /**
     * Método set do atributo materialType.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param materialType Valor de tipo de material.
     */   
    public void setMaterialType(int materialType) {
        this.materialType = materialType;
    }
    
    /**
     * Método que adiciona uma face em alguma posição do sub cubo.
     * Neste método são setadas as transformações da face que será adicionada ao cubo.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param orientation Posição em que a face será adicionada.
     * @param color Cor daface que será adicionada.
     * @return SubFace adicionada.
     */   
    public SubFace addFace(Orientation orientation, GraficColor color){
       Transformacao4D transformacao4D = new Transformacao4D();
       switch(orientation){
            case FT:
                transformacao4D.aplicaTranslacaoXYZ(new Ponto4D(0, 0, 0.505, 0));
                break;
            case UP:
                transformacao4D.aplicaRotacao(Axis.X, Transformacao4D.DEG_TO_RAD * -90);
                transformacao4D.aplicaTranslacaoXYZ(new Ponto4D(0, 0.505, 0, 0));
                break;
            case RI:
                transformacao4D.aplicaRotacao(Axis.Y, Transformacao4D.DEG_TO_RAD * 90);
                transformacao4D.aplicaTranslacaoXYZ(new Ponto4D(0.505, 0, 0, 0));
                break;
            case LE:
                transformacao4D.aplicaRotacao(Axis.Y, Transformacao4D.DEG_TO_RAD * -90);
                transformacao4D.aplicaTranslacaoXYZ(new Ponto4D(-0.505, 0, 0, 0));
                break;
            case DW:
                transformacao4D.aplicaRotacao(Axis.X, Transformacao4D.DEG_TO_RAD * 90);
                transformacao4D.aplicaTranslacaoXYZ(new Ponto4D(0, -0.505, 0, 0));
                break;
            case OP:
                transformacao4D.aplicaRotacao(Axis.X, Transformacao4D.DEG_TO_RAD * 180);
                transformacao4D.aplicaTranslacaoXYZ(new Ponto4D(0, 0, -0.505, 0));
                break;
        }
        SubFace subeFace = new SubFace(color, transformacao4D, new Ponto4D(0, 0, 1, 1), this);
        this.getFaces().put(orientation, subeFace);
        return subeFace;
    }
    
    /**
     * Método responsável por exibir o sub cubo e suas faces.
     * Primeiramente é carregada a matriz de transformação do subcubo.
     * Em seguida o sub cubo é desenhado.
     * Por fim todas as faces do sub cubo são desenhadas  
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param gl Parâmetro OpenGL
     * @param glut Parâmetro OpenGL
     * @param useTexture Determina se será utilizada a textura.
     */
    public void glDisplay(GL gl, GLUT glut, boolean useTexture){
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT_AND_DIFFUSE, this.getColor().getArray4f(), 0);
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, this.getSpecularity(), 0);
        gl.glMateriali(GL.GL_FRONT, GL.GL_SHININESS, this.getMaterialType());
        gl.glEnable(GL.GL_LIGHTING);
        gl.glPushMatrix();
        gl.glMultMatrixd(this.getTransformacao4D().GetDate(), 0);
        gl.glColor3f(this.getColor().getR(),this.getColor().getG(),this.getColor().getB());
        glut.glutSolidCube(this.getCubeSize());

        gl.glDisable(GL.GL_LIGHTING);
        
        for (Orientation orientation : this.getFaces().keySet()) {
            this.getFaces().get(orientation).glDisplay(gl, useTexture);
        }
        gl.glPopMatrix();
    }
    
}
