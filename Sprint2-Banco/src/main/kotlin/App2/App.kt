package App2

import Configuracao.Conexao
import Dominio.Empresa
import Dominio.Licenca
import Repositorio.RecRepositorio
import javax.swing.JOptionPane

fun main() {

    val jdbcTemplate = Conexao().getJdbcTemplate()
    val recRepositorio = RecRepositorio(jdbcTemplate)

    val action =
        JOptionPane.showConfirmDialog(null, "Deseja realzar o cadastro?", "Selecione a opção", JOptionPane.YES_NO_CANCEL_OPTION)

    if (action == 0){
//        val novoRazao = JOptionPane.showInputDialog(null, "Qual a razão social?")
//        val novoCNPJ = JOptionPane.showInputDialog(null, "Qual o CNPJ ?")
//        val novoLogradouro = JOptionPane.showInputDialog(null, "Qual o logradouro?")
//        val novoNumero = JOptionPane.showInputDialog(null, "Numero ?").toInt()
//        val novoBairro = JOptionPane.showInputDialog(null, "Bairro?")
//        val novoCidade = JOptionPane.showInputDialog(null, "Cidade ?")
//        val novoEstado = JOptionPane.showInputDialog(null, "Estado ?")
//        val novoCep = JOptionPane.showInputDialog(null, "Cep ?")
//        val novoComplemento = JOptionPane.showInputDialog(null, "Complemento ?")
//
//        val novoEmpresa = Empresa(0,novoRazao,novoCNPJ,novoLogradouro,novoNumero,novoBairro,novoCidade,novoEstado,novoCep,novoComplemento)
//        recRepositorio.inserirEmpresa(novoEmpresa)

        val empresa = recRepositorio.listarEmpresa()
        var consultar1 = ""

        empresa.forEach {
            consultar1 += "Empresa: ${it.idEmpresa} \r\nRazão Social: ${it.razaoSocial} \r\nCNPJ: ${it.CNPJ} \r\nlogadouro: ${it.logradouro} \r\nNumero: ${it.numero} \r\nBairro: ${it.bairro} \r\nCidade: ${it.cidade} \r\nEstado: ${it.estado} \r\nCep: ${it.cep} \r\nComplemento: ${it.complemento},"
            consultar1 += "\r\n"
        }
        JOptionPane.showMessageDialog(null, consultar1)

        while (true) {
            val novoIdLicenca = JOptionPane.showInputDialog(null, "Qual o id").toInt()
            val novoFkEmpresa = JOptionPane.showInputDialog(null, "Qual o id da empresa ?").toInt()
            val novoTipoLicenca = JOptionPane.showInputDialog(null, "Qual o tipo de Licença ?")
            if (novoTipoLicenca == "analista" || novoTipoLicenca == "gerenciaFilial" || novoTipoLicenca == "gerenciaMatriz"){
                val novoLicenca = Licenca(novoIdLicenca,novoFkEmpresa,novoTipoLicenca)
                recRepositorio.inserirLicenca(novoLicenca)

                val licenca = recRepositorio.listarLicenca()
                var consultar2 = ""

                licenca.forEach {
                    consultar2 += "Licenca - ${it.idLicenca}, ${it.fkEmpresa}, ${it.tipoLicenca}"
                    consultar2 += "\r\n"
                    JOptionPane.showMessageDialog(null, consultar2)
                }
                break
            }
            else{
                JOptionPane.showMessageDialog(null, "Valores invalidos")
            }
        }
    } else{
        JOptionPane.showMessageDialog(null, "Operação finalizada!!!")
    }
}