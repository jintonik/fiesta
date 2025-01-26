package org.kotlin.fiesta

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FiestaApplication

fun main(args: Array<String>) {
	runApplication<FiestaApplication>(*args)
}
