/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package controller;

import eventinterfaces.EIs;
import java.awt.Cursor;
import javax.swing.JOptionPane;
import model.GainsToFile;
import model.Jatek;
import swingmodels.Ajto;

/**
 *
 * @author Szabó-MesterAlex(SZF
 */
public class HaromAjto extends javax.swing.JFrame implements EIs.JatekItfc{
    private Jatek jatek;
    private Ajto[] ajtok;
    /**
     * Creates new form HaromAjto
     */
    public HaromAjto() {
        initComponents();
        La_szoveg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        GainsToFile.setFilename("gains.txt");
        ajtok = new Ajto[0];
        doRestart();
        setInitAll();
    }
    
    public final void doRestart(){
        jatek = new Jatek();
        for (Ajto ajto : ajtok) {
            ajto.setJatek(jatek);
            ajto.bezar();
        }
    }
    
    public final void setInitAll(){
        Jatek.addEventListener(this);
        int kezd = 25;
        int width = PnAjtok.getWidth();
        int pont = width / jatek.getAjtok();
        ajtok = new Ajto[jatek.getAjtok()];
        for (int i = 0; i < jatek.getAjtok(); i++) {
            ajtok[i] = new Ajto(jatek, (byte)i, (i*pont)+kezd, 1);
            PnAjtok.add(ajtok[i]);
        }
        PnAjtok.repaint();
        PnAjtok.updateUI();
        PnAjtok.validate();
        doUpdate();
    }
    
    public void doUpdate(){
        La_csereOsszes.setText(GainsToFile.getValue(GainsToFile.kincsAdatok.osszescsere)+"");
        La_csereKincs.setText(GainsToFile.getValue(GainsToFile.kincsAdatok.osszescserekincs)+"");
        La_nemCsereOsszes.setText(GainsToFile.getValue(GainsToFile.kincsAdatok.osszesnemcsere)+"");
        La_nemcsereKincs.setText(GainsToFile.getValue(GainsToFile.kincsAdatok.osszesnemcserekincs)+"");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlJatek = new javax.swing.JPanel();
        lblCim = new javax.swing.JLabel();
        txfCsereOsszes2 = new javax.swing.JTextField();
        txfNemCsere = new javax.swing.JTextField();
        txfCsereSzoveg1 = new javax.swing.JTextField();
        txfNemCsere1 = new javax.swing.JTextField();
        La_nemCsereOsszes = new javax.swing.JTextField();
        La_csereOsszes = new javax.swing.JTextField();
        La_csereKincs = new javax.swing.JTextField();
        La_nemcsereKincs = new javax.swing.JTextField();
        PnAjtok = new javax.swing.JPanel();
        btnUjJatek = new javax.swing.JButton();
        La_szoveg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Három ajtós játék");
        setResizable(false);

        lblCim.setFont(new java.awt.Font("Sitka Heading", 1, 36)); // NOI18N
        lblCim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCim.setText("Három Ajtó");
        lblCim.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblCim.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txfCsereOsszes2.setFont(new java.awt.Font("Sitka Heading", 2, 14)); // NOI18N
        txfCsereOsszes2.setText("Összes csere:");
        txfCsereOsszes2.setEnabled(false);

        txfNemCsere.setFont(new java.awt.Font("Sitka Heading", 2, 14)); // NOI18N
        txfNemCsere.setText("Ebből kincs:");
        txfNemCsere.setEnabled(false);

        txfCsereSzoveg1.setFont(new java.awt.Font("Sitka Heading", 2, 14)); // NOI18N
        txfCsereSzoveg1.setText("Ebből kincs:");
        txfCsereSzoveg1.setEnabled(false);

        txfNemCsere1.setFont(new java.awt.Font("Sitka Heading", 2, 14)); // NOI18N
        txfNemCsere1.setText("Összes nem csere:");
        txfNemCsere1.setEnabled(false);

        La_nemCsereOsszes.setFont(new java.awt.Font("Sitka Heading", 2, 14)); // NOI18N
        La_nemCsereOsszes.setEnabled(false);

        La_csereOsszes.setFont(new java.awt.Font("Sitka Heading", 2, 14)); // NOI18N
        La_csereOsszes.setEnabled(false);

        La_csereKincs.setFont(new java.awt.Font("Sitka Heading", 2, 14)); // NOI18N
        La_csereKincs.setEnabled(false);

        La_nemcsereKincs.setFont(new java.awt.Font("Sitka Heading", 2, 14)); // NOI18N
        La_nemcsereKincs.setEnabled(false);

        javax.swing.GroupLayout PnAjtokLayout = new javax.swing.GroupLayout(PnAjtok);
        PnAjtok.setLayout(PnAjtokLayout);
        PnAjtokLayout.setHorizontalGroup(
            PnAjtokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 623, Short.MAX_VALUE)
        );
        PnAjtokLayout.setVerticalGroup(
            PnAjtokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 267, Short.MAX_VALUE)
        );

        btnUjJatek.setText("Új játék");
        btnUjJatek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUjJatekActionPerformed(evt);
            }
        });

        La_szoveg.setFont(new java.awt.Font("Sitka Heading", 2, 14)); // NOI18N
        La_szoveg.setText("<html> <head> <style> body{ color: gray; } </style> </head> <body> A játék lényege, hogy itt 3 ajtót látsz. Az egyik ajtó egy autót rejt, a másik kettő mögött egy-egy kecske van.  Dönts arról, hogy a három ajtó közül, melyik rejtheti az autót! Miután megjelölted, a gép felfed egy másik ajtót, ami mögött biztosan nem az autó van,  ezután kapsz egy esélyt a döntésed megváltoztatására. Döntsd el, hogy elfogadod-e a cserét, vagy hagyatkozol az eredeti elképzelésedre.  <br><a href='https://www.youtube.com/watch?v=8rk98fNaBQQ'>https://www.youtube.com/watch?v=8rk98fNaBQQ</a> </body> </html>");
        La_szoveg.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pnlJatekLayout = new javax.swing.GroupLayout(pnlJatek);
        pnlJatek.setLayout(pnlJatekLayout);
        pnlJatekLayout.setHorizontalGroup(
            pnlJatekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJatekLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlJatekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(La_szoveg, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnlJatekLayout.createSequentialGroup()
                        .addComponent(lblCim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlJatekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txfNemCsere1, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(txfCsereOsszes2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlJatekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(La_csereOsszes, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(La_nemCsereOsszes, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlJatekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlJatekLayout.createSequentialGroup()
                                .addComponent(txfNemCsere, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(La_nemcsereKincs))
                            .addGroup(pnlJatekLayout.createSequentialGroup()
                                .addComponent(txfCsereSzoveg1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(La_csereKincs))))
                    .addComponent(PnAjtok, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUjJatek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlJatekLayout.setVerticalGroup(
            pnlJatekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJatekLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlJatekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCim, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlJatekLayout.createSequentialGroup()
                        .addGroup(pnlJatekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfCsereOsszes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(La_csereOsszes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlJatekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfNemCsere1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(La_nemCsereOsszes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlJatekLayout.createSequentialGroup()
                        .addGroup(pnlJatekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfCsereSzoveg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(La_csereKincs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlJatekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfNemCsere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(La_nemcsereKincs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(La_szoveg, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PnAjtok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUjJatek)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlJatek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlJatek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUjJatekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUjJatekActionPerformed
        doRestart();
    }//GEN-LAST:event_btnUjJatekActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HaromAjto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HaromAjto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HaromAjto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HaromAjto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HaromAjto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField La_csereKincs;
    private javax.swing.JTextField La_csereOsszes;
    private javax.swing.JTextField La_nemCsereOsszes;
    private javax.swing.JTextField La_nemcsereKincs;
    private javax.swing.JLabel La_szoveg;
    private javax.swing.JPanel PnAjtok;
    private javax.swing.JButton btnUjJatek;
    private javax.swing.JLabel lblCim;
    private javax.swing.JPanel pnlJatek;
    private javax.swing.JTextField txfCsereOsszes2;
    private javax.swing.JTextField txfCsereSzoveg1;
    private javax.swing.JTextField txfNemCsere;
    private javax.swing.JTextField txfNemCsere1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionValueChanged() {
        if(jatek.getFelkinal() != -1) {
            JOptionPane.showMessageDialog(this, 
                    "A játékmester felfedett egy ajtót. "
                + "Kapsz még egy esélyt a döntésre.");
            ajtok[jatek.getFelkinal()].kinyit(false);
        }
        if(jatek.getKincs() != -1){
            byte kincssz = (byte)(jatek.getKincs());
            for (int i = 0; i < ajtok.length; i++) {
                ajtok[i].kinyit(i == kincssz);
            }
        }
        doUpdate();
    }
}
