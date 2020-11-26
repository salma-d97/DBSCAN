import java.io.File
import java.io.PrintWriter

import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object Test1 {
  def main (args: Array[String]) : Unit = {

    val SOP : SetOfPoint = new SetOfPoint()
    val lines = Source.fromFile("PATH OF THE DATASET FILE").getLines.toArray
    val dimChoisi : Int =4  // number of features 

   for(str <- lines){
     val words = str.split("\t")
      
     val tab :  ArrayBuffer[Float] = ArrayBuffer.empty[Float]

    for ( i <- 0 to ( dimChoisi -1)) {
       tab+=words(i).toFloat
     }

       var Pt: Point = new Point(dimChoisi, tab)
       SOP.Ajout(Pt)
      }
      val p : Double =0.1

       val r : Float = p.toFloat
       val db : DBSCAN = new DBSCAN(SOP,r,200)
       db.DBSCAN_RUN()
   // outputs each point a,d the cluster it belongs to
   val writer = new PrintWriter(new File(CUsersPROXY INFODesktopResults.txt))

    for(p1 <- SOP.MySet)
    {
      println( p1.ClId)
    }
 writer.close()
  }
}
