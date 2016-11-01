package com.geb.demo

import com.geb.demo.pages.todo.AboutPage
import com.geb.demo.pages.todo.IndexPage
import geb.spock.GebReportingSpec
import ratpack.groovy.test.GroovyRatpackMainApplicationUnderTest
import ratpack.test.remote.RemoteControl
import spock.lang.Shared

class MenuExample extends GebReportingSpec {

    @Shared
    def aut = new GroovyRatpackMainApplicationUnderTest()

    RemoteControl remoteControl

    def setup() {
        URI base = aut.address
        browser.baseUrl = base.toString()
        remoteControl = new RemoteControl(aut)
    }

    def "Test navigation to about"() {
        when: 'Go to IndexPage'
        to IndexPage
        and: 'Click about menu item'
        menubar.about.click()

        then: 'Ensure we end at about page'
        at AboutPage
    }

    def cleanupSpec() {
        aut.stop()
    }
}
