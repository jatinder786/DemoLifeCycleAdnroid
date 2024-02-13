package com.example.navgrpahdemo.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.navgrpahdemo.databinding.FragmentHomeBinding
import com.example.navgrpahdemo.ui.dashboard.DashboardFragment
import kotlin.random.Random

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private var TAG= HomeFragment::class.java.name

    private lateinit var homeViewModel:HomeViewModel


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(!::homeViewModel.isInitialized)
        {
            homeViewModel=ViewModelProvider(this)[HomeViewModel::class.java]
            Log.d(TAG,"OnAttach View Model Not Init $homeViewModel")

        }
        else
        {
            Log.d(TAG,"OnAttach View Model Already Init")

        }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"OnCreate Being Called")

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        Log.d(TAG,"OnCreateView Being Called")

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG,"OnViewCreated Being Called")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"OnStart Being Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"OnResume Being Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"OnPause Being Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"OnStop Being Called")
    }


    override fun onDestroyView() {
        super.onDestroyView()
        val name = (0..10).random()
        homeViewModel.updateUiText("OnDestroyView() $name")
        _binding = null
        Log.d(TAG,"OnDestroyView Being Called $name")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"OnDestroy Being Called")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG,"OnDetach Being Called")
    }
}