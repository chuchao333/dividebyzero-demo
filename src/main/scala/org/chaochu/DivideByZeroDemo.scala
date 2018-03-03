package org.chaochu 

import scala.tools.nsc.{Global, Phase}
import scala.tools.nsc.plugins.{Plugin, PluginComponent}

class DivideByZeroDemo(override val global: Global) extends Plugin {

  override val name: String = "dividebyzero-demo""
  override val description: String = "DivideByZero Demo plugin""

  override val components: List[PluginComponent] = List(new ScalaCompilerPluginComponent(global))
}

class ScalaCompilerPluginComponent(val global: Global) extends PluginComponent {
  override val phaseName: String = "dividebyzero"
  override val runsAfter: List[String] = List("parser")

  override def newPhase(prev: Phase): Phase = new StdPhase(prev) {
    override def apply(unit: global.CompilationUnit): Unit = {
      global.reporter.echo("implement me ")
    }
  }
}
