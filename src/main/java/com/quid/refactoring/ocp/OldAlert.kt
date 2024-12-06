package com.quid.refactoring.ocp

class OldAlert(
    private val notification: AlertNotification
) {
    fun check(cpuStat: Int, memoryStat:Int, threshold: Int, maxThreshold: Int, currentThreadCount: Int) {
        if (cpuStat > threshold) {
            notification.notify()
        }

        if (memoryStat > maxThreshold) {
            notification.notify()
        }

        if (currentThreadCount > 100) {
            notification.notify()
        }
        // more checks
    }
}

