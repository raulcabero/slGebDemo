package com.geb.demo.pages.drag

import geb.Module


class DraggableSquare extends Module {

    void drag(int xOffset, int yOffset) {
        def endX = x + xOffset
        def endY = y + yOffset

        def chunks = 6

        def xChunkSize = Math.abs(Math.ceil((xOffset / chunks).toDouble()).toInteger())
        def yChunkSize = Math.abs(Math.ceil((yOffset / chunks).toDouble()).toInteger())

        (chunks + 1).times { i ->
            def distanceToX = Math.max(x, endX) - Math.min(x, endX)
            def distanceToY = Math.max(y, endY) - Math.min(y, endY)

            def moveX = x == endX ? 0 : Math.min(distanceToX, xChunkSize)
            def moveY = y == endY ? 0 : Math.min(distanceToY, yChunkSize)

            if (xOffset < 0) {
                moveX = 0 - moveX
            }

            if (yOffset < 0) {
                moveY = 0 - moveY
            }

            browser.interact {
                //dragAndDropBy $(), moveX, moveY
                dragAndDropBy this, moveX, moveY
            }
        }

        assert x == endX
        assert y == endY
    }

    void dragTo(int toX, int toY) {
        drag(toX - x, toY - y)
    }

}
