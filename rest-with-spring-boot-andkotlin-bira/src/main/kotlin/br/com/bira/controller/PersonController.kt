package br.com.bira.controller

import br.com.bira.converters.NumberConverter
import br.com.bira.exceptions.UnsupportedMathOperationException
import br.com.bira.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    private lateinit var personService: PersonService

    @GetMapping
    @RequestMapping("/person")


}