package linshaoyou.meizu.com.mytestapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import linshaoyou.meizu.com.mytestapp.moreFragment.MoreFragmentActivity
import linshaoyou.meizu.com.mytestapp.singleFragment.SingleFragmentActivity

class MainActivity : AppCompatActivity() {

    @BindView(R.id.hello)
    lateinit var helloText1 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        helloText1.setText("这个是1.0.0 补丁 版本，呵呵哒~ ")
    }

    @OnClick(R.id.singleFragmentButton)
    fun turnToFragmentActivity(){
        var intent = Intent()
        intent.setClass(this, SingleFragmentActivity::class.java)
        startActivity(intent)
    }

    @OnClick(R.id.moreFragmentButton)
    fun turnToMoreActivity(){
        var intent = Intent(this, MoreFragmentActivity::class.java)
        startActivity(intent)
    }
}
