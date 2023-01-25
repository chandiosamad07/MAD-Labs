package com.example.hangmangame_assignment01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import java.util.HashMap
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private val words = arrayOf("ball", "account", "goggles", "noodles", "follower", "bitter", "egg", "been", "cool", "chess", "comma", "funny","hurry","press","rupee","yahoo","common","indeed","killed")
    var guessedWord : String = ""
    var won : Boolean = false
    var guessLeft : Int = 0
    private val images = arrayOf(R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five, R.drawable.six, R.drawable.seven)
    private var character : Char = ' '
    var word : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtGuess = findViewById<EditText>(R.id.txtEnterGuessWord)
        val btnGuess = findViewById<Button>(R.id.btnGuess)
        val btnNew = findViewById<Button>(R.id.btnNew)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val txtViewDescription = findViewById<TextView>(R.id.txtViewDescription)
        val txtViewGuess = findViewById<TextView>(R.id.txtViewGuessWord)
        val lblGuessLeft = findViewById<TextView>(R.id.guessLeft)

        val convertedWord = convertWord()
        txtViewGuess.text = convertedWord

        btnGuess.setOnClickListener(){
            val guessedChar : Char = txtGuess.text.toString()[0]
            if (guessLeft < 6 && !won){
                if(character === guessedChar){
                    won = true
                    txtViewDescription.text = "Wow! Your guess $guessedChar is Right.\nThe word is: $word \nClick New for next word."
                    txtGuess.isEnabled = false
                    btnGuess.isEnabled = false
                }
                else{
                    guessLeft++
                    txtViewDescription.text = "Your guess $guessedChar is Wrong!\nTry Again."
                    imageView.setImageResource(images[guessLeft])
                }
                lblGuessLeft.text = "Guess Left: "+(7-guessLeft)
            }
            else{
                if(!won){
                    btnGuess.isEnabled = false
                    txtGuess.isEnabled = false
                    lblGuessLeft.text = "Guess Left: "+(0)
                    txtViewDescription.text = "No Guess Left!\nYou lost the game.\nClick New for next word."
                }
            }
            txtGuess.text.clear()
        }
        btnNew.setOnClickListener(){
            txtViewDescription.text = "Enter Letter to Guess."
            imageView.setImageResource(images[0])
            txtGuess.isEnabled = true
            guessLeft = 0
            btnGuess.isEnabled = true
            txtGuess.text.clear()
            val convertedWord = convertWord()
            txtViewGuess.text = convertedWord
        }
    }

    private fun convertWord(): String {
        val randomIndex = (words.indices).random()
        word = words[randomIndex]
        var converting=""

        var flag = false

        word = word.toLowerCase()
        val map = HashMap<Any, Any>()
        for(i in word.toCharArray()){
            if (map.keys.contains(i)) {
                var x = map[i]
                map[i] = 1+x!! as Int
            } else {
                map[i] = 1
            }
        }
        for (c in map.keys) {
            if(map[c] as Int > 1){
                flag=true
                character = c as Char
            }
        }

        if(flag===true){
            for(c in word){
                if(c==character){
                    converting+='?'
                    continue
                }
                converting+=c as Char
            }
        }
        return converting
    }
}