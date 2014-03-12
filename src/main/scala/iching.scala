import scala.util.Random
import org.json4s._
import org.json4s.JsonDSL._
import org.json4s.native.JsonMethods._

object Iching {
	def main(args: Array[String]) {

		case class EditedSounds(
		  duration: String,
		  sound: String,
		  effect: String
		)

		case class EditedTrack(
  		track: Seq[EditedSounds] = Seq()
		)

		/*val sound1 = EditedSounds("0.45","dentist drill","reverse")
		val sound2 = EditedSounds("1.2","frying egg","flanger")

		val sample = EditedTrack(Seq(sound1,sound2))

		val json = Map(
			"track1" -> sample.track.map { s =>
				Map(
					"duration" -> s.duration,
					"sound" -> s.sound,
					"effect" -> s.effect
				)
			}
		)

		println(compact(render(json)))*/


		val dice = new Random()
		val durations = Map(1 -> "0.45",2 -> "1",3 -> "0.10",4 -> "1.3",5 -> "0.5",6 -> "1.2",7 -> "0.20",8 -> "0",9 -> "0.55",10 -> "1.1",11 -> "1.10",12 -> "2")
		val sounds = Map(1 -> "car honk", 2 -> "dentist drill", 3 -> "keyboard typing", 4 -> "frying egg", 5 -> "magnet toss", 6 -> "dog bark", 7 -> "air brake", 8 -> "scream", 9 -> "gun shot", 10 -> "tube amp", 11 -> "wind", 12 -> "sine wave")
		val effects = Map(1 -> "reverse", 2 -> "lowpass filter", 3 -> "reverb", 4 -> "bitcrush", 5 -> "ping pong delay", 6 -> "highpass filter", 7 -> "preverb", 8 -> "invert phase", 9 -> "doppler", 10 -> "flanger", 11 -> "combfilter", 12 -> "none")

		// val durationRoll = 1 to 12 map { _ => durations.get(dice.nextInt(12+1)).getOrElse(0) }
		// val soundsRoll = 1 to 12 map { _ => sounds.get(dice.nextInt(12)).getOrElse(0) }
		// val effectsRoll = 1 to 12 map { _ => effects.get(dice.nextInt(12)).getOrElse(0) }

		// println("durationRoll "+ durationRoll)
		// println("soundsRoll "+ soundsRoll)
		// println("effectsRoll "+ effectsRoll)

		// val track1 = 0 to 11 map { a => Tuple3(durations.values.toList(a),sounds.values.toList(a),effects.values.toList(a)) }
		val track1 = 0 to 11 map { a => EditedSounds(durations.get(dice.nextInt(12)).getOrElse(0).toString,sounds.get(dice.nextInt(12)).getOrElse(""),effects.get(dice.nextInt(12)).getOrElse("")) }
		val track2 = 0 to 11 map { a => EditedSounds(durations.get(dice.nextInt(12)).getOrElse(0).toString,sounds.get(dice.nextInt(12)).getOrElse(""),effects.get(dice.nextInt(12)).getOrElse("")) }
		val track3 = 0 to 11 map { a => EditedSounds(durations.get(dice.nextInt(12)).getOrElse(0).toString,sounds.get(dice.nextInt(12)).getOrElse(""),effects.get(dice.nextInt(12)).getOrElse("")) }
		val track4 = 0 to 11 map { a => EditedSounds(durations.get(dice.nextInt(12)).getOrElse(0).toString,sounds.get(dice.nextInt(12)).getOrElse(""),effects.get(dice.nextInt(12)).getOrElse("")) }
		val track5 = 0 to 11 map { a => EditedSounds(durations.get(dice.nextInt(12)).getOrElse(0).toString,sounds.get(dice.nextInt(12)).getOrElse(""),effects.get(dice.nextInt(12)).getOrElse("")) }
		val track6 = 0 to 11 map { a => EditedSounds(durations.get(dice.nextInt(12)).getOrElse(0).toString,sounds.get(dice.nextInt(12)).getOrElse(""),effects.get(dice.nextInt(12)).getOrElse("")) }
		
		println("track1 "+ track1)
		// val score = track1 ++ track2 ++ track3 ++ track4 ++ track5 ++ track6
		// println("full score is "+score.toString)
	}
}
