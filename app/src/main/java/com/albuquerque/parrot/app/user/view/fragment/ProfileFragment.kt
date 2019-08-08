package com.albuquerque.parrot.app.user.view.fragment

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment

import com.albuquerque.parrot.R
import com.albuquerque.parrot.app.user.model.User
import com.albuquerque.parrot.app.user.view.activity.ProfileActivity.Companion.PROFILE_USER_ID

class ProfileFragment : Fragment() {

    private var userId: Int = -1
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

        val teste = activity?.intent?.extras?.getInt(PROFILE_USER_ID)
        Toast.makeText(context!!, "$teste", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_bottom_navigation, menu)

    }

}
