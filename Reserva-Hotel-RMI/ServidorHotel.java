import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class ServidorHotel extends UnicastRemoteObject implements GerenciadorQuartos {
    private Map<Integer, Integer> totalQuartos;
    private Map<Integer, Integer> disponiveis;
    private List<String> listaHospedes;

    public ServidorHotel() throws RemoteException {
        totalQuartos = new HashMap<>();
        disponiveis = new HashMap<>();
        listaHospedes = new ArrayList<>();

        totalQuartos.put(0, 10);
        totalQuartos.put(1, 20);
        totalQuartos.put(2, 5);
        totalQuartos.put(3, 3);
        totalQuartos.put(4, 2);

        disponiveis.putAll(totalQuartos);
    }

    public synchronized String listagem() throws RemoteException {
        StringBuilder sb = new StringBuilder();
        sb.append("Quartos disponíveis:\n");
        for (int tipo = 0; tipo <= 4; tipo++) {
            sb.append("Tipo ").append(tipo).append(": ")
              .append(disponiveis.get(tipo)).append(" disponíveis\n");
        }
        return sb.toString();
    }

    public synchronized String reserva(int tipo, String nomeHospede) throws RemoteException {
        if (!disponiveis.containsKey(tipo)) {
            return "Tipo de quarto inexistente.";
        }

        if (disponiveis.get(tipo) > 0) {
            disponiveis.put(tipo, disponiveis.get(tipo) - 1);
            listaHospedes.add(nomeHospede + " (Tipo " + tipo + ")");
            return "Reserva confirmada para " + nomeHospede + ".";
        }

        return "Nenhum quarto disponível para o tipo informado.";
    }

    public synchronized List<String> hospedes() throws RemoteException {
        return new ArrayList<>(listaHospedes);
    }

    public static void main(String[] args) {
        try {
            GerenciadorQuartos hotel = new ServidorHotel();
            Naming.rebind("rmi://localhost:1099/hotel", hotel);
            System.out.println("Servidor do hotel iniciado.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
