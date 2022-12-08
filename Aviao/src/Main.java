import Execoes.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main (String[] args) {
        int l = 0;
        int confirmar= 0;
        String nome=null;
        String cpf=null;
        String senha = "123";
        Scanner src = new Scanner(System.in);
        ArrayList<Voo> voo = new ArrayList<>();
        ArrayList<Integer> posicoes = new ArrayList<>();
        Voo.adicionar();
        while(l != 6) {
            System.out.println("1:Comprar a passagem:");
            System.out.println("2:Alterar o assento:");
            System.out.println("3:Alterar a titulariedade da rezerva:");
            System.out.println("4:Cancela a reserva:");
            System.out.println("5:Lista de passageiros:");
            System.out.println("6:Sair:");
            l = src.nextInt();
            switch (l) {
                case 1:
                    try {
                                System.out.println("Digite sua origem");
                                String leitura = src.next();
                                leitura = leitura.toUpperCase();
                                System.out.println("Digite sua Destino");
                                String leitura1 = src.next();
                                leitura1 = leitura1.toUpperCase();
                                Voo voo1 = new Voo(leitura, leitura1);
                        if (voo.size() == 0) {
                        } else {
                            for (int i = 0; i < voo.size(); i++) {
                                if (voo.get(i).getOrigem().equals(leitura) && voo.get(i).getDestino().equals(leitura1)) {
                                    break;
                                } else {
                                    if (i + 1 == voo.size()) {
                                        break;
                                    }
                                }
                            }
                        }
                        System.out.println("Confirmar");
                        System.out.println("1:sim");
                        System.out.println("2:nao");
                        confirmar = src.nextInt();
                        Cliente cl = new Cliente();
                        if (confirmar == 1) {
                            System.out.println("Digite seu nome: ");
                            cl.setNome(nome = src.next());
                            System.out.println("Digite seu cpf: ");
                            cl.setCpf(cpf = src.next());
                        }
                        int posicao = voo1.AddPassageiro(cl);
                        posicoes.add(posicao);
                        voo.add(voo1);
                        System.out.println("\nnome: " + cl.getNome() + "\ncpf: " + cl.getCpf() + "\norigem: "
                                + leitura + " Destino " + leitura1 + "\n" +
                                "Assento: " + voo1.getNumDeAssentos()[posicao].getGuadarassento()+ "\n"
                                + "ID: " +voo1.IdAleatorio()+ "\nValor da passagem: " + voo1.getvalPassagem());
                    } catch (LocalInvalidoException e) {
                        System.out.println("Local invalido");
                    } catch (AviaoLotadoException e) {
                        System.out.println("Aviao lotado");
                    }
                    break;
                case 2:
                    System.out.println("Voce deseja alterar seu assento?");
                    System.out.println("1:sim");
                    System.out.println("2:nao");
                    int confirmar1 = src.nextInt();
                    if (confirmar1 == 1) {
                        System.out.println("Coque seu id");
                        int leituraid = src.nextInt();
                        for (int i = 0; i < voo.size(); i++) {
                            if (leituraid ==voo.get(i).getId()) {
                                System.out.println("Voce deseja cancelar a reserva?");
                                System.out.println("1:sim");
                                System.out.println("2:nao");
                                int confirmar3 = src.nextInt();
                                if (confirmar3 == 1) {
                                    System.out.println("Coloque seu assento");
                                    int assento = src.nextInt();
                                    for (int t = 0; t < voo.size(); t++) {
                                        for(int posicao: posicoes) {
                                            voo.get(t).cancelaComprar(voo.get(t).getNumDeAssentos()[posicao], posicao);
                                            posicoes.remove(posicoes.indexOf(posicao));
                                            break;
                                        }
                                    }
                                }


                            }

                        }
                    }
                    break;
                case 3:
                    System.out.println("Voce deseja alterar Titulariedade?");
                    System.out.println("1:sim");
                    System.out.println("2:nao");
                    int confirmar2 = src.nextInt();
                    if (confirmar2 == 1) {
                        System.out.println("Coloque seu id");
                        int id = src.nextInt();
                        for (int i = 0; i < voo.size(); i++) {
                            if (id ==voo.get(i).getId()) {
                                System.out.println("digite o nome:");
                                String nomeNovo = src.next();
                                System.out.println("digite o cpf:");
                                String cpfNovo = src.next();
                                voo.get(i).getNumDeAssentos()[posicoes.get(i)].getPassageiros().setNome(nomeNovo);
                                voo.get(i).getNumDeAssentos()[posicoes.get(i)].getPassageiros().setCpf(cpfNovo);
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("Voce deseja cancelar a reserva?");
                    System.out.println("1:sim");
                    System.out.println("2:nao");
                    int confirmar3 = src.nextInt();
                    if (confirmar3 == 1) {
                        System.out.println("Coloque seu assento");
                        int assento = src.nextInt();
                        for (int i = 0; i < voo.size(); i++) {
                        	for(int posicao: posicoes) {
                            	voo.get(i).cancelaComprar(voo.get(i).getNumDeAssentos()[posicao], posicao);
                            	posicoes.remove(posicoes.indexOf(posicao));
                                break;	
                        	}
                        }
                    }

                    break;
                case 5:
                    try {
                        System.out.println("coloque sua senha: ");
                        String testesenha = src.next();
                        if (testesenha.equals(senha)){
                            System.out.println("Digite sua origem");
                            String leitura2 = src.next();
                            leitura2 = leitura2.toUpperCase();
                            System.out.println("Digite sua Destino");
                            String leitura3 = src.next();
                            leitura3 = leitura3.toUpperCase();
                            boolean vooExiste = false;
                            for (int i = 0; i < voo.size(); i++) {
                                if (voo.get(i).getOrigem().equals(leitura2) && voo.get(i).getDestino().equals(leitura3)) {
                                    voo.get(i).ListarPassageiros();
                                    vooExiste = true;
                                    break;
                                }
                            }
                            if(!vooExiste) throw new Execoes.LocalInvalidoException();
                        }
                        else{
                            throw new Execoes.SenhaInvalidaException();
                        }
                    }catch (SenhaInvalidaException e){
                        System.out.println("senha invalida");
                    }catch (LocalInvalidoException e){
                        System.out.println("Local invalido");
                    }
                    break;
                case 6:
                    break;

            }
        }
    }
}