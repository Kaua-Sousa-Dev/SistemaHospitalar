package br.uece.hospital.model;

public class Paciente {
    private String nome;
    private int idade;
    private String planoSaude; // "não possuo" se for vazio
    private String senha;

    public Paciente(String nome, int idade, String planoSaude, String senha) {
        this.nome = nome;
        this.idade = idade;
        this.planoSaude = (planoSaude == null || planoSaude.isEmpty()) ? "não possuo" : planoSaude;
        this.senha = senha;
    }

    public String getNome() { return nome; }
    public String getPlanoSaude() { return planoSaude; }
    public String getSenha() { return senha; }

    // Formato CSV: nome;idade;plano;senha
    @Override
    public String toString() {
        return nome + ";" + idade + ";" + planoSaude + ";" + senha;
    }
}