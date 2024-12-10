package com.fabijimenez.proyectoprogramacionv.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fabijimenez.proyectoprogramacionv.R
import com.google.android.material.bottomnavigation.BottomNavigationView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BottomNavigation.newInstance] factory method to
 * create an instance of this fragment.
 */
class BottomNavigationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bottom_navigation, container, false)

        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Configurar el listener para cada item
//        bottomNavigationView.setOnItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.navigation_home -> {
//                    startActivity(Intent(requireContext(), HomeActivity::class.java))
//                    true
//                }
//                R.id.navigation_store -> {
//                    startActivity(Intent(requireContext(), StoreActivity::class.java))
//                    true
//                }
//                R.id.navigation_profile -> {
//                    startActivity(Intent(requireContext(), ProfileActivity::class.java))
//                    true
//                }
//                R.id.navigation_branches -> {
//                    startActivity(Intent(requireContext(), BranchesActivity::class.java))
//                    true
//                }
//                R.id.navigation_contact -> {
//                    startActivity(Intent(requireContext(), ContactActivity::class.java))
//                    true
//                }
//                else -> false
//            }
//        }

        return view
    }
}

