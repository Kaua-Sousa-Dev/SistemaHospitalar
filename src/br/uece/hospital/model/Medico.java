package br.uece.hospital.model;

public class Medico {
    private String nome;
    private String especialidade;
    private String planoAtendido;
    private String senha;

    public Medico(String nome, String especialidade, String planoAtendido, String senha) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.planoAtendido = planoAtendido;
        this.senha = senha;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public String getEspecialidade() { return especialidade; }
    public String getPlanoAtendido() { return planoAtendido; }
    public String getSenha() { return senha; }

    // Formato para salvar no CSV: nome;especialidade;plano;senha
    @Override
    public String toString() {
        return nome + ";" + especialidade + ";" + planoAtendido + ";" + senha;
    }
}