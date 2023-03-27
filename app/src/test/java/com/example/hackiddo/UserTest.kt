package com.example.hackiddo

import gatraenggar.hackiddo.User
import org.junit.Assert
import org.junit.Test

class UserTest {
    @Test
    fun testPrintUsername() {
        val result = User.printUsername("android")
        Assert.assertEquals("android", result)
    }
}