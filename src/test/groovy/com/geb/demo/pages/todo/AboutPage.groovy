package com.geb.demo.pages.todo

import geb.Page

class AboutPage extends Page {

    static url = "/about"

    static at = {
        title == "About"
    }

    static content = {
        header { $('h1', 0) }
    }
}
