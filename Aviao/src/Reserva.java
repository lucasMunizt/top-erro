public class Reserva {
    private Passagem passagem;
    private Cliente passageiros;
    private double  ValorDaPassagem;
    private int numAssentos;
    Reserva(Passagem passagem, Cliente passageiros){
        this.passageiros =passageiros;
        this.passagem  = passagem;
    }

    public Passagem getPassagem() {
        return passagem;
    }

    public void setPassagem(Passagem passagem) {
        this.passagem = passagem;
    }

    public Cliente getPassageiros() {
        return passageiros;
    }
    public void setPassageiros(Cliente passageiros) {
        this.passageiros = passageiros;
    }

    public double getValorDaPassagem() {
        return ValorDaPassagem;
    }
    public void setValorDaPassagem(double ValorDaPassagem) {
        this.ValorDaPassagem = ValorDaPassagem;
    }
    public int getNumAssentos() {
        return numAssentos;
    }
    public void setNumAssentos(int numAssentos) {
        this.numAssentos = numAssentos;
    }

}
