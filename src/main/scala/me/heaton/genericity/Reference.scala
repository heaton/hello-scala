package me.heaton.genericity

class Reference[T] {

  // _ is 0 for numeric types, false for the Boolean type,
  // () for the Unit type and null for all object types.
  private var contents: T = _

  def set(value: T) { contents = value }
  def get: T = contents

}