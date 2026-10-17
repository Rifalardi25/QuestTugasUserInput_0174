package com.example.tugaspertemuan5_pam

import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun FormBiodata(modifier: Modifier){
    var textNamaDepan by remember {mutableStateOf("")}
    var textNamaBelakang by remember { mutableStateOf("") }
    var textEmail by remember { mutableStateOf("") }
    var textTglLahir by remember { mutableStateOf("") }
    var textExperience by remember { mutableStateOf("") }

    var checkAndroid by remember { mutableStateOf(false) }
    var checkUiUx by remember { mutableStateOf(false) }
    var checkWeb by remember { mutableStateOf(false) }

    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()

    var expandedExperience by remember { mutableStateOf(false) }
    val experienceOptions = listOf("Beginner", "Intermediate", "Advanced", "Expert")

    val isProceedEnabled = textNamaDepan.isNotEmpty() &&
            textNamaBelakang.isNotEmpty() &&
            textEmail.isNotEmpty() &&
            textTglLahir.isNotEmpty() &&
            textExperience.isNotEmpty()
}