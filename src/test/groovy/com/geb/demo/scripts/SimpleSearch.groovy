package com.geb.demo.scripts

import geb.Browser

Browser.drive {

    go "http://www.google.com"

    $("div").q = "geb"
    $("button", name: "btnG").click()

    waitFor { $("#search").displayed }

    $("#search h3.r").find(
            "a", text: contains("Very Groovy Browser Automation"))
            .click()

    waitFor { title.contains("Very Groovy Browser Automation")}
}
