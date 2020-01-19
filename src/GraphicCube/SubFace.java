//Roberto, Thiago - Trabalho 04 - 2017.1
package GraphicCube;

import javax.media.opengl.GL;
/**
 * Classe que representa uma sub face.
 * Nesta classe estão armazenados os dados gráficos de sub face, como cor e transformações gráficas.
 * Nesta classe que as sub faces são desenhadas.
 * 
 * @author Roberto Weege Jr
 * @since Versão inicial
 */
public class SubFace {
    
    private SubCube parentSubCube;

    private Ponto4D ponto1;
    private Ponto4D ponto2;
    private Ponto4D ponto3;
    private Ponto4D ponto4;
    
    private Ponto4D normalVetor;
    private Transformacao4D transformacao4D;
    
    private Color color;
    private GraficColor enumColor;
    
    private float[] specularity;
    private int materialType;
    
    /**
     * Método construtor.
     * Seta os valores para os atributos.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param color Cor da face.
     * @param transformacao4D Transformação da face.
     * @param normalVetor Vetor normal da face.
     * @param parentSubCube Sub cubo ao qual esta face pertence.
     */
    public SubFace(GraficColor color, Transformacao4D transformacao4D, Ponto4D normalVetor, SubCube parentSubCube) {
        this.setParentSubCube(parentSubCube);
        this.setPonto1(new Ponto4D(-0.45f, -0.45f, 0, 1));
        this.setPonto2(new Ponto4D( 0.45f, -0.45f, 0, 1));
        this.setPonto3(new Ponto4D( 0.45f,  0.45f, 0, 1));
        this.setPonto4(new Ponto4D(-0.45f,  0.45f, 0, 1));
        this.setNormalVetor(normalVetor);
        this.setTransformacao4D(transformacao4D);
        this.setEnumColor(color);
        this.setColor(new Color());
        this.getColor().setColor(this.getEnumColor());
        this.setSpecularity(new float[]{0.6f,0.6f,0.6f,1f});
        this.setMaterialType(65);
    }
    
    /**
     * Método get do atributo parentSubCube.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return SubCube - Objeto parentSubCube.
     */
    public SubCube getParentSubCube() {
        return parentSubCube;
    }
    
    /**
     * Método set do atributo parentSubCube.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param parentSubCube Objeto parentSubCube.
     */ 
    public void setParentSubCube(SubCube parentSubCube) {
        this.parentSubCube = parentSubCube;
    }
    
    /**
     * Método get do atributo ponto1.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return Ponto4D - Objeto ponto1.
     */
    public Ponto4D getPonto1() {
        return ponto1;
    }
    
    /**
     * Método set do atributo ponto1.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param ponto1 Objeto ponto1.
     */ 
    public void setPonto1(Ponto4D ponto1) {
        this.ponto1 = ponto1;
    }
    
    /**
     * Método get do atributo ponto2.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return Ponto4D - Objeto ponto2.
     */
    public Ponto4D getPonto2() {
        return ponto2;
    }
    
   /**
     * Método set do atributo ponto2.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param ponto2 Objeto ponto2.
     */ 
    public void setPonto2(Ponto4D ponto2) {
        this.ponto2 = ponto2;
    }
    
    /**
     * Método get do atributo ponto3.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return Ponto4D - Objeto ponto3.
     */
    public Ponto4D getPonto3() {
        return ponto3;
    }
    
   /**
     * Método set do atributo ponto3.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param ponto3 Objeto ponto3.
     */ 
    public void setPonto3(Ponto4D ponto3) {
        this.ponto3 = ponto3;
    }
    
    /**
     * Método get do atributo ponto4.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return Ponto4D - Objeto ponto4.
     */
    public Ponto4D getPonto4() {
        return ponto4;
    }
    
   /**
     * Método set do atributo ponto4.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param ponto4 Objeto ponto4.
     */ 
    public void setPonto4(Ponto4D ponto4) {
        this.ponto4 = ponto4;
    }
    
    /**
     * Método get do atributo normalVetor.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return Ponto4D - Objeto normalVetor.
     */
    public Ponto4D getNormalVetor() {
        return normalVetor;
    }
    
   /**
     * Método set do atributo normalVetor.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param normalVetor Objeto normalVetor.
     */ 
    public void setNormalVetor(Ponto4D normalVetor) {
        this.normalVetor = normalVetor;
    }
    
    /**
     * Método get do atributo transformacao4D.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return Transformacao4D - Objeto transformacao4D.
     */
    public Transformacao4D getTransformacao4D() {
        return transformacao4D;
    }
    
   /**
     * Método set do atributo transformacao4D.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param transformacao4D Objeto transformacao4D.
     */ 
    public void setTransformacao4D(Transformacao4D transformacao4D) {
        this.transformacao4D = transformacao4D;
    }
    
    /**
     * Método get do atributo color.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return Color - Objeto color.
     */
    public Color getColor() {
        return color;
    }
    
   /**
     * Método set do atributo color.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param color Objeto color.
     */ 
    public void setColor(Color color) {
        this.color = color;
    }
    
    /**
     * Método get do atributo enumColor.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return Color - Valor enumColor.
     */
    public GraficColor getEnumColor() {
        return enumColor;
    }
    
    /**
     * Método set do atributo enumColor.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param enumColor Valor color.
     */ 
    public void setEnumColor(GraficColor enumColor) {
        this.enumColor = enumColor;
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
     * Método responsável por exibir a sub face.
     * Este método realiza tratativas para ativar e desativar a textura conforma valor parametrizado.
     * Primeiramente são carregadas as transformações do objeto e após a face é desenhada.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param gl Parâmetro OpenGL
     * @param useTexture Determina se será utilizada a textura.
     */
    public void glDisplay(GL gl, boolean useTexture){
        if (useTexture){
            gl.glEnable(GL.GL_TEXTURE_2D);
        }      
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, this.getSpecularity(), 0);
        gl.glMateriali(GL.GL_FRONT, GL.GL_SHININESS, this.getMaterialType());
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT_AND_DIFFUSE, this.getColor().getArray4f(), 0);
        gl.glEnable(GL.GL_LIGHTING);
        gl.glPushMatrix();
        gl.glMultMatrixd(this.getTransformacao4D().GetDate(), 0);
        gl.glColor3f(this.getColor().getR(),this.getColor().getG(),this.getColor().getB());
        
        gl.glNormal3d(this.getNormalVetor().obterX(), this.getNormalVetor().obterY(), this.getNormalVetor().obterZ());
        gl.glBegin (GL.GL_QUADS );
            if (useTexture) gl.glTexCoord2f(0.0f, 1.0f); 
            gl.glVertex3d(this.getPonto1().obterX(), this.getPonto1().obterY(), this.getPonto1().obterZ());
            if (useTexture) gl.glTexCoord2f(1.0f, 1.0f);
            gl.glVertex3d(this.getPonto2().obterX(), this.getPonto2().obterY(), this.getPonto2().obterZ());
            if (useTexture) gl.glTexCoord2f(1.0f, 0.0f);
            gl.glVertex3d(this.getPonto3().obterX(), this.getPonto3().obterY(), this.getPonto3().obterZ());
            if (useTexture) gl.glTexCoord2f(0.0f, 0.0f);
            gl.glVertex3d(this.getPonto4().obterX(), this.getPonto4().obterY(), this.getPonto4().obterZ());

        gl.glEnd();
        
        if (useTexture){
            gl.glDisable(GL.GL_TEXTURE_2D);
        } 
        gl.glDisable(GL.GL_LIGHTING);
        
        gl.glPopMatrix();
    }
}
