package com.geb.demo

import com.geb.demo.pages.google.GitGeb
import com.geb.demo.pages.google.GooglePage
import geb.spock.GebReportingSpec

class GoogleExample extends GebReportingSpec {

    def "Go to geb on GitHub"() {
        when: "search geb"
        to GooglePage
        searchField = 'geb'
        searchButton.click()
        and: "click on a result"
        result("Very Groovy Browser Automation").click()

        then: "Verify at GitGeb page"
        waitFor { at GitGeb }
    }

}
