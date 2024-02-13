package com.example.navgrpahdemo.ui.notifications

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.navgrpahdemo.databinding.FragmentNotificationsBinding
import com.example.navgrpahdemo.ui.home.HomeFragment

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    private var TAG= NotificationsFragment::class.java.name

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG,"OnAttach Being Called")
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
        val notificationsViewModel = ViewModelProvider(this)[NotificationsViewModel::class.java]

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner) {
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
        _binding = null
        Log.d(TAG,"OnDestroyView Being Called")
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