package pcontatos;

public class Pessoa {
    private String nome;
    private String telefone;
    private String email;
    private String cidade;

    public Pessoa(String nome, String telefone, String email, String cidade) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "\n\nContato:\n{Nome = " + nome + "\nTelefone = " + telefone + "\nCidade = "+ cidade+ "\nEmail = " +email+ "}\n";
    }

}
