package com.d.pivp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.d.pivp.R
import com.d.pivp.model.ObjectBox
import com.d.pivp.model.User
import com.d.pivp.model.User_
import io.objectbox.Box
import io.objectbox.kotlin.boxFor
import io.objectbox.kotlin.query
import io.objectbox.query.Query


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    private var userQuery: Query<User>? = null
    private lateinit var userBox: Box<User>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        homeViewModel.text.observe(this, Observer {

        })

        userBox = ObjectBox.boxStore.boxFor(User::class)

        // query all notes, sorted a-z by their text (https://docs.objectbox.io/queries)
//        userQuery = userBox.query().order().build()
        userQuery = userBox.query {
            order(User_.name)
        }


//        val d = User(name = "vishal")
//        userBox.put(d)

        listQueryData()
    }

    private fun updateNotes() {
        val notes = userQuery!!.find()
        for(data in notes){
            Log.e("data","----------"+ data.name)
        }
    }

    private fun listQueryData(){
        val qdata =   userBox.query().equal(User_.name, "Vishal").build().find()

        for(data in qdata){
            Log.e("data","----------"+ data.name)
        }
    }
}