package com.geb.demo

import ratpack.groovy.test.GroovyRatpackMainApplicationUnderTest
import ratpack.test.remote.RemoteControl
import geb.spock.GebReportingSpec
import com.geb.demo.pages.todo.IndexPage
import spock.lang.Shared
import spock.lang.Stepwise

@Stepwise
class TodoListExample extends GebReportingSpec {

    @Shared
    def aut = new GroovyRatpackMainApplicationUnderTest()

    RemoteControl remoteControl

    def setup() {
        URI base = aut.address
        browser.baseUrl = base.toString()
        remoteControl = new RemoteControl(aut)
    }

    def "Go to index page"() {
        when: 'Go to index url'
        to IndexPage

        then: 'Verify 3 items present'
        at IndexPage
        countValue == '3'
    }

    def "Create new todo"() {
        when: 'Input text and submit'
        todoInput = "Do this"
        todoSubmit.click()

        then: 'Verify new item present in list'
        waitFor { countValue == '4'}
        todos.any{ it.label == 'Do this' }

        and: 'Verify input field empty'
        !todoInput.text()
    }

    def "Delete todo item"() {
        when: 'Click delete and accept'
        withConfirm {
            todos.find{ it.label == 'Do this' }.deleteBtn.click()
        }

        then: 'Verify item deleted'
        waitFor {countValue == '3'}
        todos.every{ it.label != 'Do this' }
    }

    def cleanupSpec() {
        aut.stop()
    }

}
