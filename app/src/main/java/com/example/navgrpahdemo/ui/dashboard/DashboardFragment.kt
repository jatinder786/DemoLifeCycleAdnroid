package com.example.navgrpahdemo.ui.dashboard

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.navgrpahdemo.databinding.FragmentDashboardBinding
import com.example.navgrpahdemo.models.AddNumber
import com.example.navgrpahdemo.models.Age
import com.example.navgrpahdemo.models.Animal
import com.example.navgrpahdemo.models.Area
import com.example.navgrpahdemo.models.Names
import com.example.navgrpahdemo.models.Status
import com.example.navgrpahdemo.models.Student
import kotlin.random.Random

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    private var TAG=DashboardFragment::class.java.name

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
        val dashboardViewModel = ViewModelProvider(this)[DashboardViewModel::class.java]

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root



        Log.d(TAG,"OnCreateView Being Called")
        var animal:Animal<String>?=null
        if(Names.JATINDER.name.startsWith("a"))
       animal=Animal.Dog("dOG")
        else if(Names.MONINDER.name.startsWith("M"))
                animal=Animal.Cow(1)
        else if(Names.SUNIL.name.startsWith("S"))
             animal=Student("aRUN")
        val age=Age(12)
        val age1=Age("Jatt")

        Log.d(TAG,"$age as")
        age
        animal?.let {
            when (it) {
                is Animal.Dog ->
                {
                    animal.avoidCall("Dog")
                }
                is Animal.Cow ->
                {
                    animal.avoidCall("Cow")
                }

                is Student ->
                {
                    animal.avoidCall("Student")
                }
            }
        }
        _binding?.test?.setOnClickListener {
            val alphabet: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

// Build list from 20 random samples from the alphabet,
// and convert it to a string using "" as element separator
            val randomString: String = List(20) { alphabet.random() }.joinToString("")

            var age= Random(100).nextInt()

            dashboardViewModel.updateData(name = randomString, age = age)
        }

        dashboardViewModel.mediatorLiveData.observe(viewLifecycleOwner) {
        Toast.makeText(activity,"Name =${it.name} Age=${it.age}",Toast.LENGTH_LONG).show()
        }
        val addNumber= AddNumber {

        }

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