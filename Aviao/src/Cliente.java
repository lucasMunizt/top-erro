public class Cliente {
    private String nome;
    private String cpf;
    void listar(){
        System.out.println("Passageiro: " + nome + " cpf: " + cpf );
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}


