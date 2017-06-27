package geniusk.rinc.dpcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textview = findViewById(R.id.main_test_text) as TextView
        val edittext = findViewById(R.id.main_test_edit) as EditText
        edittext.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                Log.d("textaction","after");
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.d("textaction","before");
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val txt: String = edittext.text.toString().trim()
                Log.i("bool", Pattern.matches("^\\d+$", txt).toString())
                if (Pattern.matches("^\\d+$", txt)) {
                    Log.i("txtmatch", "true")
                    val value: Float = txt.toFloat()
                    val result = getResult(value)
                    textview.text = result.toString()
                } else {
                    textview.text = "정수만 입력하세요!"
                }
            }

        })

        val inforBtn = findViewById(R.id.main_infor_btn) as ImageView
        var idx = 0;
        inforBtn.setOnClickListener{
            idx++
            Log.i("idx",idx.toString())
            if(idx <=3)
                Toast.makeText(this,"본 어플은 width : 100 기준으로 개발되었습니다",Toast.LENGTH_SHORT).show()
            else if(idx <= 7)
                Toast.makeText(this,"width : 100 기준으로 개발되었습니다... (어플이 화나요)",Toast.LENGTH_SHORT).show()
            else if(idx == 10) {
                Toast.makeText(this,"width : 100 기준이라고요! (어플이 화나서 종료됩니다)",Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }

    private fun getResult(value: Float): Double {
        return Math.round(value / 3.6 * 100) / 100.0
    }
}


