package com.geb.demo.pages.todo

import geb.Page
import com.geb.demo.modules.TodoItemModule
import com.geb.demo.modules.MenubarModule

class IndexPage extends Page {
    static url = "/"


    static atCheckWaiting = true
    static at = {
        title == "Todo List"
        $("#count").text()
    }


    static content = {
        count { $("#count") }
        countValue(required: false) { count.text() }

        menubar { module MenubarModule }
        todos(required: false) {
            $('li.todo-item').moduleList(TodoItemModule)
        }


        //todo(required: false) { index -> todos[index] }

        todoInput { $("#new-todo") }
        todoSubmit { $("#create-btn") }

      }
}
