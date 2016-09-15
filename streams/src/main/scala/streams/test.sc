

case class Pos(row: Int, col: Int)


val levelVector = Vector(Vector('S', 'T'), Vector('o', 'o'), Vector('o', 'o'), Vector('o', 'b'), Vector('-', '-') )

val c = 'b'
val row = levelVector.indexWhere( x => x.indexOf(c)  != -1)
val col = levelVector(row).indexOf(c)


def terrainFunction(levelVector: Vector[Vector[Char]]): Pos => Boolean = {
  def theTerrainFunction(p: Pos) : Boolean = {
    if (levelVector.indices.exists(_ == p.row) && levelVector(p.row).indices.exists(_ == p.col) && levelVector(p.row)(p.col) != '-' ) true
    else false
  }
  theTerrainFunction
}

terrainFunction(levelVector)(new Pos(10,10))
terrainFunction(levelVector)(new Pos(4,1))
terrainFunction(levelVector)(new Pos(1,1))
terrainFunction(levelVector)(new Pos(2,0))