package com.fh

import javax.servlet.annotation.WebServlet

import com.vaadin.annotations.{Theme, Title, VaadinServletConfiguration}
import com.vaadin.server.{VaadinRequest, VaadinServlet}
import com.vaadin.ui._
import org.slf4j.LoggerFactory

/**
  * Servlet definition with annotations, so that we can avoid using a web.xml file.
  * Points to our sub-class of the Vaadin UI.
  * Created by fh on 2/12/2017.
  */
@WebServlet(value=Array("/*"), asyncSupported=true)
@VaadinServletConfiguration(productionMode=false, ui=classOf[App])
class Servlet extends VaadinServlet

/**
  * Vaadin application.
  * Created by fh on 2/12/2017.
  */
@Theme( "fh1" )
@Title( "Hello World Application" )
class App extends UI {
  private val log = LoggerFactory.getLogger( classOf[App] )

  override def init(request: VaadinRequest): Unit = {
    try {
      log.info( "init" )

      val view = new VerticalLayout()
      view.setStyleName( "bgYellow" )   // highlight the background of this view, so that we can see it on the page
      view.addComponent(new Label( getMsg ))

      setContent(view)
    } catch {
      case t: Throwable => log.error( "Failed miserably", t )
    }
  }

  def getMsg = "Hello Vaadin!"
}
