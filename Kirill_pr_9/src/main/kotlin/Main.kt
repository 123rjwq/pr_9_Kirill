import kotlinx.coroutines.*

fun main() = runBlocking {

    // Ввод времени для будильника 1
    println("Введите время для будильника 1:")
    val alarm1Time = readLine()!!.toInt()

    // Ввод времени для будильника 2
    println("Введите время для будильника 2:")
    val alarm2Time = readLine()!!.toInt()

    // Ввод времени для будильника 3
    println("Введите время для будильника 3:")
    val alarm3Time = readLine()!!.toInt()

    // Запуск будильника 1
    val alarm1 = launch { soundAlarm(" click ", alarm1Time) }

    // Запуск будильника 2
    val alarm2 = launch { soundAlarm(" click ", alarm2Time) }

    // Запуск будильника 3
    val alarm3 = launch { soundAlarm(" click ", alarm3Time) }

    // Ожидание завершения будильника 1
    alarm1.join()

    // Ожидание завершения будильника 2
    alarm2.join()

    // Ожидание завершения будильника 3
    alarm3.join()
}

suspend fun soundAlarm(sound: String, seconds: Int) {
    repeat(seconds) {
        // Вывод звука будильника указанное количество раз
        print("$sound")

        // Задержка выполнения на 10 миллисекунд
        delay(10)
    }

    // Вывод сообщения "Stand up!!!!" по завершению цикла
    println("= Stand up!!!!")
}