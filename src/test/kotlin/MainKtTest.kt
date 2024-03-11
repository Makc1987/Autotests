import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun visaMir() {
        val comission = 0.0075
        val minComission = 35
        val amount = 50_000

        val result = visaMir(amount)

        assertEquals(376, result)
    }

    @Test
    fun limitCheck1() {
        val limitDay = 150_000
        val limitMonth = 600_000
        val amount = 50000
        val sumMonth = 0
        val result = limitCheck(amount, sumMonth)
        assertEquals(0, result)
    }
    @Test
    fun limitCheck2() {
        val limitDay = 150_000
        val limitMonth = 600_000
        val amount = 250000
        val sumMonth = 0
        val result = limitCheck(amount, sumMonth)
        assertEquals(-1, result)
    }
    @Test
    fun limitCheck3() {
        val limitDay = 150_000
        val limitMonth = 600_000
        val amount = 50000
        val sumMonth = 350000
        val result = limitCheck(amount, sumMonth)
        assertEquals(0, result)
    }
    @Test
    fun limitCheck4() {
        val limitDay = 150_000
        val limitMonth = 600_000
        val amount = 150_000
        val sumMonth = 550_000
        val result = limitCheck(amount, sumMonth)
        assertEquals(-2, result)
    }

    @Test
    fun mastercardMaestrd1() {
        val minMonthLimit = 300
        val maxMonthLimit = 75_000
        val comission = 0.006
        val amount = 200
        val result = mastercardMaestrd(amount)
        assertEquals(21, result)
    }
    @Test
    fun mastercardMaestrd2() {
        val minMonthLimit = 300
        val maxMonthLimit = 75_000
        val comission = 0.006
        val amount = 80000
        val result = mastercardMaestrd(amount)
        assertEquals(500, result)
    }
    @Test
    fun mastercardMaestrd3() {
        val minMonthLimit = 300
        val maxMonthLimit = 75_000
        val comission = 0.006
        val amount = 50000
        val result = mastercardMaestrd(amount)
        assertEquals(0, result)
    }


    @Test
    fun vkPay1() {
        val atOnce = 15000
        val month = 40000
        val amount = 20_000
        val sumMonth = 0
        val result = vkPay(amount, sumMonth)
        assertEquals(0, result)
    }
    @Test
    fun vkPay2() {
        val atOnce = 15000
        val month = 40000
        val amount = 20_000
        val sumMonth = 25_000
        val result = vkPay(amount, sumMonth)
        assertEquals(-2, result)
    }
    @Test
    fun vkPay3() {
        val atOnce = 15000
        val month = 40000
        val amount = 50000
        val sumMonth = 60000
        val result = vkPay(amount, sumMonth)
        assertEquals(-2, result)
    }

    @Test
    fun transfer1() {
        val typeIn = "MIR"
        val typeOut = "VKPay"
        val sumMonth = 0
        val amount = 50000
        val result = transfer(typeIn = typeIn, typeOut = typeOut, sumMonth = sumMonth, amount = amount)
        assertEquals(0, result)
    }
    @Test
    fun transfer2() {
        val typeIn = "VKPay"
        val typeOut = "VISA"
        val sumMonth = 0
        val amount = 50000
        val result = transfer(typeIn = typeIn, typeOut = typeOut, sumMonth = sumMonth, amount = amount)
        assertEquals(-2, result)
    }
    @Test
    fun transfer3() {
        val typeIn = "VISA"
        val typeOut = "MIR"
        val sumMonth = 0
        val amount = 50000
        val result = transfer(typeIn = typeIn, typeOut = typeOut, sumMonth = sumMonth, amount = amount)
        assertEquals(375, result)
    }
    @Test
    fun transfer4() {
        val typeIn = "MIR"
        val typeOut = "VISA"
        val sumMonth = 0
        val amount = 50000
        val result = transfer(typeIn = typeIn, typeOut = typeOut, sumMonth = sumMonth, amount = amount)
        assertEquals(375, result)
    }
    @Test
    fun transfer5() {
        val typeIn = "MAESTRO"
        val typeOut = "VISA"
        val sumMonth = 0
        val amount = 50000
        val result = transfer(typeIn = typeIn, typeOut = typeOut, sumMonth = sumMonth, amount = amount)
        assertEquals(0, result)
    }
    @Test
    fun transfer6() {
        val typeIn = "MASTERCARD"
        val typeOut = "VISA"
        val sumMonth = 0
        val amount = 50000
        val result = transfer(typeIn = typeIn, typeOut = typeOut, sumMonth = sumMonth, amount = amount)
        assertEquals(0, result)
    }
    @Test
    fun transfer7() {
        val typeIn = "sdfd"
        val typeOut = "VISA"
        val sumMonth = 0
        val amount = 50000
        val result = transfer(typeIn = typeIn, typeOut = typeOut, sumMonth = sumMonth, amount = amount)
        assertEquals(-3, result)
    }
    @Test
    fun transfer8() {
        val typeIn = "MASTERCARD"
        val typeOut = "VISA"
        val sumMonth = 0
        val amount = 200_000
        val result = transfer(typeIn = typeIn, typeOut = typeOut, sumMonth = sumMonth, amount = amount)
        assertEquals(1220, result)
    }
    @Test
    fun transfer9() {
        val typeIn = "MASTERCARD"
        val typeOut = "VISA"
        val sumMonth = 800_000
        val amount = 50_000
        val result = transfer(typeIn = typeIn, typeOut = typeOut, sumMonth = sumMonth, amount = amount)
        assertEquals(0, result)
    }
}