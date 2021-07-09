package com.robertohuertas.endless

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_blank.*


class BlankFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var ma : MainActivity= activity as MainActivity

        button.setOnClickListener {
            ma.actionOnService(Actions.START)
        }

        return inflater.inflate(R.layout.fragment_blank, container, false)


    }


    }
