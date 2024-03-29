import kotlin.math.max

val dayLimit: Int = -1
val monthLimit: Int = -2
val wrongTypeCard: Int = -3
fun main() {
    println("Введите сумму перевода: ")
    println("Размер комиссии: ${transfer()}")
}
fun limitCheck(amount: Int, sumMonth: Int): Int {
    val limitDay = 150_000
    val limitMonth = 600_000
    var result: Int = 0
    if (amount > limitDay) result = dayLimit
    if (amount + sumMonth > limitMonth) result = monthLimit
    return result
}

fun visaMir(amount: Int): Int {
    val comission = 0.0075
    val minComission = 35
    return max(minComission, (amount*comission).toInt())
}
fun mastercardMaestrd(amount: Int): Int {
    val minMonthLimit = 300
    val maxMonthLimit = 75_000
    val comission = 0.006
    return if (amount < minMonthLimit || amount > maxMonthLimit) (amount*comission).toInt() + 20 else 0
}
fun vkPay(amount: Int, sumMonth: Int): Int {
    val atOnce = 15000
    val month = 40000
    return if (amount <= atOnce || amount+sumMonth <= month) 0 else -2
}
fun transfer(typeIn: String = "MIR", typeOut: String = "VKPay", sumMonth: Int = 0, amount: Int = readln().toInt()): Int {
    if (limitCheck(amount, sumMonth) == -1 || limitCheck(amount, sumMonth) == -2)
        println("Перевод невозможен, превышены лимиты!")
    var result: Int = 0
    if(typeOut == "VKPay") result = 0
    else
        when(typeIn) {
            "VKPay" -> result = vkPay(amount, sumMonth)
            "MIR" -> result = visaMir(amount)
            "VISA" -> result = visaMir(amount)
            "MASTERCARD" -> result = mastercardMaestrd(amount)
            "MAESTRO" -> result = mastercardMaestrd(amount)
            else -> result = wrongTypeCard
    }
    return result
}