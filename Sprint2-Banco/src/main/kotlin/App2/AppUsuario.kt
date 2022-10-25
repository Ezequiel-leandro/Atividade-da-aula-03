package App2

import Configuracao.Conexao
import Dominio.Usuario
import Repositorio.RecRepositorio
import javax.swing.JOptionPane.*

fun main() {
    val jdbcTemplate = Conexao().getJdbcTemplate()
    val recRepositorio = RecRepositorio(jdbcTemplate)

    val novoFkFilial = showInputDialog(null,"Qual o id da Filial?").toInt()
    val novoFkLicenca = showInputDialog(null,"Qual o id da Licença ?").toInt()
    val novoNomeUsuario = showInputDialog(null,"Nome do Usuario:")
    val novoEmailUsuario = showInputDialog(null,"Email para contato:")
    val novoSenhaUsuario = showInputDialog(null,"Senha:").toInt()

    val novoUsuario = Usuario(0,novoFkFilial,novoFkLicenca,novoNomeUsuario,novoEmailUsuario,novoSenhaUsuario)
    recRepositorio.inserirUsuario(novoUsuario)

    val usuario = recRepositorio.listarUsuario()
    var consultar = ""

    usuario.forEach{
        consultar += "id-${it.idUsuario}, Filial-${it.fkFilial}, Licença-${it.fkLicenca}, Nome-${it.nomeUsuario}, Email-${it.emailUsuario}, Senha-${it.senhaUsuario}"
        consultar += "\r\n"
    }
    showMessageDialog(null, consultar)
}