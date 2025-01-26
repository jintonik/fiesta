package org.kotlin.fiesta.api.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ApplicationController {
    @GetMapping("index")
    fun loadPage(): String {
        return "index.html"
    }
}