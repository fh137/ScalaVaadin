package com.fh

import org.scalatest.{BeforeAndAfter, FunSuite}

/**
  * Created: 2017-07-15
  */
class AppTest extends FunSuite with BeforeAndAfter {
  var app: App = _

  before {
    app = new App
  }

  test( "make sure we calculate the correct msg" ) {
    assert( "Hello Vaadin!" == app.getMsg )
  }
}
