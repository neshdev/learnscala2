abstract class JSON

case class JSeq(elems: List[JSON]) extends JSON

case class JObj(bindings: Map[String, JSON]) extends JSON

case class JNum(num: Double) extends JSON

case class JStr(str: String) extends JSON

case class JBool(b: Boolean) extends JSON

case object JNull extends JSON

type JBinding = (String, JSON)

val data = JObj(Map(
  "firstName" -> JStr("John"),
  "lastName" -> JStr("Smith"),
  "address" -> JObj(Map(
  "streetAddress" -> JStr("21 2nd Stree")
  ))
))

//def show(json: JSON) : String = json match {
//  case JSeq(elems) => "[" + (elems map show mkString ", ") + "]"
//  case JObj(bindings) =>
//    val assocs = bindings map {
//      case (key, value) => "\"" + key + "\": " + show(value)
//    }
//
//  case JNum(num) => num.toString
//  case JStr(str) => '\"' + str + '\"'
//  case JBool(b) => b.toString
//  case JNull => "null"
//}
//
//show(data)

val f:PartialFunction[String,String] = { case "ping" => "pong"}
f.isDefinedAt("ping")
f.isDefinedAt("abc")