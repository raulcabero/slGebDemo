package com.geb.demo.pages.drag

import geb.Page


class DragPage extends Page {

    static url = "/drag.html"

    static content = {
        square { i -> module(DraggableSquare, $("div.draggable", i)) }
    }

}
