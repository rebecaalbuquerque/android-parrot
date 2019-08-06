package com.albuquerque.parrot.app.auth.view.activity

import android.os.Bundle
import com.albuquerque.parrot.R
import com.albuquerque.parrot.app.post.view.fragment.PostsFragment
import com.albuquerque.parrot.app.user.view.fragment.NotificationFragment
import com.albuquerque.parrot.app.user.view.fragment.ProfileFragment
import com.albuquerque.parrot.app.user.view.fragment.SearchFragment
import com.albuquerque.parrot.core.extensions.openFragment
import com.albuquerque.parrot.core.view.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PostsFragment().openFragment(supportFragmentManager, R.id.container)

        bottomNavigation.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.actionHome -> PostsFragment().openFragment(supportFragmentManager, R.id.container)
                R.id.actionSearch -> SearchFragment().openFragment(supportFragmentManager, R.id.container)
                R.id.actionNotifications -> NotificationFragment().openFragment(supportFragmentManager, R.id.container)
                R.id.actionProfile -> ProfileFragment().openFragment(supportFragmentManager, R.id.container)
            }

            true
        }


    }
}
