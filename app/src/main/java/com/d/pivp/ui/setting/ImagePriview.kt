package com.d.pivp.ui.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.d.pivp.MainActivity
import com.d.pivp.R
import com.layout.pulldown.PullDownLayout
import kotlinx.android.synthetic.main.image_priview_fragment.*


class ImagePriview : Fragment(), PullDownLayout.Callback {

    companion object {
        fun newInstance() = ImagePriview()
    }

    private lateinit var viewModel: ImagePriviewViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.image_priview_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ImagePriviewViewModel::class.java)
        pullBack.setCallback(this)
        // TODO: Use the ViewModel
    }

    override fun onPull(progress: Float) {
    }

    override fun onPullCancel() {
    }

    override fun onPullComplete() {
        (activity as MainActivity).onBackPressed()
    }

    override fun onPullStart() {
    }


    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }
}
