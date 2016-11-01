package com.geb.demo

import geb.spock.GebReportingSpec
import com.geb.demo.pages.todo.AboutPage
import ratpack.groovy.test.GroovyRatpackMainApplicationUnderTest
import spock.lang.Shared
import spock.lang.Stepwise
import org.openqa.selenium.JavascriptExecutor

@Stepwise
class AboutFunctionalSpec extends GebReportingSpec {

    //tag::ratpack-geb[]
    @Shared
    def aut = new GroovyRatpackMainApplicationUnderTest()

    def setup() {
        URI base = aut.address
        browser.baseUrl = base.toString()
    }

    def "Go to About page"() {
        when: 'Go to About'
        to AboutPage

        then: 'Verify at About Page'
        at AboutPage
    }

    def "Test retrieving information"() {
        expect: 'Query p element'
        //tag::retrieving-info[]
        $("p").text() == "Sample text"
        $("#sample").tag() == "p"
        $("p").@title == "Sample p element"
        $("p").classes() == ["class-a", "class-b"]
        //end::retrieving-info[]
    }

    def cleanupSpec() {
        aut.stop()
    }

    def js( String script ){
        (driver as JavascriptExecutor).executeScript( script )
    }


}
