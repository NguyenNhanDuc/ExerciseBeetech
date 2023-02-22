package com.example.baitapprojectctybeetech

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.baitapprojectctybeetech.ui.main.account.AccountFragment
import com.example.baitapprojectctybeetech.ui.main.checkup.CheckUpFragment
import com.example.baitapprojectctybeetech.ui.main.home.HomeFragment
import com.example.baitapprojectctybeetech.ui.main.information.InforFragment
import com.example.baitapprojectctybeetech.ui.main.test.TestFragment

class MainPagerAdapter(
    fragmentActivity: FragmentActivity,
) : FragmentStateAdapter(fragmentActivity) {

    private val fragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        HOME to { HomeFragment() },
        TEST to { TestFragment() },
        CHECK to { CheckUpFragment() },
        INFOR to { InforFragment() },
        ACCOUNT to { AccountFragment() }
    )

    override fun getItemCount() = fragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return fragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }

    companion object {
        private const val HOME = 0
        private const val TEST = 1
        private const val CHECK = 2
        private const val INFOR = 3
        private const val ACCOUNT = 4
    }
}
