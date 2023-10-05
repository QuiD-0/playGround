package com.quid.kotlin.effective

fun main() {
    val app: App = getRandomApp()
    when (app) {
        is Android -> app.androidFunction()
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

    fun androidFunction() = println("androidFunction")
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