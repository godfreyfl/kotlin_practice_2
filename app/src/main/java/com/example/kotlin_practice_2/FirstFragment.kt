package com.example.kotlin_practice_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kotlin_practice_2.R

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        // Кнопка для ручной навигации
        val manualNavigationButton: Button = view.findViewById(R.id.first_to_second)
        manualNavigationButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SecondFragment())  // Используем replace, чтобы не наслаивать фрагменты
                .addToBackStack(null)  // Добавляем транзакцию в стек, чтобы можно было вернуться
                .commit()
        }

        // Кнопка для навигации через Navigation API
        val apiNavigationButton: Button = view.findViewById(R.id.first_to_second_api)
        apiNavigationButton.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        return view
    }
}

