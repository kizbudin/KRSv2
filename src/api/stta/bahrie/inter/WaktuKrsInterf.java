/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package api.stta.bahrie.inter;

import api.stta.bahrie.entiy.WaktuKrs;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author bahrie
 */
public interface WaktuKrsInterf extends Remote{

    WaktuKrs insert(WaktuKrs o) throws RemoteException;

    void update(WaktuKrs o)throws RemoteException;

    void delete(int id) throws RemoteException;

    WaktuKrs getById(int id)throws RemoteException;

    List<WaktuKrs> getAll() throws RemoteException;

    WaktuKrs getByNim(String nim) throws RemoteException;

}
