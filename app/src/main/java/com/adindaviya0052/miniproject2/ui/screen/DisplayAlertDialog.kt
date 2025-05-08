package com.adindaviya0052.miniproject2.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.adindaviya0052.miniproject2.R
import com.adindaviya0052.miniproject2.ui.theme.MiniProject2Theme

@Composable
fun DisplayAlertDialog(
    openDialog: Boolean,
    onDismissRequest: () -> Unit,
    onUndo: () -> Unit,
    onDelete: () -> Unit
) {
    if (openDialog) {
        AlertDialog(
            text = { Text(text = stringResource(R.string.dialog_recycle)) },
            confirmButton = {
                Row {
                    TextButton(onClick = { onUndo() }) {
                        Text(text = stringResource(R.string.undo_button))
                    }
                    TextButton(onClick = { onDelete() }) {
                        Text(text = stringResource(R.string.tombol_hapus))
                    }
                }
            },
            dismissButton = {
                TextButton(onClick = onDismissRequest) {
                    Text(text = stringResource(R.string.tombol_batal))
                }
            },
            onDismissRequest = onDismissRequest
        )
    }
}


@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun DialogPreview(){
    MiniProject2Theme {
        DisplayAlertDialog(
            openDialog = true,
            onDismissRequest = {},
            onUndo = {},
            onDelete = {}
        )
    }
}