package Repositorio

import Dominio.*
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate

class RecRepositorio(val jdbcTemplate: JdbcTemplate) {

    fun inserirEmpresa(empresa: Empresa) {
        jdbcTemplate.update("""
           insert into Empresa (razaoSocial, CNPJ, logradouro, numero, bairro, cidade, estado, cep, complemento) values
            ('${empresa.razaoSocial}',${empresa.CNPJ},'${empresa.logradouro}',${empresa.numero},'${empresa.bairro}',
            '${empresa.cidade}','${empresa.estado}',${empresa.cep},'${empresa.complemento}')
        """)
    }
    fun listarEmpresa():List<Empresa> {
        return jdbcTemplate.query("select * from Empresa",
            BeanPropertyRowMapper(Empresa::class.java)
        )
    }

    fun inserirLicenca(licenca: Licenca) {
        jdbcTemplate.update("""
           insert into Licenca (idLicenca,fkEmpresa,tipoLicenca) values
            (${licenca.idLicenca},${licenca.fkEmpresa},'${licenca.tipoLicenca}')
        """)
    }
    fun listarLicenca():List<Licenca> {
        return jdbcTemplate.query("select * from Licenca",
            BeanPropertyRowMapper(Licenca::class.java)
        )
    }

    fun inserirFilial(filial: Filial) {
        jdbcTemplate.update("""
           insert into Filial (fkEmpresa,nomeFantasia,logradouro,numero,bairro,cidade,estado,cep,receita) values
            (${filial.fkEmpresa},'${filial.nomeFantasia}','${filial.logradouro}',${filial.numero},'${filial.bairro}','${filial.cidade}','${filial.estado}',
            ${filial.cep},${filial.receita}
            )
        """)
    }

    fun listarFilial():List<Filial> {
        return jdbcTemplate.query("select * from Filial",
            BeanPropertyRowMapper(Filial::class.java)
        )
    }

    fun inserirUsuario(usuario: Usuario) {
        jdbcTemplate.update("""
           insert into Usuario (idUsuario, fkFilial, fkLicenca, nomeUsuario, emailUsuario, senhaUsuario) values
            (${usuario.idUsuario}, ${usuario.fkFilial}, ${usuario.fkLicenca}, '${usuario.nomeUsuario}', 
            '${usuario.emailUsuario}', ${usuario.senhaUsuario})
        """)
    }

    fun listarUsuario():List<Usuario> {
        return jdbcTemplate.query("select * from Usuario",
            BeanPropertyRowMapper(Usuario::class.java)
        )
    }

    fun inserirSala(sala: Sala) {
        jdbcTemplate.update("""
            insert into Sala (fkFilial,numeroSala,situacao) values 
            (${sala.fkFilial},${sala.numeroSala},'${sala.situacao}')
        """)
    }

    fun listarSala():List<Sala>{
        return jdbcTemplate.query("select * from Sala",
            BeanPropertyRowMapper(Sala::class.java)
        )
    }

    fun inserirAtm(atm: Atm){
        jdbcTemplate.update("""
           insert into Atm (fkFilial,nome,maquina,sistemaOp) values
            (${atm.fkFilial},'${atm.nome}','${atm.maquina}','${atm.sistemaOp}')
        """)
    }

    fun listarAtm():List<Atm>{
        return jdbcTemplate.query("select * from Atm ",
            BeanPropertyRowMapper(Atm::class.java)
        )
    }

    fun inserirVendas(vendas: Vendas) {
        jdbcTemplate.update("""
           insert into vendas (fkFilial,transacao,qtdTransacao,valor) values
            (${vendas.fkFiial},'${vendas.transacao}',${vendas.qtdTransacao},${vendas.valor})
        """)
    }

    fun listarVendas():List<Vendas> {
        return jdbcTemplate.query("select * from Vendas",
            BeanPropertyRowMapper(Vendas::class.java)
        )
    }

    fun inserirLeitura(leitura: Leitura){
        jdbcTemplate.update("""
           insert into Leitura2 (sistemaOperacional,memoriaTotem,discoTotem) values
           (?,?,?)
        """, leitura.sistemaOperacional, leitura.memoriaTotem, leitura.discoTotem)
    }

    fun listarLeitura():List<Leitura> {
        return jdbcTemplate.query("select * from Leitura2",
            BeanPropertyRowMapper(Leitura::class.java)
        )
    }

}