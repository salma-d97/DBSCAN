import scala.collection.mutable.ArrayBuffer

class SetOfPoint ( var MySet : ArrayBuffer[Point] = ArrayBuffer.empty[Point]){
  def Size() : Int ={
    return MySet.length
  }

  def Ajout ( A : Point ) : Unit ={
    this.MySet+=A
  }

  def Suppression ( A : Point ) : Unit ={
    this.MySet-=A
  }
  def ChangeClId( P: Point, NClId: String): Unit = {
    MySet(MySet.indexOf(P)).ClId=NClId
  }
  def isEmpty() : Boolean = {
    return MySet.isEmpty
  }
  def ChangeSetClId( NewSet : SetOfPoint, NClId: String): Unit = {
    var sd : ArrayBuffer[Point] = NewSet.MySet
    for(p1 <- sd)
    {
      p1.ClId = NClId
    }
  }

  def RegionQuery(P: Point, Eps: Float) : SetOfPoint= {
    var nset: SetOfPoint = new SetOfPoint
    for( p1 <- MySet)
    {
      if ( P.Distance(p1) <= (Eps*Eps))
        nset.Ajout(p1)
    }
    return nset
  }
}
