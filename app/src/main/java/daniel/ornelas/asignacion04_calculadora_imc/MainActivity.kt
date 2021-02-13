package daniel.ornelas.asignacion04_calculadora_imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val height: EditText = findViewById(R.id.height)
        val weight: EditText = findViewById(R.id.weight)
        val btnCalculate: Button = findViewById(R.id.btnCalcular)

        var IMC: TextView = findViewById(R.id.imc)
        var range: TextView = findViewById(R.id.range)

        btnCalculate.setOnClickListener {
            var IMCcalulado = "%.2f".format((weight.text.toString().toFloat())/(Math.pow(height.text.toString().toDouble(),2.0))).toDouble()
            IMC.setText(IMCcalulado.toString())
            setRange(IMCcalulado,range)


        }
    }

    fun setRange(IMC: Double ,range: TextView) {
        when(IMC) {
            in 0.0..18.4 -> {
                range.setText("Bajo Peso")
                range.setBackgroundResource(R.color.colorGreenish)
            }
            in 18.5..24.9 -> {
                range.setText("Normal")
                range.setBackgroundResource(R.color.colorGreen)
            }
            in 25.0..29.9 -> {
                range.setText("SobrePeso")
                range.setBackgroundResource(R.color.colorOrange)
            }
            in 30.0..34.9 -> {
                range.setText("Obesidad Grado 1")
                range.setBackgroundResource(R.color.colorRed)
            }
            in 35.0..39.9 -> {
                range.setText("Obesidad Grado 2")
                range.setBackgroundResource(R.color.colorRed)
            }
            in 40.0..120.0 -> {
                range.setText("Obesidad Grado 3")
                range.setBackgroundResource(R.color.colorBrown)
            }
        }
    }
}