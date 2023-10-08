package com.quid.kotlin.effective

fun main(){

    val start = System.currentTimeMillis()
    repeat(100000) { it }
    val end = System.currentTimeMillis()
    println("repeat: ${end - start}")

    val start2 = System.currentTimeMillis()
    noRepeat(100000) { it }
    val end2 = System.currentTimeMillis()
    println("noRepeat: ${end2 - start2}")

}

private inline fun repeat(times: Int, action: (Int) -> Unit){
    for(index in 0 until times){
        action(index)
    }
}

private fun noRepeat(times: Int, action: (Int) -> Unit){
    for(index in 0 until times){
        action(index)
    }
}