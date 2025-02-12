import classes.User;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("mm");
        User usuario = new User();


        while (true) {
            System.out.print("Por favor, digite seu nome: ");
            usuario.setNome(sc.nextLine());

            while (true){
                System.out.println("Bem-vindo, " + usuario.getNome() + ". Por favor, escolha uma opção: ");
                System.out.println("1. Iniciar atendimento");
                System.out.println("2. Finalizar o sistema");

                int inicializacao = sc.nextInt();

                if (inicializacao == 1){
                    System.out.println("Tem certeza que deseja iniciar o atendimento? (s/n)");
                    char escolha = sc.next().toUpperCase().charAt(0);
                    sc.nextLine();

                    if (escolha == 'S'){
                        LocalTime hora = LocalTime.now();
                        System.out.println("Bem vindo ao sistema de suporte, como podemos ajudar?");
                        String resposta = sc.nextLine();
                        System.out.println("Seu pedido de ajuda foi registrado, deseja finalizar o chamado ou páusa-lo? (finalizar/pausar)");
                        String finalizacao = sc.nextLine();
                        if (finalizacao.equalsIgnoreCase("finalizar")){
                            LocalTime horaFinal = LocalTime.now();
                            System.out.println(horaFinal);
                            LocalTime total = hora.minusMinutes(horaFinal.getMinute());
                            String decorrido = dtf.format(total);
                            System.out.println("Olá, " + usuario.getNome() + ", seu chamado levou " + decorrido + " minutos" );
                            break;
                        }else if (finalizacao.equalsIgnoreCase("pausar")){

                        }

                    }else if (escolha == 'N'){
                        break;
                    }
                }else if (inicializacao == 2){
                    System.out.println("O sistema será finalizado");
                    System.exit(0);
                }
            }
        }



    }
}