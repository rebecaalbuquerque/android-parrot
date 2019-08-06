package com.albuquerque.parrot.app.user.view.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment

import com.albuquerque.parrot.R
import com.albuquerque.parrot.app.user.model.User

class ProfileFragment : Fragment() {

    private var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(user == null)
            setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_bottom_navigation, menu)

    }

}
