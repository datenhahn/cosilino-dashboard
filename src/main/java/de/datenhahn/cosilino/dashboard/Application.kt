package de.datenhahn.cosilino.dashboard

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication
open class Application

fun main(args: Array<String>) {
	SpringApplication.run(Application::class.java, *args)
}
