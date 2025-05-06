package com.adindaviya0052.miniproject2.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.adindaviya0052.miniproject2.R
import com.adindaviya0052.miniproject2.ui.theme.MiniProject2Theme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavHostController) {
    var judul by remember { mutableStateOf("") }
    var review by remember { mutableStateOf("") }
    var kategori by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf<Long?>(null) }

    val kategoriList = listOf("Drama Cina", "Drama Korea", "Film Animasi",
        "Film Hollywood", "Film Indonesia")
    val statusList = listOf("Belum ditonton", "Sedang ditonton", "Selesai ditonton")

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.kembali),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                title = {
                    Text(text = stringResource(id = R.string.tambah_film))
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                actions = {
                    IconButton(onClick = { navController.popBackStack()}) {
                        Icon(
                            imageVector = Icons.Outlined.Check,
                            contentDescription = stringResource(R.string.simpan),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            )
        },
    ) { padding ->
        FormFilm(
            title = judul,
            onTitleChange = { judul = it },
            review = review,
            onReviewChange = { review = it },
            kategori = kategori,
            onKategoriChange = { kategori = it },
            status = status,
            onStatusChange = { status = it },
            kategoriList = kategoriList,
            statusList = statusList,
            selectedDate = selectedDate,
            onDateChange = { selectedDate = it },
            modifier = Modifier.padding(padding)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormFilm(
    title: String, onTitleChange: (String) -> Unit,
    review: String, onReviewChange: (String) -> Unit,
    kategori: String, onKategoriChange: (String) -> Unit,
    status: String, onStatusChange: (String) -> Unit,
    kategoriList: List<String>,
    statusList: List<String>,
    selectedDate: Long?, onDateChange: (Long) -> Unit,
    modifier: Modifier
){
    Column (
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // judul
        OutlinedTextField(
            value = title,
            onValueChange = { onTitleChange(it) },
            label = { Text(text = stringResource(R.string.judul)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )

        // review
        OutlinedTextField(
            value = review,
            onValueChange = { onReviewChange(it) },
            label = { Text(text = stringResource(R.string.review)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )

        // kategori
        var expanded by remember { mutableStateOf(false) }

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                readOnly = true,
                value = kategori,
                onValueChange = {},
                label = { Text(text = stringResource(R.string.kategori)) },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                modifier = Modifier.fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                kategoriList.forEach { film ->
                    DropdownMenuItem(
                        text = { Text(text = film) },
                        onClick = {
                            onKategoriChange(film)
                            expanded = false
                        }
                    )
                }
            }
        }

        // status
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(modifier = Modifier.padding(8.dp)) {
                statusList.forEach { stat ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 4.dp)
                    ) {
                        RadioButton(
                            selected = stat == status,
                            onClick = { onStatusChange(stat) }
                        )
                        Text(text = stat)
                    }
                }
            }
        }

        // tanggal
        DatePickerDocked(
            selectedDate = selectedDate,
            onDateChange = onDateChange
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerDocked(
    selectedDate: Long?,
    onDateChange: (Long) -> Unit
) {
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState(initialSelectedDateMillis = selectedDate)

    val formattedDate = selectedDate?.let {
        convertMillisToDate(it)
    } ?: ""

    Box(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = formattedDate,
            onValueChange = {},
            label = { Text("Tanggal Selesai Ditonton") },
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = { showDatePicker = !showDatePicker }) {
                    Icon(imageVector = Icons.Default.DateRange, contentDescription = "Select date")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
        )

        if (showDatePicker) {
            Popup(
                onDismissRequest = { showDatePicker = false },
                alignment = Alignment.TopStart
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 64.dp)
                        .shadow(elevation = 4.dp)
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(16.dp)
                ) {
                    DatePicker(
                        state = datePickerState,
                        showModeToggle = false
                    )
                    LaunchedEffect(datePickerState.selectedDateMillis) {
                        datePickerState.selectedDateMillis?.let { millis ->
                            onDateChange(millis)
                        }
                    }
                }
            }
        }
    }
}

fun convertMillisToDate(millis: Long): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return formatter.format(Date(millis))
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun DetailScreenPreview(){
    MiniProject2Theme {
        DetailScreen(rememberNavController())
    }
}