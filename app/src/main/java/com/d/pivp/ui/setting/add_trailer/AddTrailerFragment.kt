package com.d.pivp.ui.setting.add_trailer

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController

import com.d.pivp.R
import kotlinx.android.synthetic.main.add_trailer_fragment.*

class AddTrailerFragment : Fragment() {

    companion object {
        fun newInstance() = AddTrailerFragment()
    }

    private lateinit var addTrailerViewModel: AddTrailerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_trailer_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        addTrailerViewModel = ViewModelProviders.of(this).get(AddTrailerViewModel::class.java)
        // TODO: Use the ViewModel
        button.setOnClickListener {
            it.findNavController().navigate(R.id.addGroupFragment)
        }
    }
}
