package com.example.test9.presentation.screen.home


import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.test9.databinding.FragmentHomeBinding
import com.example.test9.presentation.base.BaseFragment
import com.example.test9.presentation.event.HomeEvents
import com.example.test9.presentation.extensions.showSnackBar
import com.example.test9.presentation.screen.home.adapter.PagerAdapter
import com.example.test9.presentation.state.HomePageState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel:HomePageViewModel by viewModels()
    private lateinit var myAdapter :PagerAdapter

    override fun bind() {
        viewModel.onEvent(HomeEvents.LoadTouristicPlaces)
        initializeViewPager()
    }

    override fun bindObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.uiStateFlow.collect(){
                    handleResult(it)
                }
            }
        }
    }

    private fun handleResult(homePageState: HomePageState){

        homePageState.errorMessage?.let {
            binding.root.showSnackBar(it)
            viewModel.onEvent(HomeEvents.ResetErrorMessageToNull)
        }

        showOrHideProgressBar(homePageState.isLoading)

        homePageState.isSuccess?.let {
            //myAdapter.submitList(it)
            myAdapter.submitList(it)
        }
    }

    private fun showOrHideProgressBar(isLoading:Boolean){
        Log.d("tag123","loading")
        binding.progressBar.visibility = if(isLoading) View.VISIBLE else View.GONE
    }

    private fun initializeViewPager() {
        myAdapter = PagerAdapter()
        binding.pager.adapter = myAdapter
    }

}