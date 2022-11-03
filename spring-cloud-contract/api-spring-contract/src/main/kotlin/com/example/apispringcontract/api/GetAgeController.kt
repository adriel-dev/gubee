package com.example.apispringcontract.api

import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.badRequest
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/api/age")
class GetAgeController {

    @GetMapping("/year/{year}", produces = [APPLICATION_JSON_VALUE])
    fun getAge(@PathVariable year: Int): ResponseEntity<Map<String, Int>> {
        val currentYear = LocalDate.now().year
        if(year < 1900 || year > currentYear) return badRequest().build()
        return ok().body(mapOf(Pair("age", currentYear - year)))
    }

}