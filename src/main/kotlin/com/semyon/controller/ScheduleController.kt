package com.semyon.controller

import com.semyon.model.WorkHours
import com.semyon.service.ScheduleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ScheduleController(private val scheduleService: ScheduleService) {

    @RequestMapping("/schedule", method = [(RequestMethod.POST)])
    fun schedule(@RequestBody request: Map<String, MutableList<WorkHours>>): ResponseEntity<String> =
        ResponseEntity.ok(scheduleService.handleSchedule(request))
}