/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MenuForDosen.java
 *
 * Created on Oct 17, 2010, 7:22:35 AM
 */
package stta.bahrie.krsdosen.Gui;

import api.stta.bahrie.entiy.DetailKrs;
import api.stta.bahrie.entiy.Dosen;
import api.stta.bahrie.entiy.Mahasiswa;
import api.stta.bahrie.entiy.Mk;
import api.stta.bahrie.entiy.WaktuKrs;
import api.stta.bahrie.inter.DetailKrsInterf;
import api.stta.bahrie.inter.DosenInterf;
import api.stta.bahrie.inter.MahasiswaInterf;
import api.stta.bahrie.inter.MkInterf;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bahrie
 */
public class MenuForDosen extends javax.swing.JFrame {

    /** Creates new form MenuForDosen */
    private Mahasiswa mhsPerson = new Mahasiswa();
    private Dosen dsnPerson = new Dosen();
    private List<Mahasiswa> listMhs = new ArrayList<Mahasiswa>();
    private List<Mk> mk2List = new ArrayList<Mk>();
    private List<DetailKrs> detailList = new ArrayList<DetailKrs>();
    private MahasiswaInterf mhsService;
    private DosenInterf dsnService;
    private MkInterf mkService;
    private DetailKrsInterf detailService;

    public MenuForDosen(MahasiswaInterf mhsService, MkInterf mksService, DosenInterf dsnService, DetailKrsInterf detailService) {
        try {
            //        try {
            this.mhsService = mhsService;
            this.mkService = mksService;
            this.dsnService = dsnService;
            this.detailService = detailService;
            initComponents();
            this.statusAwal();
            //            tableDibimbing.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            //
            //                public void valueChanged(ListSelectionEvent e) {
            //             int indek=tableDibimbing.getSelectedRow();
            //             if(indek!=-1){
            //                        try {
            //                            mhsPerson = listMhs.get(indek);
            //                            loadKrs();
            //                            isitabelKrs();
            //                        } catch (RemoteException ex) {
            //                            Logger.getLogger(MenuForDosen.class.getName()).log(Level.SEVERE, null, ex);
            //                        }
            //             }
            //                }
            //            });
            //
        } catch (RemoteException ex) {
            Logger.getLogger(MenuForDosen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void menuPanel(boolean status) {
        jPanel1.setVisible(status);
        jPanel2.setVisible(status);
        jPanel3.setVisible(status);
        jPanel4.setVisible(status);

    }

    void statusAwal() throws RemoteException {
        this.menuPanel(false);
        this.logoutMenu.setEnabled(false);
    }

    void isitabelKrs() {
        Object data[][] = new Object[mk2List.size()][4];
        int x = 0;
        for (Mk mk : mk2List) {
            data[x][0] = mk.getKd_mk();
            data[x][1] = mk.getMk();
            data[x][2] = mk.getSks();
            data[x][3] = mk.getJurusan();
            // System.out.println(mk.getKd_mk());
            x++;
        }
        String[] judul = {"Kode", "Nama", "Sks", "Jurusan"};
        tableMkygDiambil.setModel(new DefaultTableModel(data, judul));
        jScrollPane2.setViewportView(tableMkygDiambil);
    }

    void loadKrs() throws RemoteException {
        detailList = detailService.getByNim(mhsPerson.getNim());
        for (int a = 0; a < detailList.size(); a++) {
            Mk mk = mkService.getByMk(detailList.get(a).getKd_mk());

            mk2List.add(mk);
        }
        System.out.println(detailList.size());
    }

    void isiTabelMhs() {
        Object data[][] = new Object[listMhs.size()][4];
        int x = 0;
        for (Mahasiswa mhs : listMhs) {
            data[x][0] = mhs.getNim();
            data[x][1] = mhs.getNama();
            data[x][2] = mhs.getProdi();
            data[x][3] = mhs.getJumlah_krs();
            x++;
        }
        String[] judul = {"NPM", "Nama", "Jurusan", "Jumlah SKS"};
        tableDibimbing.setModel(new DefaultTableModel(data, judul));
        jScrollPane1.setViewportView(tableDibimbing);
    }

    private boolean isValidUser(String kode, String password) throws RemoteException {


        Dosen dsn = dsnService.getByKd(kode);
        if (dsn != null) {
            if (dsn.getKd_dosen().equals(kode) && dsn.getPwd().equals(password)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        txtKdDosen = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        txtPwd = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDibimbing = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNim = new javax.swing.JTextField();
        cariButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMkygDiambil = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loginMenu = new javax.swing.JMenuItem();
        logoutMenu = new javax.swing.JMenuItem();
        exitMenu = new javax.swing.JMenuItem();

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel8.setText("Password");

        jLabel7.setText("Kode Dosen");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPwd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(txtKdDosen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                .addContainerGap())
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtKdDosen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Untuk Dosen");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Mahasiswa Yang Di Bimbing"));

        tableDibimbing.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableDibimbing);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 223, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(13, Short.MAX_VALUE)))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pencarian Mahasiswa"));

        jLabel1.setText("NPM :");

        cariButton.setText("Cari");
        cariButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNim, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cariButton, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cariButton))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Mata Kuliah Yang Di Ambil"));

        tableMkygDiambil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tableMkygDiambil);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tombol Lihat"));

        jButton1.setText("Lihat KRS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("File");

        loginMenu.setText("Login");
        loginMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginMenuActionPerformed(evt);
            }
        });
        jMenu1.add(loginMenu);

        logoutMenu.setText("Logout");
        logoutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutMenuActionPerformed(evt);
            }
        });
        jMenu1.add(logoutMenu);

        exitMenu.setText("Exit");
        exitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuActionPerformed(evt);
            }
        });
        jMenu1.add(exitMenu);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        try {
            // TODO add your handling code here:
            if (isValidUser(txtKdDosen.getText().toUpperCase(), String.valueOf(txtPwd.getText()).toUpperCase())) {
                this.dsnPerson = dsnService.getByKd(txtKdDosen.getText().toUpperCase());
                if (dsnPerson != null) {
                    this.setTitle("Login : " + dsnPerson.getDosen());
                }
                this.menuPanel(true);
                loginMenu.setEnabled(false);
                logoutMenu.setEnabled(true);

                listMhs = mhsService.getByDosen(txtKdDosen.getText().toUpperCase());
                this.isiTabelMhs();
                System.out.println(dsnPerson.getDosen());
                txtKdDosen.setText("");
                txtPwd.setText("");
                jDialog1.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "kesalahan Login");
                txtKdDosen.setText("");
                txtPwd.setText("");
                txtKdDosen.requestFocus();
            }
        } catch (RemoteException ex) {
            Logger.getLogger(MenuForDosen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void loginMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginMenuActionPerformed
        // TODO add your handling code here:
        txtKdDosen.requestFocus();
        jDialog1.setSize(350, 140);
        jDialog1.setLocationRelativeTo(null);
        jDialog1.setVisible(true);
    }//GEN-LAST:event_loginMenuActionPerformed

    private void logoutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutMenuActionPerformed
        // TODO add your handling code here:
        mk2List.clear();
        listMhs.clear();

        menuPanel(false);
        loginMenu.setEnabled(true);
        logoutMenu.setEnabled(false);
    }//GEN-LAST:event_logoutMenuActionPerformed

    private void cariButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariButtonActionPerformed
        try {
            // TODO add your handling code here:
            mk2List.clear();
            mhsPerson.setNim(txtNim.getText());
            loadKrs();
            if(mk2List.size()==0){
                JOptionPane.showMessageDialog(null, "Blum ada data KRS yang diambil", "Kosong", JOptionPane.INFORMATION_MESSAGE);
                txtNim.setText("");
            }
            isitabelKrs();
            txtNim.setText("");
        } catch (RemoteException ex) {
            Logger.getLogger(MenuForDosen.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_cariButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        mk2List.clear();
        int indek = tableDibimbing.getSelectedRow();
        if (indek != -1) {
            try {
                mhsPerson = listMhs.get(indek);
                loadKrs();
                isitabelKrs();
            } catch (RemoteException ex) {
                Logger.getLogger(MenuForDosen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        txtKdDosen.setText("");
        txtPwd.setText("");
        jDialog1.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void exitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuActionPerformed
        // TODO add your handling code here:
        System.exit(1);
    }//GEN-LAST:event_exitMenuActionPerformed
        /**
         * @param args the command line arguments
         */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton cariButton;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton loginButton;
    private javax.swing.JMenuItem loginMenu;
    private javax.swing.JMenuItem logoutMenu;
    private javax.swing.JTable tableDibimbing;
    private javax.swing.JTable tableMkygDiambil;
    private javax.swing.JTextField txtKdDosen;
    private javax.swing.JTextField txtNim;
    private javax.swing.JPasswordField txtPwd;
    // End of variables declaration//GEN-END:variables
}
