//Roberto, Thiago - Trabalho 04 - 2017.1
package View;

import GraphicCube.MoveCubeTask;
import GraphicCube.Cube;
import GraphicCube.CubeAnimator;
import GraphicCube.CubeTask;
import GraphicCube.CubeTaskType;
import GraphicCube.GraficColor;
import GraphicCube.Ponto4D;
import GraphicCube.Transformacao4D;
import com.sun.opengl.util.GLUT;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.opengl.DebugGL;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

/**
 * Classe que gerencia a interação do usuário com o mundo gráfico.
 * Esta classe controla os listners de teclado e mouse bem como realiza implementa 
 * os metodos de desenho do GL.
 * 
 * @author Roberto Weege Jr
 * @since Versão inicial
 */
public class Main implements GLEventListener, KeyListener, MouseListener, MouseMotionListener {

    private GL gl;
    private GLU glu;
    private GLUT glut;
    private GLAutoDrawable glDrawable;
    
    private Cube cube;
    private CubeAnimator cubeAnimator;
    
    private Camera3D camera3D;
    private Camera2D camera2D;
    
    private int width;
    private int height;
  
    private float viewRotationX; 
    private float viewRotationY;
    private float viewRotationZ;
    
    private double posicaoInicialMouseX;
    private double posicaoInicialMouseY;
    
    private boolean isDisplayComplete;
    
    private boolean useTexture;
    
    private boolean useLight;
    
    private GraficColor faceSelected;
    
    private FaceTextureManager faceTextureManager;
    
    /**
     * Método construtor.
     * Seta os valores default para todos os atributos.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     */
    public Main() {
        this.setPosicaoInicialMouseX(0);
        this.setPosicaoInicialMouseY(0);
        this.setCamera3D(new Camera3D(new Ponto4D(7, 7, 7, 1), new Ponto4D(0, -3, 0, 1), new Ponto4D(0, 1, 0, 1)));
        this.setCamera2D(new Camera2D(-15f, 15f, -15f, 15f));
        this.setCube(new Cube());
        this.setCubeAnimator(new CubeAnimator(this));
        this.getCubeAnimator().start();
        this.setViewRotationX(0);
        this.setViewRotationY(0);
        this.setViewRotationZ(0);
        this.setIsDisplayComplete(true);
        this.setFaceSelected(GraficColor.WH);
        this.setUseTexture(true);
        this.setUseLight(true);
        this.setFaceTextureManager(new FaceTextureManager());
    }
    
    /**
     * Método get do atributo posicaoInicialMouseX.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return double - Valor da coordenada X no momento do clic inicial do mouse.
     */
    private double getPosicaoInicialMouseX() {
        return this.posicaoInicialMouseX;
    }
    
    /**
     * Método set do atributo posicaoInicialMouseX.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param x Valor da coordenada X no momento do clic inicial do mouse.
     */
    public void setPosicaoInicialMouseX(double x) {
        this.posicaoInicialMouseX = x;
    }
    
    /**
     * Método get do atributo posicaoInicialMouseY.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return double - Valor da coordenada Y no momento do clic inicial do mouse.
     */
    private double getPosicaoInicialMouseY() {
        return this.posicaoInicialMouseY;
    }
    
    /**
     * Método set do atributo posicaoInicialMouseY.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param y Valor da coordenada Y no momento do clic inicial do mouse.
     */
    public void setPosicaoInicialMouseY(double y) {
        this.posicaoInicialMouseY = y;
    }
    
    /**
     * Método get do atributo cubeAnimator.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return CubeAnimator - Objeto CubeAnimator.
     */
    public CubeAnimator getCubeAnimator() {
        return cubeAnimator;
    }
    
    /**
     * Método set do atributo cubeAnimator.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param cubeAnimator Objeto CubeAnimator.
     */
    public void setCubeAnimator(CubeAnimator cubeAnimator) {
        this.cubeAnimator = cubeAnimator;
    }
    
    /**
     * Método get do atributo width.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return int - Valor de width.
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * Método set do atributo width.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param width Valor de width.
     */
    public void setWidth(int width) {
        this.width = width;
    }
    
    /**
     * Método get do atributo height.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return double - Valor de height.
     */
    public int getHeight() {
        return height;
    }
    
    /**
     * Método set do atributo height.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param height Valor de height.
     */
    public void setHeight(int height) {
        this.height = height;
    }
    
    /**
     * Método get do atributo viewRotationX.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return float - Valor de viewRotationX.
     */
    public float getViewRotationX() {
        return viewRotationX;
    }
    
    /**
     * Método set do atributo viewRotationX.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param viewRotationX Valor de viewRotationX.
     */
    public void setViewRotationX(float viewRotationX) {
        this.viewRotationX = viewRotationX;
    }
    
    /**
     * Método get do atributo viewRotationY.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return float - Valor de viewRotationY.
     */
    public float getViewRotationY() {
        return viewRotationY;
    }
    
    /**
     * Método set do atributo viewRotationY.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param viewRotationY Valor de viewRotationY.
     */
    public void setViewRotationY(float viewRotationY) {
        this.viewRotationY = viewRotationY;
    }
    
    /**
     * Método get do atributo viewRotationZ.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return float - Valor de viewRotationZ.
     */
    public float getViewRotationZ() {
        return viewRotationZ;
    }
    
    /**
     * Método set do atributo viewRotationZ.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param viewRotationZ Valor de viewRotationZ.
     */
    public void setViewRotationZ(float viewRotationZ) {
        this.viewRotationZ = viewRotationZ;
    }
    
    /**
     * Método get do atributo camera3D.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return Camera3D - Objeto Camera3D.
     */
    public Camera3D getCamera3D() {
        return camera3D;
    }
    
    /**
     * Método set do atributo camera3D.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param camera3D Objeto Camera3D.
     */
    public void setCamera3D(Camera3D camera3D) {
        this.camera3D = camera3D;
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
     * Método get do atributo isDisplayComplete.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return boolean - Valor de isDisplayComplete.
     */
    public boolean isIsDisplayComplete() {
        return isDisplayComplete;
    }
    
    /**
     * Método set do atributo isDisplayComplete.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param isDisplayComplete Valor de isDisplayComplete.
     */
    public void setIsDisplayComplete(boolean isDisplayComplete) {
        this.isDisplayComplete = isDisplayComplete;
    }
    
    /**
     * Método get do atributo faceSelected.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return GraficColor - Objeto faceSelected.
     */
    public GraficColor getFaceSelected() {
        return faceSelected;
    }
    
    /**
     * Método set do atributo faceSelected.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param faceSelected Objeto faceSelected.
     */
    public void setFaceSelected(GraficColor faceSelected) {
        this.faceSelected = faceSelected;
    }
    
    /**
     * Método get do atributo camera2D.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return Camera2D - Objeto camera2D.
     */
    public Camera2D getCamera2D() {
        return camera2D;
    }
    
    /**
     * Método set do atributo camera2D.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param camera2D Objeto camera2D.
     */
    public void setCamera2D(Camera2D camera2D) {
        this.camera2D = camera2D;
    }
    
    /**
     * Método get do atributo useTexture.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return boolean - Valor de useTexture.
     */
    public boolean isUseTexture() {
        return useTexture;
    }
    
    /**
     * Método set do atributo useTexture.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param useTexture Valor de useTexture.
     */
    public void setUseTexture(boolean useTexture) {
        this.useTexture = useTexture;
    }
    
    /**
     * Método get do atributo useLight.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return boolean - Valor de useLight.
     */
    public boolean isUseLight() {
        return useLight;
    }
    
    /**
     * Método set do atributo useLight.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param useLight Valor de useLight.
     */
    public void setUseLight(boolean useLight) {
        this.useLight = useLight;
    }
    
    /**
     * Método get do atributo faceTextureManager.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @return FaceTextureManager - Objeto faceTextureManager.
     */
    public FaceTextureManager getFaceTextureManager() {
        return faceTextureManager;
    }
    
    /**
     * Método set do atributo faceTextureManager.
     *
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param faceTextureManager Objeto faceTextureManager.
     */
    public void setFaceTextureManager(FaceTextureManager faceTextureManager) {
        this.faceTextureManager = faceTextureManager;
    }
    
    /**
     * Método OpenGL.
     * Inicia os objetos GL, seta a cor de limpeza seta a iluminação e carrega a textura das subfaces.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param drawable Objeto GLAutoDrawable.
     */
    @Override
    public void init(GLAutoDrawable drawable) {
        System.out.println(" --- init ---");
        glDrawable = drawable;
        gl = drawable.getGL();
        glu = new GLU();
        glut = new GLUT();
        glDrawable.setGL(new DebugGL(gl));
        System.out.println("Espaco de desenho com tamanho: " + drawable.getWidth() + " x " + drawable.getHeight());
        
        gl.glClearColor(1f, 1f, 1f, 1f);

        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, new float[]{0.1f, 0.1f, 0.1f, 1f}, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, new float[]{1f, 1f, 1f, 1f}, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, new float[]{1f, 1f, 1f, 1f}, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, new float[]{0f, 5f, 3f, 1f}, 0);
        
        this.getFaceTextureManager().configureTextures(gl, "faceTexture.jpg");

        gl.glBindTexture(GL.GL_TEXTURE_2D, this.getFaceTextureManager().getIdTexture()[0]);
        gl.glTexImage2D(GL.GL_TEXTURE_2D, 0, 3, this.getFaceTextureManager().getImageWidth()
                , this.getFaceTextureManager().getImageHeight(), 0, GL.GL_BGR, GL.GL_UNSIGNED_BYTE
                , this.getFaceTextureManager().getBuffer()[0]);
        
        gl.glShadeModel(GL.GL_SMOOTH);
        gl.glEnable(GL.GL_CULL_FACE);
        gl.glEnable(GL.GL_DEPTH_TEST);
    } 
        
    /**
     * Método OpenGL.
     * Armazena os valores de width e height
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param drawable Objeto GLAutoDrawable.
     * @param x valor inteiro.
     * @param y valor inteiro.
     * @param width valor inteiro.
     * @param height valor inteiro.
     */
    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        System.out.println(" --- reshape ---");
        this.setWidth(width);
        this.setHeight(height);
    }
    
    /**
     * Método OpenGL.
     * Seta os valores de camera com base na camera do mundo, desenha o cubo em 3D
     * e logo após o mapa do cubo em 2D.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param arg0 Objeto GLAutoDrawable.
     */
    @Override
    public void display(GLAutoDrawable arg0) {
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glViewport(0, 0, this.getWidth(), this.getHeight());
        glu.gluPerspective(50, this.getWidth() / this.getHeight(), 0.1, 15);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
        glu.gluLookAt(this.getCamera3D().getCamera().obterX(), this.getCamera3D().getCamera()
                .obterY(), this.getCamera3D().getCamera().obterZ(), 
                      this.getCamera3D().getLookAt().obterX(), this.getCamera3D().getLookAt()
                              .obterY(), this.getCamera3D().getLookAt().obterX(), 
                      this.getCamera3D().getUp().obterX(), this.getCamera3D().getUp()
                              .obterY(), this.getCamera3D().getUp().obterZ());       

        gl.glRotatef(this.getViewRotationX(), 1.0f, 0.0f, 0.0f);
        gl.glRotatef(this.getViewRotationY(), 0.0f, -1.0f, 0.0f);
        gl.glRotatef(this.getViewRotationZ(), 0.0f, 0.0f, 1.0f);
        
        if (this.isUseLight()){
            gl.glEnable(GL.GL_LIGHT0);
        }
        this.setIsDisplayComplete(this.getCube().glDisplay(gl, glut, this.isUseTexture()));
        if (this.isUseLight()){
            gl.glDisable(GL.GL_LIGHT0);
        }
        this.genCubeMap();
        gl.glFlush();
    }
    
    /**
     * Método que realiza o desenho do mapa do cubo em 2D.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     */
     public void genCubeMap(){        
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(this.getCamera2D().getGluOrtho2DInicioX(), this.getCamera2D().getGluOrtho2DFimX(), 
                       this.getCamera2D().getGluOrtho2DInicioY(), this.getCamera2D().getGluOrtho2DFimY());
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
        gl.glPushMatrix();
        Transformacao4D transformacao4D = new Transformacao4D();
        transformacao4D.aplicaTranslacaoXYZ(new Ponto4D(-1.5, -9, 0, 0));
        gl.glMultMatrixd(transformacao4D.GetDate(), 0);
        this.getCube().glDisplayCubeMap(gl, glut, this.isUseTexture());
        gl.glPopMatrix();
    }
     
    /**
     * Método que realiza as chamadas do método display enquanto ainda existem 
     * operações não finalizadas no cubo.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     */
    public  void displayWithPartial() {
        this.setIsDisplayComplete(false);
        while (!this.isIsDisplayComplete()) {
            glDrawable.display();
            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Método que executa 10 rotações em faces do cubo de forma aleatória.
     */
    private void randomizeCube() {
        Random random = new Random();
        GraficColor randomColor = GraficColor.WH;
        int qtyMoves = 10/*random.nextInt(9999)*/;
        for (int i = 0; i < qtyMoves; i++) {

            switch (random.nextInt(6)) {
                case 0:
                    randomColor = GraficColor.WH;
                    break;
                case 1:
                    randomColor = GraficColor.RE;
                    break;
                case 2:
                    randomColor = GraficColor.GR;
                    break;
                case 3:
                    randomColor = GraficColor.BL;
                    break;
                case 4:
                    randomColor = GraficColor.OR;
                    break;
                case 5:
                    randomColor = GraficColor.YE;
                    break;
            }
            this.getCubeAnimator().addMoveTask(new CubeTask(CubeTaskType.Move, 
                    new MoveCubeTask(randomColor, random.nextInt(2) == 1, true)));
        }
    }
    
    /**
     * Método que insere uma tarefa para o animador do cubo resolver o cubo gráfico.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     */
    private void solveCube() {
        this.getCubeAnimator().addMoveTask(new CubeTask(CubeTaskType.Solve));
    }


    /**
     * Método OpenGL.
     * Sem ação.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param arg0 Objeto GLAutoDrawable.
     * @param arg1 valor booleano.
     * @param arg2 valor booleano.
     */
    @Override
    public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {
    }

    /**
     * Método KeyListener.
     * Verifica ações de tecla.
     * As ações são:
     * Tecla W: Seleciona a face branca.
     * Tecla R: Seleciona a face vermelha.
     * Tecla G: Seleciona a face verde.
     * Tecla O: Seleciona a face laranja.
     * Tecla B: Seleciona a face azul.
     * Tecla Y: Seleciona a face amarela.
     * Tecla Seta para esquerda: Rotaciona a face selecionada para a esquerda.
     * Tecla Seta para direita: Rotaciona a face selecionada para a direita.
     * Tecla T: Ativa ou desativa a textura no cubo.
     * Tecla L: Ativa ou desativa a iluminação.
     * Tecla espaço: Aplica movimentos aleatórios no cubo.
     * Tecla enter: Aplica movimentos para resolver o cubo gráfico.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param e Evento de tecla.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_R:
                this.setFaceSelected(GraficColor.RE);
                break;
            case KeyEvent.VK_G:
                this.setFaceSelected(GraficColor.GR);
                break;
            case KeyEvent.VK_B:
                this.setFaceSelected(GraficColor.BL);
                break;
            case KeyEvent.VK_O:
                this.setFaceSelected(GraficColor.OR);
                break;
            case KeyEvent.VK_Y:
                this.setFaceSelected(GraficColor.YE);
                break;
            case KeyEvent.VK_W:
                this.setFaceSelected(GraficColor.WH);
                break;
            case KeyEvent.VK_T:
                this.setUseTexture(!this.isUseTexture());
                this.getCubeAnimator().setViewChange(true);
                break;
            case KeyEvent.VK_L:
                this.setUseLight(!this.isUseLight());
                this.getCubeAnimator().setViewChange(true);
                break;
            case KeyEvent.VK_RIGHT:
                this.getCubeAnimator().addMoveTask(new CubeTask(CubeTaskType.Move, 
                        new MoveCubeTask(this.getFaceSelected(), true, true)));
                break;
            case KeyEvent.VK_LEFT:
                this.getCubeAnimator().addMoveTask(new CubeTask(CubeTaskType.Move, 
                        new MoveCubeTask(this.getFaceSelected(), false, true)));
                break;
            case KeyEvent.VK_SPACE:
                this.randomizeCube();
                break;
            case KeyEvent.VK_ENTER:
                this.solveCube();
                break;
        }
    }
    
    /**
     * Método MouseListener.
     * Verifica ações de press de mouse.
     * Se o tipo de operação do editor for criação, inicia a criação ou adiciona 
     * um vertice ao objeto que está sendo criado.
     * Se o tipo de operação do editor for edição de vertice, busca o vertice 
     * do objeto selecionado mais procimo click para setar como vertice selecionado.
     * Se o tipo de operação do editor for edição de seleciona, seta o objeto 
     * selecionado se o click foi efetuado dentro de um objeto gráfico, ou seta 
     * o objeto selecionado como null se o click não for em nenhum objeto gráfico.
     * Se o tipo de operação do editor for edição de translação, escala ou rotação, 
     * grava as cooredenadas iniciais de click de mouse.
     * Para os outros tipos de operação, não possui ação.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param e Evento de mouse.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        this.setPosicaoInicialMouseX(e.getX());
        this.setPosicaoInicialMouseY(e.getY());       
    }
    
    /**
     * Método MouseListener.
     * Verifica ações de drag de mouse.
     * Se o tipo de operação do editor for edição de vertice, atualiza os valores do 
     * vertice que está selecionado.
     * Se o tipo de operação do editor for translação, aplica translação no objeto 
     * selecionado.
     * Se o tipo de operação do editor for escala, aplica escala no objeto 
     * selecionado.
     * Se o tipo de operação do editor for rotação, aplica rotação no objeto 
     * selecionado.
     * Para os outros tipos de operação, não possui ação.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param e Evento de mouse.
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        Dimension size = e.getComponent().getSize();
        this.setViewRotationX(this.getViewRotationX() +  360.0f * 
                ((float)(this.getPosicaoInicialMouseY()-e.getY())/(float)size.height));
        this.setViewRotationY(this.getViewRotationY() +  360.0f * 
                ((float)(e.getX()-this.getPosicaoInicialMouseX())/(float)size.width));
        this.setPosicaoInicialMouseX(e.getX());
        this.setPosicaoInicialMouseY(e.getY());
        this.getCubeAnimator().setViewChange(true);
    }
    
    /**
     * Método MouseListener.
     * Verifica ações de move de mouse.
     * Se o tipo de operação do editor for criação, atualiza os valores do 
     * vertice que está sendo criado.
     * Para os outros tipos de operação, não possui ação.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param e Evento de mouse.
     */
    @Override
    public void mouseMoved(MouseEvent e) {
    }

    /**
     * Método MouseListener.
     * Sem ação.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param e Evento de mouse.
     */
    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    /**
     * Método MouseListener.
     * Sem ação.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param arg0 Evento de mouse.
     */
    @Override
    public void keyTyped(KeyEvent arg0) {
    }

    /**
     * Método MouseListener.
     * Sem ação.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param e Evento de mouse.
     */
    @Override
    public void mouseEntered(MouseEvent e) {
    }
   
    /**
     * Método MouseListener.
     * Sem ação.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param e Evento de mouse.
     */
    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    /**
     * Método MouseListener.
     * Sem ação.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param e Evento de mouse.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    
    /**
     * Método MouseListener.
     * Sem ação.
     * 
     * @author Roberto Weege Jr
     * @since Versão inicial
     * @param e Evento de mouse.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
    }
}
