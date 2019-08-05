package com.rtjvm.scala.oop.commands

import com.rtjvm.scala.oop.filesystem.State

trait Command {
  // basic type of commands
  def apply(state: State): State
}

object Command {
  def from(input: String): Command =
    new UnknownCommand
}
