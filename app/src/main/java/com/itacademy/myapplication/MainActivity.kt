package com.itacademy.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.itacademy.myapplication.models.Gender
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var firstName: EditText
    lateinit var age: EditText
    lateinit var BirthDate: EditText
    lateinit var saveBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstName = findViewById(R.id.firstName)
        age = findViewById(R.id.age)
        BirthDate = findViewById(R.id.BirthDate)
        saveBtn = findViewById(R.id.saveBtn)

        val firstText = "Имя"
        val secondText = "Вася"
        val thirdText = "Возраст"
        val fourthText = 26
        var index = 1
        val count = 10
        //val array = mutableListOf<Int>(90,13,55,99)
        //array = 13

        while (count >= index) {//10>=10
            val answer = 3 * index
            val text = "3 * $index = $answer"
            Log.i("ANSWER", text)
            index += 1
        }



        //ИмяВасяВозраст26
        val firstTypeText = firstText + " " + secondText + thirdText + fourthText.toString()
        val secondTypeText = "$firstText $secondText"

        Log.i("Первый формат:", firstTypeText)
        Log.i("Второй формат:", secondTypeText)

        saveBtn.setOnClickListener {
            val name = firstName.text.toString()
            val ageText = age.text.toString().toInt()
            val birth = BirthDate.text.toString()
            val gender = Gender.male.value

            val user: User = User(name, ageText, gender, Date(2002,5,31))

            val intent = Intent(this,SecondActivity::class.java) // intent - путь
            intent.putExtra("user", user)
            startActivity(intent)
        }
    }

    override fun onResume(){
        super.onResume()
        Log.i("OnResume!!!", "ВОСПРОИЗВЕДЕНИЕ!!!")
    }

    override fun onStart() {
        super.onStart()
        Log.i("OnStart!!!", "СТАРТ!!!")
    }

    override fun onPause() {
        super.onPause()
        Log.i("OnPause!!!","ПАУЗА!!!")
        Toast.makeText(this, "onPause!!!", Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
        Log.i("OnStop!!!","СТОП!!!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("OnDestroy","Уничтожение")
    }
}