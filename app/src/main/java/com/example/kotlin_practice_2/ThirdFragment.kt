package com.example.kotlin_practice_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kotlin_practice_2.R

class ThirdFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_third, container, false)

        // Кнопка для ручной навигации — возвращение на первый фрагмент
        val manualNavigationButton: Button = view.findViewById(R.id.third_to_first)
        manualNavigationButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FirstFragment())  // Заменяем фрагмент
                .addToBackStack(null)  // Добавляем в стек
                .commit()
        }

        // Кнопка для навигации через Navigation API — возвращение на первый фрагмент
        val apiNavigationButton: Button = view.findViewById(R.id.third_to_first_api)
        apiNavigationButton.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_firstFragment)
        }

        return view
    }
}
