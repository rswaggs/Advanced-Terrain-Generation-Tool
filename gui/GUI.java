package gui;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import world.World;
import world.terrain.Generator;

public final class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    private GUI() {
        initComponents();
    }
    
    private static GUI gui;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mapView = new javax.swing.JDialog();
        miniMap1 = new gui.MiniMap();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        canvas = new gui.Canvas();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        worldMenu = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();

        mapView.setBounds(new java.awt.Rectangle(100, 100, 500, 500));

        javax.swing.GroupLayout miniMap1Layout = new javax.swing.GroupLayout(miniMap1);
        miniMap1.setLayout(miniMap1Layout);
        miniMap1Layout.setHorizontalGroup(
            miniMap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        miniMap1Layout.setVerticalGroup(
            miniMap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );

        jButton1.setText("Close");

        javax.swing.GroupLayout mapViewLayout = new javax.swing.GroupLayout(mapView.getContentPane());
        mapView.getContentPane().setLayout(mapViewLayout);
        mapViewLayout.setHorizontalGroup(
            mapViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mapViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mapViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(miniMap1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
                .addContainerGap())
        );
        mapViewLayout.setVerticalGroup(
            mapViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mapViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(miniMap1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Advanced Terrain Generation Tool - Untitled World");
        setBounds(new java.awt.Rectangle(100, 100, 550, 900));
        setIconImage(getIconImage());

        canvas.setBackground(new java.awt.Color(0, 0, 0));
        canvas.setDoubleBuffered(false);
        canvas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                canvasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout canvasLayout = new javax.swing.GroupLayout(canvas);
        canvas.setLayout(canvasLayout);
        canvasLayout.setHorizontalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 988, Short.MAX_VALUE)
        );
        canvasLayout.setVerticalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Canvas", canvas);

        jMenu1.setText("File");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("New world...");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newWorld(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Open existing world...");
        jMenuItem5.setEnabled(false);
        jMenu1.add(jMenuItem5);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        worldMenu.setText("World");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem7.setText("Generate terrain...");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateTerrainFromText(evt);
            }
        });
        worldMenu.add(jMenuItem7);
        worldMenu.add(jSeparator1);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem6.setText("Set seed...");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        worldMenu.add(jMenuItem6);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem3.setText("Choose tile spritesheet...");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        worldMenu.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Resize world...");
        jMenuItem4.setEnabled(false);
        worldMenu.add(jMenuItem4);

        jMenuBar1.add(worldMenu);

        jMenu2.setText("Canvas");

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setText("Navigator...");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newWorld(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newWorld
        World.newWorld(64, 64);
        worldMenu.setEnabled(true);
        canvas.repaint();
    }//GEN-LAST:event_newWorld

    @Override
    public Image getIconImage() {
        try {
            InputStream img = GUI.class.getResourceAsStream("/resources/favicon.png");
            if (img == null) return null;
            return ImageIO.read(img);
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    private String last_terrain_string = "";
    private void generateTerrainFromText(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateTerrainFromText
        String s = JOptionPane.showInputDialog(gui, "Parameters:", last_terrain_string);
        if (s == null) return; s = s.trim();
        last_terrain_string = s;
        //split by colon
        String split[] = s.split("\\s*:\\s*");
        if (split.length < 2) { System.err.println("Invalid input!"); return; }
        //find generator type
        String gname = split[0].trim(); String params = split[1].trim();
        System.out.println(gname);
        //find parameters
        String[] params_spl = params.split("\\s*,\\s*");
        Generator g = Generator.getGenerator(gname);
        if (g == null) { System.err.println("Generator '"+gname+"' not found!"); return; }
        for (int i = 0; i < params_spl.length; i++) {
            String spl[] = params_spl[i].split("\\s*=\\s*");
            String name = spl[0]; String val = spl[1];
            g.setParameter(name, val);
            System.out.println(gname+" parameter: "+name+" = "+val);
        }
        //clear and generate
        World.getWorld().clearTiles();
        g.generate(World.getWorld());
        //repaint
        canvas.repaint();
    }//GEN-LAST:event_generateTerrainFromText

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JFileChooser chooser = new JFileChooser();
        int success = chooser.showOpenDialog(gui);
        if (success == JFileChooser.APPROVE_OPTION) {
            File chosen = chooser.getSelectedFile();
            World.getWorld().setSpritesheet(chosen);
            System.out.println("Set world spritesheet file to "+chosen.getAbsolutePath());
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void canvasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMouseClicked
        canvas.repaint();
    }//GEN-LAST:event_canvasMouseClicked

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        World.getWorld().setSeed(Long.parseLong(JOptionPane.showInputDialog(gui, "Seed (integer):")));
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        showDialog(mapView);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    public static void showDialog(JDialog d) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        d.setLocation(gui.getX() + (int) (gui.getWidth() / 2) - (d.getWidth() / 2),
                gui.getY() + (int) (gui.getHeight() / 2) - ((d.getHeight() / 2)));
        d.setModal(true);
        d.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        d.setVisible(true);
        System.out.println("Showing " + d.getTitle());
    }
    
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
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                gui = new GUI();
                gui.setVisible(true);
                World.newWorld(64, 64);
            }
        });
    }
    
    protected static Canvas getCanvas() { return gui == null ? null : gui.canvas; }
    protected static MiniMap getMiniMap() { return gui == null ? null : gui.miniMap1; }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.Canvas canvas;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JDialog mapView;
    private gui.MiniMap miniMap1;
    private javax.swing.JMenu worldMenu;
    // End of variables declaration//GEN-END:variables
}
