package com.geb.demo.pages.google.dym

import geb.Page

class GooglePageDym extends Page {

    static url = "http://www.google.com"

    static at = {
        title == "Google"
    }

    static content = {
        searchField { $("input", name: "q") }
        searchButton(to: GoogleResultsDym, toWait: true) {
            $("button", name: "btnG")
        }
    }
}