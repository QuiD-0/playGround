package com.quid.kotlin.effective

fun main() {
    when (val app: App = getRandomApp()) {
        is Android -> app.androidFunction { "test" }
        is IOS -> app.iosFunction()
        is Web -> app.webFunction()
    }
}

private fun getRandomApp(): App {
    return when (System.currentTimeMillis() % 3) {
        0L -> Android("galaxy")
        1L -> IOS("iphone")
        else -> Web("chrome")
    }
}

sealed interface App {
    fun type(): String
}

data class Android(val name: String) : App {
    override fun type(): String {
        return "Android"
    }

    fun androidFunction(function: () -> String) {
        println("${function()} android")
    }
}

data class IOS(val name: String) : App {
    override fun type(): String {
        return "IOS"
    }

    fun iosFunction() = println("iosFunction")
}

data class Web(val name: String) : App {
    override fun type(): String {
        return "Web"
    }

    fun webFunction() = println("webFunction")
}