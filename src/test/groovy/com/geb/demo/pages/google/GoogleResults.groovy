package com.geb.demo.pages.google

import geb.Page

class GoogleResults extends Page {

    static at = {
        results.isDisplayed()
    }

    static content = {
        results { $("#search") }
        result {
            linkName -> results.find(
                    "h3.r a", text: contains(linkName))
        }
    }
}
