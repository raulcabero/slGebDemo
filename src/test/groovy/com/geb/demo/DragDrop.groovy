package com.geb.demo

import com.geb.demo.pages.drag.DragPage
import com.geb.demo.pages.drag.DraggableSquare
import geb.spock.GebSpec
import ratpack.groovy.test.GroovyRatpackMainApplicationUnderTest
import spock.lang.Ignore
import spock.lang.Shared


class DragDrop extends GebSpec {

    @Shared
    def aut = new GroovyRatpackMainApplicationUnderTest()

    def setup() {
        URI base = aut.address
        browser.baseUrl = base.toString()
    }

    //@Ignore
    def "can drag squares"() {
        given:
        to DragPage

        def greenSquare = square(0) //DraggableSquare greenSquare = square(0)
        def blueSquare = square(1) //DraggableSquare blueSquare = square(1)

        when:
        blueSquare.drag(200, 200)

        def blueTopLeft = [blueSquare.x, blueSquare.y]
        def blueBottomLeft = [blueSquare.x, blueSquare.y + blueSquare.height]
        def blueBottomRight = [blueSquare.x + blueSquare.width, blueSquare.y + blueSquare.height]
        def blueTopRight = [blueSquare.x + blueSquare.width, blueSquare.y]

        6.times {
            // top left
            greenSquare.dragTo(blueTopLeft[0] - greenSquare.width, blueTopLeft[1] - greenSquare.height)

            // bottom left
            greenSquare.dragTo(blueBottomLeft[0] - greenSquare.width, blueBottomLeft[1])

            // bottom right
            greenSquare.dragTo(blueBottomRight[0], blueBottomRight[1])

            // top right
            greenSquare.dragTo(blueTopRight[0], blueTopRight[1] - greenSquare.height)
        }

        then:
        true
    }

    def cleanupSpec() {
        aut.stop()
    }

}
