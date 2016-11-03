package server

import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder

@SpringBootApplication
open class Application {
    @Bean
    open fun objectMapperBuilder() : Jackson2ObjectMapperBuilder
            = Jackson2ObjectMapperBuilder().modulesToInstall(KotlinModule())

    @Bean
    open fun init(repository: PersonRepository) = CommandLineRunner {
        repository.deleteAll()
        repository.save(Person("Jack", "Bauer"))
        repository.save(Person("Chloe", "O'Brian"))
        repository.save(Person("Kim", "Bauer"))
        repository.save(Person("David", "Palmer"))
        repository.save(Person("Michelle", "Dessler"))
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}