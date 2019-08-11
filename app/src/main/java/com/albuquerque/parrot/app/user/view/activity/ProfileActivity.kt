package com.albuquerque.parrot.app.user.view.activity

import android.os.Bundle
import com.albuquerque.parrot.R
import com.albuquerque.parrot.app.user.view.fragment.ProfileFragment
import com.albuquerque.parrot.core.extensions.openFragment
import com.albuquerque.parrot.core.view.activity.BaseActivity

class ProfileActivity : BaseActivity() {

    companion object {
        const val PROFILE_USER_ID = "PROFILE_USER_ID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        ProfileFragment().openFragment(supportFragmentManager, R.id.containerProfile)

    }
}
