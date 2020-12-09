package com.semyon.service

import com.semyon.model.WorkHours
import org.springframework.stereotype.Service
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Service
class ScheduleService {

    fun handleSchedule(scheduleRequest: Map<String, MutableList<WorkHours>>): String {
        val stringBuilder = StringBuilder()
        prepareData(scheduleRequest)
        scheduleRequest.forEach { (day, workHours) ->
            stringBuilder.append("${day.capitalize()}: ")
            if (workHours.isEmpty())
                stringBuilder.appendLine("Closed")

            workHours.forEachIndexed { index, workHour ->
                when(workHour.type) {
                    CLOSE -> {
                        if (index == workHours.size-1)
                            stringBuilder.appendLine(" - ${prepareTime(workHour.value)}")
                        else
                            stringBuilder.append(" - ${prepareTime(workHour.value)}, ")
                    }
                    else -> stringBuilder.append(prepareTime(workHour.value))
                }
            }
        }
        print(stringBuilder.trimEnd().toString())
        return stringBuilder.trimEnd().toString()
    }

    private fun prepareData(scheduleRequest: Map<String, MutableList<WorkHours>>) {
        val daysStartedWithClose: MutableList<Pair<Int, WorkHours>> = mutableListOf()
        var dayNumber = 0
        scheduleRequest.forEach { (_, workHours) ->
            if (workHours.isNotEmpty() && workHours.first().type == CLOSE)
                daysStartedWithClose.add(Pair(dayNumber, workHours.first()))
            dayNumber++
        }

        daysStartedWithClose.forEach {
            scheduleRequest[scheduleRequest.keys.elementAt(it.first)]?.removeFirst()
            scheduleRequest[scheduleRequest.keys.elementAt(it.first - 1)]?.add(it.second)
        }
    }

    private fun prepareTime(time: Long) =
        LocalTime.ofSecondOfDay(time).format(DateTimeFormatter.ofPattern("h:mm a"))

    companion object {
        const val CLOSE = "close"
    }
}