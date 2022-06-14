package main.java;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import com.mashape.unirest.http.exceptions.UnirestException;

import org.jfree.chart.ChartPanel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author thale
 */
public class GraficoLive extends javax.swing.JFrame {

    /**
     * Creates new form GraficoLive
     */
    
    public GraficoLive(ChartPanel chart) {
        initComponents(chart);
        
    }
    private String codigo = "";
    private String[] moedas = { "BTC", "USD", "EUR" };
    private int dataInicial = 0;
    private int dataFinal = 0;
    private ChartPanel chart;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // public static void show(Moeda[] moeda, String title) {
    //     //Create and set up the chart.
    //     Candlestick Candlestick = new Candlestick(title);
    //     Candlestick.candleGenerator(moeda);
    //     frame.setContentPane(Candlestick);
    //     frame.setResizable(false);
    //     frame.pack();
    // }
    
    private void initComponents(ChartPanel chart) {
        this.chart = chart;

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gráfico ao vivo");

        jScrollPane1.setBackground(new java.awt.Color(250, 250, 250));
        //jScrollPane1.add(chart);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("até");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Moeda:");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("OK");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(this.moedas));
        jComboBox1.setBorder(null);

        jMenu1.setText("Gráfico");
        jMenu1.setIcon(new javax.swing.ImageIcon("C:\\Users\\thale\\eclipse-workspace\\trabalhoFinalDesktop\\src\\trabalhoFinalDesktop\\img\\perfil.png"));
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Gráfico ao Vivo");
        jMenu2.setIcon(new javax.swing.ImageIcon("C:\\Users\\thale\\eclipse-workspace\\trabalhoFinalDesktop\\src\\trabalhoFinalDesktop\\img\\perfil.png"));
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Resumo");
        jMenu3.setIcon(new javax.swing.ImageIcon("C:\\Users\\thale\\eclipse-workspace\\trabalhoFinalDesktop\\src\\trabalhoFinalDesktop\\img\\perfil.png"));
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        jMenu1.addMenuListener(new MenuListener() {
            public void menuSelected(MenuEvent e) {
                JMenu1ActionPerformed(e);
            }
            public void menuDeselected(MenuEvent e) {
            }
            public void menuCanceled(MenuEvent e) {
            }
        });
        jMenu3.addMenuListener(new MenuListener() {
            public void menuSelected(MenuEvent e) {
                JMenu3ActionPerformed(e);
            }
            public void menuDeselected(MenuEvent e) {
            }
            public void menuCanceled(MenuEvent e) {
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(103, 103, 103))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)))
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                    )))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void JMenu1ActionPerformed(MenuEvent e) {
        Grafico gf = new Grafico(this.chart);
        this.setVisible(false);
        gf.setVisible(true); 
    }
    private void JMenu3ActionPerformed(MenuEvent e) {
    	Resumo resumo = new Resumo();
        this.setVisible(false);
        resumo.setVisible(true); 
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.codigo = "BRL-" + moedas[jComboBox1.getSelectedIndex()];
        try{
        this.dataInicial = Integer.parseInt(jTextField1.getText());
        this.dataFinal = Integer.parseInt(jTextField2.getText());
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Atualizei");
        }
        if(dataInicial > dataFinal){
            JOptionPane.showMessageDialog(null, "Data inicial maior que a data final");
        }
        else{
            try{
            this.dataFinal = dataFinal + 10;
            try{
            Thread.sleep(1*1000);

            }
            catch(InterruptedException e){
                JOptionPane.showMessageDialog(null, "Erro ao carregar gráfico");
            }
            Moeda[] result = ApiConnector.getMoedaTime(this.codigo,""+(dataInicial+dataFinal));
            // //System.out.println(result[0].toString());
             ChartPanel chart = MoedaChart.show(result,codigo);
             GraficoLive GraficoLive = new GraficoLive(chart);
             this.dispose();
             //this.setVisible(false);
             GraficoLive.setVisible(true);
             jButton1ActionPerformed(evt);
         } catch (UnirestException e) {
             e.printStackTrace();
         }
        }

    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(GraficoLive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraficoLive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraficoLive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraficoLive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        // java.awt.EventQueue.invokeLater(new Runnable() {
        //     public void run() {
        //         new GraficoLive(chart).setVisible(true);
        //     }
        // });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
