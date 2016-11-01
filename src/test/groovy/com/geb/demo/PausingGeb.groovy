package com.geb.demo

import com.geb.demo.pages.google.GitGeb
import com.geb.demo.pages.google.GooglePage
import geb.spock.GebReportingSpec
import spock.lang.Ignore

/**
 * Created by raul on 10/11/16.
 */
class PausingGeb extends GebReportingSpec {

    //@Ignore
    def "Go to geb on GitHub"() {
        when: "search geb"
        to GooglePage
        and: "pausing geb"
        pause()
        searchField = 'geb'
        searchButton.click()
        and: "click on a result"
        result("Very Groovy Browser Automation").click()

        then: "Verify at GitGeb page"
        waitFor { at GitGeb }
    }

    // https://github.com/tomaslin/grails-test-recipes
    // tag::pause-geb[]
    private void pause() {
        js.exec """(function() {
          window.__gebPaused = true;
          var div = document.createElement("div");
          div.setAttribute('style',
            "position: absolute; top:0px;right: 0px;z-index: 3000;\\
            padding: 10px; background-color: red;");
          var button = document.createElement("button");
          button.innerHTML = "Unpause Geb";
          button.onclick = function() {
              window.__gebPaused = false;
          }
          div.appendChild(button);
          document.getElementsByTagName("body")[0].appendChild(div);
        })();"""
        waitFor(300) { !js.__gebPaused }
    }

}
