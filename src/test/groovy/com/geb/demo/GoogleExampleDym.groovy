package com.geb.demo

import com.geb.demo.pages.google.dym.GooglePageDym
import geb.spock.GebReportingSpec

class GoogleExampleDym extends GebReportingSpec {

    def "Go to geb on GitHub"() {
        when: "search geb"
        to GooglePageDym
        searchField = 'geb'
        searchButton.click()
        and: "click on a result"
        println results.size()
        //firstLink.click()
        resultLink(5).click()

        then: "Verify at GitGeb page"
        true
    }
}