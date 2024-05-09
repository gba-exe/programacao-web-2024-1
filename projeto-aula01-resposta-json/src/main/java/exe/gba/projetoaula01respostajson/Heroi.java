package exe.gba.projetoaula01respostajson;

public class Heroi {

    private String nome;
    private int forca;
    private String habilidade;
    private int idade;
    private boolean vivo;

    public Heroi(String nome, int forca, String habilidade, int idade, boolean vivo) {
        this.nome = nome;
        this.forca = forca;
        this.habilidade = habilidade;
        this.idade = idade;
        this.vivo = vivo;
    }

    public Heroi() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public String getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public String getDescricao() {
        return forca > 5000 ? "Eh mais de 5 mil" : "Fraquin";
    }
}
