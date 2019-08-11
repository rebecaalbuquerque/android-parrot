package com.albuquerque.parrot.app.user.view.fragment

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.albuquerque.parrot.R
import com.albuquerque.parrot.app.post.adapter.PostsAdapter
import com.albuquerque.parrot.app.user.view.activity.ProfileActivity.Companion.PROFILE_USER_ID
import com.albuquerque.parrot.app.user.viewmodel.ProfileViewModel
import com.albuquerque.parrot.app.user.viewmodel.ProfileViewModelFactory
import com.albuquerque.parrot.core.session.SessionController
import com.albuquerque.parrot.databinding.FragmentProfileBinding
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    private var userId: Int = -1
    private lateinit var profileViewModel: ProfileViewModel
    private lateinit var binding: FragmentProfileBinding
    private var postsAdapter = PostsAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)
        activity?.intent?.extras?.getInt(PROFILE_USER_ID)?.let {
            userId = it
        } ?: kotlin.run {
            setHasOptionsMenu(true)
            userId = SessionController.user!!.id
        }

        profileViewModel = ViewModelProviders.of(this, ProfileViewModelFactory(userId)).get(ProfileViewModel::class.java)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupView()
        setupDataBinding()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_bottom_navigation, menu)
    }

    private fun setupDataBinding() {
        with(binding) {
            lifecycleOwner = this@ProfileFragment
            posts = profileViewModel.posts
            user = profileViewModel.user
            executePendingBindings()
        }
    }

    private fun setupView() {
        rvPosts.adapter = postsAdapter
    }

}
