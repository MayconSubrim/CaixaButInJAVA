import java.util.Scanner;

class Main {

    /* Aqui criamos uma variavel global. Global significa que o elemento pode ser acessado por qualquer método. Para tornar global, utilizamos a palavra static.
     */
    static double saldo = 100;
    static String nome = "";
    static Scanner scan = new Scanner(System.in);
    static int senha = 3589;

    /*  Um método simples que só exibe uma mensagem ao usuário e em seguida chama a função principal. */
    public static void ver_saldo() {
        System.out.println("Inforem a senha por favor:");
        int checasenha = scan.nextInt();
        while (checasenha != senha){
            System.out.println("Inforem a senha por favor:");
            checasenha = scan.nextInt();
        }
        System.out.println("Seu saldo atual é: " + saldo);

        //O método "main" pode receber comandos diretamente da linha de comando. Quando isso não ocorre, usamos a palavra "null" para avisar que nada será passado
        escolhas();
    }

    /*  Método para receber informado pelo usuário, processar e levar a uma mensagem de sucesso ou a repetição da função */
    public static void fazer_deposito() {
        System.out.println("Inforem a senha por favor:");
        int checasenha = scan.nextInt();
        while (checasenha != senha){
            System.out.println("Inforem a senha por favor:");
            checasenha = scan.nextInt();
        }

        System.out.println("Qual o valor a ser depositado?");
        Scanner valor = new Scanner(System.in);
        Double deposito = valor.nextDouble();

        // Not a Number
        boolean checaNumero = deposito.isNaN(); // o método isNaN retorna checa se o valor informado é um Não-Número e retorna verdadeiro ou falso.

        if (checaNumero || deposito <= 0) {
            System.out.println("Por favor, informe um número válido:");
            fazer_deposito();
        } else {
            saldo += deposito;
            ver_saldo();
        }

        valor.close();
    }

    public static void fazer_saque() {
        System.out.println("Inforem a senha por favor:");
        int checasenha = scan.nextInt();
        while (checasenha != senha){
            System.out.println("Inforem a senha por favor:");
            checasenha = scan.nextInt();
        }
        System.out.println("Qual o valor para saque?");
        Scanner valor = new Scanner(System.in);
        Double saque = valor.nextDouble();

        boolean checaNumero = saque.isNaN();

        if (checaNumero || saque < 0 || saldo < saque) {
            System.out.println("Por favor, informe um número válido:");
            fazer_saque();
        } else {
            saldo -= saque;
            ver_saldo();

            valor.close();
        }
    }

    public static void erro() {
        System.out.println("Por favor, informe um número entre 1 e 6");
        escolhas();
    }

    public static void sair() {
        System.out.println("Você deseja sair? S/N");

        Scanner sair = new Scanner(System.in);
        String escolha = sair.nextLine();

        if (escolha.equals("S")) {
            System.out.println(nome + ", foi um prazer ter você por aqui!");
            System.exit(0);
        } else if (escolha.equals("N")) {
            escolhas();
        } else {
            System.out.println("Desculpe, mas não compreendi.");
            sair();
        }

        sair.close();

    }

    public static void escolhas(){
        System.out.println("Selecione uma opção:\n 1.)saldo;\n 2.)Extrato;\n 3.)Saque;\n 4.)Depósito;\n 5.)Transferência;\n 6.)Sair. ");

        Scanner in = new Scanner(System.in);
        int escolha = in.nextInt();

        switch (escolha){
            case 1:
                ver_saldo();
                break;
            case 2:
                extrato();
                break;
            case 3:
                fazer_saque();
                break;
            case 4:
                fazer_deposito();
                break;
            case 5:
                tranf();
                break;
            case 6:
                sair();
            default:
                erro();
                
        }
    }

    private static void tranf() {
        System.out.println("Inforem a senha por favor:");
        int checasenha = scan.nextInt();
        while (checasenha != senha){
            System.out.println("Inforem a senha por favor:");
            checasenha = scan.nextInt();
        }

        System.out.println("informe a conta de destino");
        Double conta = scan.nextDouble();
        boolean checaConta = conta.isNaN();
        if (checaConta){
            System.out.println("operação invalida!");
            tranf();
        }

        System.out.println("Qual o valor para trasnferir?");
        Double saque = scan.nextDouble();
        boolean checaNumero = saque.isNaN();

        if (checaNumero || saque < 0 || saldo < saque) {
            System.out.println("Por favor, informe um número válido:");
            tranf();
        } else {
            saldo -= saque;
            ver_saldo();
        }
    }

    private static void extrato() {
        System.out.println("Inforem a senha por favor:");
        int checasenha = scan.nextInt();
        while (checasenha != senha){
            System.out.println("Inforem a senha por favor:");
            checasenha = scan.nextInt();
        }
        System.out.println("Seu extrato:\n TED agencias: -100\n pix claudin: -150\n pix para voce: +100");
        escolhas();
    }

    public static void main(String[] args) {
        System.out.println("informa seu usuario");
        nome = scan.nextLine();
        System.out.println("Olá " + nome + "é um prazer ter você por aqui!");
        escolhas();
    }


}