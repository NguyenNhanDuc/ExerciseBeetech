package com.example.baitapprojectctybeetech

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.baitapprojectctybeetech.databinding.ActivityMainBinding
import com.fxc.studio.key.connect.base.BaseActivity
import kotlinx.coroutines.delay
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlinx.coroutines.launch

class MainActivity : BaseActivity<ActivityMainBinding>() {

    //override val viewModel: MainViewModel by viewModel()

    override val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val pagerAdapter by lazy(LazyThreadSafetyMode.NONE) {
        MainPagerAdapter(this)
    }

    private var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        initListener()
    }

    private fun initView() = binding.run {
        viewPager.run {
            adapter = pagerAdapter
            offscreenPageLimit = 4
            isUserInputEnabled = false  // Disable viewpager swipe
        }

        bottomNav.itemIconTintList = null

    }

    private fun initListener() = binding.run {
        bottomNav.setOnItemSelectedListener {
            setViewPagerSelected(it.itemId)
            true
        }
    }

    private fun setViewPagerSelected(itemId: Int) = binding.run {
        when (itemId) {
            R.id.itemHome -> viewPager.setCurrentItem(0, false)
            R.id.itemCheckUp -> viewPager.setCurrentItem(1, false)
            R.id.itemTest -> viewPager.setCurrentItem(2, false)
            R.id.itemInfor -> viewPager.setCurrentItem(3, false)
            else -> viewPager.setCurrentItem(4, false)
        }
    }

    fun setNavSelected(itemId: Int) = binding.run {
        bottomNav.selectedItemId = itemId
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        //toastNormal(resources.getString(R.string.please_click_back_again_to_exit))
        lifecycleScope.launch {
            delay(2000)
            doubleBackToExitPressedOnce = false
        }
    }
}