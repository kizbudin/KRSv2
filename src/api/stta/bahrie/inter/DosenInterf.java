/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package api.stta.bahrie.inter;

import api.stta.bahrie.entiy.Dosen;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author bahrie
 */
public interface DosenInterf extends Remote{

    Dosen insert(Dosen o) throws RemoteException;

    void update(Dosen o)throws RemoteException;

    void delete(String id) throws RemoteException;

    Dosen getByKd(String kd)throws RemoteException;

    List<Dosen> getAll() throws RemoteException;

}
