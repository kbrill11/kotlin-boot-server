package server

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController @Autowired constructor(val repository: PersonRepository) {

    @RequestMapping("/")
    fun findAll() : Iterable<Person> = repository.findAll()

    @RequestMapping("/{lastName}")
    fun findByLastName(@PathVariable lastName: String)
            = repository.findByLastName(lastName)
}