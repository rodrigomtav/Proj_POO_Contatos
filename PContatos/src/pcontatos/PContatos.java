package pcontatos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class PContatos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Pessoa> contatos = new ArrayList<>();
        int opc=1;
        String aux;

        Leitor(contatos);

        do{
            System.out.println(">>> MENU PRINCIPAL <<<");
            System.out.println("1 - Adicionar um Contato");
            System.out.println("2 - Localizar Contato");
            System.out.println("3 - Imprimir Contatos");
            System.out.println("4 - Remover Contato");
            System.out.println("0 - Sair");
            System.out.print("Informe a opção desejada: ");
            aux = sc.nextLine();
            opc = Integer.parseInt(aux);
            
            switch(opc){
                case 1: contatos.add(Ler_Pessoa());
                    break;
                case 2: Localizar_Contato(contatos);
                    break;
                case 3: Print_Contatos(contatos);
                    break;
                case 4: Remover_Contato(contatos);
                    break;
                case 0: System.out.println("TCHAU!");
                    break;
                default:  System.out.println("Opcao Inválida!");
                    break;
            }
            System.out.println("Pressione ENTER para continuar...");
            sc.nextLine();
        }while(opc!=0);
        System.out.println("FIM DO PROGRAMA");
        Escritor(contatos);

    }

    private static Pessoa Ler_Pessoa() {
        String nome, telefone, email, cidade;
        Scanner sc = new Scanner(System.in);
        System.out.println("INFORMANDO DADOS DE UM NOVO CONTATO:");
        System.out.print("Informe o Nome: ");
        nome = sc.nextLine();
        System.out.print("Informe o Telefone: ");
        telefone = sc.nextLine();
        System.out.print("Informe o Email: ");
        email = sc.nextLine();
        System.out.print("Informe a Cidade: ");
        cidade = sc.nextLine();
        
        return new Pessoa(nome, telefone, email, cidade);

    }

    private static void Print_Contatos(ArrayList<Pessoa> contatos) {
        System.out.println(">>> LISTA DE CONTATOS <<<");
        for(Pessoa contato : contatos){
            System.out.println(contato.toString());
        }
    }

    private static void Localizar_Contato(ArrayList<Pessoa> contatos) {
        String nome = JOptionPane.showInputDialog("Digite o Nome Para localizar:");
        boolean achou = false;
        for(Pessoa contato : contatos){
            if (nome.equalsIgnoreCase(contato.getNome())){
                System.out.println("CONTATO LOCALIZADO:"+contato.toString());
                achou = true;
            }
        }
        if(!achou){
            System.out.println("Contato não localizado!");
        }
    }

    private static void Remover_Contato(ArrayList<Pessoa> contatos) {
        //Utilizando JOptionPane
        String Titulo_Janela = "REMOÇÃO DE CONTATO";
        String nome = JOptionPane.showInputDialog(null, "Digite o Nome Para localizar/remover:", Titulo_Janela,JOptionPane.QUESTION_MESSAGE);
        boolean achou = false;
        int resposta;
        for(int i=0; i<contatos.size();i++){
            if (nome.equalsIgnoreCase(contatos.get(i).getNome())){
                JOptionPane.showMessageDialog(null, contatos.get(i).toString(), ">>> CONTATO LOCALIZADO <<<", JOptionPane.INFORMATION_MESSAGE);
                achou = true;
                resposta = JOptionPane.showConfirmDialog(null, "Deseja REMOVER o CONTATO (S/N):", Titulo_Janela, JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION)
                {
                    contatos.remove(i);
                    JOptionPane.showMessageDialog(null, "CONTATO REMOVIDO COM SUCESSO", Titulo_Janela, JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        if(!achou){
            JOptionPane.showMessageDialog(null, "CONTATO NÃO LOCALIZADO", Titulo_Janela, JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Contato não localizado!");
        }
    }

        public static void Escritor (ArrayList<Pessoa> contatos){
        try {
            FileOutputStream arquivo = new FileOutputStream("contatos.txt");
            PrintWriter pr = new PrintWriter(arquivo);

            for ( int i=0 ; i < contatos.size() ; i++)
            pr.println(contatos.get(i).getNome() +";"+ contatos.get(i).getTelefone() + ";"+ contatos.get(i).getEmail() + ";" + contatos.get(i).getCidade());


            pr.close();
            arquivo.close();
        } 
        catch (Exception e){
            System.out.println ("Erro na escrita do arquivo!");
        }
    }



    public static void Leitor (ArrayList<Pessoa> contatos){
        String nome, telefone, email, cidade;
        try{
            BufferedReader br = new BufferedReader(new FileReader("contatos.txt"));
            String linha = "";

            do {
                linha = br.readLine();
                    if (linha != null){ 
                        String[] palavras = linha.split(";");
//teste                for (int i=0 ; i<palavras.length ; i++){System.out.println(palavras[i]);}
                    new Pessoa(palavras[0], palavras[1], palavras[2], palavras[3]);
                    }

            } while (linha != null);

        } catch(Exception e) {
            System.out.println("Erro na leitura do arquivo!");
        }
    }
    
}

