import scala.util.Random
import org.json4s._
import org.json4s.JsonDSL._
import org.json4s.native.JsonMethods._
import java.io._

object Iching {
	def main(args: Array[String]) {

		/***
		*		Define the json object structure
		*		A Score consists of EditedTrack, EditedTrack consist of EditedSounds
		*		The goal is to have a visible structure for how to build your score
		*		Futhur improvements to come!
		*/
		case class EditedSounds(
		  duration: String,
		  sound: String,
		  effect: String
		)

		case class EditedTrack(
  		track: Seq[EditedSounds] = Seq()
		)

		val dice = new Random()
		val durations = Map(1 -> "0.45",2 -> "1",3 -> "0.10",4 -> "1.3",5 -> "0.5",6 -> "1.2",7 -> "0.20",8 -> "0",9 -> "0.55",10 -> "1.1",11 -> "1.10",12 -> "2")
		val sounds = Map(1 -> "car honk", 2 -> "dentist drill", 3 -> "keyboard typing", 4 -> "frying egg", 5 -> "magnet toss", 6 -> "dog bark", 7 -> "air brake", 8 -> "scream", 9 -> "gun shot", 10 -> "tube amp", 11 -> "wind", 12 -> "sine wave")
		val effects = Map(1 -> "reverse", 2 -> "lowpass filter", 3 -> "reverb", 4 -> "bitcrush", 5 -> "ping pong delay", 6 -> "highpass filter", 7 -> "preverb", 8 -> "invert phase", 9 -> "doppler", 10 -> "flanger", 11 -> "combfilter", 12 -> "none")

		val track1 = 0 to 11 map { a => EditedSounds(durations.get(dice.nextInt(12)).getOrElse(0).toString,sounds.get(dice.nextInt(12)).getOrElse(""),effects.get(dice.nextInt(12)).getOrElse("")) }
		val track2 = 0 to 11 map { a => EditedSounds(durations.get(dice.nextInt(12)).getOrElse(0).toString,sounds.get(dice.nextInt(12)).getOrElse(""),effects.get(dice.nextInt(12)).getOrElse("")) }
		val track3 = 0 to 11 map { a => EditedSounds(durations.get(dice.nextInt(12)).getOrElse(0).toString,sounds.get(dice.nextInt(12)).getOrElse(""),effects.get(dice.nextInt(12)).getOrElse("")) }
		val track4 = 0 to 11 map { a => EditedSounds(durations.get(dice.nextInt(12)).getOrElse(0).toString,sounds.get(dice.nextInt(12)).getOrElse(""),effects.get(dice.nextInt(12)).getOrElse("")) }
		val track5 = 0 to 11 map { a => EditedSounds(durations.get(dice.nextInt(12)).getOrElse(0).toString,sounds.get(dice.nextInt(12)).getOrElse(""),effects.get(dice.nextInt(12)).getOrElse("")) }
		val track6 = 0 to 11 map { a => EditedSounds(durations.get(dice.nextInt(12)).getOrElse(0).toString,sounds.get(dice.nextInt(12)).getOrElse(""),effects.get(dice.nextInt(12)).getOrElse("")) }
		
		// TODO make it this much more flexible
		val score = Map(
			"track1" -> track1.map { s =>
				Map(
					"duration" -> s.duration,
					"sound" -> s.sound,
					"effect" -> s.effect
				)
			},
			"track2" -> track2.map { s =>
				Map(
					"duration" -> s.duration,
					"sound" -> s.sound,
					"effect" -> s.effect
				)
			},
			"track3" -> track3.map { s =>
				Map(
					"duration" -> s.duration,
					"sound" -> s.sound,
					"effect" -> s.effect
				)
			},
			"track4" -> track4.map { s =>
				Map(
					"duration" -> s.duration,
					"sound" -> s.sound,
					"effect" -> s.effect
				)
			},
			"track5" -> track5.map { s =>
				Map(
					"duration" -> s.duration,
					"sound" -> s.sound,
					"effect" -> s.effect
				)
			},
			"track6" -> track6.map { s =>
				Map(
					"duration" -> s.duration,
					"sound" -> s.sound,
					"effect" -> s.effect
				)
			}
		)

		// println(pretty(render(score)))
		println("Writing to file!")

		// FileWriter
		val file = new File("score.json")
		val bw = new BufferedWriter(new FileWriter(file))
		bw.write(pretty(render(score)))
		bw.close()

		println("Finished Writing to file!")
	}
}
