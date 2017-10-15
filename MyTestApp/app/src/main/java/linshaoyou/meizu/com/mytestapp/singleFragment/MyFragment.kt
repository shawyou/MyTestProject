package linshaoyou.meizu.com.mytestapp.singleFragment

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import linshaoyou.meizu.com.mytestapp.R

/**
 * Created by linshaoyou on 17/10/15.
 */
class MyFragment : Fragment(){

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.e("LSY", "MyFragment onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("LSY", "MyFragment onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        Log.e("LSY", "MyFragment onCreateView")
        var view = inflater!!.inflate(R.layout.fragment1,container)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("LSY", "MyFragment onViewCreated")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e("LSY", "MyFragment onActivityCreated")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("LSY", "MyFragment onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("LSY", "MyFragment onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.e("LSY", "MyFragment onDetach")
    }
}