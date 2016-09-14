

case class Pos(row: Int, col: Int)


val v = Vector(Vector('S', 'T'), Vector('o', 'o'), Vector('o', 'o'), Vector('o', 'b'))

val c = 'b'
val row = v.indexWhere( x => x.indexOf(c)  != -1)
val col = v(row).indexOf(c)


def terrainFunction(levelVector: Vector[Vector[Char]]): Pos => Boolean = {
def theTerrainFunction(p: Pos) : Boolean = {
if (levelVector.indices.exists(_ == p.row)) levelVector(p.row).indices.exists(_ == p.col)
else false
}
theTerrainFunction
}

terrainFunction(v)(new Pos(10,10))
terrainFunction(v)(new Pos(1,1))