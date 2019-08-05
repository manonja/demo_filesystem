package com.rtjvm.scala.oop.filesystem

// user input
import java.util.Scanner

import com.rtjvm.scala.oop.commands.Command
import com.rtjvm.scala.oop.files.Directory

object Filesystem extends App {
  val root = Directory.ROOT
  var state = State(root, root)
  // create a scanner object
  val scanner = new Scanner(System.in)
  // create infinite loop receiving our command
  while (true) {
    state.show
    val input = scanner.nextLine()
    state = Command.from(input).apply(state)
    // create package handling our commands

  }
}
