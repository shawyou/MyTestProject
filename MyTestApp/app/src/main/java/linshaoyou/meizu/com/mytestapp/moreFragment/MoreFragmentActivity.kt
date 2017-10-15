package linshaoyou.meizu.com.mytestapp.moreFragment

import android.app.FragmentTransaction
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

import linshaoyou.meizu.com.mytestapp.R

/**
 * Created by linshaoyou on 17/10/15.
 * 可以添加多个fragment的Activity
 */

class MoreFragmentActivity : AppCompatActivity() {

    @BindView(R.id.floatingActionButton)
    lateinit var mFloatingActionButton: FloatingActionButton
    lateinit var mFragmentTransaction: FragmentTransaction
    var mFragmentIndex: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_fragment)
        Log.e("LSY", "onCreate More FragmentActivity")
        ButterKnife.bind(this)
    }

    @OnClick(R.id.floatingActionButton)
    fun addFragment() {
        mFragmentTransaction = fragmentManager.beginTransaction()
        if (++mFragmentIndex % 2 == 0) {
            mFragmentTransaction.add(R.id.fragment, AnothorFragment())
        } else {
            mFragmentTransaction.add(R.id.fragment, OneFragment())
        }
        mFragmentTransaction.addToBackStack(null)
        mFragmentTransaction.commit()
        Toast.makeText(this, "目前存在" + mFragmentIndex + "个Fragment", Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (mFragmentIndex > 0) {
            mFragmentIndex--
            Toast.makeText(this, "目前存在" + mFragmentIndex + "个Fragment", Toast.LENGTH_SHORT).show()
        }
    }
}
