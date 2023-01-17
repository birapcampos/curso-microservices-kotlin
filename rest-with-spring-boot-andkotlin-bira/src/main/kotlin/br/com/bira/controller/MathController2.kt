package br.com.bira.controller

import br.com.bira.exceptions.UnsupportedMathOperationException
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

//@RestController
//@RequestMapping("/match")
class MathController2 {

    @GetMapping
    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable(value="numberOne") numberOne: String?,
            @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {

        if(numberOne.isNullOrBlank() || numberTwo.isNullOrBlank())
            throw UnsupportedMathOperationException("Please inform two numeric values!")

        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")

        return convertToDouble(numberOne) + convertToDouble(numberTwo)
    }

    @GetMapping
    @RequestMapping(value = ["/subtraction/{numberOne}/{numberTwo}"])
    fun subtraction(@PathVariable(value="numberOne") numberOne: String?,
                    @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {

        if(numberOne.isNullOrBlank() || numberTwo.isNullOrBlank())
            throw UnsupportedMathOperationException("Please inform two numeric values!")

        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")

        return convertToDouble(numberOne) - convertToDouble(numberTwo)
    }

    @GetMapping
    @RequestMapping(value = ["/multiplication/{numberOne}/{numberTwo}"])
    fun multiplication(@PathVariable(value="numberOne") numberOne: String?,
                       @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {

        if(numberOne.isNullOrBlank() || numberTwo.isNullOrBlank())
            throw UnsupportedMathOperationException("Please inform two numeric values!")

        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")

        return convertToDouble(numberOne) * convertToDouble(numberTwo)
    }

    @GetMapping
    @RequestMapping(value = ["/division/{numberOne}/{numberTwo}"])
    fun division(@PathVariable(value="numberOne") numberOne: String?,
                 @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {

        if(numberOne.isNullOrBlank() || numberTwo.isNullOrBlank())
            throw UnsupportedMathOperationException("Please inform two numeric values!")

        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")

        return convertToDouble(numberOne) / convertToDouble(numberTwo)
    }

    @GetMapping
    @RequestMapping(value = ["/mean/{numberOne}/{numberTwo}"])
    fun mean(@PathVariable(value="numberOne") numberOne: String?,
             @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {

        if(numberOne.isNullOrBlank() || numberTwo.isNullOrBlank())
            throw UnsupportedMathOperationException("Please inform two numeric values!")

        if(!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")

        return (convertToDouble(numberOne) + convertToDouble(numberTwo) ) / 2
    }

    @GetMapping
    @RequestMapping(value = ["/squareRoot/{number}"])
    fun squareRoot(@PathVariable(value="number") number: String?
    ): Double {

        if(number.isNullOrBlank() || number.isNullOrBlank())
            throw UnsupportedMathOperationException("Please inform two numeric values!")

        if(!isNumeric(number) || !isNumeric(number))
            throw UnsupportedMathOperationException("Please set a numeric value!")

        return Math.sqrt(convertToDouble(number))
    }


    private fun convertToDouble(strNumber: String?): Double {
        if(strNumber.isNullOrBlank()) return 0.0
        val number = strNumber.replace("," .toRegex(),".")
        return if(isNumeric(number)) number.toDouble() else 0.0
    }

    private fun isNumeric(strNumber: String?): Boolean {
        if(strNumber.isNullOrBlank()) return false
        val number = strNumber.replace("," .toRegex(),".")
        return number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }


}