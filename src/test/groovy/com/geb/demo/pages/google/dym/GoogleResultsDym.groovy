package com.geb.demo.pages.google.dym

import geb.Page

class GoogleResultsDym extends Page {

    static at = {
        $("#search").isDisplayed()
    }

    static content = {
        results { $("div.g") }

        result { index -> results[index] }

        resultLink { index -> result(index).find("h3.r a", 0) }

        firstLink { resultLink(0) }
    }
}
