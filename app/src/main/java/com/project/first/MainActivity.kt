package com.project.first

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import coil.load
import com.project.first.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchButton.setOnClickListener {
            val countryName = binding.countryNameEditText.text.toString();

            lifecycleScope.launch {
                binding.resultLayout.visibility = View.INVISIBLE;
                binding.progressSpinner.visibility = View.VISIBLE
                binding.statusTextView.visibility = View.INVISIBLE
                binding.statusImageView.visibility = View.INVISIBLE
                binding.statusLayout.visibility = View.VISIBLE;

                try {
                    val countries = RemoteDataSource().getCountryInfo(countryName);
                    val country = countries[0];

                    binding.countryFlagImage.load(country.flags.png);

                    binding.countryNameTextView.text = country.name.official;
                    binding.countryCapitalInfo.text = country.capital.get(0);

                    binding.countryPopulationInfo.text =
                        Utils().formatLongNumber(country.population);
                    binding.countryAreaInfo.text = Utils().formatDoubleNumber(country.area);

                    binding.countryLanguageInfo.text = Utils().mapToString(country.languages);


                    binding.countryCurrencyInfo.text =
                        Utils().mapCurrencyNameToString(country.currencies);
                    binding.countryCurrencySimbolInfo2.text =
                        Utils().mapCurrencySymbolToString(country.currencies);

                    binding.resultLayout.visibility = View.VISIBLE;
                    binding.statusLayout.visibility = View.INVISIBLE;
                    binding.progressSpinner.visibility = View.INVISIBLE
                } catch (e: Exception) {
                    binding.progressSpinner.visibility = View.INVISIBLE
                    binding.statusTextView.visibility = View.VISIBLE
                    binding.statusImageView.visibility = View.VISIBLE
                    binding.statusImageView.setImageResource(R.drawable.ic_baseline_error_outline_24);
                    binding.statusTextView.text = "Страна не найдена";
                    binding.resultLayout.visibility = View.INVISIBLE;
                    binding.statusLayout.visibility = View.VISIBLE;
                }
            }
        }
    }
}