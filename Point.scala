import scala.collection.mutable.ArrayBuffer
class Point (var dim: Int, var features : ArrayBuffer[Float] , var ClId : String = "UNCLASSIFIED" ) {

  def ClId_( ci : String) = {
    this.ClId= ci
  }
  def Distance ( p : Point) : Float = {
    var d : Float = 0

    for ( i <- 0 to (dim -1)){
    d+= ((this.features(i)-p.features(i))*(this.features(i)-p.features(i)))
    }
    return d
  }
}
