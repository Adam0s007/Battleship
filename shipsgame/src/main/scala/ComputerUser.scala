import Constants._
import SimpleUser.trials

import scala.util.Random

object ComputerUser extends User {
  var board: Board
  var enemy_board: Board
  var points: Int = 0
  var trials: Int = 0
  override def attack(x_x:Int=1,y_y:Int=1): Unit = {//pomysl: zrobic bardziej inteligentnego kompa, ktory bedzie wiedzial gdzie strzelac,
    //np. jesli trafil to strzelaj wokol tego miejsca, jesli nie to strzelaj losowo

      var x = Random.nextInt(10)
      var y = Random.nextInt(10)

    if (enemy_board.alreadyMissed(x, y) || enemy_board.alreadyBombarded(x, y)) println("Komputer trafil w pole wczesniej trafione!")
    else if (enemy_board.tryAttack(x, y)) { //od razu usuwanie wektora z enemy_board jesli sie powiedzie atak
      println(s"Komputer trafil na polu ($x, $y)!")
      points += ACQUIRED_POINTS
    } else {
      println(s"Komputer chybil na polu ($x, $y).")
      points -= LOST_POINTS
    }
    trials+=1
  }

  override def isDefeated(): Boolean = {
    board.isEmpty
  }
}
