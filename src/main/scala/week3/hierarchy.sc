/* Importing class */
import week3.Rational
new Rational(1,3)


/* Null is a subtype of every class that inherits from Object; it is
incompatible with subtypes of AnyVal: */
val x = null // x: Null
val y: String = null // y: String
//val z: Int = null  -- error


/* Type: AnyVal, pois pode retornar Int ou Boolean */
if (true) 1 else false


/* Type: Nothing, pois não retorna nada, apenas para a execução */
def error(msg: String) = throw new Error(msg)
//error("testing exceptions")
















