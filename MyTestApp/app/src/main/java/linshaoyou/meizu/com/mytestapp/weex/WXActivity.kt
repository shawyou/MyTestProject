package linshaoyou.meizu.com.mytestapp.weex

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.taobao.weex.IWXRenderListener
import com.taobao.weex.WXSDKInstance
import com.taobao.weex.common.WXRenderStrategy
import com.taobao.weex.utils.WXFileUtils
import linshaoyou.meizu.com.mytestapp.R

/**
 * Created by linshaoyou on 17/10/28.
 */

class WXActivity : AppCompatActivity(), IWXRenderListener {
    override fun onRefreshSuccess(instance: WXSDKInstance?, width: Int, height: Int) {
        Log.e("LSY", "onRefreshSuccess width == " + width + ", height == " + height)
    }

    override fun onException(instance: WXSDKInstance?, errCode: String?, msg: String?) {
        Log.e("LSY", "onException errCode == " + errCode + ", msg == " + msg)
    }

    override fun onViewCreated(instance: WXSDKInstance?, view: View?) {
        setContentView(view)
    }

    override fun onRenderSuccess(instance: WXSDKInstance?, width: Int, height: Int) {
        Log.e("LSY", "onRenderSuccess WIDTH == " + width + ", height == " + height)
    }

    var mWXSDKInstanse: WXSDKInstance? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xw)
        mWXSDKInstanse = WXSDKInstance(this)
        mWXSDKInstanse!!.registerRenderListener(this)
        mWXSDKInstanse!!.render(
                "WXSample",
                WXFileUtils.loadFileContent("index.js", this),
                null,
                null,
                -1,
                -1,
                WXRenderStrategy.APPEND_ASYNC)
    }

    override fun onStart() {
        super.onStart()
        mWXSDKInstanse?.onActivityStart()
    }

    override fun onResume() {
        super.onResume()
        mWXSDKInstanse?.onActivityResume()
    }

    override fun onPause() {
        super.onPause()
        mWXSDKInstanse?.onActivityPause()
    }

    override fun onStop() {
        super.onStop()
        mWXSDKInstanse?.onActivityStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mWXSDKInstanse?.onActivityDestroy()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        mWXSDKInstanse?.onActivityBack()
    }
}