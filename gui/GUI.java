package gui;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicDirectoryModel;
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

        navigator = new javax.swing.JDialog();
        mapView = new gui.MiniMap();
        canvas = new gui.Canvas();
        layerPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        layerList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        layerUpButton = new javax.swing.JButton();
        layerDownButton = new javax.swing.JButton();
        editLayerButton = new javax.swing.JButton();
        deleteLayerButton = new javax.swing.JButton();
        regenLayerButton = new javax.swing.JButton();
        addLayerButton = new javax.swing.JButton();
        editLayerPanel = new javax.swing.JPanel();
        applyLayerChangesButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        layerNameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        editLayerTitleLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        layerTileChooser = new javax.swing.JComboBox<>();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newWorldButton = new javax.swing.JMenuItem();
        openWorldButton = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        exportTerrainButton = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        exitButton = new javax.swing.JMenuItem();
        worldMenu = new javax.swing.JMenu();
        showNavigatorButton = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        setSeedButton = new javax.swing.JMenuItem();
        chooseSpriteSheetMenu = new javax.swing.JMenu();
        earthSpritesheetButton = new javax.swing.JMenuItem();
        marsSpritesheetButton = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        customSpritesheetButton = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        navigator.setTitle("Navigator");
        navigator.setAlwaysOnTop(true);
        navigator.setBounds(new java.awt.Rectangle(100, 100, 500, 500));
        navigator.setIconImage(getIconImage());
        navigator.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                navigatorFocusLost(evt);
            }
        });

        mapView.setBackground(new java.awt.Color(0, 0, 0));
        mapView.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                mapViewFocusLost(evt);
            }
        });

        javax.swing.GroupLayout mapViewLayout = new javax.swing.GroupLayout(mapView);
        mapView.setLayout(mapViewLayout);
        mapViewLayout.setHorizontalGroup(
            mapViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        mapViewLayout.setVerticalGroup(
            mapViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout navigatorLayout = new javax.swing.GroupLayout(navigator.getContentPane());
        navigator.getContentPane().setLayout(navigatorLayout);
        navigatorLayout.setHorizontalGroup(
            navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mapView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        navigatorLayout.setVerticalGroup(
            navigatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mapView, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Advanced Terrain Generation Tool - Untitled World");
        setBounds(new java.awt.Rectangle(100, 100, 550, 900));
        setIconImages(getIconImages());

        canvas.setBackground(new java.awt.Color(0, 0, 0));
        canvas.setDoubleBuffered(false);
        canvas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                canvasMouseClicked(evt);
            }
        });

        layerList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        layerList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Untitled Layer" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        layerList.setSelectedIndices(new int[] {0});
        layerList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                layerListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(layerList);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Layers");

        layerUpButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/up.png"))); // NOI18N
        layerUpButton.setToolTipText("Move up");
        layerUpButton.setEnabled(false);
        layerUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                layerUpButtonActionPerformed(evt);
            }
        });

        layerDownButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/down.png"))); // NOI18N
        layerDownButton.setToolTipText("Move down");
        layerDownButton.setEnabled(false);
        layerDownButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                layerDownButtonActionPerformed(evt);
            }
        });

        editLayerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/edit.png"))); // NOI18N
        editLayerButton.setToolTipText("Edit layer properties");
        editLayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editLayerButtonActionPerformed(evt);
            }
        });

        deleteLayerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/delete.png"))); // NOI18N
        deleteLayerButton.setToolTipText("Delete layer");
        deleteLayerButton.setEnabled(false);
        deleteLayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteLayerButtonActionPerformed(evt);
            }
        });

        regenLayerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/favicon-16.png"))); // NOI18N
        regenLayerButton.setToolTipText("Generator options");
        regenLayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regenLayerButtonActionPerformed(evt);
            }
        });

        addLayerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add.png"))); // NOI18N
        addLayerButton.setToolTipText("Move up");
        addLayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLayerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layerPanelLayout = new javax.swing.GroupLayout(layerPanel);
        layerPanel.setLayout(layerPanelLayout);
        layerPanelLayout.setHorizontalGroup(
            layerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteLayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(layerUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(layerDownButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(editLayerButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(regenLayerButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(addLayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, Short.MAX_VALUE))
                .addContainerGap())
        );
        layerPanelLayout.setVerticalGroup(
            layerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layerPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layerPanelLayout.createSequentialGroup()
                        .addComponent(addLayerButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editLayerButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(layerUpButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(layerDownButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(regenLayerButton)
                        .addGap(26, 26, 26)
                        .addComponent(deleteLayerButton))
                    .addComponent(jScrollPane1))
                .addGap(9, 15, Short.MAX_VALUE))
        );

        applyLayerChangesButton.setText("Apply changes");
        applyLayerChangesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyLayerChangesButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Name");

        jLabel3.setText("Tile");

        editLayerTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        editLayerTitleLabel.setText("Editing 'Untitled Layer'");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/left.png"))); // NOI18N

        layerTileChooser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<no tiles defined>" }));

        javax.swing.GroupLayout editLayerPanelLayout = new javax.swing.GroupLayout(editLayerPanel);
        editLayerPanel.setLayout(editLayerPanelLayout);
        editLayerPanelLayout.setHorizontalGroup(
            editLayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editLayerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(editLayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editLayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(applyLayerChangesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(layerTileChooser, 0, 164, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editLayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(layerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(editLayerTitleLabel)))
                .addContainerGap())
        );
        editLayerPanelLayout.setVerticalGroup(
            editLayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editLayerPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(editLayerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(editLayerTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(layerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(layerTileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(applyLayerChangesButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout canvasLayout = new javax.swing.GroupLayout(canvas);
        canvas.setLayout(canvasLayout);
        canvasLayout.setHorizontalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, canvasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(layerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(editLayerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(285, Short.MAX_VALUE))
        );
        canvasLayout.setVerticalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, canvasLayout.createSequentialGroup()
                .addContainerGap(159, Short.MAX_VALUE)
                .addGroup(canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(layerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editLayerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        fileMenu.setText("File");

        newWorldButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newWorldButton.setText("New world...");
        newWorldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newWorld(evt);
            }
        });
        fileMenu.add(newWorldButton);

        openWorldButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openWorldButton.setText("Open existing world...");
        openWorldButton.setEnabled(false);
        fileMenu.add(openWorldButton);
        fileMenu.add(jSeparator3);

        exportTerrainButton.setText("Export terrain...");
        exportTerrainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportTerrainButtonActionPerformed(evt);
            }
        });
        fileMenu.add(exportTerrainButton);
        fileMenu.add(jSeparator4);

        exitButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        fileMenu.add(exitButton);

        menuBar.add(fileMenu);

        worldMenu.setText("World");

        showNavigatorButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        showNavigatorButton.setText("Navigator...");
        showNavigatorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showNavigatorButtonActionPerformed(evt);
            }
        });
        worldMenu.add(showNavigatorButton);
        worldMenu.add(jSeparator1);

        setSeedButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        setSeedButton.setText("Set seed...");
        setSeedButton.setEnabled(false);
        setSeedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setSeedButtonActionPerformed(evt);
            }
        });
        worldMenu.add(setSeedButton);

        chooseSpriteSheetMenu.setText("Choose tile spritesheet...");

        earthSpritesheetButton.setText("Earth");
        earthSpritesheetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                earthSpritesheetButtonActionPerformed(evt);
            }
        });
        chooseSpriteSheetMenu.add(earthSpritesheetButton);

        marsSpritesheetButton.setText("Mars");
        marsSpritesheetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marsSpritesheetButtonActionPerformed(evt);
            }
        });
        chooseSpriteSheetMenu.add(marsSpritesheetButton);
        chooseSpriteSheetMenu.add(jSeparator2);

        customSpritesheetButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        customSpritesheetButton.setText("Pick a file...");
        customSpritesheetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customSpritesheetButtonActionPerformed(evt);
            }
        });
        chooseSpriteSheetMenu.add(customSpritesheetButton);

        worldMenu.add(chooseSpriteSheetMenu);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Resize world...");
        jMenuItem4.setEnabled(false);
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        worldMenu.add(jMenuItem4);

        menuBar.add(worldMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(canvas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(canvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        return getIconImage(32);
    }

    @Override
    public List<Image> getIconImages() {
        ArrayList<Image> icons = new ArrayList<Image>();
        icons.add(getIconImage(16));
        icons.add(getIconImage(32));
        icons.add(getIconImage(48));
        icons.add(getIconImage(64));
        return icons;
    }

    public Image getIconImage(int size) {
        try {
            InputStream img = GUI.class.getResourceAsStream("/resources/favicon-"+size+".png");
            if (img == null) return null;
            return ImageIO.read(img);
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void customSpritesheetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customSpritesheetButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        int success = chooser.showOpenDialog(gui);
        if (success == JFileChooser.APPROVE_OPTION) {
            File chosen = chooser.getSelectedFile();
            try {
                World.getWorld().setSpritesheet(chosen);
                System.out.println("Set world spritesheet file to "+chosen.getAbsolutePath());
                String tdefs = JOptionPane.showInputDialog(gui, 
                        "Type the name of each tile in order, comma separated:", 
                        "Add tile definitions", JOptionPane.QUESTION_MESSAGE);
                String tdefspl[] = tdefs.split("\\s*,\\s*");
                World.getWorld().setTileNames(tdefspl);
                editLayerPanel.setVisible(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(gui, "You need to choose a valid image file! (.png, .jpg, etc...)", 
                        "Invalid spritesheet", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_customSpritesheetButtonActionPerformed

    private void canvasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_canvasMouseClicked
        canvas.repaint();
    }//GEN-LAST:event_canvasMouseClicked

    private void setSeedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setSeedButtonActionPerformed
        World.getWorld().setSeed(Long.parseLong(JOptionPane.showInputDialog(gui, "Seed (integer):")));
    }//GEN-LAST:event_setSeedButtonActionPerformed

    private void showNavigatorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showNavigatorButtonActionPerformed
        showDialog(navigator, false);
    }//GEN-LAST:event_showNavigatorButtonActionPerformed

    private void navigatorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_navigatorFocusLost
        navigator.setVisible(false);
    }//GEN-LAST:event_navigatorFocusLost

    private void mapViewFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mapViewFocusLost
        navigator.setVisible(false);
    }//GEN-LAST:event_mapViewFocusLost

    private void earthSpritesheetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_earthSpritesheetButtonActionPerformed
        World.getWorld().setSpritesheet(new File("src/resources/samples/terrain/earth.png"));
        World.getWorld().setTileNames(new String[]{"Stone", "Lava", "Sand", "Dirt", "Grass", "Snow", "Ice", "Water", "Tree", "Rocks"});
        editLayerPanel.setVisible(false);
    }//GEN-LAST:event_earthSpritesheetButtonActionPerformed

    private void marsSpritesheetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marsSpritesheetButtonActionPerformed
        World.getWorld().setSpritesheet(new File("src/resources/samples/terrain/mars.png"));
        World.getWorld().setTileNames(new String[]{"Sand", "Ice", "Rocks"});
        editLayerPanel.setVisible(false);
    }//GEN-LAST:event_marsSpritesheetButtonActionPerformed

    private void exportTerrainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportTerrainButtonActionPerformed
        JFileChooser saver = new JFileChooser();
        saver.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int success = saver.showSaveDialog(gui);
        if (success == JFileChooser.APPROVE_OPTION) {
            boolean saved = World.getWorld().exportTerrain(saver.getSelectedFile());
            JOptionPane.showMessageDialog(gui, 
                    saved ? "Terrain data has been exported!" : "Error exporting terrain data!", 
                    saved ? "Success" : "Error",
                    JOptionPane.INFORMATION_MESSAGE, new ImageIcon(gui.getIconImage(32)));
        }
        
    }//GEN-LAST:event_exportTerrainButtonActionPerformed

    private void layerUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_layerUpButtonActionPerformed
        World.getWorld().reorderLayer(layerList.getSelectedIndex(), -1);
        canvas.repaint();
        refreshLayerList();
    }//GEN-LAST:event_layerUpButtonActionPerformed

    private void layerDownButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_layerDownButtonActionPerformed
        World.getWorld().reorderLayer(layerList.getSelectedIndex(), 1);
        canvas.repaint();
        refreshLayerList();
    }//GEN-LAST:event_layerDownButtonActionPerformed

    private void editLayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editLayerButtonActionPerformed
        editLayerPanel.setVisible(true);
        canvas.repaint();
        editLayerTitleLabel.setText("Editing '"+World.getWorld().getLayerProperty("name", layerList.getSelectedIndex())+"'");
    }//GEN-LAST:event_editLayerButtonActionPerformed

    private void deleteLayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteLayerButtonActionPerformed
        int index = layerList.getSelectedIndex();
        World.getWorld().removeLayer(index);
        gui.refreshLayerList();
        layerList.setSelectedIndex(index < layerList.getModel().getSize() ? index 
                : layerList.getModel().getSize() - 1);
        canvas.repaint();
    }//GEN-LAST:event_deleteLayerButtonActionPerformed

    private void regenLayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regenLayerButtonActionPerformed
        String s = JOptionPane.showInputDialog(gui, "Parameters:", 
                World.getWorld().getLayerProperty("lastcmd", Canvas.layer()));
        if (s == null) return; s = s.trim();
        World.getWorld().setLayerProperty("lastcmd", s, Canvas.layer());
        //split by colon
        String split[] = s.split("\\s*:\\s*");
        if (split.length == 0) { System.err.println("Invalid input!"); return; }
        //find generator type
        String gname = split[0].trim(); 
        Generator g = Generator.getGenerator(gname);
        
        if (split.length > 1) { //if params actually exist
            String params = split[1].trim();
            System.out.println(gname);
            //find parameters
            String[] params_spl = params.split("\\s*,\\s*");
            if (g == null) { System.err.println("Generator '"+gname+"' not found!"); return; }
            for (int i = 0; i < params_spl.length; i++) {
                String spl[] = params_spl[i].split("\\s*=\\s*");
                String name = spl[0]; String val = spl[1];
                g.setParameter(name, val);
                System.out.println(gname+" parameter: "+name+" = "+val);
            }
        }
        
        //clear and generate
        World.getWorld().clearTiles(layerList.getSelectedIndex());
        g.generate(World.getWorld(), layerList.getSelectedIndex());
        //repaint
        canvas.repaint();
    }//GEN-LAST:event_regenLayerButtonActionPerformed

    private void addLayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLayerButtonActionPerformed
        World.getWorld().addLayer();
        gui.refreshLayerList();
        layerList.setSelectedIndex(0);
        canvas.repaint();
        layerList.ensureIndexIsVisible(layerList.getSelectedIndex());
    }//GEN-LAST:event_addLayerButtonActionPerformed

    private void layerListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_layerListValueChanged
        if (evt.getFirstIndex() == -1) layerList.setSelectedIndex(0);
        int scount = evt.getLastIndex() - evt.getFirstIndex();
        editLayerPanel.setVisible(false);
    }//GEN-LAST:event_layerListValueChanged

    private void applyLayerChangesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyLayerChangesButtonActionPerformed
        if (layerNameField.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(gui, "You cannot have a blank layer name!", 
                        "Invalid name", JOptionPane.ERROR_MESSAGE);
            return;
        }
        World.getWorld().setLayerProperty("name", layerNameField.getText(), layerList.getSelectedIndex());
        World.getWorld().setLayerProperty("tile", 
                layerTileChooser.getSelectedIndex(), layerList.getSelectedIndex());
        canvas.repaint();
        refreshLayerList();
        editLayerPanel.setVisible(false);
    }//GEN-LAST:event_applyLayerChangesButtonActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        String input = JOptionPane.showInputDialog(gui, 
                        "Enter the new world size (i.e. \"64, 64\")", 
                        "Resize world", JOptionPane.QUESTION_MESSAGE);
        String[] dims = input.split("\\s*,\\s*");
        World.getWorld().resize(Integer.parseInt(dims[0]), Integer.parseInt(dims[1]));
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    public static void showDialog(JDialog d, boolean modal) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        d.setLocation(gui.getX() + (int) (gui.getWidth() / 2) - (d.getWidth() / 2),
                gui.getY() + (int) (gui.getHeight() / 2) - ((d.getHeight() / 2)));
        d.setModal(modal);
        d.setModalityType(modal ? Dialog.ModalityType.APPLICATION_MODAL : Dialog.ModalityType.MODELESS);
        d.setVisible(true);
        System.out.println("Showing " + d.getTitle());
    }
    
    public void refreshLayerList() {
        DefaultListModel m = new DefaultListModel();
        int index = layerList.getSelectedIndex();
        for (int i = 0; i < World.getWorld().layerCount(); i++) 
            m.addElement(World.getWorld().getLayerProperty("name", i));
        layerList.setModel(m);
        layerList.setSelectedIndex(index);
        deleteLayerButton.setEnabled(World.getWorld().layerCount() > 1);
        
        layerNameField.setText((String)World.getWorld().getLayerProperty("name", layerList.getSelectedIndex()));
        DefaultComboBoxModel<String> md = new DefaultComboBoxModel<String>();
        for (String tile: World.getWorld().getTileNames()) md.addElement(tile);
        if (m.getSize() == 0) md.addElement("<no tiles defined>");
        layerTileChooser.setModel(md);
        layerTileChooser.setSelectedIndex((Integer)World.getWorld().getLayerProperty("tile", layerList.getSelectedIndex()));
        
        //layerUpButton.setEnabled(layerList.getSelectedIndex() > 0);
        //layerDownButton.setEnabled(layerList.getSelectedIndex() < m.getSize() - 1);
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
                gui.refreshLayerList();
            }
        });
    }
    
    protected static Canvas getCanvas() { return gui == null ? null : gui.canvas; }
    protected static MiniMap getMiniMap() { return gui == null ? null : gui.mapView; }
    protected static JList getLayerList() { return layerList; }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addLayerButton;
    private javax.swing.JButton applyLayerChangesButton;
    private gui.Canvas canvas;
    private javax.swing.JMenu chooseSpriteSheetMenu;
    private javax.swing.JMenuItem customSpritesheetButton;
    private javax.swing.JButton deleteLayerButton;
    private javax.swing.JMenuItem earthSpritesheetButton;
    private javax.swing.JButton editLayerButton;
    private javax.swing.JPanel editLayerPanel;
    private javax.swing.JLabel editLayerTitleLabel;
    private javax.swing.JMenuItem exitButton;
    private javax.swing.JMenuItem exportTerrainButton;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JButton layerDownButton;
    private static javax.swing.JList<String> layerList;
    private javax.swing.JTextField layerNameField;
    private javax.swing.JPanel layerPanel;
    private javax.swing.JComboBox<String> layerTileChooser;
    private javax.swing.JButton layerUpButton;
    private gui.MiniMap mapView;
    private javax.swing.JMenuItem marsSpritesheetButton;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JDialog navigator;
    private javax.swing.JMenuItem newWorldButton;
    private javax.swing.JMenuItem openWorldButton;
    private javax.swing.JButton regenLayerButton;
    private javax.swing.JMenuItem setSeedButton;
    private javax.swing.JMenuItem showNavigatorButton;
    private javax.swing.JMenu worldMenu;
    // End of variables declaration//GEN-END:variables
}
