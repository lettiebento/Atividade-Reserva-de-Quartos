import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface GerenciadorQuartos extends Remote {
    String listagem() throws RemoteException;
    String reserva(int tipo, String nomeHospede) throws RemoteException;
    List<String> hospedes() throws RemoteException;
}
