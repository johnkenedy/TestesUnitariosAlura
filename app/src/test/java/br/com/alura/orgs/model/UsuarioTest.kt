package br.com.alura.orgs.model

import org.amshove.kluent.shouldBeFalse
import org.amshove.kluent.shouldBeTrue
import org.junit.Before
import org.junit.Test

class UserTest {

    private var validUser: User? = null
    private var invalidUser: User? = null

    @Before
    fun setupUsers() {
        invalidUser = User(
            id = "1",
            email = "user",
            senha = ""
        )
        validUser = User(
            id = "2",
            email = "user@gmail.com",
            senha = "1234567890"
        )
    }

    @Test
    fun `fun isValid should return true if email and password is valid`() {
        //EXECUTE
        validUser?.ehValido()?.shouldBeTrue()
        invalidUser?.ehValido()?.shouldBeFalse()
    }
}