package App2

import Configuracao.Conexao
import Dominio.Leitura
import Repositorio.RecRepositorio
import com.github.britooo.looca.api.core.Looca
import javax.swing.JOptionPane.*



open class Main {
    companion object {
        @JvmStatic fun main(args: Array<String>) {



            val jdbcTemplate = Conexao().getJdbcTemplate()
            val recRepositorio = RecRepositorio(jdbcTemplate)
            // seu código ficará aqui

            var i = 1
            var tentativas = 1

            while (tentativas <= 3) {
                var validas = 3 - tentativas
                val emailVal = showInputDialog("Informe o seu email")
                val senhaVal = showInputDialog("Informe sua senha")

                if (emailVal == "fernando@gmail.com" && senhaVal == "1234") {
                    showMessageDialog(null, "Logado com sucesso")
                    break

                } else {
                    showMessageDialog(null, "Credências inválidas")
                    showMessageDialog(null, "Tente novamente, você tem mais $validas tentativas")
                    tentativas += 1
                }
            }

            i += 1

            val looca = Looca()
            val sistema = looca.sistema.sistemaOperacional.toString()

            val memoria = "${looca.memoria.emUso.toDouble()/1024/1024/1024}".toDouble()


            val grupoDiscos = looca.grupoDeDiscos
            // Obtendo lista de discos
            val discos = "${ grupoDiscos.tamanhoTotal.toDouble()/1024/1024/1024 }".toDouble()



            val insert1 = Leitura(0,sistema,memoria,discos)
            recRepositorio.inserirLeitura(insert1)

            val insert2 = Leitura(0,sistema,memoria,discos)
            recRepositorio.inserirLeitura(insert2)

            val insert3 = Leitura(0,sistema,memoria,discos)
            recRepositorio.inserirLeitura(insert3)

            val leitura = recRepositorio.listarLeitura()
            var consultar = ""

            leitura.forEach{
                consultar += "id: ${it.idLeitura} - SO: ${it.sistemaOperacional} - Disco: ${it.discoTotem} - Memoria:${it.memoriaTotem}"
                consultar += "\r\n"
            }
            showMessageDialog(null, consultar)
        }
    }
}