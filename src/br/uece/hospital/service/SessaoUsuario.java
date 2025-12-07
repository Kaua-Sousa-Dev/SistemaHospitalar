package br.uece.hospital.service;

import br.uece.hospital.model.Medico;
import br.uece.hospital.model.Paciente;

public class SessaoUsuario {
    // Estas variáveis guardam o usuário enquanto o programa estiver aberto
    public static Medico medicoLogado;
    public static Paciente pacienteLogado;

    // Chama isso quando clicar em "Sair"
    public static void limparSessao() {
        medicoLogado = null;
        pacienteLogado = null;
    }
}