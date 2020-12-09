package com.semyon.wolt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.semyon"])
class WoltApplication

fun main(args: Array<String>) {
    runApplication<WoltApplication>(*args)
}