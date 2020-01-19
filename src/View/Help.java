//Roberto, Thiago - Trabalho 04 - 2017.1
package View;

/**
 * Classe Form que exibe um texto de ajuda.
 * 
 * @author Roberto Weege Jr
 * @since Versão inicial
 */
public class Help extends javax.swing.JFrame {
    /**
    * Método construtor.
    * Configura o Form de ajuda.
    *
    * @author Roberto Weege Jr
    * @since Versão inicial
    * @param title Titulo do form.
    * @param help Texto de ajuda.
    */
    public Help(String title, String help) {
        super(title);
        initComponents();
        this.help.setText(help);
    }    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        help = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        help.setEditable(false);
        help.setColumns(20);
        help.setRows(5);
        jScrollPane1.setViewportView(help);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea help;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
