package com.quid.refactoring.ocp

class NewAlert(
    private val notification: AlertNotification,
    private val alertChecks: List<AlertCheck> = emptyList()
) {
    fun addAlertCheck(alertCheck: AlertCheck) {
        alertChecks.plus(alertCheck)
    }

    fun check(statInfo: StatInfo) {
        alertChecks.forEach {
            if (it.check(statInfo)) {
                notification.notifyMsg()
            }
        }
    }
}

data class StatInfo(
    val cpuStat: Int,
    val memoryStat: Int,
    val currentThreadCount: Int,
    val maxThreshold: Int,
    val threshold: Int
)

interface AlertCheck {
    fun check(statInfo: StatInfo): Boolean
}

data object CpuStatCheck : AlertCheck {
    override fun check(statInfo: StatInfo): Boolean {
        return statInfo.cpuStat > statInfo.threshold
    }
}

data object MemoryStatCheck : AlertCheck {
    override fun check(statInfo: StatInfo): Boolean {
        return statInfo.memoryStat > statInfo.maxThreshold
    }
}

data object ThreadCountCheck : AlertCheck {
    override fun check(statInfo: StatInfo): Boolean {
        return statInfo.currentThreadCount > 100
    }
}
