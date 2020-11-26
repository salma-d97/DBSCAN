class DBSCAN  (SetOfPoints: SetOfPoint, Eps : Float , MinPts : Int){


  def ExpandCluster (Pt: Point, NewClId : String) : Boolean = {
    var seed : SetOfPoint =SetOfPoints.RegionQuery(Pt,Eps)
    if (seed.Size < MinPts)
    {SetOfPoints.ChangeClId(Pt,"NOISE")
      return false }
    else {
      SetOfPoints.ChangeSetClId(seed,NewClId)
      seed.Suppression(Pt)
      while (!seed.isEmpty)
      { var CurrentP : Point = seed.MySet(0)
        var result : SetOfPoint = SetOfPoints.RegionQuery(CurrentP,Eps)
        if ( result.Size() >= MinPts)  {
          for ( i <- 0 to (result.Size -1)){
            var resultP : Point = result.MySet(i)
            if ( (resultP.ClId=="NOISE") || (resultP.ClId=="UNCLASSIFIED")) {
              if (resultP.ClId=="UNCLASSIFIED")  { seed.Ajout(resultP)}
              SetOfPoints.ChangeClId(resultP,NewClId)
            }
          }
        }
        seed.Suppression(CurrentP)
      }
      return true
    }
  }
  def NextId( S : String ) : String = {
    if(S=="NOISE") {
      return "0"
    }
    var p : Int = S.toInt
    p=p+1
    return (p.toString)
  }
  def DBSCAN_RUN(): Unit = {
    var ClusterId : String =NextId("NOISE")
    for( i <- 0 to (SetOfPoints.Size - 1)) {
      var Pt : Point = SetOfPoints.MySet(i)
      if (Pt.ClId=="UNCLASSIFIED") {
        if (ExpandCluster(Pt,ClusterId)) {
          ClusterId = NextId(ClusterId)
        }
      }
    }
  }
}
