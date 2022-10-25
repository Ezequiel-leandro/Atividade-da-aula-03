package Dominio

data class Leitura(var idLeitura:Int,
                   var sistemaOperacional:String,
                   var memoriaTotem:Double,
                   var discoTotem:Double
                   ) {
    constructor() : this(0,"",0.0,0.0)
}