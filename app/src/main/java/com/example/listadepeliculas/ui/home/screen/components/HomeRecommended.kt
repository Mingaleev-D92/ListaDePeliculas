package com.example.listadepeliculas.ui.home.screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.listadepeliculas.R
import com.example.listadepeliculas.domain.model.FilterType

/**
 * @author : Mingaleev D
 * @data : 30.05.2023
 */

@Composable
fun HomeRecommended(
    selectedFilter: FilterType,
    onFilterClick: (FilterType) -> Unit,
    modifier: Modifier = Modifier,
) {
   Column(modifier = modifier.fillMaxWidth()) {
      CategoryTitle(title = stringResource(id = R.string.recommended_movie))
      Spacer(modifier = Modifier.height(12.dp))
      FilterPillContainer(
          filters = FilterType.values().toList(),
          selectedFilter = selectedFilter,
          onFilterClick = onFilterClick
      )
   }
}

