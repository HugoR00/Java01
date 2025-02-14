import classes.User;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        User usuario = new User();


        while (true) {
            System.out.print("Por favor, digite seu nome: ");
            usuario.setNome(sc.nextLine());


            while (true){
                System.out.println("Bem-vindo, " + usuario.getNome() + ". Por favor, escolha uma opção: ");
                System.out.println("1. Iniciar atendimento");
                System.out.println("2. Finalizar o sistema");
                System.out.println("3. Retornar ao menu de escrita do nome");

                int inicializacao = sc.nextInt();
                sc.nextLine();

                if (inicializacao == 1){
                    System.out.println("Tem certeza que deseja iniciar o atendimento? (s/n)");
                    char escolha = sc.next().toUpperCase().charAt(0);
                    sc.nextLine();

                    while (true){
                        if (escolha == 'S'){
                            Instant horaInicio = Instant.now();

                            System.out.println("Bem vindo ao sistema de suporte, como podemos ajudar?(digite sair caso queira sair)");
                            String resposta = sc.nextLine();
                            if (resposta.equalsIgnoreCase("sair")){
                                break;
                            }
                            System.out.println("Seu pedido de ajuda foi registrado, deseja finalizar o chamado ou páusa-lo? (finalizar/pausar)");
                            String finalizacao = sc.nextLine();
                            while (true){
                                if (finalizacao.equalsIgnoreCase("pausar")) {
                                    System.out.println("O seu chamado será pausado!");
                                    Instant horaPause = Instant.now();
                                    System.out.println("Caso deseje despausar, digite 'despausar'!");
                                    String despause = sc.nextLine();
                                    if (despause.equalsIgnoreCase("despausar")) {
                                        System.out.println("Seu chamado será despausado!");
                                        Instant horaDespause = Instant.now();
                                        Duration tempoPause = Duration.between(horaPause,horaDespause);
                                        System.out.println(tempoPause.toMinutes());
                                        break;
                                    }
                                }else if (finalizacao.equalsIgnoreCase("finalizar")){
                                    Instant horaFinal = Instant.now();
                                    Duration tempoChamado = Duration.between(horaInicio,horaFinal);
                                    System.out.println("Olá, " + usuario.getNome() + ", seu chamado levou " + tempoChamado + " minuto(s)" );
                                    break;
                                }

                            }

                        }else if (escolha == 'N'){
                            break;
                        }
                    }
                }else if (inicializacao == 2){
                    System.out.println("O sistema será finalizado");
                    System.exit(0);

                }
                else if (inicializacao == 3){
                    break;
                }
            }
        }



    }
}