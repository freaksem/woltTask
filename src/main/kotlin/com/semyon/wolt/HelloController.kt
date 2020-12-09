package com.semyon.wolt

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class HelloController {
    @RequestMapping("/hello", method = [(RequestMethod.GET)])
    fun hello(): ResponseEntity<String> = ResponseEntity.ok("Hello!")
}