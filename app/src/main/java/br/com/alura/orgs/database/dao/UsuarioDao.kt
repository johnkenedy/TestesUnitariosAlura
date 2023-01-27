package br.com.alura.orgs.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.alura.orgs.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDao {

    @Insert
    suspend fun salva(user: User)

    @Query(
        """
        SELECT * FROM User 
        WHERE id = :usuarioId 
        AND senha = :senha"""
    )
    suspend fun autentica(
        usuarioId: String,
        senha: String
    ): User?

    @Query("SELECT * FROM User WHERE id = :usuarioId")
    fun buscaPorId(usuarioId: String): Flow<User>

}