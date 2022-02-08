package urias.andres.asignacion4_calculadoraimc_urias

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var IMC: Float = 0.0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnCalcular : Button = findViewById(R.id.btnCalcular) as Button
        var tvImc : TextView = findViewById(R.id.tvImc) as TextView
        var tvRange : TextView = findViewById(R.id.tvRange) as TextView

        btnCalcular.setOnClickListener {
            tvImc.setText(calcularIMC().toString())
            if(IMC < 18.5){
                tvRange.setText("Bajo peso")
                tvRange.setBackgroundResource(R.color.colorGreenish)
            }else if(IMC >= 18.5 && IMC <= 24.9){
                tvRange.setText("Normal")
                tvRange.setBackgroundResource(R.color.colorGreen)
            }else if(IMC >= 25 && IMC <= 29.9){
                tvRange.setText("Sobrepeso")
                tvRange.setBackgroundResource(R.color.colorYellow)
            }else if(IMC >= 30 && IMC <= 34.9){
                tvRange.setText("Obesidad grado 1")
                tvRange.setBackgroundResource(R.color.colorOrange)
            }else if(IMC >= 35 && IMC <= 39.9){
                tvRange.setText("Obesidad grado 2")
                tvRange.setBackgroundResource(R.color.colorRed)
            }else if(IMC >= 40){
                tvRange.setText("Obesidad grado 3")
                tvRange.setBackgroundResource(R.color.colorBrown)
            }

        }
    }

    fun calcularIMC(): Float{
        var weight: EditText = findViewById(R.id.weight) as EditText
        var height: EditText = findViewById(R.id.height) as EditText
        IMC = (weight.text.toString().toFloat()) / (height.text.toString().toFloat() * height.text.toString().toFloat())
        return IMC
    }
}