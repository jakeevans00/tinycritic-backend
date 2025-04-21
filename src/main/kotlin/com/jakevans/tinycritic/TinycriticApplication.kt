package com.jakevans.tinycritic

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TinycriticApplication

fun main(args: Array<String>) {
	runApplication<TinycriticApplication>(*args)
}

