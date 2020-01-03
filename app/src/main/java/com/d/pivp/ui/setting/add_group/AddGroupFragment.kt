package com.d.pivp.ui.setting.add_group

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController

import com.d.pivp.R
import kotlinx.android.synthetic.main.add_group_fragment2.*

class AddGroupFragment : Fragment() {

    companion object {
        fun newInstance() = AddGroupFragment()
    }

    private lateinit var viewModel: AddGroupViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_group_fragment2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddGroupViewModel::class.java)
        // TODO: Use the ViewModel

        imageView.setOnClickListener {
            it.findNavController().navigate(R.id.imagePriviewFragment)
        }
    }

}
