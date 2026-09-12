package com.litecord.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.litecord.app.databinding.FragmentHomeBinding
import com.example.liquidglass.LiquidGlassView
import com.google.android.material.color.MaterialColors

class HomeFragment : Fragment() n
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupLiquidGlassUI()
    }

    private fun setupLiquidGlassUI() {
        val glassView = binding.glassContainer as? LiquidGlassView
        glassView?.apply {
            enableDynamicBackground = true
            enableAdaptiveTint = true
            enableSensorHighlight = true
            material = com.example.liquidglass.GlassMaterial.REGULAR
            refractionHeight = 160f
            bevelWidth = 48f
            dispersionStrength = 0.10f
            cornerRadius = 999f
            glassAppearanceListener = { isOverLight ->
                // Adapt foreground colors based on backdrop luminance
                val textColor = if (isOverLight) 0xFF000000.toInt() else 0xFFFFFFFF.toInt()
                binding.welcomeText.setTextColor(textColor)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
