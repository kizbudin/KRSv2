/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbokrs;

import api.stta.bahrie.inter.DetailKrsInterf;
import api.stta.bahrie.inter.DosenInterf;
import api.stta.bahrie.inter.MahasiswaInterf;
import api.stta.bahrie.inter.MkInterf;
import api.stta.bahrie.inter.WaktuKrsInterf;
import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import stta.bahrie.admin.gui.MainAdmin;
import stta.bahrie.gui.MenuUtama;
import stta.bahrie.implementserviceserver.ImplDetailKrs;
import stta.bahrie.implementserviceserver.ImplDosen;
import stta.bahrie.implementserviceserver.ImplMahasiswa;
import stta.bahrie.implementserviceserver.ImplMk;
import stta.bahrie.implementserviceserver.ImplWaktuKrs;
import stta.bahrie.krsdosen.Gui.MenuForDosen;

public class PBOKRS {
  
        // TODO code application logic here
        public static void main(String[] args)throws RemoteException, NotBoundException, MalformedURLException {
        
        Registry server = LocateRegistry.createRegistry(4321);
        ImplDetailKrs detailServer=new ImplDetailKrs();
        server.rebind("detailServer", detailServer);

        ImplDosen dosenServer=new ImplDosen();
        server.rebind("dosenServer", dosenServer);

        ImplMahasiswa mhsServer=new ImplMahasiswa();
        server.rebind("mhsServer", mhsServer);

        ImplMk mkServer=new ImplMk();
        server.rebind("mkServer", mkServer);

        ImplWaktuKrs waktuServer=new ImplWaktuKrs();
        server.rebind("waktuServer", waktuServer);

        System.out.println("server jalan bro");
        
        String host="localhost";
//        Registry registry=LocateRegistry.getRegistry("localhost",4321);
//        final MahasiswaInterf mhsService=(MahasiswaInterf) registry.lookup("mhsServer");
//        final MkInterf mkService=(MkInterf) registry.lookup("mkServer");
//        final DosenInterf dsnService=(DosenInterf) registry.lookup("dosenServer");
        final MahasiswaInterf mhsService=(MahasiswaInterf) Naming.lookup("rmi://"+host+":4321/mhsServer");
        final MkInterf mkService=(MkInterf) Naming.lookup("rmi://"+host+":4321/mkServer");
        final DosenInterf dsnService=(DosenInterf) Naming.lookup("rmi://"+host+":4321/dosenServer");
        System.out.println("Client Admin jalan juga bro");
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PBOKRS.class.getName()).log(Level.SEVERE, null, ex);
        }
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                try {
                    MainAdmin mainAd=new MainAdmin(dsnService, mhsService, mkService);
                    mainAd.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    mainAd.setLocationRelativeTo(null);
                    mainAd.setVisible(true);
                } catch (Throwable ex) {
                    Logger.getLogger(PBOKRS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Registry registry = LocateRegistry.getRegistry("localhost", 4321);
        final DetailKrsInterf detailService = (DetailKrsInterf) registry.lookup("detailServer");
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PBOKRS.class.getName()).log(Level.SEVERE, null, ex);
        }
        MenuForDosen menu = new MenuForDosen(mhsService, mkService, dsnService, detailService);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        final WaktuKrsInterf wktuSevice=(WaktuKrsInterf) registry.lookup("waktuServer");
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(PBOKRS.class.getName()).log(Level.SEVERE, null, ex);
        }
        MenuUtama menu1=new MenuUtama(mhsService, dsnService, mkService, wktuSevice,detailService);
        menu.setLocationRelativeTo(null);
        menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
      
        menu1.setVisible(true);
    } 
}
    
