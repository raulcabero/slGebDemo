package com.geb.demo.pages.google

import geb.Page

class GooglePage extends Page {

    static url = "http://www.google.com"

    static at = {
        title == "Google"
    }

    static content = {
        searchField { $("input", name: "q") }
        searchButton(to: GoogleResults, toWait: true) {
            $("button", name: "btnG")
        }
    }

}
