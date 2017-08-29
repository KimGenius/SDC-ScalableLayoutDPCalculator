package geniusk.rinc.dpcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_test_edit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val txt: String = main_test_edit.text.toString().trim()
                if (Pattern.matches("^[\\d]+(.[\\d]*)$", txt)) {
                    val value: Float = txt.toFloat()
                    val result = getResult(value)
                    main_test_text.text = result.toString()
                } else {
                    main_test_text.text = "숫자만 입력하세요!"
                }
            }

        })

        var idx = 0;
        main_infor_btn.setOnClickListener{
            idx++
            when {
                idx <=3 -> Toast.makeText(this,"본 어플은 width : 100 기준으로 개발되었습니다",Toast.LENGTH_SHORT).show()
                idx <= 7 -> Toast.makeText(this,"width : 100 기준으로 개발되었습니다... (어플이 화나요)",Toast.LENGTH_SHORT).show()
                idx == 10 -> {
                    Toast.makeText(this,"width : 100 기준이라고요! (어플이 화나서 종료됩니다)",Toast.LENGTH_LONG).show()
                    finish()
                }
            }
        }
    }

    private fun getResult(value: Float): Double {
        return Math.round(value / 3.6 * 100) / 100.0
    }
}


