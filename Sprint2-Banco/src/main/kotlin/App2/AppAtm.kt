package App2

import Configuracao.Conexao
import Dominio.Atm
import Repositorio.RecRepositorio
import javax.swing.JOptionPane.*

fun main() {

    val jdbcTemplate = Conexao().getJdbcTemplate()
    val recRepositorio =  RecRepositorio(jdbcTemplate)

    val novoFkFilial = showInputDialog(null,"Qual o id referente a filial ?").toInt()
    val novoNome = showInputDialog(null,"Qual o nome da Maquina:")
    val novoMaquina = showInputDialog(null,"Qual a maquina:")
    val novoSistemaOp = showInputDialog(null,"Qual o sitema operacional ?")

    val novoAtm = Atm(0,novoFkFilial,novoNome,novoMaquina,novoSistemaOp)
    recRepositorio.inserirAtm(novoAtm)

    val atm = recRepositorio.listarAtm()
    var consultar = ""

    atm.forEach{
        consultar += "${it.idAtm},${it.fkFilial},${it.nome},${it.maquina},${it.sistemaOp}"
        consultar += "\r\n"
    }
    showMessageDialog(null, consultar)
}