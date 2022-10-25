package Configuracao

import org.apache.commons.dbcp2.BasicDataSource
import org.springframework.jdbc.core.JdbcTemplate

class Conexao {
    val driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"

    // val url = "jdbc:h2:mem:banco-aula"
    val url = "jdbc:sqlserver://projeto-rec.database.windows.net;databaseName=REC"
    val username = "grupo09"
    val password = "M@umau03221"

    fun getJdbcTemplate(): JdbcTemplate {
        val dataSource = BasicDataSource()
        dataSource.driverClassName = driverClassName
        dataSource.url = url
        dataSource.username = username
        dataSource.password = password

        val jdbcTemplate = JdbcTemplate(dataSource)
        return jdbcTemplate
    }
}