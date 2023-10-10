package kr.hs.emirim.lhj.vote2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        title = "투표 결과"

        var intent=intent
        //ResultActivity를 시작시킨 intent 객체에서
        //투표수가 저장된 배열객체 참조값과
        //이미지 이름이 저장된 배열 객체 참조값을 반환받음
        var voteCount=intent.getIntArrayExtra("voteCount")
        var imgName=intent.getStringArrayExtra("imgName")

        // 이미지 이름이 나타날  textView 객체의 참조값을 저장할 1차원 배열
        var tv= arrayOfNulls<TextView>(imgName!!.size)
        //투표수가 나타날 RatingBar 객체의 참조값을 저장할 1차원 배열
        var rBar= arrayOfNulls<RatingBar>(imgName!!.size)

        //textview객체의 Id값 저장할 1차원 배열
        var tvId= arrayOf(R.id.tv1,R.id.tv2,R.id.tv3,
                            R.id.tv4,R.id.tv5,R.id.tv6,
                            R.id.tv7,R.id.tv8,R.id.tv9,)
        //RatingBar 객체의 Id값 저장할 1차원 배열
        var rBarId= arrayOf(R.id.rbar1,R.id.rbar2,R.id.rbar3,
            R.id.rbar4,R.id.rbar5,R.id.rbar6,
            R.id.rbar7,R.id.rbar8,R.id.rbar9,)

        for(i in imgName.indices){
            tv[i]=findViewById<TextView>(tvId[i])
            tv[i]!!.setText(imgName[i])
            rBar[i]=findViewById<RatingBar>(rBarId[i])
            rBar[i]!!.rating=voteCount!![i].toFloat()

        }

        var btnReturn=findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener{
            finish()
        }
    }
}