package com.quid.refactoring.ocp

class OldAlert(
    private val notification: AlertNotification
) {
    fun check(cpuStat: Int, memoryStat:Int, threshold: Int, maxThreshold: Int, currentThreadCount: Int) {
        if (cpuStat > threshold) {
            notification.notifyMsg()
        }

        if (memoryStat > maxThreshold) {
            notification.notifyMsg()
        }

        if (currentThreadCount > 100) {
            notification.notifyMsg()
        }
        // more checks
    }
}

