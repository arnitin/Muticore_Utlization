case object Test2
case object Test

import scala.actors.Actor
import scala.actors.Actor._
import scala.math

class Boss(limit: Int,numberofitems: Int) extends Actor {
	def act() {
		var current:Int = 1
		var callBacks:Int = 0
		var ResultStringIn: String = ""
		var runningInstances:Int = 100000
		var EachActorHas = limit/runningInstances
		var i = 0
		while (current <= runningInstances) {
			var test_obj2  = new Worker(numberofitems,EachActorHas)
			test_obj2.start
			test_obj2 ! (1 + i * EachActorHas)
		//	println(1 + i * EachActorHas)
			current = current + 1
			i = i + 1
		}

		while(true) {
			receive {
				case x:String =>
					ResultStringIn =  ResultStringIn  + x
					callBacks = callBacks + 1
				//	println(ResultStringIn)
					if (callBacks == runningInstances){
					//  println(ResultStringIn)
					  exit()
					}
				case x:Int =>
				  	callBacks = callBacks + 1
				  	if (callBacks == runningInstances){
					 // println(ResultStringIn)
					  exit()
					}	
			}
		}
	}
}

class Worker(numberofitems: Int,till: Int) extends Actor {
	var ResultString:String = ""
	var found:Int = 0
	var thisNumber:Int = 0
	def act() {
		while (true) {
			react {
				case x:Int =>		
				  thisNumber = x
				  	while(thisNumber <= x + till) {
						var curval :Int = thisNumber
						var counter  = numberofitems
						var res = 0					
						while (counter > 0) {
							res += curval*curval
							curval = curval + 1
							counter = counter - 1
						}
						var sqrtno = math.sqrt(res)
						if(res%sqrtno == 0) {
							//println(thisNumber)
							ResultString = ResultString  + thisNumber + "\n"
							found = 1;
						} else {								
							
						}
						thisNumber = thisNumber + 1
				  	}
				  	if (found == 1) {				  	 
				  	  sender ! (ResultString)
				  	  exit()
				  	}  else {
				  	  sender ! 0
				  	  exit()
				  	}		  	
			}
		}
	}
}


object project1 {
    def main(args:Array[String]) : Unit = {
       val test_obj = new Boss(args(0).toInt,args(1).toInt)
       println("Start : " + System.currentTimeMillis)
       test_obj.start
       }
}