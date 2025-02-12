import classes.User;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        User usuario = new User();

        System.out.print("Por favor, digite seu nome: ");
        usuario.setNome(sc.nextLine());
        System.out.println("Bem-vindo, " + usuario.getNome() + ". Por favor, escolha uma opção: ");
        System.out.println("1. Iniciar atendimento");
        System.out.println("2. Finalizar o sistema");



    }
}