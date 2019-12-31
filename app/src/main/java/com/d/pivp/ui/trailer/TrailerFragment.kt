package com.d.pivp.ui.trailer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.d.pivp.R

class TrailerFragment : Fragment() {

    companion object {
        fun newInstance() = TrailerFragment()
    }

    private lateinit var trailerViewModel: TrailerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_trailer, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        trailerViewModel = ViewModelProviders.of(this).get(TrailerViewModel::class.java)

    }

}
