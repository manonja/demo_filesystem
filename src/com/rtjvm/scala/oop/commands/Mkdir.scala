package com.rtjvm.scala.oop.commands

import com.rtjvm.scala.oop.files.{DirEntry, Directory}
import com.rtjvm.scala.oop.filesystem.State

class Mkdir(name: String) extends Command {
  override def apply(state: State): State = {
    // Receive the wd from
    val wd = state.wd
    if (wd.hasEntry(name)) {
      state.setMessage("Entry " + name + " already exists!")
    } else if (name.contains(Directory.SEPARATOR)) {
      state.setMessage(name + " Must not contain separators")
    } else if (checkIllegal(name)) {
      state.setMessage(name + ": illegal entry name")
    } else {
      doMkdir(name, state)
    }
  }

  def checkIllegal(name: String): Boolean = {
    name.contains(".")
  }

  def doMkdir(name: String, state: State): State = {
    def updateStructure(currentDirectory: Directory, path: List[String], newEntry: DirEntry): Directory =
      

    val wd = state.wd

    // 1. all the directories in the full path
    val allDirsInPath = wd.getAllFoldersInPath
    // 2. create new directory entry in the wd
    val newDir = Directory.empty(wd.path, name)
    // 3. update the whole directory structure starting from root (directory structure is immutable!)
    val newRoot = updateStructure(state.root, allDirsInPath, newDir)
    // 4. find new directory INSTANCE given wd's fullPath, in the NEW directory structure
    val newWd = newRoot.findDescendant(allDirsInPath)

    State(newRoot, newWd)
  }

}
