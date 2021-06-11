package ordunio.maribel.guessthenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var maxNumber = 100
    var minNumber= 0
    var number: Int = 0
    var won: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guessings: TextView = findViewById(R.id.guessings)
        val up: Button = findViewById(R.id.up)
        val down: Button = findViewById(R.id.down)
        val generate: Button = findViewById(R.id.generate)
        val guessed: Button = findViewById(R.id.guessed)


        fun checkingLimits(): Boolean{
            return minNumber != maxNumber
        }

        fun resetNumbers(){
            minNumber= 0
            maxNumber= 100
            number= 0
            won= false
        }

        generate.setOnClickListener {
            number = Random.nextInt(minNumber, maxNumber)
            guessings.setText(number.toString())
            generate.visibility = View.INVISIBLE
            guessed.visibility = View.VISIBLE
        }

        up.setOnClickListener {
           if(checkingLimits()){
               minNumber = number
               number = Random.nextInt(minNumber, maxNumber)
               guessings.setText(number.toString())
           }else{
               guessings.setText("Has acertado, te la rifaste")
           }


        }

        down.setOnClickListener {
            if(checkingLimits()){
                maxNumber = number
                number = Random.nextInt(minNumber, maxNumber)
                guessings.setText(number.toString())
            }else{
                guessings.setText("Has acertado, te la rifaste")

            }
        }

        guessed.setOnClickListener {

            if(!won){
                guessings.setText("Acerté, tu número es: "+number)
                guessed.setText("Play again")
                won = true
            }else{
                generate.visibility = View.VISIBLE
                guessings.setText("Tap on generate to start")
                guessed.visibility = View.GONE
                resetNumbers()
            }

        }

        fun quejaleGithubParo(){

        }

    }
}