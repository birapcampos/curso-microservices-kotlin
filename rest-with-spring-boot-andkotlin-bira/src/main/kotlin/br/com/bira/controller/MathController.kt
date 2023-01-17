package br.com.bira.controller

import br.com.bira.converters.NumberConverter
import br.com.bira.exceptions.UnsupportedMathOperationException
import br.com.bira.match.SimpleMatch
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/match")
class MathController {

    private val math: SimpleMatch = SimpleMatch()

    @GetMapping
    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable(value="numberOne") numberOne: String?,
            @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {

        if(numberOne.isNullOrBlank() || numberTwo.isNullOrBlank())
            throw UnsupportedMathOperationException("Please inform two numeric values!")

        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")

        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @GetMapping
    @RequestMapping(value = ["/subtraction/{numberOne}/{numberTwo}"])
    fun subtraction(@PathVariable(value="numberOne") numberOne: String?,
                    @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {

        if(numberOne.isNullOrBlank() || numberTwo.isNullOrBlank())
            throw UnsupportedMathOperationException("Please inform two numeric values!")

        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")

        return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @GetMapping
    @RequestMapping(value = ["/multiplication/{numberOne}/{numberTwo}"])
    fun multiplication(@PathVariable(value="numberOne") numberOne: String?,
                       @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {

        if(numberOne.isNullOrBlank() || numberTwo.isNullOrBlank())
            throw UnsupportedMathOperationException("Please inform two numeric values!")

        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")

        return math.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @GetMapping
    @RequestMapping(value = ["/division/{numberOne}/{numberTwo}"])
    fun division(@PathVariable(value="numberOne") numberOne: String?,
                 @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {

        if(numberOne.isNullOrBlank() || numberTwo.isNullOrBlank())
            throw UnsupportedMathOperationException("Please inform two numeric values!")

        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")

        return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @GetMapping
    @RequestMapping(value = ["/mean/{numberOne}/{numberTwo}"])
    fun mean(@PathVariable(value="numberOne") numberOne: String?,
             @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {

        if(numberOne.isNullOrBlank() || numberTwo.isNullOrBlank())
            throw UnsupportedMathOperationException("Please inform two numeric values!")

        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")

        return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @GetMapping
    @RequestMapping(value = ["/squareRoot/{number}"])
    fun squareRoot(@PathVariable(value="number") number: String?
    ): Double {

        if(number.isNullOrBlank() || number.isNullOrBlank())
            throw UnsupportedMathOperationException("Please inform two numeric values!")

        if(!NumberConverter.isNumeric(number) || !NumberConverter.isNumeric(number))
            throw UnsupportedMathOperationException("Please set a numeric value!")

        return math.squareRoot(NumberConverter.convertToDouble(number))
    }

}