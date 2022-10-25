package App2

import com.github.britooo.looca.api.core.Looca

fun main() {






    val looca = Looca()
    val sistema = looca.sistema
    println("Sistema: $sistema")
    println("""
        SO: ${sistema.sistemaOperacional}       
    """.trimIndent())

    val grupoDiscos = looca.grupoDeDiscos
    val discos = grupoDiscos.discos
    discos.forEachIndexed { d, disco ->
        println("""            
            Disco ${d+1}:
            Tamanho (GB): ${"%.2f".format(disco.tamanho.toDouble()/1024/1024/1024)}            
        """.trimIndent() )
    }

    val memoria = looca.memoria
    println("""               
        Em uso (GB): ${"%.2f".format(memoria.emUso.toDouble()/1024/1024/1024)}
    """.trimIndent())
}

