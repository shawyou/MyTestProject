package linshaoyou.meizu.com.mytestapp.singleFragment

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

import linshaoyou.meizu.com.mytestapp.R

/**
 * Created by linshaoyou on 17/10/15.
 * 该Activity只添加了一个fragment，该fragment在xml中添加
 */

class SingleFragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singlefragment)
        Log.e("LSY", "onCreate")
//        var transaction = fragmentManager.beginTransaction()
//        transaction.replace(R.id.my_fragment, MyFragment())
//        transaction.addToBackStack(null)
//        transaction.commit()
    }

    override fun onRestart() {
        super.onRestart()
        //在此activity显示时，按下home键，回到桌面；
        //再重点击应用回到该activity时，会先回调这个方法，然后才调用onStart()方法
        Log.e("LSY", "SingleFragmentActivity onRestart")
    }

    override fun onStart() {
        super.onStart()
        Log.e("LSY", "SingleFragmentActivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("LSY", "SingleFragmentActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("LSY", "SingleFragmentActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("LSY", "SingleFragmentActivity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("LSY", "SingleFragmentActivity onDestroy")
    }
}
