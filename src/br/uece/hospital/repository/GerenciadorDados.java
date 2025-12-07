package br.uece.hospital.repository;

import br.uece.hospital.model.Medico;
import br.uece.hospital.model.Paciente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDados {
    private static final String ARQ_MEDICOS = "medicos.txt";
    private static final String ARQ_PACIENTES = "pacientes.txt";

    // Salvar Médico
    public static void salvarMedico(Medico m) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQ_MEDICOS, true))) {
            bw.write(m.toString());
            bw.newLine();
        }
    }

    // Carregar Médicos
    public static List<Medico> carregarMedicos() throws IOException {
        List<Medico> lista = new ArrayList<>();
        File arquivo = new File(ARQ_MEDICOS);
        if (!arquivo.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length >= 4) {
                    lista.add(new Medico(dados[0], dados[1], dados[2], dados[3]));
                }
            }
        }
        return lista;
    }

    // Carregar Pacientes
    public static List<Paciente> carregarPacientes() throws IOException {
        List<Paciente> lista = new ArrayList<>();
        File arquivo = new File(ARQ_PACIENTES);
        if (!arquivo.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length >= 4) {
                    int idade = Integer.parseInt(dados[1]);
                    lista.add(new Paciente(dados[0], idade, dados[2], dados[3]));
                }
            }
        }
        return lista;
    }

    // Gerenciar Paciente
    public static void registrarPaciente(Paciente p) throws IOException {
        // O parâmetro "true" no FileWriter diz para ADICIONAR ao final, não sobrescrever
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("pacientes.txt", true))) {
            bw.write(p.toString());
            bw.newLine();
        }
    }
}