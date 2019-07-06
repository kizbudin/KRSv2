/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package api.stta.bahrie.inter;

import api.stta.bahrie.entiy.Mk;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author bahrie
 */
public interface MkInterf extends Remote{

    Mk insert(Mk o) throws RemoteException;

    void update(Mk o)throws RemoteException;

    void delete(String id) throws RemoteException;

    Mk getByMk(String kode)throws RemoteException;

    List<Mk> getAll() throws RemoteException;

    List<Mk> getByProdi(String prodi) throws RemoteException;

}
