//Roberto, Thiago - Trabalho 04 - 2017.1
package View;

import java.awt.BorderLayout;

import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Classe que configura e instancia os forms de desenho e ajuda.
 * 
 * @author Roberto Weege Jr
 * @since Versão inicial
 */
public class Frame extends JFrame{

	private static final long serialVersionUID = 1L;
	private Main renderer = new Main();
	private int janelaLargura  = 600, janelaAltura = 600;
        private static String helpText = 
            "Para mover uma face do Cubo pressione uma das teclas de seleção de face e após uma tecla de rotação:\n" +
            "Tecla W: Seleciona a face branca.\n" +
            "Tecla R: Seleciona a face vermelha.\n" +
            "Tecla G: Seleciona a face verde.\n" +
            "Tecla O: Seleciona a face laranja.\n" +
            "Tecla B: Seleciona a face azul.\n" +
            "Tecla Y: Seleciona a face amarela.\n" +
            "Tecla Seta para Esquerda: Rotaciona a face selecionada para a esquerda.\n" +
            "Tecla Seta para Direita: Rotaciona a face selecionada para a direita.\n" +
            "\n" +
            "Para ativar/ativar recursos pressione uma das teclas:\n" +
            "Tecla T: Ativa ou desativa a textura no cubo.\n" +
            "Tecla L: Ativa ou desativa a iluminação.\n" +
            "\n" +
            "Para resolver/embaralhar o Cubo pressione uma das teclas:\n" +
            "Tecla espaço: Aplica movimentos aleatórios no cubo.\n" +
            "Tecla enter: Aplica movimentos para resolver o cubo gráfico.\n" +
            "\n" +
            "Para rotacionar o Cubo clique com qualquer botão do mouse e arraste a seta."; 
        
        /**
         * Método construtor.
         * Configura o Form de desenho.
         *
         * @author Roberto Weege Jr
         * @since Versão inicial
         */
        public Frame() {		
            // Cria o frame.
            super("N4");   
            //Somado 18 para criar janela com 800x800
            setBounds(300,250,janelaLargura + 14,janelaAltura + 29 + 8);  // 800 + 29 da borda do titulo da janela
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            getContentPane().setLayout(new BorderLayout());

            /* Cria um objeto GLCapabilities para especificar 
             * o numero de bits por pixel para RGBA
             */
            GLCapabilities glCaps = new GLCapabilities();
            glCaps.setRedBits(8);
            glCaps.setBlueBits(8);
            glCaps.setGreenBits(8);
            glCaps.setAlphaBits(8); 

            /* Cria um canvas, adiciona ao frame e objeto "ouvinte" 
             * para os eventos Gl, de mouse e teclado
             */
            GLCanvas canvas = new GLCanvas(glCaps);
            add(canvas,BorderLayout.CENTER);
            canvas.addGLEventListener(renderer);        
            canvas.addKeyListener(renderer);
            canvas.addMouseListener(renderer);
            canvas.addMouseMotionListener(renderer);
            canvas.requestFocus();			
	}	
        
        /**
         * Método dispose.
         * Finaliza a thread de movimentação do cubo e executa o método pai.
         *
         * @author Roberto Weege Jr
         * @since Versão inicial
         */
        @Override
        public void dispose() {
            this.renderer.getCubeAnimator().setIsAtive(false);
            super.dispose(); //To change body of generated methods, choose Tools | Templates.
        }

        /**
         * Método main.
         * Executa o Form de desenho e configura e inicia o form de ajuda.
         *
         * @author Roberto Weege Jr
         * @since Versão inicial
         * @param args Nenhuma leitura de args.
         */
	public static void main(String[] args) {
            new Help("Ajuda N4", helpText).setVisible(true);
            new Frame().setVisible(true);
	}
	
}
