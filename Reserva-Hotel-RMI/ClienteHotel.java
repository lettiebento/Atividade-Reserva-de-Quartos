import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class ClienteHotel {
    public static void main(String[] args) {
        try {
            GerenciadorQuartos hotel = (GerenciadorQuartos) Naming.lookup("rmi://localhost:1099/hotel");
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n--- Menu ---");
                System.out.println("1 - Listar quartos disponíveis");
                System.out.println("2 - Reservar quarto");
                System.out.println("3 - Ver hóspedes");
                System.out.println("0 - Sair");
                System.out.print("Escolha: ");
                int opcao = sc.nextInt();
                sc.nextLine();

                if (opcao == 1) {
                    System.out.println(hotel.listagem());
                } else if (opcao == 2) {
                    System.out.print("Tipo de quarto (0 a 4): ");
                    int tipo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nome do hóspede: ");
                    String nome = sc.nextLine();
                    System.out.println(hotel.reserva(tipo, nome));
                } else if (opcao == 3) {
                    List<String> hospedes = hotel.hospedes();
                    if (hospedes.isEmpty()) {
                        System.out.println("Nenhum hóspede registrado.");
                    } else {
                        System.out.println("Hóspedes:");
                        for (String h : hospedes) {
                            System.out.println(" - " + h);
                        }
                    }
                } else if (opcao == 0) {
                    break;
                } else {
                    System.out.println("Opção inválida.");
                }
            }

            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
