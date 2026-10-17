package com.example.tugaspertemuan5_pam

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Scaffold
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import java.util.Calendar
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
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
    val experienceOptions = listOf("1 Tahun", "2 Tahun", "3 Tahun", "4 Tahun")

    var submittedNama by remember { mutableStateOf("") }
    var submittedEmail by remember { mutableStateOf("") }
    var submittedTglLahir by remember { mutableStateOf("") }
    var submittedExperience by remember { mutableStateOf("") }
    var submittedSkills by remember { mutableStateOf("") }
    var showResult by remember { mutableStateOf(false) }

    val isProceedEnabled = (
            textNamaDepan.isNotEmpty() &&
            textNamaBelakang.isNotEmpty() &&
            textEmail.isNotEmpty() &&
            textTglLahir.isNotEmpty() &&
            textExperience.isNotEmpty()
            )
        Box(
            modifier = modifier
                .fillMaxSize()
        ) {

            Image(
                painter = painterResource(id = R.drawable.foto_bg),
                contentDescription = stringResource(id = R.string.bg),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.45f)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.80f)
                    .align(Alignment.BottomCenter)
                    .clip(
                        RoundedCornerShape(
                            topStart = dimensionResource(id = R.dimen.corner_radius_large),
                            topEnd = dimensionResource(id = R.dimen.corner_radius_large)
                        )
                    )
                    .background(colorResource(id = R.color.white))
            ) {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(
                            horizontal = dimensionResource(id = R.dimen.padding_large),
                            vertical = dimensionResource(id = R.dimen.padding_xlarge)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.form_biodata),
                        color = colorResource(id = R.color.blue_title),
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
                    Text(
                        text = stringResource(id = R.string.subjudul_form_biodata),
                        color = colorResource(id = R.color.gray_subtitle),
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_large)))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
                    ) {
                        OutlinedTextField(
                            value = textNamaDepan,
                            onValueChange = { textNamaDepan = it },
                            label = { Text(stringResource(id = R.string.nama_depan)) },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_radius_medium)),
                            singleLine = true
                        )
                        OutlinedTextField(
                            value = textNamaBelakang,
                            onValueChange = { textNamaBelakang = it },
                            label = { Text(stringResource(id = R.string.nama_belakang)) },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_radius_medium)),
                            singleLine = true
                        )
                    }
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))

                    OutlinedTextField(
                        value = textEmail,
                        onValueChange = { textEmail = it },
                        label = { Text(stringResource(id = R.string.email)) },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_radius_medium)),
                        singleLine = true
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
                    ){
                        OutlinedTextField(
                            value = textTglLahir,
                            onValueChange = { },
                            readOnly = true,
                            label = { Text(stringResource(id = R.string.tanggal_lahir)) },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_radius_medium)),
                            singleLine = true,
                            trailingIcon = {
                                IconButton(onClick = { showDatePicker = true }) {
                                    Icon(
                                        imageVector = Icons.Default.DateRange,
                                        contentDescription = stringResource(id = R.string.calendar)
                                    )
                                }
                            }
                        )
                        if (showDatePicker) {
                            DatePickerDialog(
                                onDismissRequest = { showDatePicker = false },
                                confirmButton = {
                                    TextButton(onClick = {
                                        datePickerState.selectedDateMillis?.let { millis ->
                                            val formatter =
                                                SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                                            val calendar = Calendar.getInstance()
                                            calendar.timeInMillis = millis
                                            textTglLahir = formatter.format(calendar.time)
                                        }
                                        showDatePicker = false
                                    }) {
                                        Text("OK")
                                    }
                                },
                                dismissButton = {
                                    TextButton(onClick = { showDatePicker = false }) {
                                        Text("Batal")
                                    }
                                }
                            ) {
                                DatePicker(state = datePickerState)
                            }
                        }
                        ExposedDropdownMenuBox(
                            expanded = expandedExperience,
                            onExpandedChange = { expandedExperience = !expandedExperience },
                            modifier = Modifier.weight(1f)
                        ) {
                            OutlinedTextField(
                                value = textExperience,
                                onValueChange = {},
                                readOnly = true,
                                label = { Text(stringResource(id = R.string.experience)) },
                                modifier = Modifier.menuAnchor(),
                                shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_radius_medium)),
                                singleLine = true,
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedExperience)
                                },
                                colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors()
                            )
                            ExposedDropdownMenu(
                                expanded = expandedExperience,
                                onDismissRequest = { expandedExperience = false }
                            ) {
                                experienceOptions.forEach { selectionOption ->
                                    DropdownMenuItem(
                                        text = { Text(selectionOption) },
                                        onClick = {
                                            textExperience = selectionOption
                                            expandedExperience = false
                                        }
                                    )
                                }
                            }
                        }

                     }
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_large)))

                    Text(
                        text = stringResource(id = R.string.pilih_skill),
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_large)))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.toggleable(
                                value = checkAndroid,
                                onValueChange = { checkAndroid = it },
                                role = Role.Checkbox
                            )
                        ) {
                            Checkbox(checked = checkAndroid, onCheckedChange = null)
                            Text(text = stringResource(id = R.string.skill_android), style = MaterialTheme.typography.bodySmall)
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.toggleable(
                                value = checkUiUx,
                                onValueChange = { checkUiUx = it },
                                role = Role.Checkbox
                            )
                        ) {
                            Checkbox(checked = checkUiUx, onCheckedChange = null)
                            Text(text = stringResource(id = R.string.skill_ui_ux), style = MaterialTheme.typography.bodySmall)
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.toggleable(
                                value = checkWeb,
                                onValueChange = { checkWeb = it },
                                role = Role.Checkbox
                            )
                        ) {
                            Checkbox(checked = checkWeb, onCheckedChange = null)
                            Text(text = stringResource(id = R.string.skill_web), style = MaterialTheme.typography.bodySmall)
                        }
                    }
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_xlarge)))
                    val strAndroid = stringResource(id = R.string.skill_android)
                    val strUiUx = stringResource(id = R.string.skill_ui_ux)
                    val strWeb = stringResource(id = R.string.skill_web)

                    Button(
                        onClick = {
                            submittedNama = "$textNamaDepan $textNamaBelakang"
                            submittedEmail = textEmail
                            submittedTglLahir = textTglLahir
                            submittedExperience = textExperience

                            val skills = mutableListOf<String>()

                            if (checkAndroid) skills.add(strAndroid)
                            if (checkUiUx) skills.add(strUiUx)
                            if (checkWeb) skills.add(strWeb)

                            submittedSkills = if (skills.isNotEmpty()) skills.joinToString(", ") else "-"

                            showResult = true
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(dimensionResource(id = R.dimen.button_height)),
                        enabled = isProceedEnabled,
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_radius_large))
                    ) {
                        Text(stringResource(id = R.string.btn_proceed))
                    }
                    if (showResult) {
                        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_xlarge)))

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.corner_radius_medium)))
                                .background(colorResource(id = R.color.black)) // Pastikan warna hitam didefinisikan di colors.xml
                                .padding(dimensionResource(id = R.dimen.padding_large))
                        ) {
                            Column(verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))) {
                                Text(
                                    text = stringResource(id = R.string.data_tersimpan),
                                    color = colorResource(id = R.color.white),
                                    fontWeight = FontWeight.Bold,
                                    style = MaterialTheme.typography.titleMedium
                                )
                                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))

                                Text(text = "Nama : $submittedNama", color = colorResource(id = R.color.white), style = MaterialTheme.typography.bodyMedium)
                                Text(text = "Email : $submittedEmail", color = colorResource(id = R.color.white), style = MaterialTheme.typography.bodyMedium)
                                Text(text = "Tanggal Lahir : $submittedTglLahir", color = colorResource(id = R.color.white), style = MaterialTheme.typography.bodyMedium)
                                Text(text = "Pengalaman : $submittedExperience", color = colorResource(id = R.color.white), style = MaterialTheme.typography.bodyMedium)
                                Text(text = "Keahlian : $submittedSkills", color = colorResource(id = R.color.white), style = MaterialTheme.typography.bodyMedium)
                            }
                        }
                    }
                  }
              }
        }

}