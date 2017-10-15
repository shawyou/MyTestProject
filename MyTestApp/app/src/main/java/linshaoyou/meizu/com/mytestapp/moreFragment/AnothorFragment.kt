package linshaoyou.meizu.com.mytestapp.moreFragment

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import linshaoyou.meizu.com.mytestapp.R

/**
 * Created by linshaoyou on 17/10/15.
 */
class AnothorFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater!!.inflate(R.layout.another_fragment, container, false)
    }
}